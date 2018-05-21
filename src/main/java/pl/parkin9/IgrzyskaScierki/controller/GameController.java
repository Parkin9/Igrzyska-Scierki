package pl.parkin9.IgrzyskaScierki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.parkin9.IgrzyskaScierki.model.Game;
import pl.parkin9.IgrzyskaScierki.model.Player;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;
import pl.parkin9.IgrzyskaScierki.model.Task;
import pl.parkin9.IgrzyskaScierki.service.GameService;
import pl.parkin9.IgrzyskaScierki.service.PlayerService;
import pl.parkin9.IgrzyskaScierki.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GameController {

    private final GameService gameService;
    private final PlayerService playerService;
    private final TaskService taskService;

    @Autowired
    public GameController(GameService gameService, PlayerService playerService, TaskService taskService) {
        this.gameService = gameService;
        this.playerService = playerService;
        this.taskService = taskService;
    }

///////////////////////////////////////////////////////////////////////////////

    @GetMapping("/game")
    public ModelAndView showGame(@CookieValue("gameCookie") String gameCook,
                                 HttpSession sess) {

        ModelAndView modelAndView = new ModelAndView();
        PlayerGroup playerGroup = (PlayerGroup) sess.getAttribute("loggedInPlayerGroup");

        if(gameCook.equals("gameNotExists")) {

            modelAndView.addObject("game", new Game());
            modelAndView.setViewName("form/addGame");

        } else {

            List<Task> taskList = taskService.findAllTasks(playerGroup);
            List<Player> playerList = playerService.findAllPlayers(playerGroup);
            modelAndView.addObject("playerList", playerList);
            modelAndView.addObject("taskList", taskList);
            modelAndView.setViewName("game");
        }

        return modelAndView;
    }

    @PostMapping("/game")
    public ModelAndView gameForm(@CookieValue("gameCookie") String gameCook,
                                 @ModelAttribute Game game,
                                 HttpServletRequest request,
                                 HttpSession sess) {

        ModelAndView modelAndView = new ModelAndView();
        PlayerGroup playerGroup = (PlayerGroup) sess.getAttribute("loggedInPlayerGroup");

        if(gameCook.equals("gameNotExists")) {

            game.setPlayerGroup(playerGroup);
            gameService.saveGame(game);
            modelAndView.setViewName("redirect:/panel");

            return modelAndView;
        }

        Player player = playerService.findOneById(Long.valueOf(request.getParameter("whichPlayerDo")));
        List<Task> tasks = taskService.findAllTasksById(Long.valueOf(request.getParameter("whichTaskIsDone")));

        for(Task task : tasks) {
            player.setScore((player.getScore()) + (task.getPointsValue()));
        }

        playerService.savePlayer(player);
        modelAndView.setViewName("redirect:/panel");

        return modelAndView;
    }
}

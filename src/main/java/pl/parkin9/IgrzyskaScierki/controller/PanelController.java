package pl.parkin9.IgrzyskaScierki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.parkin9.IgrzyskaScierki.model.Game;
import pl.parkin9.IgrzyskaScierki.model.Player;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;
import pl.parkin9.IgrzyskaScierki.model.Task;
import pl.parkin9.IgrzyskaScierki.implementation.CompareTimeServiceImpl;
import pl.parkin9.IgrzyskaScierki.service.CompareTimeService;
import pl.parkin9.IgrzyskaScierki.service.GameService;
import pl.parkin9.IgrzyskaScierki.service.PlayerService;
import pl.parkin9.IgrzyskaScierki.service.TaskService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class PanelController {

    private final TaskService taskService;
    private final PlayerService playerService;
    private final GameService gameService;
    private  final CompareTimeService compareTimeService;

    @Autowired
    public PanelController(TaskService taskService, PlayerService playerService, GameService gameService, CompareTimeService compareTimeService) {
        this.taskService = taskService;
        this.playerService = playerService;
        this.gameService = gameService;
        this.compareTimeService = compareTimeService;
    }

////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/panel")
    public ModelAndView showPanel(HttpServletResponse response, HttpSession sess) {

        ModelAndView modelAndView = new ModelAndView();
        PlayerGroup playerGroup = (PlayerGroup) sess.getAttribute("loggedInPlayerGroup");
        Game game = gameService.findOneByPlayerGroup(playerGroup);
        List<Player> playerList = playerService.findAllPlayers(playerGroup);

        if(game == null) {
            response.addCookie(new Cookie("gameCookie", "gameNotExists"));
        } else {
            response.addCookie(new Cookie("gameCookie", "gameExists"));
        }

        if((compareTimeService.compare(sess) == 1) && (game != null)) {

            game.setActive(false);
            gameService.saveGame(game);

            for(Player player : playerList) {
                player.setScore(0);
                playerService.savePlayer(player);
            }

            modelAndView.setViewName("winScreen");
        } else {

            modelAndView.addObject("playerList", playerList);
            modelAndView.setViewName("panel");
        }


        return modelAndView;
    }

////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/addTask")
    public ModelAndView showTaskForm(HttpSession sess) {

        ModelAndView modelAndView = new ModelAndView("form/addTask");
        Task task = new Task();
        PlayerGroup playerGroup = (PlayerGroup) sess.getAttribute("loggedInPlayerGroup");
        List<Task> taskList = taskService.findAllTasks(playerGroup);

        modelAndView.addObject("task", task);
        modelAndView.addObject("taskList", taskList);

        return modelAndView;
    }

    @PostMapping("/addTask")
    public ModelAndView addNewTask(@Valid Task task, BindingResult bindingResult, HttpSession sess) {

        ModelAndView modelAndView = new ModelAndView();
        PlayerGroup playerGroup = (PlayerGroup) sess.getAttribute("loggedInPlayerGroup");

        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("redirect:/addTask");
        } else {
            task.setPlayerGroup(playerGroup);
            taskService.saveTask(task);
            modelAndView.setViewName("redirect:/addTask");
        }

        return modelAndView;
    }

    @GetMapping("/deleteTask/{id}")
    public ModelAndView deleteTask(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Task task = taskService.findOneById(id);
        taskService.deleteTask(task);
        modelAndView.setViewName("redirect:/addTask");

        return modelAndView;
    }

///////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/addPlayer")
    public ModelAndView showPlayerForm(HttpSession sess) {

        ModelAndView modelAndView = new ModelAndView("form/addPlayer");
        Player player = new Player();
        PlayerGroup playerGroup = (PlayerGroup) sess.getAttribute("loggedInPlayerGroup");
        List<Player> playerList = playerService.findAllPlayers(playerGroup);

        modelAndView.addObject("player", player);
        modelAndView.addObject("playerList", playerList);

        return modelAndView;
    }

    @PostMapping("/addPlayer")
    public ModelAndView addNewPlayer(@Valid Player player, BindingResult bindingResult, HttpSession sess) {

        ModelAndView modelAndView = new ModelAndView();
        PlayerGroup playerGroup = (PlayerGroup) sess.getAttribute("loggedInPlayerGroup");

        if(bindingResult.hasErrors()) {
            modelAndView.setViewName("redirect:/addPlayer");
        } else {
            player.setPlayerGroup(playerGroup);
            playerService.savePlayer(player);
            modelAndView.setViewName("redirect:/addPlayer");
        }

        return modelAndView;
    }

    @GetMapping("/deletePlayer/{id}")
    public ModelAndView deletePlayer(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Player player = playerService.findOneById(id);
        playerService.deletePlayer(player);
        modelAndView.setViewName("redirect:/addPlayer");

        return modelAndView;
    }

///////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession sess) {
        sess.invalidate();
        return new ModelAndView("logout");
    }
}

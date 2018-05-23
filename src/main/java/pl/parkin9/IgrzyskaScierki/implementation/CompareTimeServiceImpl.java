package pl.parkin9.IgrzyskaScierki.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.parkin9.IgrzyskaScierki.model.Game;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;
import pl.parkin9.IgrzyskaScierki.service.CompareTimeService;
import pl.parkin9.IgrzyskaScierki.service.GameService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Service
public class CompareTimeServiceImpl implements CompareTimeService {

    private final GameService gameService;

    @Autowired
    public CompareTimeServiceImpl(GameService gameService) {
        this.gameService = gameService;
    }


///////////////////////////////////////////////////////////////////////////////

    @Override
    public Integer compare(HttpSession sess) {

        Integer value = 0;
        PlayerGroup playerGroup = (PlayerGroup) sess.getAttribute("loggedInPlayerGroup");

        Game game = gameService.findOneByPlayerGroup(playerGroup);
        if(game != null) {
            String endGameStr = (game.getEnd()).toString();

            LocalDate endGame = LocalDate.parse(endGameStr);
            LocalDate currentDate = LocalDate.now();

            if(currentDate.isEqual(endGame)) {
                value = 0;
            } else if (currentDate.isAfter(endGame)) {
                value = 1;
            } else if (currentDate.isBefore(endGame)) {
                value = -1;
            }
        }

        return value;
    }
}

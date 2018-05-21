package pl.parkin9.IgrzyskaScierki.service;

import pl.parkin9.IgrzyskaScierki.model.Game;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;

import java.util.List;

public interface GameService {

    Game findOneByPlayerGroup(PlayerGroup playerGroup);

    void saveGame(Game game);

    List<Game> findAllGames(PlayerGroup playerGroup);
}

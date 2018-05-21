package pl.parkin9.IgrzyskaScierki.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.parkin9.IgrzyskaScierki.model.Game;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;
import pl.parkin9.IgrzyskaScierki.repository.GameRepository;
import pl.parkin9.IgrzyskaScierki.service.GameService;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

///////////////////////////////////////////////////////////////

    @Override
    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    @Override
    public List<Game> findAllGames(PlayerGroup playerGroup) {
        return gameRepository.findAllByPlayerGroup(playerGroup);
    }

    @Override
    public Game findOneByPlayerGroup(PlayerGroup playerGroup) {
        return gameRepository.findFirstByPlayerGroupAndActiveIsTrue(playerGroup);
    }
}

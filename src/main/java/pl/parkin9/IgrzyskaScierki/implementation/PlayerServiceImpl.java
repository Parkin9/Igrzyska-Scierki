package pl.parkin9.IgrzyskaScierki.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.parkin9.IgrzyskaScierki.model.Player;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;
import pl.parkin9.IgrzyskaScierki.repository.PlayerRepository;
import pl.parkin9.IgrzyskaScierki.service.PlayerService;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

/////////////////////////////////////////////////////////////////////////////

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public List<Player> findAllPlayers(PlayerGroup playerGroup) {
        return playerRepository.findAllByPlayerGroup(playerGroup);
    }

    @Override
    public void deletePlayer(Player player) {
        playerRepository.delete(player);
    }

    @Override
    public Player findOneById(Long id) {
        return playerRepository.getOne(id);
    }
}

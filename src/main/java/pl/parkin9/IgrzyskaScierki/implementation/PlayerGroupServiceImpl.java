package pl.parkin9.IgrzyskaScierki.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;
import pl.parkin9.IgrzyskaScierki.repository.PlayerGroupRepository;
import pl.parkin9.IgrzyskaScierki.service.PlayerGroupService;

@Service
public class PlayerGroupServiceImpl implements PlayerGroupService {

    private final PlayerGroupRepository playerGroupRepository;

    @Autowired
    public PlayerGroupServiceImpl(PlayerGroupRepository playerGroupRepository) {
        this.playerGroupRepository = playerGroupRepository;
    }

/////////////////////////////////////////////////////////////////////////////

    @Override
    public void savePlayerGroup(PlayerGroup playerGroup) {
        playerGroupRepository.save(playerGroup);
    }

    @Override
    public PlayerGroup findByName (String name) {
        return playerGroupRepository.findFirstByName(name);
    }

}

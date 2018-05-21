package pl.parkin9.IgrzyskaScierki.service;

import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;

public interface PlayerGroupService {

    void savePlayerGroup(PlayerGroup playerGroup);
    PlayerGroup findByName (String name);
}

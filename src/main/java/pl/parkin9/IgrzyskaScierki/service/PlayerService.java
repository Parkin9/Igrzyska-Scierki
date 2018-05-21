package pl.parkin9.IgrzyskaScierki.service;

import pl.parkin9.IgrzyskaScierki.model.Player;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;

import java.util.List;

public interface PlayerService {

    void savePlayer (Player player);

    List<Player> findAllPlayers(PlayerGroup playerGroup);

    Player findOneById(Long id);

    void deletePlayer(Player player);

    /*TODO Metoda do sprawdzania czy dana nazwa zadania,
    nie istnieje juz w bazie. Warunek: tylko w obrebie
    jednego mieszkania (PlayerGroup); relacja OneToMany, ManyToOne.*/
}

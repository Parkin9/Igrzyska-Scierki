package pl.parkin9.IgrzyskaScierki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.parkin9.IgrzyskaScierki.model.Game;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByPlayerGroup(PlayerGroup playerGroup);
    Game findFirstByPlayerGroupAndActiveIsTrue(PlayerGroup playerGroup);
}

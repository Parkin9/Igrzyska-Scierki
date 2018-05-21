package pl.parkin9.IgrzyskaScierki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.parkin9.IgrzyskaScierki.model.Player;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findAllByPlayerGroup (PlayerGroup playerGroup);
}

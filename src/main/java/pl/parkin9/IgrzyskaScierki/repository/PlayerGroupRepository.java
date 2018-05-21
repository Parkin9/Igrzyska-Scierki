package pl.parkin9.IgrzyskaScierki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.parkin9.IgrzyskaScierki.model.PlayerGroup;

@Repository
public interface PlayerGroupRepository extends JpaRepository<PlayerGroup, Long> {

    PlayerGroup findFirstByName (String name);
}

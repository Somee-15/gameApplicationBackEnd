package com.stackroute.fgf.repository;

import com.stackroute.fgf.domain.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*Repository class which have definition of Database related operation*/
@Repository
public interface PlayerRepository extends CrudRepository<Player,Integer> {
    @Query("select p from Player p where p.name=?1")
    List<Player> findByName(String name);

    @Query("select count(p) from Player p where p.name=?1")
    int playerExits(String name);
}

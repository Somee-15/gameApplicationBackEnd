package com.stackroute.fgf.repository;

import com.stackroute.fgf.domain.Player;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends MongoRepository<Player,String> {
//    @Query("select p from Player p where p.name=?1")
//    List<Player> findByName(String name);
//
//    @Query("select count(p) from Player p where p.name=?1")
//    int playerExits(String name);


    public List<Player> findByname(String name);
    public List<Player> findByid(String id);

}

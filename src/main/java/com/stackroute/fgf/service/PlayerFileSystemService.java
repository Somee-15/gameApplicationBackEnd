package com.stackroute.fgf.service;

import com.stackroute.fgf.domain.Player;
import com.stackroute.fgf.repository.PlayerRepository;
import com.stackroute.fgf.repository.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerFileSystemService implements PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerFileSystemService(PlayerRepository playerRepository){
        this.playerRepository=playerRepository;
    }

    @Override
    public Player setPlayer(Player player) {
        Player savePlayer = playerRepository.save(player);
        return savePlayer;
    }

    @Override
    public Iterable<Player> getAllPlayers() {
        Iterable<Player> list = playerRepository.findAll();
        return list;
    }

    @Override
    public Player updatePlayer(Player player,int id) {
        player.setId(id);
        Player updatePlayer = playerRepository.save(player);
        return updatePlayer;
    }


    @Override
    public Optional<Player> getPlayerById(int id) {
        Optional<Player> playerByid = playerRepository.findById(id);
        return playerByid;
    }

    @Override
    public void deletePlayerById(int id) {
        playerRepository.deleteById(id);
    }

    public Iterable<Player> getPlayerByName(String name){
        Iterable<Player> playerByName =  playerRepository.findByName(name);
        return playerByName;
    }

}

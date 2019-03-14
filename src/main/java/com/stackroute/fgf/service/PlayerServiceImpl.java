package com.stackroute.fgf.service;

import com.stackroute.fgf.domain.Player;
import com.stackroute.fgf.exceptions.PlayerAlreadyExitsException;
import com.stackroute.fgf.exceptions.PlayerNotExitsException;
import com.stackroute.fgf.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Iterables.isEmpty;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository){
        this.playerRepository=playerRepository;
    }

    @Override
    public Player savePlayer(Player player) throws PlayerAlreadyExitsException {
        if(playerRepository.existsById(player.getId()))
        {
            throw new PlayerAlreadyExitsException("Player already Exits");
        }
        Player savePlayer = playerRepository.save(player);
        return savePlayer;
    }

    @Override
    public Iterable<Player> getAllPlayers() {
        Iterable<Player> list = playerRepository.findAll();
        return list;
    }

    @Override
    public Player updatePlayerById(Player player,String id) throws PlayerNotExitsException {
        player.setId(id);
        if(!playerRepository.existsById(id)) {
            throw new PlayerNotExitsException("Player Not Exits");
        }
        Player updatePlayer = playerRepository.save(player);
        return updatePlayer;
    }

    @Override
    public List<Player> getPlayerById(String id) throws PlayerNotExitsException {
        if (!playerRepository.existsById(id)) {
            throw new PlayerNotExitsException("Player Not Exits");
        }
        List<Player> playerByid = playerRepository.findByid(id);
        return playerByid;
    }

    @Override
    public void deletePlayerById(String id) throws PlayerNotExitsException {
        if(!playerRepository.existsById(id)) {
            throw new PlayerNotExitsException("Player Not Exits");
        }
        playerRepository.deleteById(id);
    }

    public Iterable<Player> getPlayerByName(String name) throws PlayerNotExitsException{
        if(playerRepository.findByname(name).isEmpty()){
            throw new PlayerNotExitsException("Player Not Exits");
        }
        Iterable<Player> playerByName =  playerRepository.findByname(name);
        return playerByName;
    }

}

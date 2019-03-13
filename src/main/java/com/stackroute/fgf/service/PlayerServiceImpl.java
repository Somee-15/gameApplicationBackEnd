package com.stackroute.fgf.service;

import com.stackroute.fgf.domain.Player;
import com.stackroute.fgf.exceptions.PlayerAlreadyExitsException;
import com.stackroute.fgf.exceptions.PlayerNotExitsException;
import com.stackroute.fgf.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
* Implements PlayerService Interface
*/
@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;


    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /*
    * Method to Save Player Details
    */
    @Override
    public Player savePlayer(Player player) throws PlayerAlreadyExitsException {
        if (playerRepository.existsById(player.getId())) {
            throw new PlayerAlreadyExitsException("Player already Exits");
        }
        Player savePlayer = playerRepository.save(player);
        return savePlayer;
    }

    /*
    * Method to Get All Player Details
    */
    @Override
    public Iterable<Player> getAllPlayers() {
        Iterable<Player> list = playerRepository.findAll();
        return list;
    }

    /*
    * Method to Update Player Details
    * Using Player Id
    */
    @Override
    public Player updatePlayerById(Player player, int id) throws PlayerNotExitsException {
        player.setId(id);
        if (!playerRepository.existsById(id)) {
            throw new PlayerNotExitsException("Player Not Exits");
        }
        Player updatePlayer = playerRepository.save(player);
        return updatePlayer;
    }


    /*
    * Method to Search for Player Details
    * Using Player Id
    */
    @Override
    public Optional<Player> getPlayerById(int id) throws PlayerNotExitsException {
        if (!playerRepository.existsById(id)) {
            throw new PlayerNotExitsException("Player Not Exits");
        }

        Optional<Player> playerByid = playerRepository.findById(id);
        return playerByid;
    }

    /*
    * Method to Delete Player Details from DB
    * Using Player Id
    */
    @Override
    public void deletePlayerById(int id) throws PlayerNotExitsException {
        if (!playerRepository.existsById(id)) {
            throw new PlayerNotExitsException("Player Not Exits");
        }
        playerRepository.deleteById(id);
    }

    /*
    * Method to Search for Player Details
    * Using Player Name
    */
    public Iterable<Player> getPlayerByName(String name) throws PlayerNotExitsException {
        if (playerRepository.playerExits(name) == 0) {
            throw new PlayerNotExitsException("Player Not Exits");
        }
        Iterable<Player> playerByName = playerRepository.findByName(name);
        return playerByName;
    }

}

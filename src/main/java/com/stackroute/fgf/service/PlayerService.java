package com.stackroute.fgf.service;

import com.stackroute.fgf.domain.Player;
import com.stackroute.fgf.exceptions.PlayerAlreadyExitsException;
import com.stackroute.fgf.exceptions.PlayerNotExitsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*Service class*/
@Service
public interface PlayerService {
    public Player savePlayer(Player Player) throws PlayerAlreadyExitsException;

    public Iterable<Player> getAllPlayers();

    public Player updatePlayerById(Player Player, int id) throws PlayerNotExitsException;

    public Optional<Player> getPlayerById(int id) throws PlayerNotExitsException;

    public void deletePlayerById(int id) throws PlayerNotExitsException;

    public Iterable<Player> getPlayerByName(String name) throws PlayerNotExitsException;

}

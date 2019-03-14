package com.stackroute.fgf.service;

import com.stackroute.fgf.domain.Player;
import com.stackroute.fgf.exceptions.PlayerAlreadyExitsException;
import com.stackroute.fgf.exceptions.PlayerNotExitsException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Optional;

@Service
public interface PlayerService {
    public Player savePlayer(Player Player) throws PlayerAlreadyExitsException;
    public Iterable<Player> getAllPlayers();
    public Player updatePlayerById(Player Player,String id) throws PlayerNotExitsException;
    public List<Player> getPlayerById(String id) throws PlayerNotExitsException;
    public void deletePlayerById(String id) throws PlayerNotExitsException;
    public Iterable<Player> getPlayerByName(String name) throws PlayerNotExitsException;

}

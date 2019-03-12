package com.stackroute.fgf.repository;

import com.stackroute.fgf.domain.Player;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PlayerService {
    public Player setPlayer(Player Player);
    public Iterable<Player> getAllPlayers();
    public Player updatePlayer(Player Player,int id);
    public Optional<Player> getPlayerById(int id);
    public void deletePlayerById(int id);
    public Iterable<Player> getPlayerByName(String name);

}

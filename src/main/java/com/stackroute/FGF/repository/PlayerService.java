package com.stackroute.FGF.repository;

import com.stackroute.FGF.domain.Player;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PlayerService {
    public Player setPlayer(Player Player);
    public Iterable<Player> getAllPlayers();
    public Player updatePlayer(Player Player,int id);
    public Optional<Player> getPlayerById(int id);
    public void deletePlayerById(int id);
}

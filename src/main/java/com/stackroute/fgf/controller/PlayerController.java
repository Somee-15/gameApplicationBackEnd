package com.stackroute.fgf.controller;

import com.stackroute.fgf.domain.Player;
import com.stackroute.fgf.exceptions.PlayerAlreadyExitsException;
import com.stackroute.fgf.exceptions.PlayerNotExitsException;
import com.stackroute.fgf.service.PlayerService;
import com.stackroute.fgf.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fgf/api/v1")
public class PlayerController {
    private PlayerService playerService;


    @Autowired
    public PlayerController(PlayerServiceImpl playerServiceImpl) {
        this.playerService = playerServiceImpl;
    }

    @PostMapping("/player")
    public ResponseEntity<String> savePlayer(@RequestBody Player Player) throws PlayerAlreadyExitsException {
        ResponseEntity responseEntity;
        playerService.savePlayer(Player);
        responseEntity = new ResponseEntity<String>("Succesfully add", HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/players")
    public ResponseEntity<Iterable<Player>> getPlayers() {
        Iterable<Player> allPlayer = playerService.getAllPlayers();
        return new ResponseEntity<Iterable<Player>>(allPlayer, HttpStatus.OK);
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable String id) throws PlayerNotExitsException {
        ResponseEntity responseEntity;
        List<Player> Player = playerService.getPlayerById(id);
        responseEntity = new ResponseEntity<List<Player>>(Player, HttpStatus.FOUND);
        return responseEntity;
    }

    @PutMapping("/player/{id}")
    public ResponseEntity<?> updatePlayer(@RequestBody Player Player, @PathVariable String id) throws PlayerNotExitsException {
        ResponseEntity responseEntity;
        Player savedPlayer = playerService.updatePlayerById(Player, id);
        responseEntity = new ResponseEntity<Player>(savedPlayer, HttpStatus.FOUND);
        return responseEntity;

    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<?> deletePlayerById(@PathVariable String id) throws PlayerNotExitsException {
        ResponseEntity responseEntity;

        playerService.deletePlayerById(id);
        responseEntity = new ResponseEntity<Player>(HttpStatus.FOUND);
        return responseEntity;
    }

    @GetMapping("/players/{name}")
    public ResponseEntity<?> getplayer(@PathVariable String name) throws PlayerNotExitsException {
        ResponseEntity responseEntity;
        Iterable<Player> player = playerService.getPlayerByName(name);
        responseEntity = new ResponseEntity<Iterable<Player>>(player, HttpStatus.FOUND);
        return responseEntity;
    }

}

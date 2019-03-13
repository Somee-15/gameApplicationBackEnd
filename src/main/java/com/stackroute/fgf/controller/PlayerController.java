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

import java.util.Optional;

/*Controller to map url requests*/
@RestController
@RequestMapping("/fgf/api/v1")
public class PlayerController {
    private PlayerService playerService;


    @Autowired
    public PlayerController(PlayerServiceImpl playerServiceImpl) {
        this.playerService = playerServiceImpl;
    }

    /*Mapping of Saveplayer Details Method*/
    @PostMapping("/player")
    public ResponseEntity<String> savePlayer(@RequestBody Player Player) throws PlayerAlreadyExitsException {
        ResponseEntity responseEntity;
        playerService.savePlayer(Player);
        responseEntity = new ResponseEntity<String>("Succesfully add", HttpStatus.CREATED);
        return responseEntity;
    }


    /*Mapping of GetAllPlayer Details Method*/
    @GetMapping("/players")
    public ResponseEntity<Iterable<Player>> getPlayers() {
        Iterable<Player> allPlayer = playerService.getAllPlayers();
        return new ResponseEntity<Iterable<Player>>(allPlayer, HttpStatus.OK);
    }

    /*Mapping of GetPlayer Details Method using Player Id*/
    @GetMapping("/player/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable int id) throws PlayerNotExitsException {
        ResponseEntity responseEntity;
        Optional<Player> Player = playerService.getPlayerById(id);
        responseEntity = new ResponseEntity<Optional<Player>>(Player, HttpStatus.FOUND);

        return responseEntity;

    }

    /*Mapping of UpdatePlayer Details Method using Player Id*/
    @PutMapping("/player/{id}")
    public ResponseEntity<?> updatePlayerById(@RequestBody Player Player, @PathVariable int id) throws PlayerNotExitsException {
        ResponseEntity responseEntity;
        Player savedPlayer = playerService.updatePlayerById(Player, id);
        responseEntity = new ResponseEntity<Player>(savedPlayer, HttpStatus.FOUND);
        return responseEntity;

    }

    /*Mapping of DeletePlayer Details Method using Player Id*/
    @DeleteMapping("/player/{id}")
    public ResponseEntity<?> deletePlayerById(@PathVariable int id) throws PlayerNotExitsException {
        ResponseEntity responseEntity;
        playerService.deletePlayerById(id);
        responseEntity = new ResponseEntity<Player>(HttpStatus.FOUND);
        return responseEntity;
    }

    /*Mapping of GetPlayer Details Method using Player Name*/
    @GetMapping("/player/{name}")
    public ResponseEntity<?> getplayerByName(@PathVariable String name) throws PlayerNotExitsException {
        ResponseEntity responseEntity;
        Iterable<Player> player = playerService.getPlayerByName(name);
        responseEntity = new ResponseEntity<Iterable<Player>>(player, HttpStatus.FOUND);
        return responseEntity;
    }

}

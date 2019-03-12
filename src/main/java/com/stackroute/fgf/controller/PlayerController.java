package com.stackroute.fgf.controller;

import com.stackroute.fgf.domain.Player;
import com.stackroute.fgf.repository.PlayerService;
import com.stackroute.fgf.service.PlayerFileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/fgf/api/v1")
public class PlayerController {
    private PlayerService playerService;


    @Autowired
    public PlayerController(PlayerFileSystemService PlayerFileSystemService){
        this.playerService=PlayerFileSystemService;
    }

    @PostMapping("/player")
    public ResponseEntity<Player> savePlayer(@RequestBody Player Player){
        Player savedPlayer = playerService.setPlayer(Player);
        return new ResponseEntity<Player>(savedPlayer, HttpStatus.OK);
    }

    @GetMapping("/players")
    public  ResponseEntity<Iterable<Player>> getPlayers(){
        Iterable<Player> allPlayer = playerService.getAllPlayers();
        return new ResponseEntity<Iterable<Player>>(allPlayer,HttpStatus.OK);
    }

    @GetMapping("/player/{id}")
    public  ResponseEntity<Optional<Player>> getPlayer(@PathVariable int id){
        Optional<Player> Player = playerService.getPlayerById(id);
        return new ResponseEntity<Optional<Player>>(Player,HttpStatus.OK);
    }

    @PutMapping("/player/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player Player,@PathVariable int id){
        Player savedPlayer = playerService.updatePlayer(Player,id);
        return new ResponseEntity<Player>(savedPlayer, HttpStatus.OK);

    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<Player> deletePlayerById(@PathVariable int id){

        playerService.deletePlayerById(id);
        return new ResponseEntity<Player>(HttpStatus.OK);
    }

    @GetMapping("/players/{name}")
    public ResponseEntity<Iterable<Player>> getplayer(@PathVariable String name){
        Iterable<Player> player = playerService.getPlayerByName(name);
        return new ResponseEntity<Iterable<Player>>(player,HttpStatus.OK);
    }

}

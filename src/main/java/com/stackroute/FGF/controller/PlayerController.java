package com.stackroute.FGF.controller;

import com.stackroute.FGF.domain.Player;
import com.stackroute.FGF.repository.PlayerServiceImpl;
import com.stackroute.FGF.service.PlayerFileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/fgf/api/v1")
public class PlayerController {
    private PlayerServiceImpl PlayerService;


    @Autowired
    public PlayerController(PlayerFileSystemService PlayerFileSystemService){
        this.PlayerService=PlayerFileSystemService;
    }

    @PostMapping("/player")
    public ResponseEntity<Player> savePlayer(@RequestBody Player Player){
        Player savedPlayer = PlayerService.setPlayer(Player);
        return new ResponseEntity<Player>(savedPlayer, HttpStatus.OK);
    }

    @GetMapping("/players")
    public  ResponseEntity<Iterable<Player>> getPlayers(){
        Iterable<Player> allPlayer = PlayerService.getAllPlayers();
        return new ResponseEntity<Iterable<Player>>(allPlayer,HttpStatus.OK);
    }

    @GetMapping("/player/{id}")
    public  ResponseEntity<Optional<Player>> getPlayer(@PathVariable int id){
        Optional<Player> Player = PlayerService.getPlayerById(id);
        return new ResponseEntity<Optional<Player>>(Player,HttpStatus.OK);
    }

    @PutMapping("/player/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player Player,@PathVariable int id){
        Player savedPlayer = PlayerService.updatePlayer(Player,id);
        return new ResponseEntity<Player>(savedPlayer, HttpStatus.OK);

    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<Player> deletePlayerById(@PathVariable int id){

        PlayerService.deletePlayerById(id);
        return new ResponseEntity<Player>(HttpStatus.OK);
    }
}

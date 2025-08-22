package com.aloo.iplproject.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/players")
@CrossOrigin(origins = "http://localhost:3000")
public class playerController {

    private final playerservice playerservice;

    @Autowired
    public playerController(playerservice playerservice){
        this.playerservice = playerservice;
    }

    @GetMapping
    public List<player> getPlayers(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String role){
        
        if(name != null && role != null){
            return playerservice.getPlayersByNameAndRole(name, role);
        }
        else if(name != null){
            return playerservice.getPlayerByName(name);
        }
        else if(role != null){
            return playerservice.getPlayersByRole(role);
        }
        else {
            return playerservice.getPlayers();
        }
    }

    @PostMapping
    public ResponseEntity<player> addPlayer(@RequestBody player player){
        player createdPlayer = playerservice.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<player> updatePlayer(@RequestBody player player){
        player updatedPlayer = playerservice.updatePlayer(player);
        if(updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

     @GetMapping("/team/{teamName}")
    public List<player> getPlayersByTeam(@PathVariable String teamName) {
        return playerservice.getPlayersByTeam(teamName);
    }

    
    @DeleteMapping("/{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable int playerId){
        playerservice.deletePlayerById(playerId);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
}

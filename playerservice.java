package com.aloo.iplproject.player;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class playerservice {

    private final playerrepository playerrepository;

    @Autowired
    public playerservice(playerrepository playerrepository){
        this.playerrepository = playerrepository;
    }

     public List<player> getPlayersByTeam(String team) {
        return playerrepository.findByTeam(team);
    }

    public List<player> getPlayers(){
        return playerrepository.findAll();
    }

    public List<player> getPlayerByName(String name) {
        return playerrepository.findByName(name);
    }

    public List<player> getPlayersByRole(String role) {
        return playerrepository.findByRole(role);
    }

    public List<player> getPlayersByNameAndRole(String name, String role){
        return playerrepository.findByNameAndRole(name, role);
    }

    public player addPlayer(player player){
        return playerrepository.save(player);
    }

    /**
     * Update player by id. Returns updated Player or null if Player doesn't exist.
     */
    public player updatePlayer(player updatedPlayer){
        Optional<player> existingPlayerOptional = playerrepository.findById(updatedPlayer.getPlayer_id());
        if(existingPlayerOptional.isPresent()){
            player existingPlayer = existingPlayerOptional.get();

            // Update the fields
            existingPlayer.setName(updatedPlayer.getName());
            existingPlayer.setRole(updatedPlayer.getRole());
            existingPlayer.setMatchesBatted(updatedPlayer.getMatchesBatted());
            existingPlayer.setRuns(updatedPlayer.getRuns());
            existingPlayer.setBattingAverage(updatedPlayer.getBattingAverage());
            existingPlayer.setCentury(updatedPlayer.getCentury());
            existingPlayer.setHalfCentury(updatedPlayer.getHalfCentury());
            existingPlayer.setMatchesBowled(updatedPlayer.getMatchesBowled());
            existingPlayer.setWickets(updatedPlayer.getWickets());
            existingPlayer.setBowlingAverage(updatedPlayer.getBowlingAverage());
            existingPlayer.setEconomy(updatedPlayer.getEconomy());

            return playerrepository.save(existingPlayer);
        }
        return null; // or throw an exception depending on your design
    }

    
    @Transactional
    public boolean deletePlayerById(int playerId){
        boolean exists = playerrepository.existsById(playerId);
        if(exists){
            playerrepository.deleteById(playerId);
            return true;
        }
        return false;
    }

   
    @Transactional
    public void deletePlayersByName(String playerName){
        playerrepository.deleteByName(playerName);
    }
}

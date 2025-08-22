package com.aloo.iplproject.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface playerrepository extends JpaRepository<player, Integer>{
    void deleteByName(String playername);
    List<player> findByName(String name);
    List<player> findByNameAndRole(String name, String role);
    List<player> findByRole(String role);
    List<player> findByNameContainingIgnoreCase(String name);
    List<player> findByTeam(String team);
}

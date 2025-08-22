package com.aloo.iplproject.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "iplfinalv")
public class player {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int player_id;

    @Column(name="team")
    private String team; 

    @Column(name = "player_name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "matches_batted")
    private Integer matchesBatted;

    @Column(name = "runs")
    private Integer runs;

    @Column(name = "batting_average")
    private Double battingAverage;

    @Column(name = "centuries")
    private Integer century;

    @Column(name = "half_centuries")
    private Integer halfCentury;

    @Column(name = "matches_bowled")
    private Integer matchesBowled;

    @Column(name = "wickets")
    private Integer wickets;

    @Column(name = "bowling_average")
    private Double bowlingAverage;

    @Column(name = "economy")
    private Double economy;

    // No-argument constructor
    public player() {
    }

    // All-args constructor
    public player(int player_id, String team, String name, String role, Integer matchesBatted, Integer runs, Double battingAverage,
                  Integer century, Integer halfCentury, Integer matchesBowled, Integer wickets, Double bowlingAverage, Double economy) {
        this.player_id = player_id;
        this.team = team;
        this.name = name;
        this.role = role;
        this.matchesBatted = matchesBatted;
        this.runs = runs;
        this.battingAverage = battingAverage;
        this.century = century;
        this.halfCentury = halfCentury;
        this.matchesBowled = matchesBowled;
        this.wickets = wickets;
        this.bowlingAverage = bowlingAverage;
        this.economy = economy;
    }


    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }
    
    public String getTeam(){
        return team;
    }

    public void setTeam(String team){
        this.team = team;
    }

    // Getters and setters for other fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getMatchesBatted() {
        return matchesBatted;
    }

    public void setMatchesBatted(Integer matchesBatted) {
        this.matchesBatted = matchesBatted;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Double getBattingAverage() {
        return battingAverage;
    }

    public void setBattingAverage(Double battingAverage) {
        this.battingAverage = battingAverage;
    }

    public Integer getCentury() {
        return century;
    }

    public void setCentury(Integer century) {
        this.century = century;
    }

    public Integer getHalfCentury() {
        return halfCentury;
    }

    public void setHalfCentury(Integer halfCentury) {
        this.halfCentury = halfCentury;
    }

    public Integer getMatchesBowled() {
        return matchesBowled;
    }

    public void setMatchesBowled(Integer matchesBowled) {
        this.matchesBowled = matchesBowled;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }

    public Double getBowlingAverage() {
        return bowlingAverage;
    }

    public void setBowlingAverage(Double bowlingAverage) {
        this.bowlingAverage = bowlingAverage;
    }

    public Double getEconomy() {
        return economy;
    }

    public void setEconomy(Double economy) {
        this.economy = economy;
    }
}

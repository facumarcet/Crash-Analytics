/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crash.db.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Facundo
 */
@Entity
@Table(name = "rocket_crash")
public class RocketCrash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_rocket_crash;
    
    @Column(name = "game_id")
    private String gameId;
    
    @Column(name = "crash_on")
    private float crashOn;

    public long getId_rocket_crash() {
        return id_rocket_crash;
    }

    public void setId_rocket_crash(long id_rocket_crash) {
        this.id_rocket_crash = id_rocket_crash;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public float getCrashOn() {
        return crashOn;
    }

    public void setCrashOn(float crashOn) {
        this.crashOn = crashOn;
    }
    
    
}

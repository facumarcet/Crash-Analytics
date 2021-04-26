/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crash.db.services;

import com.crash.db.dto.RocketCrashInput;
import com.crash.db.persistence.model.RocketCrash;
import com.crash.db.persistence.repo.IRocketCrashRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Facundo
 */
@Service
public class RocketCrashService {
    @Autowired
    private IRocketCrashRepo rocketCrashRepo;
    public void insertMultipleCrashes(List<RocketCrashInput> body) {
        for(RocketCrashInput crash: body) {
            Optional<RocketCrash> foundCrash = rocketCrashRepo.findByGameId(crash.id);
            if (!foundCrash.isPresent()) {
                createCrash(crash);
            }
        }
    }
    
    private void createCrash(RocketCrashInput body) {
        RocketCrash crash = new RocketCrash();
        crash.setCrashOn(body.crashPoint);
        crash.setGameId(body.id);
        rocketCrashRepo.save(crash);
    }
}

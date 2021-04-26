/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crash.db.api;

import com.crash.db.dto.RocketCrashInput;
import com.crash.db.services.RocketCrashService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Facundo
 */
@RestController
@RequestMapping("/rocketCrash")
public class RocketCrashController {
    private static final Logger log = Logger.getLogger( RocketCrashController.class.getName() );
    @Autowired
    private RocketCrashService rocketCrashSrv;
    
    @PostMapping(value = "/create")
    public ResponseEntity<Void> addCrashes(@RequestBody List<RocketCrashInput> body) {
        try {
            rocketCrashSrv.insertMultipleCrashes(body);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            log.log(Level.SEVERE, e.toString(), e);
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

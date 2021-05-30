/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crash.db.interfaces;

import com.crash.db.dto.RocketCrashInput;
import com.crash.db.dto.RocketCrashOutput;
import java.util.List;

/**
 *
 * @author Facundo
 */
public interface IRocketCrashService {
    public void insertMultipleCrashes(List<RocketCrashInput> body);
    public List<RocketCrashOutput> getAllCrashes();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crash.db.services;

import com.crash.db.dto.RocketCrashOutput;
import com.crash.db.interfaces.IRocketCrashService;
import com.crash.db.persistence.model.RocketCrash;
import com.crash.db.persistence.repo.IRocketCrashRepo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author Facundo
 */
public class RocketCrashServiceTest {

    @InjectMocks
    private RocketCrashService rocketSrv;
    @Mock
    private IRocketCrashRepo rocketRepo;

    @BeforeEach
    public void init() {
        System.out.println("Init mocks");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Test get list of crashes")
    public void testGetListCrashes() {
        RocketCrash crash = new RocketCrash("abc", 1);
        List<RocketCrash> list = new ArrayList<>();
        list.add(crash);
        
        
        Mockito.when(rocketRepo.findAll()).thenReturn(list);
        Assertions.assertTrue(rocketSrv.getAllCrashes().size() > 0);
    }
}

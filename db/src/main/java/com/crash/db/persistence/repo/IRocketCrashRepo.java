/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crash.db.persistence.repo;

import com.crash.db.persistence.model.RocketCrash;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Facundo
 */
public interface IRocketCrashRepo extends JpaRepository<RocketCrash, Long> {
    @Query(value = "SELECT * FROM rocket_crash WHERE game_id = ?1 LIMIT 1", nativeQuery = true)
    Optional<RocketCrash> findByGameId(String gameId);
}

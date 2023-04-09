package com.intuit.player.repository;

import com.intuit.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Manages db access to table players
 */
public interface PlayerRepository extends JpaRepository<Player, String> {

}

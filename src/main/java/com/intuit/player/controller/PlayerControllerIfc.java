package com.intuit.player.controller;

import com.intuit.player.PlayerConstants;
import com.intuit.player.model.Player;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Handles rest API calls
 */
public interface PlayerControllerIfc {

    /**
     * Get all players data
     *
     * @return ResponseEntity<List < Player>>
     */
    ResponseEntity<List<Player>> getPlayers();

    /**
     * Get specific player by id
     * (If none found; Returns 404)
     *
     * @param id String
     * @return ResponseEntity<Player>
     */
    ResponseEntity<Player> getPlayerById(@PathVariable(value = PlayerConstants.PLAYER_ID) String id);

    /**
     * Create new player
     *
     * @param requestEntity RequestEntity<Player>
     * @return ResponseEntity<Player>
     */
    ResponseEntity<Player> createPlayer(RequestEntity<Player> requestEntity);
}

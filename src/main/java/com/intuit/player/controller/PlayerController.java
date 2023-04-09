package com.intuit.player.controller;

import com.intuit.player.PlayerConstants;
import com.intuit.player.model.Player;
import com.intuit.player.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Handles rest API calls
 */
@RestController
@RequestMapping(PlayerConstants.MAIN_API_PATH)
@Slf4j
public class PlayerController implements PlayerControllerIfc {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping()
    @Override
    public ResponseEntity<List<Player>> getPlayers() {
        log.info("Fetching list of all existing players");
        List<Player> players = playerService.getPlayers();
        // Returns empty list with code 204 (No content) or 200 with actual content:
        return (players.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(players);
    }

    @GetMapping(PlayerConstants.PLAYER_ID_URI_PARAM)
    @Override
    public ResponseEntity<Player> getPlayerById(@PathVariable(value = PlayerConstants.PLAYER_ID) String id) {
        log.info("Fetching specific player according to ID " + id);
        Player player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }

    @PostMapping(PlayerConstants.PLAYER_ID_URI_PARAM)
    @Override
    public ResponseEntity<Player> createPlayer(@PathVariable(value = PlayerConstants.PLAYER_ID) String id, RequestEntity<Player> requestEntity) {
        log.info("Creating new player with following id" + id);
        Player player = playerService.savePlayer(requestEntity.getBody());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("/players/" + player.getPlayerID()));
        return new ResponseEntity<>(player, httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping()
    @Override
    public ResponseEntity<List<Player>> createPlayers(RequestEntity<List<Player>> requestEntities) {
        log.info("Creating new players");
        List<Player> players = playerService.savePlayers(requestEntities.getBody());
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(players, httpHeaders, HttpStatus.CREATED);
    }
}

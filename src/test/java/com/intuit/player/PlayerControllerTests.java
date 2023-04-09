package com.intuit.player;

import com.intuit.player.controller.PlayerController;
import com.intuit.player.exception.EntityNotFoundException;
import com.intuit.player.model.Player;
import com.intuit.player.service.PlayerService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerControllerTests {
    @Mock
    private PlayerService playerService;
    @InjectMocks
    private PlayerController playerController;

    @Test
    @DisplayName("When we call player service get players method return a valid response; " +
            "controller should return response in status 200 and players included in the response body")
    public void testGetPlayersShouldPass() {
        // Arrange
        List<Player> players = new ArrayList<>();
        players.add(new Player("player-1"));
        players.add(new Player("player-2"));
        when(playerService.getPlayers()).thenReturn(players);
        // Act
        ResponseEntity<List<Player>> responseEntity = playerController.getPlayers();
        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(players, responseEntity.getBody());
    }

    @Test
    @DisplayName("When we call player service get player by id and it finds the player controller should " +
            "return response in status 200 and player included in the response body")
    public void testGetPlayerByIdShouldPass() {
        // Arrange
        String playerId = "player-1";
        Player player = new Player(playerId);
        when(playerService.getPlayerById(playerId)).thenReturn(player);
        // Act
        ResponseEntity<Player> responseEntity = playerController.getPlayerById(playerId);
        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(player, responseEntity.getBody());
    }

    @Test
    @DisplayName("When we call player service get player by id and it's not found " +
            "return response in status 404")
    public void testGetPlayerByIdShouldNotBeFound() {
        // Arrange
        String playerId = "player-1";
        when(playerService.getPlayerById(playerId)).thenThrow(EntityNotFoundException.class);
        // Act
        ResponseEntity<Player> response = playerController.getPlayerById(playerId);
        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @DisplayName("When we create new player and it was saved successfully by the service " +
            "controller should return 201 with the saved player in response body")

    public void testCreatePlayerShouldPass() {
        // Arrange
        Player player = new Player("player-1");
        ResponseEntity<Player> expectedResponse = new ResponseEntity<>(player, HttpStatus.CREATED);
        when(playerService.savePlayer(player)).thenReturn(player);

        // Act
        RequestEntity<Player> requestEntity = new RequestEntity<>(player, HttpMethod.POST, URI.create("/players"));
        ResponseEntity<Player> response = playerController.createPlayer(requestEntity);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(player, response.getBody());
    }
}

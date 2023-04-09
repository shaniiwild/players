package com.intuit.player;

import com.intuit.player.model.Player;
import com.intuit.player.repository.PlayerRepository;
import com.intuit.player.service.PlayerService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTests {
    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    @DisplayName("When we call player service get players method should return list of saved players")
    public void testGetPlayersShouldPass() {
        // Arrange
        List<Player> players = new ArrayList<>();
        players.add(new Player("player-1"));
        players.add(new Player("player-2"));
        when(playerRepository.findAll()).thenReturn(players);
        // Act
        List<Player> playersList = playerService.getPlayers();
        // Assert
        assertEquals(players, playersList);
    }

    // todo complete tests for createPlayer, getPlayerById, With positive and non-positive outcomes
}

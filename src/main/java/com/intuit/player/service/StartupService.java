package com.intuit.player.service;

import com.intuit.player.PlayerConstants;
import com.intuit.player.model.Player;
import com.intuit.player.util.CSVUtil;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * All actions related to application loading
 **/
@Service
@AllArgsConstructor
public class StartupService {
    private final PlayerService playerService;

    /**
     * Responsible for initializing players from CSV;
     * Called after app context has been refreshed, Before application runners have been called
     */
    @EventListener(ApplicationStartedEvent.class)
    public void loadPlayers() throws Exception {
        // Get path to file in resources:
        Path path = Paths.get(ClassLoader.getSystemResource(PlayerConstants.PLAYER_CSV_FILE_NAME).toURI());
        // Create List of Player based on csv data:
        List<Player> csvPlayers = CSVUtil.csvToBeanBuilder(path, Player.class);
        // Save to db:
        playerService.savePlayers(csvPlayers);
    }
}

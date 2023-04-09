package com.intuit.player.service;

import com.intuit.player.exception.EntityNotFoundException;
import com.intuit.player.model.Player;
import com.intuit.player.repository.PlayerRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PlayerService {
    private final PlayerRepository playerRepository;

    /**
     * Save list of players to db
     *
     * @param playerList List<Player>
     * @return List<Player>
     */
    public List<Player> savePlayers(List<Player> playerList) {
        playerRepository.saveAll(playerList);
        return playerList;
    }

    /**
     * Get all existing players
     *
     * @return List<Player>
     */
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    /**
     * Get specific player by id
     *
     * @param id String
     * @return Player
     */
    public Player getPlayerById(String id) throws EntityNotFoundException {
        return playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id " + id));
    }

    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }
}

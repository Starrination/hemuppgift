package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class DemoController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping(path="/players")
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        for(Player player: playerRepository.findAll()) {
            players.add(player);
        }
        return players;
    }

    @GetMapping(path="/players/{id}")
    public Player getPlayer(@PathVariable Integer id) {
        return playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PostMapping(path="/players")
    public Player addPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PostMapping (path="/players/{id}")
    public Player updatePlayer(@RequestBody Player newPlayer, @PathVariable Integer id) {
        return playerRepository.findById(id)
        .map(player -> {
                player.setName(newPlayer.getName());
                player.setAge(newPlayer.getAge());
                player.setJersey(newPlayer.getJersey());
                return playerRepository.save(player);
         })
         .orElseThrow(() -> new PlayerNotFoundException(id));
    } 

    @DeleteMapping (path="/players/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerRepository.deleteById(id);
    } 

}

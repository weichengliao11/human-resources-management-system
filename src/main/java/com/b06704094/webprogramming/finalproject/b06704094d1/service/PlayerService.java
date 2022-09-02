package com.b06704094.webprogramming.finalproject.b06704094d1.service;

import com.b06704094.webprogramming.finalproject.b06704094d1.repository.PlayerEntityRepository;
import com.b06704094.webprogramming.finalproject.b06704094d1.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
	
	@Autowired
    PlayerEntityRepository playerEntityRepository;
	
	
	// 找到所有的球員
	public List<Player> getAllPlayers() {
			
		return playerEntityRepository.findAll(); 
	}
	
	// 尋找特定球員
	public Player getPlayer(String playerId) {
		
		return playerEntityRepository.findById(playerId).get();
	}
	
	// 新增球員
	public void addPlayer(Player player) {
		
		playerEntityRepository.save(player);
	}

	public void deletePlayer(String playerId) {

		playerEntityRepository.deleteById(playerId);
	}

	public Player findById(String id) {

		return playerEntityRepository.findById(id).get();
	}

}

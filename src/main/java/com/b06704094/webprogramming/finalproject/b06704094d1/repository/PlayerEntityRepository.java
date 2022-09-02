package com.b06704094.webprogramming.finalproject.b06704094d1.repository;

import com.b06704094.webprogramming.finalproject.b06704094d1.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerEntityRepository extends JpaRepository<Player, String> {
	

}

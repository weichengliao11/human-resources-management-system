package com.b06704094.webprogramming.finalproject.b06704094d1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "PLAYERS")
public class Player {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "PLAYER_ID")
	private String playerId;
	
	@NotBlank
	@Column(name = "PLAYER_NAME")
	private String playerName;
	
	@NotBlank
	@Column(name = "PLAYER_NATION")
	private String playerNation;
	
	@NotBlank
	@Column(name = "PLAYER_NATION_NUMBER")
	private String playerNationNumber;
	
	@NotBlank
	@Column(name = "PLAYER_CLUB")
	private String playerClub;
	
	@NotBlank
	@Column(name = "PLAYER_CLUB_NUMBER")
	private String playerClubNumber;
	
	@NotBlank
	@Column(name = "PLAYER_POSITION")
	private String playerPosition;
	
	@Column(name = "IMAGE_URL")
	private String imageUrl;
	
}

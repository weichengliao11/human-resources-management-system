package com.b06704094.webprogramming.finalproject.b06704094d1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@NotBlank
	@Column(name = "USER_NAME")
	private String userName;
	
	@NotBlank
	@Column(name = "PASSWORD")
	private String password;

	@NotBlank
	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotBlank
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;
}

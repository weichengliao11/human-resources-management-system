package com.b06704094.webprogramming.finalproject.b06704094d1.controller;

import com.b06704094.webprogramming.finalproject.b06704094d1.entity.Player;
import com.b06704094.webprogramming.finalproject.b06704094d1.entity.User;
import com.b06704094.webprogramming.finalproject.b06704094d1.service.UserService;
import com.b06704094.webprogramming.finalproject.b06704094d1.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ApplicationController {

	@Autowired
	PlayerService playerService;
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String defaultPage() { return "redirect:/B06704094-D"; }

	@GetMapping("/home")
	public String goHomePage(HttpSession session) { return "index"; }

	@GetMapping("/players")
	public String getAll(Model model) {

		List<Player> playerList = playerService.getAllPlayers();
		model.addAttribute("players", playerList);
		return "player";
	}

	@GetMapping("/players/findById")
	@ResponseBody
	public Player getPlayerById(String playerId) { return playerService.findById(playerId); }

	@PostMapping("/players/addNew")
	public String addNew(Player player) {

		playerService.addPlayer(player);
		return "redirect:/players";
	}

	@RequestMapping(value = "/players/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String updatePlayer(Player player) {

		playerService.addPlayer(player);
		return "redirect:/players";
	}

	@RequestMapping(value = "/players/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String deletePlayer(String playerId) {

		playerService.deletePlayer(playerId);
		return "redirect:/players";
	}

	@GetMapping("/B06704094-D")
	public String goLoginPage(Model model) {

		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method= {RequestMethod.POST, RequestMethod.GET})
	public String login(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes) {

		model.addAttribute("user", user);
		redirectAttributes.addFlashAttribute("noUserMessage", "User " + user.getUserName() + " doesn't exist!");

		if(userService.isCorrected(user.getUserName(), user.getPassword()))
			return "redirect:/home";
		return "redirect:/B06704094-D";
	}

	@GetMapping("/register")
	public String goRegisterPage(Model model) {

		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes) {

		model.addAttribute("user", user);
		if(userService.userNameDuplicated(user.getUserName())) {

			redirectAttributes.addFlashAttribute("duplicatedMessage", user.getUserName() + " already existed!");
			return "redirect:/register";
		}

		if(userService.emailDuplicated(user.getEmail())) {

			redirectAttributes.addFlashAttribute("duplicatedMessage", user.getEmail() + " already registered!");
			return "redirect:/register";
		}

		userService.register(user);
		redirectAttributes.addFlashAttribute("message1", "You successfully registered!");
		redirectAttributes.addFlashAttribute("message2", "You can login now.");

		return "redirect:/B06704094-D";
	}
}

package com.huynh.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller	
public class HomeController {
	@GetMapping("/")
	
	private String home(HttpSession session, Model model) {
			ArrayList<String> aList = new ArrayList<String>();
			if(session.getAttribute("gold") == null) {
				session.setAttribute("gold", 0);
			}
			if(session.getAttribute("activities") == null) {
				session.setAttribute("activities",aList);
			}
			model.addAttribute("totalGold", session.getAttribute("gold"));
			model.addAttribute("activities", session.getAttribute("activities"));

		return "index.jsp";
	};
	

	@PostMapping("/getGold")
	private String getGold(HttpSession session, @RequestParam("building") String building) {
		ArrayList<String> activity = ( ArrayList<String> ) session.getAttribute("activities");
		Random r = new Random();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd Y h:mma");
		int currentGold = (int) session.getAttribute("gold");
		int goldEarnFromBuilding;
		if(building.equals("farm")) {
			goldEarnFromBuilding = r.nextInt((20-10) +1 ) +10;
			activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldEarnFromBuilding, formatter.format(now)));
		}else if(building.equals("cave")) {
			goldEarnFromBuilding = r.nextInt((10-5) +1 ) +5;
			activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldEarnFromBuilding, formatter.format(now)));
		}else if(building.equals("house")) {
			goldEarnFromBuilding = r.nextInt((5-2) +1 ) +2;
			activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldEarnFromBuilding, formatter.format(now)));
		}else {
			goldEarnFromBuilding = r.nextInt((50+50) +1 ) - 50;
			if(goldEarnFromBuilding > 0) {
				activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldEarnFromBuilding, formatter.format(now)));
			}else {
				activity.add(String.format("You entered a %s and lost %d gold. OUCH! %s \n", building, goldEarnFromBuilding, formatter.format(now)));
			}
		}
		int totalGold = goldEarnFromBuilding + currentGold;
		session.setAttribute("gold", totalGold);
		session.setAttribute("activities", activity);
		return "redirect:/";
	};
}

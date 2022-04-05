package com.villegas.karin.karindvv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.villegas.karin.karindvv.model.Vacante;
import com.villegas.karin.karindvv.service.IntServiceVacantes;
@Controller
public class HomeController {
	@Autowired
	private IntServiceVacantes serviceVacantes;

	@GetMapping("")
	public String home(Model model) {
		List<Vacante> vacantes = serviceVacantes.obtenerTodas();
		model.addAttribute("vacantes",vacantes);
		return "home";
	}
	
	@GetMapping("/acerca")
	public String acerca() {
		return "acerca";
	}
	
}

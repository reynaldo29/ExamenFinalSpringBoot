package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Reserva;
import com.example.demo.services.ReservaService;



@Controller
@RequestMapping("/reservas")
@SessionAttributes("reserva")
public class ReservaController {
	@Autowired
	@Qualifier("reserva")
	ReservaService reservaService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Reserva> reserva = reservaService.listar();
		model.addAttribute("reservas",reserva);
		model.addAttribute("titulo","Lista de Reservas");
		return "reservaListar";
	}
	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Reserva reserva = new Reserva();
		model.put("reserva",reserva);
		model.put("btn", "Crear Reserva");
		return "reservaForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("reserva",reservaService.buscar(id));
		model.addAttribute("btn","Actualizar Reserva");
		return "reservaForm";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated Reserva reserva,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			reserva = new Reserva();
			model.addAttribute("reserva",reserva);
			model.addAttribute("btn","Crear Reserva");
			return "destinoForm";
		}else {
		reservaService.guardar(reserva);
		return "redirect:/reservas/listar";
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		reservaService.eliminar(id);
		return "redirect:/reservas/listar";
	}
}

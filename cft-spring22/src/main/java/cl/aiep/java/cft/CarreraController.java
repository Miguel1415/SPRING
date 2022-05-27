package cl.aiep.java.cft;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.java.cft.modelo.Carrera;
import cl.aiep.java.cft.repository.CarreraRepository;

@Controller
@RequestMapping("/carrera")
public class CarreraController {

	@Autowired
	CarreraRepository carreraRepository;
	
	@GetMapping("/nueva")
	public String carreraNueva(Carrera carrera) 
	{
		return "carrera/form";
	}
	
	@GetMapping("/editar/{id}")
	public String alumnoEditar(@PathVariable int id, Model modelo) {
		Carrera carrera = carreraRepository.findById(id);
		modelo.addAttribute("carrera", carrera);
		return "carrera/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String alumnoEliminar(@PathVariable int id) {
		carreraRepository.delete(id);
		return "redirect:/carrera/listado";
	}
	
	@GetMapping("/listado")
	public String alumnoListado(Model modelo) {
		List<Carrera> carreras = carreraRepository.findAll();
		modelo.addAttribute("carreras", carreras);
		return "carrera/listado";
	}
	
	@PostMapping("/procesar")
	public String carreraProcesar(@Valid Carrera carrera, BindingResult informeValidacion) {
		if( informeValidacion.hasErrors() ) {
			return "carrera/form";
		}
		
		if( carrera.getId() > 0) {
			carreraRepository.edit(carrera);
		} else {
			carreraRepository.create(carrera);	
		}
		return "redirect:/carrera/listado";
	}
	
}



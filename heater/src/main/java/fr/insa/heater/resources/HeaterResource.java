package fr.insa.heater.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.heater.model.Heater;

@RestController
@RequestMapping("/heater")
public class HeaterResource {
	
	private Heater heater = new Heater(20, 20);
	
	@GetMapping("/")
	public Heater getHeater() {
		return heater;
	}
	
	@GetMapping("/status")
	public String getStatus() {
		if (heater.isHeating()) return " heating from " + heater.getCurrentTemperature()+" to "+heater.getOrder();
		return "Not heating";
 	}
	
	@GetMapping("/heating")
	public double getHeating() {
		return heater.getCurrentTemperature();
	}
	
	@GetMapping("/ordre")
	public String lol(@RequestParam(name="valeur", required=false) double value) {
		heater.setOrder(value);
		return "Bien reçu !";
	}
	


	@PostMapping("/order")
	public void order(@RequestParam double value) {
		heater.setOrder(value);
	}
	
	@PutMapping("/")
	public void updateHeater(@RequestBody Heater heater) {
			this.heater.setOrder(heater.getOrder());
	}
	
	

}

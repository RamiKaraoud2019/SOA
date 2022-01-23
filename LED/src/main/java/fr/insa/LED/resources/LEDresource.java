package fr.insa.LED.resources;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.LED.model.LED;

@RestController
@RequestMapping("/LED")
public class LEDresource {
private LED led = new LED(0.5, 1.0);
	
	@GetMapping("/")
	public LED getLED() {
		return led;
	}
	
	@GetMapping("/status")
	public String getStatus() {
		if (led.isON()) return " moving from " + led.getCurrentLuminosity()+" to "+led.getOrder();
		if (led.getCurrentLuminosity()==1) return "Maximal Luminosity";
		return "closed";
 	}
	
	@GetMapping("/luminosity")
	public double getLuminosity() {
		return led.getCurrentLuminosity();
	}
	
	@GetMapping("/ordre")
	public String lol(@RequestParam(name="valeur", required=false) double value) {
		led.setOrder(value);
		return "Bien reçu !";
	}
	
	@PostMapping("/order")
	public void order(@RequestParam double value) {
		led.setOrder(value);
	}
	
	@PutMapping("/")
	public void updateLED(@RequestBody LED led) {
			this.led.setOrder(led.getOrder());
	}
	
	
	
	
}

package fr.insa.shutterservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.shutterservice.model.Shutter; 

@RestController
@RequestMapping("/shutter")
public class ShutterResource {
	
	private Shutter shutter = new Shutter(0.5, 1.0);
	
	@GetMapping("/")
	public Shutter getShutter() {
		return shutter;
	}
	
	@GetMapping("/status")
	public String getStatus() {
		if (shutter.isMoving()) return " moving from " + shutter.getCurrentOpening()+" to "+shutter.getOrder();
		if (shutter.getCurrentOpening()>0) return "open";
		return "closed";
 	}
	
	@GetMapping("/opening")
	public double getOpening(@RequestParam(name="unit", required=false) String unit) {
		if (unit == null || unit.equals("decimal")) return shutter.getCurrentOpening();
		if (unit.equals("percent")) return shutter.getCurrentOpening() * 100;
		return -1;
	}
	
	@GetMapping("/ordre")
	public String lol(@RequestParam(name="valeur", required=false) double value) {
		shutter.setOrder(value);
		return "Bien reçu !";
	}
	
	@PostMapping("/order")
	public void order(@RequestParam double value) {
		shutter.setOrder(value);
	}
	
	@PutMapping("/")
	public void updateShutter(@RequestBody Shutter shutter) {
			this.shutter.setOrder(shutter.getOrder());
	}
	
	
	
	
}

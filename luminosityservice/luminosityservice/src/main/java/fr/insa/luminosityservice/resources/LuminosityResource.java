package fr.insa.luminosityservice.resources;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/luminosity")

public class LuminosityResource {
	@GetMapping("/value")
	public int getLuminosity() {
		return (int) Math.ceil(Math.random() * 100);
	}
}

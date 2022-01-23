package fr.insa.presenceCapteur.resources;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/presence")

public class PresenceService {
	@GetMapping("/value")
	public int getPresence() {
		return (int) Math.ceil((Math.random() * 2) -1 );
	}
}

package fr.insa.tempCapteur.resources;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/temperature")

public class TemperatureResource {
	@GetMapping("/value")
	public int getTemperature() {
		return (int) Math.ceil((Math.random() * 50) - 10);
	}
}

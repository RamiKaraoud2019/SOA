package fr.insa.Automatic.resources;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.Automatic.models.Heater;
import fr.insa.Automatic.models.LED;
import fr.insa.Automatic.models.Shutter;



@RestController
@RequestMapping("/auto")
public class AutomationResource {
		private final String luminosityURI = "http://localhost:2400/luminosity/";
		private final String presenceURI = "http://localhost:2402/presence/";
		private final String temperatureURI = "http://localhost:2403/temperature/";
		
		private final String shutterURI = "http://localhost:2401/shutter/";
		private final String heaterURI = "http://localhost:2404/heater/";
		private final String LEDURI = "http://localhost:2405/LED/";
		
		public String lights(int luminosity, int presence) {
			String msg = "";
			RestTemplate restTemplate = new RestTemplate();
			LED led = restTemplate.getForObject(LEDURI, LED.class);
			if(presence == 1 && luminosity<50) {
				double order =(100-luminosity)/100.0;
				led.setOrder(order);
				msg = " | Un individu est présent dans la salle -> il faut allumer la lumière " ;
			}
			restTemplate.put(LEDURI,  led);
			return msg;
		}
		
		public String windows(int luminosity) {
			String msg = "";
			RestTemplate restTemplate = new RestTemplate();
			Shutter shutter = restTemplate.getForObject(shutterURI, Shutter.class);
			if(luminosity>50) {
				msg+= " | Forte luminosity -> il faut fermer les volets ";
				double order =(100-luminosity)/100.0;
				shutter.setOrder(order);
			}
			else {
				msg+= " | Faible luminosity -> il faut ouvrir les volets ";
				double order = 0.005 + (100-luminosity)/100.0;
				shutter.setOrder(order);
			}
			restTemplate.put(shutterURI,  shutter);
			return msg;
		}
		
		public String chauffage(int temperature) {
			String msg = "";
			RestTemplate restTemplate = new RestTemplate();
			Heater heater = restTemplate.getForObject(heaterURI, Heater.class);
			if(temperature>30) {
				msg+= " | Forte température -> il faut refroidir ";
				heater.setOrder(26);
			}
			else if(temperature<20) {
				msg+= " | Faible température -> il faut réchauffer ";
				heater.setOrder(26);
			}
			restTemplate.put(heaterURI,  heater);
			return msg;
		}
			
		@GetMapping("/run")
		public String run() {
			RestTemplate restTemplate = new RestTemplate();
			
			String msg ="";
				
			
		
			int luminosity = restTemplate.getForObject(luminosityURI+"value", Integer.class);
			msg+= " --- La luminosity est de " + luminosity + "\n" ; 
			
			int currentTemperature = restTemplate.getForObject(temperatureURI+"value", Integer.class);
			msg+= " Temperature actuelle (Celcius): " + currentTemperature + "\n" ;
			
			int presence = restTemplate.getForObject(presenceURI+"value", Integer.class);

			msg+=this.lights(luminosity, presence);
			msg+=this.windows(luminosity);
			msg+=this.chauffage(currentTemperature);
			
			
			
			
			return msg;
			}
			
		}

		


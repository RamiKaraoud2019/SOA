package fr.insa.Automatic.resources;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class AutomationTest {
	AutomationResource myResource;
	
	@BeforeEach                                         
    void setUp() {
		myResource = new AutomationResource();
    }
	
	@Test                                               
    @DisplayName("Automation of lights should work")   
    void testLights() {
		String msg = " | Un individu est présent dans la salle -> il faut allumer la lumière ";
        assertEquals(msg, myResource.lights(40, 1),     
                "Problème de lumière");  
    }
	
	@Test                                               
    @DisplayName("Automation of windows should work")   
    void testWindows() {
		String msg = " | Forte luminosity -> il faut fermer les volets ";
        assertEquals(msg, myResource.windows(60),     
                "Problème de volets");  
    }
	
	@Test                                               
    @DisplayName("Automation of heater should work")   
    void testHeater() {
		String msg = " | Forte température -> il faut refroidir ";
        assertEquals(msg, myResource.chauffage(40),     
                "Problème de chauffage");  
    }
	
}

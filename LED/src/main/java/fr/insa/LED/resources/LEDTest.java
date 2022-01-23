package fr.insa.LED.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


public class LEDTest {
	LEDresource myResource;

    @BeforeEach                                         
    void setUp() {
        myResource = new LEDresource();
    }

    @Test                                               
    @DisplayName("LED should work")   
    void testLED() {
    	int value = 30;
    	myResource.order(value);
        assertEquals(value, myResource.getLED().getOrder(),     
                "Probleme de lampe");  
    }
}

package fr.insa.heater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import fr.insa.heater.model.Heater;
import fr.insa.heater.resources.HeaterResource;

public class HeaterTest {
	HeaterResource myResource;

    @BeforeEach                                         
    void setUp() {
        myResource = new HeaterResource();
    }

    @Test                                               
    @DisplayName("Heater should work")   
    void testHeater() {
    	int value = 30;
    	myResource.order(value);
        assertEquals(value, myResource.getHeater().getOrder(),     
                "Probleme de chauffage");  
    }
}

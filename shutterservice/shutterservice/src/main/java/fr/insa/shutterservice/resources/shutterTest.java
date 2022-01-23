package fr.insa.shutterservice.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


public class shutterTest {
	ShutterResource myResource;

    @BeforeEach                                         
    void setUp() {
        myResource = new ShutterResource();
    }

    @Test                                               
    @DisplayName("Shutter should work")   
    void testHeater() {
    	int value = 30;
    	myResource.order(value);
        assertEquals(value, myResource.getShutter().getOrder(),     
                "Probleme de volets");  
    }
}

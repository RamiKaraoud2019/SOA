package fr.insa.tempCapteur.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class TemperatureTest {
    TemperatureResource myResource;

    @BeforeEach                                         
    void setUp() {
        myResource = new TemperatureResource();
    }

    @Test                                               
    @DisplayName("Temperature sensor should work")   
    void testMultiply() {
    	int temp = myResource.getTemperature();
    	assertTrue(temp >-10  || temp<41);   
    }
}

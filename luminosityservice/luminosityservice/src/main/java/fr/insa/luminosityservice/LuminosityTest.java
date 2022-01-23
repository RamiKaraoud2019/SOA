package fr.insa.luminosityservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import fr.insa.luminosityservice.resources.LuminosityResource;

import static org.junit.Assert.assertTrue;


public class LuminosityTest {

    LuminosityResource myResource;

    @BeforeEach                                         
    void setUp() {
        myResource = new LuminosityResource();
    }

    @Test                                               
    @DisplayName("Luminosity sensor should work")   
    void testMultiply() {
    	int luminosity = myResource.getLuminosity();
    	assertTrue(luminosity >0 && luminosity <100);   
    }
}

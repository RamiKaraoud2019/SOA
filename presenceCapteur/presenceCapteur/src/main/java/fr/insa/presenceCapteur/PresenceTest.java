package fr.insa.presenceCapteur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import fr.insa.presenceCapteur.resources.PresenceService;

import static org.junit.Assert.assertTrue;

public class PresenceTest {
    PresenceService myResource;

    @BeforeEach                                         
    void setUp() {
        myResource = new PresenceService();
    }

    @Test                                               
    @DisplayName("Luminosity sensor should work")   
    void testMultiply() {
    	int presence = myResource.getPresence();
    	assertTrue(presence == 0 || presence == 1);   
    }
}

package com.ds710t.szolgaltatok;

import com.ds710t.szolgaltatok.controller.CAramSzolgaltatok;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Pál Miklós NK-DS710T
 */
public class SzolgaltatokTest {

    public SzolgaltatokTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Ellenőrizzük az összes rekord lekérdezését (controller)
     */
    @Test
    public void testgetAdat() {
        CAramSzolgaltatok am = new CAramSzolgaltatok();

        assertNotNull(am.getAdatXML());

    }
}

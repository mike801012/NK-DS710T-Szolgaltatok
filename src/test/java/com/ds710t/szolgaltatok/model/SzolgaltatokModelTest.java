package com.ds710t.szolgaltatok.model;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Drizzt2
 */
public class SzolgaltatokModelTest {

    public SzolgaltatokModelTest() {
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
     * Ellenőrizzük az összes rekord lekérdezését
     */
    @Test
    public void testSelectAll() {
        MAramSzolgaltatokXML am = new MAramSzolgaltatokXML();

        assertNotNull(am.SelectAll());

    }
}

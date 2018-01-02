package logo.shoppingcar;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestProduct {
	private Product p;

	private double expPrice;
	
	@Before
	public void setUp() throws Exception {
		p = new Product("Book", "UML", 200.0);
		expPrice = 100.0;
	}
	
	@After
	public void tearDown() throws Exception {
		p = null;
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(expPrice, p.getPrice(), 0.0);
	}
	
	@Test
	public void testIndexOutOfBounds() throws Exception {
		ArrayList<Object> emptyList = new ArrayList<Object>();
		Object o = emptyList.get(0);
	}


}
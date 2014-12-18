package Cw4;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class MeetingImplTest {
	Meeting first;
	Meeting second;
	Contact a;
	Contact b;
	

	/**
	 *  This method create objects to be use on the tests.
	 */
	@Before
	public void CreateForTest() {
		a = new ContactImpl("Noam");
		b = new ContactImpl("Daniel");
		Set<Contact> contacts1 = new TreeSet<Contact>();
		Set<Contact> contacts2 = new TreeSet<Contact>();
		try {
		contacts1.add(a);
		contacts2.add(a);
		contacts2.add(b);
		} catch (ClassCastException e) {
			e.getStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.set(2015, 10, 1, 10, 50);
		Calendar d = Calendar.getInstance();
		d.set(2014, 12, 31, 23, 59);
		first = new MeetingImpl(c, contacts1);
		second = new MeetingImpl(d, contacts2);	
	}
	
    /**
    * Test for method getId(). 
	* Id needs to be unique so the test check that two meeting does not have the same ID. 
	*/
	@Test
	public void testGetId() {
		assertNotEquals(first.getId(), second.getId());
		assertEquals(first.getId(), 1);
		assertEquals(second.getId(), 2);
	}

	/** 
	 * Test for method getDate().
	 */
	@Test
	public void testGetDate() {
		Calendar expected = Calendar.getInstance();
		expected.set(2015, 10, 1, 10, 50);
		assertEquals(expected, first.getDate());
	}

	/**
	 * Test for method getContact().
	 */
	@Test
	public void testGetContacts() {
		Set<Contact> expected1 = new TreeSet<Contact>();
	    Set<Contact> expected2 = new TreeSet<Contact>();
	    try {
	    expected1.add(a);
	    expected2.add(a);
	    expected2.add(b);
	    } catch (ClassCastException e) {
	    	e.getStackTrace(); 	
	    }
	    assertEquals(expected1, first.getContacts());
		assertEquals(expected2, second.getContacts());
			
	}

}

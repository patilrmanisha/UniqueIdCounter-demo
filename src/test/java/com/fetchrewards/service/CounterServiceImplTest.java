package com.fetchrewards.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CounterServiceImplTest {
	@Test
	void worksForNullList() { //null or empty list should return zero.
		List<String> nullList = null;
		assertEquals(0, new CounterServiceImpl().getUniqueIdCount(nullList));
	}
	
	@Test
	void worksForEmptyList() { //null or empty list should return zero.
		List<String> emptyList = new ArrayList<>();
		assertEquals(0, new CounterServiceImpl().getUniqueIdCount(emptyList));
	}
	
	@Test
	void worksForSingelIdCombinations() { 
		List<String> singleId = new ArrayList<>();
		singleId.add("testemail@gmail.com");
		singleId.add("test.email@gmail.com");
		singleId.add("testemail+test@gmail.com");
		singleId.add("te.stemail@gmail.com");
							
		assertEquals(1, new CounterServiceImpl().getUniqueIdCount(singleId));
		
	}
	
	@Test
	void worksFormultipleIdCombinations() { 
		List<String> multipleId = new ArrayList<>();
		multipleId.add("testemail@gmail.com");
		multipleId.add("test.email+spam@gmail.com");
		multipleId.add("testemail+test@fetchrewards.com");
		multipleId.add("te.stemail@gmail.com");
							
		assertEquals(2, new CounterServiceImpl().getUniqueIdCount(multipleId));
		
	}
	
	//assumptions for considering a string valid emailId
	//String contains one '@' , one '.'
	//domain is valid, it has name and extensions
	//'@' is not the last character. making domain name null
	//String doesn't start with +, making userName null
	
	
	@Test
	void worksForValidIdsOnly() { 
		List<String> invalidId = new ArrayList<>();
		invalidId.add("+testemail@gmail.com");
		invalidId.add("test.email+spamgmail.com@");
		invalidId.add("testemail");
		
		assertEquals(0, new CounterServiceImpl().getUniqueIdCount(invalidId));
		
	}
}

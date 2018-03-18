package com.skipthedishes.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.skipthedishes.domain.Cousine;
import com.skipthedishes.service.CousineService;

/**
 * @author Vitor Carrilho - 18/03/2018
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CousineResourceTests {

	private static final String NAME = "NAME";

	private CousineResource cousineResource;
	
	@Mock
	private CousineService cousineService;
	
	@Mock
	private Cousine cousine;

	@Test
	public void findByNameTest() {
		when(cousineService.findByName(NAME)).thenReturn(cousine);
		ResponseEntity<Cousine> cousineResponse = cousineResource.findByName(NAME);
		Cousine newCousine = cousineResponse.getBody();
		assertEquals(cousine, newCousine);
		verify(cousineService, times(1)).findByName(NAME);
	}
	
	@Test
	public void findAll() {
		when(cousineService.findAll()).thenReturn(Arrays.asList(cousine));
		ResponseEntity<List<Cousine>> response = cousineResource.findAll();
		List<Cousine> cousineList = response.getBody();
		assertEquals(cousine, cousineList.get(0));
		verify(cousineService, times(1)).findAll();
	}
	
	@Before
	public void setup() {
		cousineResource = new CousineResource(cousineService);
	}
	

}

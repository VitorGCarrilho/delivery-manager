package com.skipthedishes.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skipthedishes.domain.Cousine;
import com.skipthedishes.service.CousineService;

/**
 * @author Vitor Carrilho - 18/03/2018
 *
 */
@RestController
@ControllerAdvice
@RequestMapping(value = { "api/v1/cousine" })
public class CousineResource {
	
	private CousineService cousineService;
	
	@GetMapping
	public ResponseEntity<List<Cousine>> findAll() {
		List<Cousine> cousineList = cousineService.findAll();
		return ResponseEntity.ok().body(cousineList);
	}
	
	@GetMapping("search/{searchText}")
	public ResponseEntity<Cousine> findByName(@PathVariable String searchText) {
		Cousine cousine = cousineService.findByName(searchText);
		return ResponseEntity.ok().body(cousine);
	}
	
	@Autowired
	public CousineResource(CousineService cousineService) {
		this.cousineService = cousineService;
	}
}

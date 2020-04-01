package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.postgre.ApplicationMeta;
import com.example.demo.postgre.ApplicationMetaRepository;

@RestController
public class SpringPostgreController {
	
	@Autowired
	private ApplicationMetaRepository applicationMetaRepository;
	
	@GetMapping(value="/apps/{name}")
	public  ResponseEntity<ApplicationMeta> applicationData(@PathVariable String name) {
		ApplicationMeta applicationMeta=applicationMetaRepository.findByName(name);
		return ResponseEntity.ok().body(applicationMeta);
		
	}
	
	@GetMapping(value="/apps/")
	public ResponseEntity<List<ApplicationMeta>> apps(){
		List<ApplicationMeta> applicationMetaList =applicationMetaRepository.findAll();
		return ResponseEntity.ok(applicationMetaList);
	}

}

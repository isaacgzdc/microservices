package com.example.microservices.challenge.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.challenge.model.Challenge;
import com.example.microservices.challenge.service.ChallengeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/challenges")
@RequiredArgsConstructor
public class ChallengeController {
	
	private ChallengeService challengeService;

	@GetMapping
	public ResponseEntity<List<Challenge>> all(){
		List<Challenge> challenges = challengeService.findAll();		
		return new ResponseEntity<List<Challenge>>(challenges, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Challenge> one(@PathVariable("id") Long id){
		Challenge challenge = challengeService.findById(id).orElseThrow(()-> new EntityNotFoundException());	
		return new ResponseEntity<Challenge>(challenge, HttpStatus.OK);
	}
}

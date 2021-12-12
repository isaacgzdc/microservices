package com.example.microservices.challenge.service;

import java.util.List;
import java.util.Optional;

import com.example.microservices.challenge.model.Challenge;

public interface ChallengeService {

	List<Challenge> findAll();

	Optional<Challenge> findById(Long id);

}

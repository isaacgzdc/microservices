package com.example.microservices.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.microservices.challenge.model.Challenge;
import com.example.microservices.challenge.repository.ChallengeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

	private final ChallengeRepository challengeRepository;

	@Override
	public List<Challenge> findAll() {
		return challengeRepository.findAll();
	}

	@Override
	public Optional<Challenge> findById(Long id) {
		return challengeRepository.findById(id);
	}
	
}

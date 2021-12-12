package com.example.microservices.challenge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.microservices.challenge.model.Challenge;

@Repository
public interface ChallengeRepository extends MongoRepository<Challenge, Long>{

}

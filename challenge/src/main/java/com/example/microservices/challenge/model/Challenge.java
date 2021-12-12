package com.example.microservices.challenge.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Challenge {

	@Id
	private Long id;
	private UUID uuid;
	private String title;
	private LocalDateTime createdAt;
	private LocalDateTime dueDate;
	private Integer attempt;
}

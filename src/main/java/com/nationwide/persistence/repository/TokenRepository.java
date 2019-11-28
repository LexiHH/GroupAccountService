package com.nationwide.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nationwide.persistence.domain.Token;

public interface TokenRepository extends JpaRepository<Token, Long>{
	
	public Optional<Token> findByBearerToken(String bearerToken);
	
}
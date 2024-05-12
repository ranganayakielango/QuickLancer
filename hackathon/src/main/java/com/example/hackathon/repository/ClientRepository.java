package com.example.hackathon.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.hackathon.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{ 
	 Client getByEmail(String email);
	 boolean existsByEmail(String email);
}
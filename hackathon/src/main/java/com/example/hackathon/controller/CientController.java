package com.example.hackathon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackathon.entity.Client;
import com.example.hackathon.service.ClientService;
import com.example.hackathon.service.EntityAlreadyExistsException;

@CrossOrigin(origins = { "http://localhost:3000", "https://staging.example.com",
		"https://app.example.com" }, methods = { RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.PUT,
				RequestMethod.DELETE, RequestMethod.POST })
@RestController
public class CientController {

	@Autowired
	ClientService clientService;

	@GetMapping("/client")
	private List<Client> getAllClients() {
		return clientService.getAllClient();
	}

	@GetMapping("/client/{emailID}")
	private Client getClientByEmail(@PathVariable("emailID") String emailID) {
		return clientService.getByEmailId(emailID); // Assuming you have a method in your service to fetch a client by
													// email
	}

	@PostMapping("/client")
	private ResponseEntity<?> saveBook(@RequestBody Client client) {

		try {
			Client savedEntity = clientService.save(client);
			return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
		} catch (EntityAlreadyExistsException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/client")
	private Client update(@RequestBody Client client) {
		clientService.update(client);
		return client;
	}
}

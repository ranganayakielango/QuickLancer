package com.example.hackathon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hackathon.entity.Client;
import com.example.hackathon.repository.ClientRepository;


@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public List<Client> getAllClient() {

		List<Client> client = new ArrayList<Client>();
		clientRepository.findAll().forEach(client1 -> client.add(client1));
		return client;
	}
	
	 public Client save(Client client)   
	{  
		 if (clientRepository.existsByEmail(client.getEmail())) {
	            // Handle the scenario where entity already exists
	            throw new EntityAlreadyExistsException("Entity with ID " + client.getEmail() + " already exists");
	        }
		return clientRepository.save(client);  
	} 
	 
	 public Client update(Client client)   
		{  
			return clientRepository.save(client);  
		} 
	 
	 public void update(Client client, int clientid)   
	 {  
	 clientRepository.save(client);  
	 }  
	 public Optional<Client> getByEmailId(String email) {
	        return clientRepository.getByEmail(email);
	    }
}

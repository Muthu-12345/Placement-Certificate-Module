package com.tnsif.pm.certificate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertifiacteController 
{
	@Autowired
	private CertificateService service;
	
	//RESTful API methods for Retrieval operations
	@GetMapping("/certificates")
	public List<Certificate> list()
	{
		return service.listAll();
	}
	
	//Retrieve By ID
	@GetMapping("/certificates/{id}")
	public ResponseEntity<Certificate> get(@PathVariable Long id)
	{
		try
		{
			Certificate certificate = service.get(id);
			return new ResponseEntity<Certificate>(certificate,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
			
		}
	}
	//Create Operation
	@PostMapping("/certificates")
	public void add(@RequestBody Certificate certificate)
	{
		service.save(certificate);
	}
	//Update Operation
	@PutMapping("/certificates/{id}")
	public ResponseEntity<?> update(@RequestBody Certificate certificate ,@PathVariable Long id)
	{
		try
		{
			Certificate existcertificate = service.get(id);
			certificate.setId(id);
			service.save(certificate);
			return new ResponseEntity<Certificate>(certificate,HttpStatus.OK);
			
		}
		catch(Exception e)
		{
			return new ResponseEntity<Certificate>(HttpStatus.NOT_FOUND);
		}
	}
	//Delete Operation
	@DeleteMapping("/certificates/{id}")
	public void delete(@PathVariable Long id)
	{
		service.delete(id);
	}

}

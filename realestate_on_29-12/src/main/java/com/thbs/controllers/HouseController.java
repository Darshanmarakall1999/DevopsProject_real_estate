package com.thbs.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thbs.models.house;
import com.thbs.repo.HouseRepository;

@RestController
@RequestMapping("/Houses")
public class HouseController {
	@Autowired
	HouseRepository houseRepository;
	@PostMapping("/House")
	public ResponseEntity<house>Save(@RequestBody house h)
	{
		house h1=houseRepository.save(h);
		return new ResponseEntity<house>(h1,HttpStatus.OK);
	}
	
	@GetMapping("/getAllHouses")
	public ResponseEntity<List<house>>getAllHouses()
	{
		List<house> houseList=houseRepository.findAll();
		return new ResponseEntity<List<house>>(houseList,HttpStatus.OK);
	}
	
	@GetMapping("/getAHouse/{pid}")
	public ResponseEntity<house>getAHouseById(@PathVariable int pid)
	{
		Optional<house> p=houseRepository.findById(pid);
		if(p!=null)
		{
			house pk=p.get();
			return new ResponseEntity<house>(pk,HttpStatus.OK);
		}
		return new ResponseEntity<house>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/DeleteById/{pid}")
	public ResponseEntity<house>DeleteHouseById(@PathVariable int pid)
	{
		houseRepository.deleteById(pid);
		if(houseRepository.existsById(pid))
			return new ResponseEntity<house>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<house>(HttpStatus.NOT_FOUND);
	}
	

}

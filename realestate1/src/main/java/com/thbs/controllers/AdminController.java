package com.thbs.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thbs.models.Admin;
import com.thbs.models.User;
import com.thbs.models.house;
import com.thbs.repo.AdminRepository;
import com.thbs.repo.HouseRepository;

@RestController
public class AdminController {
	@Autowired
	HouseRepository houseRepository;
	
	@Autowired
	AdminRepository adminRepository;
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
	
	/*@RequestMapping(value = "/admin_options")
	public String admin_options() {
		return "admin_options";
	}
	
	@RequestMapping(value = "/adminlogin")
	public String admin_login() {
		return "admin";
	}
	
	
	@PostMapping("/adminLogin")
	public String admin(@ModelAttribute("admin") Admin a) 
	{
		Optional<Admin> searchUser =adminRepository.findById(a.getAdminid());
		 if (searchUser.isPresent())
		 { Admin userFromDb = searchUser.get();
		 if (a.getPassword().equals(userFromDb.getPassword()))
		 {  
		 return "/admin_options";
		 } else
		 { 
			 return "/adminlogin";
		 }
		 
		 } else return "/adminlogin"; 
			
	}*/
	

}

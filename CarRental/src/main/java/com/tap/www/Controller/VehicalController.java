package com.tap.www.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.www.Entity.vehicalEntity;
import com.tap.www.service.VehicalService;

@RestController
@RequestMapping("/api/vehicals")
public class VehicalController {
	
	
	@Autowired
	private VehicalService VehicalService;
	
	@PostMapping("/api/vehicals")
	public ResponseEntity<vehicalEntity> createdVehical(@RequestBody vehicalEntity vehicalEntity){
		return new ResponseEntity<>( VehicalService.saveVehical(vehicalEntity),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/api/vehicals")
	public ResponseEntity<List<vehicalEntity>> getAllData(){
		return new ResponseEntity<>(VehicalService.getAllVehicals(),HttpStatus.OK);
	}
	
	@GetMapping("/api/vehicals/{id}")
	public ResponseEntity<vehicalEntity> getDataByid(@PathVariable Long id){
		vehicalEntity vehical = VehicalService.getVehicalById(id);
		if(vehical != null) {
			return new ResponseEntity<>(vehical,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
		
	@PutMapping("/api/vehicals/{id}")
	public ResponseEntity<vehicalEntity> updateVehicalDetails(@PathVariable("id") Long id, @RequestBody vehicalEntity vehicalEntity){
		vehicalEntity updateVehical = VehicalService.updateVehical(id,vehicalEntity);
		if(updateVehical != null) {
			return new ResponseEntity<>(updateVehical,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
		
	

	
	@DeleteMapping("/api/vehicals/{id}")
	public ResponseEntity<String> deleteVehical(@PathVariable("id") Long id){
		String vehicalEntity = VehicalService.deleteVehical(id);
		return new ResponseEntity<>(vehicalEntity,HttpStatus.OK);
		
	}
	
	
	
	
	
		
		
		
		
		
	}

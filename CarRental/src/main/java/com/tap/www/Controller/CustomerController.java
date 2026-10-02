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

import com.tap.www.Entity.customerEntity;
import com.tap.www.service.customerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private customerService customerService;
	
	
	@PostMapping("/api/customers")
	public ResponseEntity<customerEntity> createCustomer(@RequestBody customerEntity customerEntity){
		return new ResponseEntity<>(customerService.saveCustomer(customerEntity),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/api/customers")
	public ResponseEntity<List<customerEntity>> getAllData(){
		return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	@GetMapping("/api/customer/{id}")
	public ResponseEntity<customerEntity> toGetDataById(@PathVariable Long Id){
		customerEntity customer = customerService.getCustomerById(Id);
		if(customer != null) {
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/api/customer/{id}")
	public ResponseEntity<customerEntity> updateCustomer(@PathVariable("id") Long Id,@RequestBody customerEntity customerEntity){
		customerEntity customer = customerService.updateCustomer(Id,customerEntity);
		if(customer != null) {
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/api/customer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long Id){
		String customer = customerService.deleteCustomer(Id);
		if(customer != null) {
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}

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

import com.tap.www.Entity.bookingEntity;
import com.tap.www.service.bookingService;

@RequestMapping("/api/booking")
@RestController
public class bookingController {
	
	@Autowired
	private bookingService bookingService;
	
	@PostMapping("api/customer/{customerId}/vehical/{vehicalId}")
	public ResponseEntity<bookingEntity> toCreatedBooking(@PathVariable("customerId") Long customerId,@PathVariable("vehicalId") Long vehicalId, @RequestBody bookingEntity bookingEntity){
		bookingEntity savedBooking = bookingService.createBooking(customerId,vehicalId,bookingEntity);
		
		if(savedBooking != null) {
			return new ResponseEntity<>(savedBooking,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	//ReadAll
	@GetMapping("/api/booking/")
	public ResponseEntity<List<bookingEntity>> toGetAllData(){
		return new ResponseEntity<> (bookingService.getAllBookings(),HttpStatus.OK);
	}
	
	//ReadAllById
	@GetMapping("/api/booking/{id}")
	public ResponseEntity<bookingEntity> toGetAllData(@PathVariable Long Id ){
		bookingEntity bookingEntity = bookingService.getBookingById(Id);
		if(bookingEntity != null) {
			return new ResponseEntity<>( bookingEntity,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(bookingEntity,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/api/booking/{id}")
	public ResponseEntity<bookingEntity> toUpdateById(@PathVariable Long Id, @RequestBody bookingEntity bookingEntity1){
		bookingEntity bookingEntity = bookingService.updateBooking(Id,bookingEntity1);
		if(bookingEntity != null) {
			return new ResponseEntity<>(bookingEntity,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/api/booking/{id}")
	public ResponseEntity<String> toDeleteById(@PathVariable("id") Long Id){
		String  bookingEntity = bookingService.deleteBooking(Id);
		if(bookingEntity != null) {
			return new ResponseEntity<>(bookingEntity,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	

}

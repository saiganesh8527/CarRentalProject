package com.tap.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tap.www.Entity.bookingEntity;
import com.tap.www.Entity.customerEntity;
import com.tap.www.Entity.vehicalEntity;
import com.tap.www.Repository.bookingRepository;
import com.tap.www.Repository.customerRepository;
import com.tap.www.Repository.vehicalRepository;

@Service
public class bookingService {

	  @Autowired
	    private bookingRepository bookingRepository;
	  
	  @Autowired
	  private customerRepository customerRespository;
	  
	  @Autowired
	  private vehicalRepository vehicalRepository;
	  

	  // 1. CREATE - Save booking with foreign key mappings
	    public bookingEntity createBooking(Long customerId, Long vehicalId, bookingEntity bookingEntity) {
	        // Fetch entities from database using repositories
	        customerEntity customer = customerRespository.findById(customerId).orElse(null);
	        vehicalEntity vehical = vehicalRepository.findById(vehicalId).orElse(null);

	        // Map them if both exist
	        if (customer != null && vehical != null) {
	            bookingEntity.setCustomer(customer); // Map the customer row
	            bookingEntity.setVehical(vehical);   // Map the vehicle row
	            bookingEntity.setBookingStatus("CONFIRMED");
	            
	            return bookingRepository.save(bookingEntity);
	        }
	        return null; // Return null if IDs are invalid
	    }


	    // Read All Bookings
	    public List<bookingEntity> getAllBookings() {
	        return bookingRepository.findAll();
	    }

	    // Read One Booking by ID
	    public bookingEntity getBookingById(Long bookingId) {
	        return bookingRepository.findById(bookingId).orElse(null);
	    }

	    // Update Booking Details
	    public bookingEntity updateBooking(Long bookingId, bookingEntity incomingBookingData) {
	        bookingEntity existingBooking = bookingRepository.findById(bookingId).orElse(null);
	        
	        if (existingBooking != null) {
	            // Keep the original bookingId, update the rental parameters
	            existingBooking.setStartDate(incomingBookingData.getStartDate());
	            existingBooking.setEndDate(incomingBookingData.getEndDate());
	            existingBooking.setTotalAmount(incomingBookingData.getTotalAmount());
	            existingBooking.setBookingStatus(incomingBookingData.getBookingStatus());
	            
	            // Return the explicitly saved database-managed object
	            return bookingRepository.save(existingBooking);
	        }
	        return null;
	    }

	    // Delete Booking
	    public String deleteBooking(Long bookingId) {
	        if (bookingRepository.existsById(bookingId)) {
	            bookingRepository.deleteById(bookingId);
	            return "Booking deleted successfully";
	        }
	        return "Booking not found with id: " + bookingId;
	    }
}

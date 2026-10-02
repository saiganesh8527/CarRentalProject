package com.tap.www.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tap.www.Entity.customerEntity;
import com.tap.www.Repository.customerRepository;

	@Service
	public class customerService {

	    @Autowired
	    private customerRepository customerRepository;

	    // Create / Save Customer
	    public customerEntity saveCustomer(customerEntity customer) {
	        return customerRepository.save(customer);
	    }

	    // Read All Customers
	    public List<customerEntity> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    // Read One Customer by ID
	    public customerEntity getCustomerById(Long customerId) {
	        return customerRepository.findById(customerId).orElse(null);
	    }

	    // Update Customer Details
	    public customerEntity updateCustomer(Long customerId, customerEntity customerData) {
	        customerEntity existingCustomer = customerRepository.findById(customerId).orElse(null);
	        
	        if (existingCustomer != null) {
	            // Keep the original primary key, update other details
	            existingCustomer.setName(customerData.getName());
	            existingCustomer.setEmail(customerData.getEmail());
	            existingCustomer.setPassword(customerData.getPassword());
	            existingCustomer.setPhone(customerData.getPhone());
	            
	            // Save the updated object back to the database
	            return customerRepository.save(existingCustomer);
	        }
	        return null;
	    }

	    // Delete Customer
	    public String deleteCustomer(Long customerId) {
	        if (customerRepository.existsById(customerId)) {
	            customerRepository.deleteById(customerId);
	            return "Customer deleted successfully";
	        }
	        return "Customer not found with id: " + customerId;
	    }
	}
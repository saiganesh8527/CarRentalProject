package com.tap.www.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tap.www.Entity.vehicalEntity;
import com.tap.www.Repository.vehicalRepository;

@Service
public class VehicalService {
	
	@Autowired
	private  vehicalRepository vehicalRepository;
	
	
	public vehicalEntity saveVehical(vehicalEntity vehical) {
		return vehicalRepository.save(vehical);
	}
	
	public List<vehicalEntity> getAllVehicals(){
		return vehicalRepository.findAll();
		
	}
	
	//Read One
			public vehicalEntity getVehicalById(Long VehicalId) {
				return vehicalRepository.findById(VehicalId).orElse(null);
			}
			
			//update
			public vehicalEntity updateVehical(Long VehicalId,vehicalEntity vehicalEntity) {
				vehicalEntity existingVehical = vehicalRepository.findById(VehicalId).orElse(null);
					
				if(existingVehical != null) {
					existingVehical.setVehicalId(vehicalEntity.getVehicalId());
					existingVehical.setBrand(vehicalEntity.getBrand());
					existingVehical.setModel(vehicalEntity.getModel());
					existingVehical.setRentPerDay(vehicalEntity.getRentPerDay());
					existingVehical.setAvailabilityStatus(vehicalEntity.getAvailabilityStatus());
					
					return vehicalRepository.save(vehicalEntity);
				}
				return null;
			}
			
			
			

			// delete
			public String deleteVehical(Long id) {
			    vehicalRepository.deleteById(id);
			    return "Vehicle deleted successfully"; // FIXED: Changed 'Employer' to 'Vehicle'
			}


			
}

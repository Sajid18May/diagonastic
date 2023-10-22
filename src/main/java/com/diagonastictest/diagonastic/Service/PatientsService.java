package com.diagonastictest.diagonastic.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diagonastictest.diagonastic.Entity.Patients;
import com.diagonastictest.diagonastic.Repo.Repo;

@Service
public class PatientsService {
    @Autowired
    Repo myrepo;
    
    public Patients addPatients(Patients p){

        return myrepo.save(p);
    }
       	public List<Patients> fetchAllPatients() {	
		return myrepo.findAll();
	}

	public Patients getPatientsById(int id) {
		Optional<Patients> patient = myrepo.findById(id);

		if (patient.isPresent()) {
			return patient.get();
		}
		return null;
	}

	
	public String deletePatientsById(int id) {
		if(myrepo.findById(id).isPresent()) {
			myrepo.deleteById(id);
			return "patient deleted successfully";
		}
		return "No such patient in the database";
	}

    public Patients upadtePatientsById(int id, Patients patient) {
		Optional<Patients> patient1 = myrepo.findById(id);
		
		if (patient1.isPresent()) {
			
			Patients originalpatient = patient1.get();
			
			 if (Objects.nonNull(patient.getFirst_name()) && !"".equalsIgnoreCase(patient.getFirst_name())) {
				 originalpatient.setFirst_name(patient.getFirst_name());
	            }
			 if (Objects.nonNull(patient.getLast_name()) && !"".equalsIgnoreCase(patient.getLast_name())) {
				 originalpatient.setLast_name(patient.getLast_name());
	            }
			 
			 if (Objects.nonNull(patient.getEmail()) && !"".equalsIgnoreCase(patient.getEmail())) {
				 originalpatient.setEmail(patient.getEmail());
	            }
			 
			 if (Objects.nonNull(patient.getPassword()) && !"".equalsIgnoreCase(patient.getPassword())) {
				 originalpatient.setPassword(patient.getPassword());
	            }
			
	            return myrepo.save(originalpatient);
			
		}

		return null;
	}

}

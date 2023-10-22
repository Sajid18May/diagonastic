package com.diagonastictest.diagonastic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diagonastictest.diagonastic.Entity.Patients;
import com.diagonastictest.diagonastic.Service.PatientsService;

@RestController
public class PatientsController {
    
    @Autowired
    PatientsService psc;

    @PostMapping("/addPatients")
    public Patients add(@RequestBody Patients p){

        return psc.addPatients(p);
    }
    
	  @GetMapping("/getPatients")
	    public List<Patients> getAllPatients() {
	        return psc.fetchAllPatients();
	    }
	  
	  @GetMapping("/getPatients/{id}") //localhost:8080/getPatients/5
	  public Patients getPatientsById(@PathVariable("id")int id)
	  {
		  return psc.getPatientsById(id);
	  }
	  
	  @PutMapping("/Patients/{id}")
	    public Patients updatePatients(@PathVariable("id") int id, @RequestBody Patients Patients) {
	        return psc.upadtePatientsById(id, Patients);
	    }
	  
	  @DeleteMapping("/Patients/{id}")
	  public String deletePatients(@PathVariable("id") int id) {
		  return psc.deletePatientsById(id);
	  }
}

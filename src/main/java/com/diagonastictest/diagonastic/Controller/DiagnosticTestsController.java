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

import com.diagonastictest.diagonastic.Entity.DiagnosticTests;
import com.diagonastictest.diagonastic.Service.DiagnosticTestsService;

@RestController
public class DiagnosticTestsController {
    @Autowired
    DiagnosticTestsService r;

    @PostMapping("/addTest")
    public DiagnosticTests addTest(@RequestBody DiagnosticTests d){

        return r.addTest(d);
    }
    
	  @GetMapping("/getDiagnosticTests")
	    public List<DiagnosticTests> getAllDiagnosticTests() {
	        return r.fetchAllDiagnosticTests();
	    }
	  
	  @GetMapping("/getDiagnosticTests/{id}") //localhost:8080/getDiagnosticTests/5
	  public DiagnosticTests getDiagnosticTestsById(@PathVariable("id")int id)
	  {
		  return r.getDiagnosticTestsById(id);
	  }
	  
	  @PutMapping("/DiagnosticTests/{id}")
	    public DiagnosticTests updateDiagnosticTests(@PathVariable("id") int id, @RequestBody DiagnosticTests DiagnosticTests) {
	        return r.upadteDiagnosticTestsById(id, DiagnosticTests);
	    }
	  
	  @DeleteMapping("/DiagnosticTests/{id}")
	  public String deleteDiagnosticTests(@PathVariable("id") int id) {
		  return r.deleteDiagnosticTestsById(id);
	  }
}

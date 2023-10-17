package com.diagonastictest.diagonastic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
}

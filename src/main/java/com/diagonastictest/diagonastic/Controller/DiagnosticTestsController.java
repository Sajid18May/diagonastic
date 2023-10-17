package com.diagonastictest.diagonastic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diagonastictest.diagonastic.Entity.DiagnosticTests;
import com.diagonastictest.diagonastic.Service.PatientsService;

@RestController
public class DiagnosticTestsController {
    @Autowired
    PatientsService r;

    @PostMapping("/addTest")
    public DiagnosticTests addTest(@RequestBody DiagnosticTests d){

        return r.addTest(d);
    }
}

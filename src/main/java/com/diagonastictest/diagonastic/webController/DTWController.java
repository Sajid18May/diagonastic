package com.diagonastictest.diagonastic.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.diagonastictest.diagonastic.Entity.DiagnosticTests;
import com.diagonastictest.diagonastic.Service.DiagnosticTestsService;

@Controller
public class DTWController {
    @Autowired
    DiagnosticTestsService ds;

    @PostMapping("/getTested")
    public String getTested(DiagnosticTests test){
        ds.addTest(test);
        return "order";
    }
}

package com.diagonastictest.diagonastic.webController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.diagonastictest.diagonastic.Entity.DiagnosticTests;
import com.diagonastictest.diagonastic.Service.DiagnosticTestsService;

@Controller
public class DTWController {
    @Autowired
    DiagnosticTestsService ds;

    @PostMapping("/getTested")
    public String getTested( DiagnosticTests test){
        ds.addTest(test);
        return "redirect:/order";
    }

      @GetMapping("/order")
    public String getData(Model model) {
        List <DiagnosticTests> data = ds.fetchAllDiagnosticTests() ;
        model.addAttribute("dataList", data);
        return "order"; 
    }
}

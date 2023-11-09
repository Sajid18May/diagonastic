package com.diagonastictest.diagonastic.webController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.diagonastictest.diagonastic.Entity.DiagnosticTests;
import com.diagonastictest.diagonastic.Entity.Patients;
import com.diagonastictest.diagonastic.Service.DiagnosticTestsService;

@Controller
public class DTWController {
    @Autowired
    DiagnosticTestsService ds;

    @PostMapping("/getTested1")
    public String getTested( DiagnosticTests test){
        ds.addTest(test);
        return "redirect:/order";
    }
     @PostMapping("/getTested")
    public String saveTestInfo(@RequestParam("file") MultipartFile file,
    @RequestParam("test_name") String test_name,
    @RequestParam("lab_name") String lab_name,
    @RequestParam("processing_time") String processing_time,
    @DateTimeFormat(pattern ="yy-MM-dd" ) @RequestParam("order_date") Date order_date,
    @RequestParam("patients") Patients patients)
    {
    	ds.saveDiagnosticTestsToDB(file,test_name,lab_name
        ,processing_time,order_date,patients);
    	return "redirect:/order";
    }

      @GetMapping("/order")
    public String getData(Model model) {
        List <DiagnosticTests> data = ds.fetchAllDiagnosticTests() ;
        model.addAttribute("dataList", data);
        return "order"; 
    }
}

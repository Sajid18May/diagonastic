package com.diagonastictest.diagonastic.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import com.diagonastictest.diagonastic.Entity.Patients;
import com.diagonastictest.diagonastic.Service.PatientsService;

@Controller
public class loginController {
    @Autowired
    PatientsService ps;
    
    @PostMapping("/log_in")
    public String login(Model model, String email, String password){
         Patients p1=ps.getByEmail(email);
        if(p1!=null && p1.getPassword().equals(password)){
            model.addAttribute("user", p1);
            return "test"; 
        }
        else
         return "redirect:/login";    
    }
   
    @PostMapping("/register")
    public String saveData(Patients patient) {
        ps.addPatients(patient);
        return "index";
    }
}

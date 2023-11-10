package com.diagonastictest.diagonastic.webController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.diagonastictest.diagonastic.Entity.Patients;
import com.diagonastictest.diagonastic.Service.PatientsService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class loginController {
    @Autowired
    PatientsService ps;
    
    @PostMapping("/log_in")
    public String login(Model model, String email, String password,HttpSession session){
         Patients p1=ps.getByEmail(email);
        if(p1!=null && p1.getPassword().equals(password)){
            session.setAttribute("cust", p1.getFirst_name()+" "+p1.getLast_name());
            session.setAttribute("userid", p1.getPatient_id());
            model.addAttribute("user", p1);
            return "test"; 
        }
        else{
            return "redirect:/login";    
        }
    }
   
    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("patient") Patients userDto,
                               BindingResult result,
                               Model model){
        Patients existingUser = ps.getByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("patient", userDto);
            return "/signup";
        }

        ps.addPatients(userDto);
        return "redirect:/login";
    }


    @GetMapping("/signout")
    public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/login"; 
    }

}

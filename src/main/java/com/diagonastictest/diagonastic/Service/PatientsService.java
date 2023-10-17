package com.diagonastictest.diagonastic.Service;

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

}

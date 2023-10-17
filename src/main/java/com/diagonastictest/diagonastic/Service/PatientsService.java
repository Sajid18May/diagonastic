package com.diagonastictest.diagonastic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diagonastictest.diagonastic.Entity.DiagnosticTests;
import com.diagonastictest.diagonastic.Entity.Orders;
import com.diagonastictest.diagonastic.Entity.Patients;
import com.diagonastictest.diagonastic.Repo.DRepo;
import com.diagonastictest.diagonastic.Repo.ORepo;
import com.diagonastictest.diagonastic.Repo.Repo;

@Service
public class PatientsService {
    @Autowired
    Repo myrepo;
    
    public Patients addPatients(Patients p){

        return myrepo.save(p);
    }
    @Autowired
    DRepo drep;
    public DiagnosticTests addTest(DiagnosticTests diagnosticTests){

        return drep.save(diagnosticTests);
    }
    @Autowired
    ORepo orepo;
    public Orders addOrder(Orders orders){
        return orepo.save(orders);
    }

}

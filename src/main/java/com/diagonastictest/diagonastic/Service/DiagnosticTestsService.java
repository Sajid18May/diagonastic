package com.diagonastictest.diagonastic.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.diagonastictest.diagonastic.Entity.DiagnosticTests;
import com.diagonastictest.diagonastic.Repo.DRepo;

public class DiagnosticTestsService {
    @Autowired
    DRepo drep;
    public DiagnosticTests addTest(DiagnosticTests diagnosticTests){

        return drep.save(diagnosticTests);
    }


}

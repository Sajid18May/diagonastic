package com.diagonastictest.diagonastic.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diagonastictest.diagonastic.Entity.DiagnosticTests;
import com.diagonastictest.diagonastic.Repo.DRepo;

@Service
public class DiagnosticTestsService {
    @Autowired
    DRepo drep;
    public DiagnosticTests addTest(DiagnosticTests diagnosticTests){

        return drep.save(diagnosticTests);
    }

       	public List<DiagnosticTests> fetchAllDiagnosticTests() {	
		return drep.findAll();
	}

	public DiagnosticTests getDiagnosticTestsById(int id) {
		Optional<DiagnosticTests> diagonastictest = drep.findById(id);

		if (diagonastictest.isPresent()) {
			return diagonastictest.get();
		}
		return null;
	}

	
	public String deleteDiagnosticTestsById(int id) {
		if(drep.findById(id).isPresent()) {
			drep.deleteById(id);
			return "diagonastictest deleted successfully";
		}
		return "No such diagonastictest in the database";
	}

    public DiagnosticTests upadteDiagnosticTestsById(int id, DiagnosticTests diagonastictest) {
		Optional<DiagnosticTests> diagonastictest1 = drep.findById(id);
		
		if (diagonastictest1.isPresent()) {
			
			DiagnosticTests originaldiagonastictest = diagonastictest1.get();
			
			 if (Objects.nonNull(diagonastictest.getTest_name()) && !"".equalsIgnoreCase(diagonastictest.getTest_name())) {
				 originaldiagonastictest.setTest_name(diagonastictest.getTest_name());
	            }
			 if (Objects.nonNull(diagonastictest.getLab_name()) && !"".equalsIgnoreCase(diagonastictest.getLab_name())) {
				 originaldiagonastictest.setLab_name(diagonastictest.getLab_name());
	            }
			 
			 if (Objects.nonNull(diagonastictest.getProcessing_time()) && !"".equalsIgnoreCase(diagonastictest.getProcessing_time())) {
				 originaldiagonastictest.setProcessing_time(diagonastictest.getProcessing_time());
	            }
			
	            return drep.save(originaldiagonastictest);
			
		}

		return null;
	}


}

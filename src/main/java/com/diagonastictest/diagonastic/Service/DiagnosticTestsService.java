package com.diagonastictest.diagonastic.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.diagonastictest.diagonastic.Entity.DiagnosticTests;
import com.diagonastictest.diagonastic.Entity.Patients;
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

	public void saveDiagnosticTestsToDB(MultipartFile file,String test_name,String lab_name
			,String processing_time,Date order_date,Patients patients)
	{
		DiagnosticTests testinfo = new DiagnosticTests();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			testinfo.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		testinfo.setTest_name(test_name);
		testinfo.setLab_name(lab_name);
		testinfo.setProcessing_time(processing_time);
		testinfo.setOrder_date(order_date);
		testinfo.setPatients(patients);
        
        drep.save(testinfo);
	}


}

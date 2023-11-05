package com.diagonastictest.diagonastic.Entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class DiagnosticTests {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int test_id;
private String test_name;
private String lab_name;
private String processing_time;
@DateTimeFormat(pattern = "yy-MM-dd")
private Date order_date;

@ManyToOne
@JoinColumn(name ="patient_id")
private Patients patients;
}

package com.diagonastictest.diagonastic.Entity;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patients {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int patient_id ;
private String first_name;
private String last_name;
@Column(nullable=false, unique=true)
private String email;
private String password ;
@DateTimeFormat(pattern = "yy-MM-dd")
private Date date_of_birth;
private String gender;
private String address;
private String phone_number;

}
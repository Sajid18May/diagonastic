package com.diagonastictest.diagonastic.Entity;
import java.util.Date;

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
private String email;
private String password ;
private Date date_of_birth;
private String gender;
private String address;
private String phone_number;
}

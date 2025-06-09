package net.student.studentportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class StudentEntry {

    @Id
    private long id;
    private String name;
    private String gender;
    private String natonality;
    private long aadhaarnumber;
    private long phone_number;
    private String email;
    private String address;


}

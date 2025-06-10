package net.student.studentportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class StudentsEntity {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String name;
    private long sclass;
    private long telugu;
    private long hindi;
    private long english;
    private long maths;
    private long science;
    private long social;


     
}

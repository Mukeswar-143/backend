package net.student.studentportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String rollno;

    private String name;
    private String sclass;
    private String telugu;
    private String hindi;
    private String english;
    private String maths;
    private String science;
    private String social;

    private int totalMarks;
    private double averageMarks;

    public Long getId() {
        return id;
    }

    public String getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public String getSclass() {
        return sclass;
    }

    public String getTelugu() {
        return telugu;
    }

    public String getHindi() {
        return hindi;
    }

    public String getEnglish() {
        return english;
    }

    public String getMaths() {
        return maths;
    }

    public String getScience() {
        return science;
    }

    public String getSocial() {
        return social;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public double getAverageMarks() {
        return averageMarks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public void setTelugu(String telugu) {
        this.telugu = telugu;
    }

    public void setHindi(String hindi) {
        this.hindi = hindi;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public void setMaths(String maths) {
        this.maths = maths;
    }

    public void setScience(String science) {
        this.science = science;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public void setAverageMarks(double averageMarks) {
        this.averageMarks = averageMarks;
    }
}

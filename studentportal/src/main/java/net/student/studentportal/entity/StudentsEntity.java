package net.student.studentportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class StudentsEntity {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String name;
    private String sclass;
    private String telugu;
    private String hindi;
    private String  english;
    private String maths;
    private String science;
    private String social;

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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
}

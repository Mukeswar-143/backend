package net.student.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.student.studentportal.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Long>{

}

package net.student.studentportal.repository;

import net.student.studentportal.entity.StudentEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntry, Long> {
    // No extra code needed, JpaRepository provides CRUD methods
}

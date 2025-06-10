package net.student.studentportal.repository;
import net.student.studentportal.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<StudentsEntity, Long> {
}

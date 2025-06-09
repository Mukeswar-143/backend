package net.student.studentportal.repository;

import net.student.studentportal.entity.StudentEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<StudentEntry , Long> {

}

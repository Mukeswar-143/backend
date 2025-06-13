package net.student.studentportal.controller;
import net.student.studentportal.entity.StudentEntity;
import net.student.studentportal.repository.StudentRepository;
import net.student.studentportal.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Students")
//@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentServices studentService;

    @GetMapping("/details")
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/entry")
    public StudentEntity createStudent(@RequestBody StudentEntity student) {
        return studentService.addStudentWithMarks(student);
    }

    @GetMapping("/{id}")
    public StudentEntity getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateStudentById(
            @PathVariable Long id,
            @RequestBody StudentEntity updatedStudent) {
        return studentService.updateStudentMarks(id, updatedStudent)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "Student with ID " + id + " has been deleted.";
    }
}

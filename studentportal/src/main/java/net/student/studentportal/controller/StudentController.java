package net.student.studentportal.controller;

import net.student.studentportal.entity.StudentEntry;
import net.student.studentportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Student")
@CrossOrigin(origins = "http://localhost:3000")  // Allow React app to access API
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Test endpoint
    @GetMapping("/hello")
    public String hello() {
        return "hi to all";
    }

    // Get all students
    @GetMapping("/details")
    public List<StudentEntry> getAllStudents() {
        return studentRepository.findAll();
    }

    // Create new student
    @PostMapping("/entry")
    public StudentEntry createStudent(@RequestBody StudentEntry student) {
        return studentRepository.save(student);
    }

    // Get student by ID
    @GetMapping("/{id}")
    public StudentEntry getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Update student by ID
    @PutMapping("/{id}")
    public StudentEntry updateStudentById(@PathVariable Long id, @RequestBody StudentEntry updatedStudent) {
        Optional<StudentEntry> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            StudentEntry existingStudent = optionalStudent.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setGender(updatedStudent.getGender());
            existingStudent.setNatonality(updatedStudent.getNatonality());
            existingStudent.setAadhaarnumber(updatedStudent.getAadhaarnumber());
            existingStudent.setPhone_number(updatedStudent.getPhone_number());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setAddress(updatedStudent.getAddress());
            return studentRepository.save(existingStudent);
        } else {
            return null;  // Or throw exception if preferred
        }
    }

    // Delete student by ID
    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "Student with ID " + id + " has been deleted.";
    }
}

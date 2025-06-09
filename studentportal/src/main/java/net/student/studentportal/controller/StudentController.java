package net.student.studentportal.controller;


import net.student.studentportal.entity.StudentEntry;
import net.student.studentportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentRepository StudentRepository;

    @GetMapping("/details")
    public List<StudentEntry> getAllStudents() {
        return StudentRepository.findAll();
    }

    @PostMapping("/entry")
    public StudentEntry createStudent(@RequestBody StudentEntry student) {
        return StudentRepository.save(student);
    }

    @GetMapping("/{my_id}")
    public StudentEntry getEntryById(@PathVariable Long my_id) {
        return StudentRepository.findById(my_id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteEntryById(@PathVariable Long id) {
        StudentRepository.deleteById(id);
        return "Person with ID " + id + " has been deleted.";
    }

    @PutMapping("/{id}")
    public StudentEntry updateEntryById(@PathVariable Long id, @RequestBody StudentEntry updatedStudent) {
        Optional<StudentEntry> optionalStudent = StudentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            StudentEntry existingStudent = optionalStudent.get();

            existingStudent.setName(updatedStudent.getName());
            existingStudent.setGender(updatedStudent.getGender());
            existingStudent.setNatonality(updatedStudent.getNatonality()); // Typo in "nationality"?
            existingStudent.setAadhaarnumber(updatedStudent.getAadhaarnumber());
            existingStudent.setPhone_number(updatedStudent.getPhone_number());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setAddress(updatedStudent.getAddress());

            return StudentRepository.save(existingStudent);
        } else {
            return null;
        }
    }

}
//{
//        "id": 1,
//        "name": "mukesh",
//        "gender": "male",
//        "natonality": "hindu",
//        "aadhaarnumber": 624134154336,
//        "phone_number": 8074137300,
//        "email": "vasanamukeswar@gmail.com",
//        "address": "Vijayawada"
//        }
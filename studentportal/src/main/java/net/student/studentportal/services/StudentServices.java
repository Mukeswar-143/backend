package net.student.studentportal.services;

import net.student.studentportal.entity.StudentEntity;
import net.student.studentportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity addStudentWithMarks(StudentEntity student) {
        calculateTotalAndAverage(student);
        return studentRepository.save(student);
    }

    public Optional<StudentEntity> updateStudentMarks(Long id, StudentEntity updatedStudent) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            StudentEntity existingStudent = optionalStudent.get();

            existingStudent.setTelugu(updatedStudent.getTelugu());
            existingStudent.setHindi(updatedStudent.getHindi());
            existingStudent.setEnglish(updatedStudent.getEnglish());
            existingStudent.setMaths(updatedStudent.getMaths());
            existingStudent.setScience(updatedStudent.getScience());
            existingStudent.setSocial(updatedStudent.getSocial());

            calculateTotalAndAverage(existingStudent);

            return Optional.of(studentRepository.save(existingStudent));
        } else {
            return Optional.empty();
        }
    }

    private void calculateTotalAndAverage(StudentEntity student) {
        try {
            int telugu = Integer.parseInt(student.getTelugu());
            int hindi = Integer.parseInt(student.getHindi());
            int english = Integer.parseInt(student.getEnglish());
            int maths = Integer.parseInt(student.getMaths());
            int science = Integer.parseInt(student.getScience());
            int social = Integer.parseInt(student.getSocial());

            int total = telugu + hindi + english + maths + science + social;
            double average = total / 6.0;

            student.setTotalMarks(total);
            student.setAverageMarks(average);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Marks must be numeric strings", e);
        }
    }
}

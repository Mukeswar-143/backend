package net.student.studentportal.services;

import net.student.studentportal.entity.StudentEntity;
import net.student.studentportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity addStudentWithMarks(StudentEntity student) {
        calculateTotalAndAverage(student);
        return studentRepository.save(student);
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentEntity> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Optional<StudentEntity> updateStudentMarks(Long id, StudentEntity updatedStudent) {
        return studentRepository.findById(id).map(existing -> {
            existing.setRollno(updatedStudent.getRollno());
            existing.setName(updatedStudent.getName());
            existing.setSclass(updatedStudent.getSclass());
            existing.setTelugu(updatedStudent.getTelugu());
            existing.setHindi(updatedStudent.getHindi());
            existing.setEnglish(updatedStudent.getEnglish());
            existing.setMaths(updatedStudent.getMaths());
            existing.setScience(updatedStudent.getScience());
            existing.setSocial(updatedStudent.getSocial());

            calculateTotalAndAverage(existing);
            return studentRepository.save(existing);
        });
    }

    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
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
            student.setTotalMarks(0);
            student.setAverageMarks(0.0);
        }
    }
}

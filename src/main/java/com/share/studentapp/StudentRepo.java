package com.share.studentapp;

import com.share.studentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findBySnameOrderBySidDesc(String sname);
}

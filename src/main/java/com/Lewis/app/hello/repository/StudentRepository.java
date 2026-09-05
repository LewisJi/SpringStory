package com.Lewis.app.hello.repository;

import com.Lewis.app.hello.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM test.student", nativeQuery = true)
    List<Student> findAllStudent();
}



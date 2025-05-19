package com.example.quizz_app.dao;

import com.example.quizz_app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * from question q where q.category=:category ORDER BY RANDOM() LIMIT :number",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int number);
}

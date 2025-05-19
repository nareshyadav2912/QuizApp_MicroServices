package com.example.quizz_app.dao;
import com.example.quizz_app.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {
}

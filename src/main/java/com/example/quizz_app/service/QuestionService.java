package com.example.quizz_app.service;


import com.example.quizz_app.dao.QuestionRepo;
import com.example.quizz_app.model.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepo.findByCategory(category), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionRepo.save(question);
            return new ResponseEntity<>("Question added", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Invalid Data", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> updateQuestion(Question question) {
        try {
            questionRepo.save(question);
            return new ResponseEntity<>("Question updated", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Invalid Data", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteQuestion(int id) {
        try{
            questionRepo.delete(questionRepo.findById(id).get());
            return new ResponseEntity<>("Question deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Invalid Data", HttpStatus.BAD_REQUEST);
        }
    }
}

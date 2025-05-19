package com.example.quizz_app.controller;


import com.example.quizz_app.model.Question;
import com.example.quizz_app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.StringTokenizer;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @PostMapping("/updateQuestion")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id, Question question) {
        return questionService.deleteQuestion(question.getId());
    }
}

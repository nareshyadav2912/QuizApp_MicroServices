package com.example.quizz_app.controller;

import com.example.quizz_app.model.Question;
import com.example.quizz_app.model.QuestionWrapper;
import com.example.quizz_app.model.Response;
import com.example.quizz_app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("createQuiz")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int number,@RequestParam String title) {
        return quizService.createQuiz(category,number,title);
    }

    @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id) {
        return quizService.getQuiz(id);
    }

    @PostMapping("submitQuiz/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response) {
        return quizService.calculateResult(id,response);
    }
}

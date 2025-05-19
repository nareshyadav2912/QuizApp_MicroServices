package com.example.quizz_app.service;


import com.example.quizz_app.dao.QuestionRepo;
import com.example.quizz_app.dao.QuizRepo;
import com.example.quizz_app.model.Question;
import com.example.quizz_app.model.QuestionWrapper;
import com.example.quizz_app.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int number, String title) {
        List<Question> questions= questionRepo.findRandomQuestionsByCategory(category,number);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Quiz created", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
        //return new quizRepo.findById(id);
        Optional<Quiz> quiz=quizRepo.findById(id);
        List<Question> questionsFromDb=quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUsers=new ArrayList<>();
        for(Question question:questionsFromDb){
            QuestionWrapper questionWrapper=new QuestionWrapper(question.getId(),question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
            questionsForUsers.add(questionWrapper);

        }
        return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
    }
}

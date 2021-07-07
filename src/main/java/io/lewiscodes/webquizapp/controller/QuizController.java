package io.lewiscodes.webquizapp.controller;

import io.lewiscodes.webquizapp.model.Question;
import io.lewiscodes.webquizapp.service.Quiz;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    REST Controller to create, get by id, get all and solve by id
 */

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    private final Quiz quiz;

    public QuizController(Quiz quiz) {
        this.quiz = quiz;
    }

    // Create a question and add to quiz
    @PostMapping
    public Question create(@RequestBody Question newQuestion) {
        return quiz.create(newQuestion);
    }
}

package io.lewiscodes.webquizapp.controller;

import io.lewiscodes.webquizapp.model.Feedback;
import io.lewiscodes.webquizapp.model.Question;
import io.lewiscodes.webquizapp.service.Quiz;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/*
    REST Controller for Quiz
        CREATE new Question
        GET All Questions
        GET Question by ID
        Solve Question by ID and request param answer
 */

@RestController
@RequestMapping("/api/questions")
public class QuizController {
    private final Quiz quiz;

    public QuizController(Quiz quiz) {
        this.quiz = quiz;
    }

    @PostMapping
    public Question create(@RequestBody Question newQuestion) {
        return quiz.create(newQuestion);
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return quiz.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getById(@PathVariable("id") int id) {
        Question question = quiz.find(id);
        return question != null ? ResponseEntity.ok(question) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/solve")
    public ResponseEntity<Feedback> solve(@PathVariable("id") int id, @RequestParam("answer") int answer) {
        Question question = quiz.find(id);
        if (question == null) {
            return ResponseEntity.notFound().build();
        }
        return question.getAnswer() == answer ? ResponseEntity.ok(Feedback.CORRECT) : ResponseEntity.ok(Feedback.WRONG);
    }
}

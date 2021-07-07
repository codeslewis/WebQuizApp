package io.lewiscodes.webquizapp.service;

import io.lewiscodes.webquizapp.model.Question;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
    In memory data store for created questions
 */

@Component
public class Quiz {
    private final Map<Integer, Question> questions = new HashMap<>();

    public Question create(Question question) {
        question.setId(IdGenerator.generateId());
        questions.put(question.getId(), question);
        return question;
    }

    public Question find(int id) {
        return questions.get(id);
    }

    public Collection<Question> findAll() {
        return questions.values();
    }

    private static class IdGenerator {
        private static int id = 0;

        public static int generateId() {
            return ++id;
        }
    }
}

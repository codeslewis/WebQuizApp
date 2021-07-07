# Web Quiz Backend

## Create a new Question
### HTTP POST to '/api/questions'
    {
        "title": "Question title",
        "text": "Body of the question?",
        "options": ["answer 1","answer 2","answer 3","answer 4"],
        "answer": 2 // Correct Answer
    }
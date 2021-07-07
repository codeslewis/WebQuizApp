# Web Quiz Backend

## About
Backed of a Spring Web App to create and solve quizzes. See my portfolio at http://lewiscodes.io

## Create a new Question
### HTTP POST to '/api/questions'
#### Request Body
    {
        "title": "Question title",
        "text": "Body of the question?",
        "options": ["answer 1","answer 2","answer 3","answer 4"],
        "answer": 2 // Correct Answer
    }

Resonse HTTP status '200' Ok

#### Response body
    {
        "title": "Question title",
        "text": "Body of the question?",
        "options": ["answer 1","answer 2","answer 3","answer 4"]
    }

## Get All Questions
### HTTP GET to '/api/questions'

Requires no Request Body
Response HTTP status '200' Ok
Returns an array of all excluding without answer key

## Get Question By ID
### HTTP GET to '/api/questions/{id}'

Requires no Request Body
Response HTTP status '200' Ok
Returns question with given integer {id} excluding answer key
id's are auto assigned when created, starting from 1

## Solve Question By ID
### HTTP POST to /api/questions/{id}/solve?answer={ans}

Requires no Request Body
Query parameter of answer with value integer for answer counting from 1
Response HTTP status '200' Ok

#### Response Body
    {
        "success": true, // true for correct answer, false for incorrect
        "feedback": "Congratulations, you're right!"
    }
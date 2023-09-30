# Exam Tickets Generator

This study project is a Java-based application that allows you to create, store, delete questions, and retrieve them in a specified quantity. Additionally, it generates random mathematical examples and adds them to the question list when the number of questions is provided.

## Structure
- [Java Questions](#java-questions)
- [Math Questions](#math-questions)
- [Examiner Service](#examiner-service)
- [Exam Controller](#exam-controller)
- [Java Question Controller](#java-question-controller)

### Java Questions

The `JavaQuestionService` class handles Java-related questions. It provides functionality to add, remove, and get Java questions. The questions are stored in the `JavaQuestionRepository`. You can also get a random Java question using the `getRandomQuestion` method.

### Math Questions

The `MathQuestionService` class generates random mathematical questions based on addition, subtraction, multiplication, and division. These questions are not stored but generated on-demand using the `getRandomQuestion` method.

### Examiner Service

The `ExaminerServiceImpl` class is responsible for retrieving a specified amount of questions. It collaborates with different `QuestionService` implementations, such as `JavaQuestionService` and `MathQuestionService`, to get questions.

### Exam Controller

The `ExamController` provides a RESTful API endpoint `/get/{amount}` to retrieve a specified amount of questions using the `ExaminerService`. The result is a collection of questions.

### Java Question Controller

The `JavaQuestionController` is a RESTful controller that handles Java-related questions. It supports operations such as adding, removing, and retrieving Java questions. The endpoint for this controller is `/java`.

## Usage

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/exam-tickets-generator.git
   ```
2. Build and run the application using your preferred Java development environment.

3. Use the provided API endpoints to interact with the application.

- /java for Java-related questions.
- /get/{amount} to get a specified amount of random questions.

##Configuration
The application uses a default configuration with an embedded servlet container. The context path is set to /exam.

Feel free to customize the code or configuration according to your needs. 

```
Replace `your-username/exam-tickets-generator` in the clone URL with your actual GitHub username and repository name.
```


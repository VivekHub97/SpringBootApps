package com.vivekprojects.QuizAppBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vivekprojects.QuizAppBoot.Question;
import com.vivekprojects.QuizAppBoot.Quiz;
import com.vivekprojects.QuizAppBoot.dao.QuestionDao;
import com.vivekprojects.QuizAppBoot.dao.QuizDao;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		// TODO Auto-generated method stub
		
		List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}
	
}

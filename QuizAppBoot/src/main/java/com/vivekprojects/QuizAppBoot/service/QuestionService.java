package com.vivekprojects.QuizAppBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivekprojects.QuizAppBoot.Question;
import com.vivekprojects.QuizAppBoot.dao.QuestionDao;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return questionDao.findAll();
	}

	public List<Question> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		return questionDao.findByCategory(category);
	}

}

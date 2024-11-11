package com.vivekprojects.JobListingBootMongoApp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivekprojects.JobListingBootMongoApp.models.Post;
import com.vivekprojects.JobListingBootMongoApp.repository.PostRepository;
import com.vivekprojects.JobListingBootMongoApp.repository.SearchRepository;

import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;

//@CrossOrigin(origins="http://localhost:3000") 	=> To allow CORS to connect with frontend (React)
@RestController
public class PostController {
	
	@Autowired
	PostRepository repo;
	
	@Autowired
	SearchRepository srepo;
	
	@ApiIgnore
	@RequestMapping(value="/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");	
		
	}
	
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		
		return repo.findAll();
		
	}
	
	@GetMapping("/posts/{text}")
	public List<Post> search(@PathVariable String text){
		
		return srepo.findByText(text);
		
	}
	
	@PostMapping("/post")
	public Post addPost(@RequestBody Post post) {
		
		return repo.save(post);
	}
	
}

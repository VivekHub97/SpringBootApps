package com.vivekprojects.JobListingBootMongoApp.repository;

import java.util.List;

import com.vivekprojects.JobListingBootMongoApp.models.Post;

public interface SearchRepository {

	List<Post> findByText(String text);
	
}

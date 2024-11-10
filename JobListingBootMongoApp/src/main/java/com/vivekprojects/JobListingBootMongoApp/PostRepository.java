package com.vivekprojects.JobListingBootMongoApp;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vivekprojects.JobListingBootMongoApp.models.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}

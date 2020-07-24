package com.spring.pt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.pt.model.Post;
import com.spring.pt.repository.PostRepository;


@Service
public class PostService {

	@Autowired
	private PostRepository postRepository; //DI
	
	@Transactional
	public void 글쓰기(Post post) {
			postRepository.save(post);
	}
}

package com.spring.pt.repository;

import java.util.List;

import com.spring.pt.controller.dto.PostDetailRespDto;
import com.spring.pt.model.Post;

public interface PostRepository {
	
	public void save(Post post);
	public List<Post> findAll();
	public PostDetailRespDto findById(int id);
	public Post findOne(int id);
	public void deleteById(int id);
	public void update(Post post);
}

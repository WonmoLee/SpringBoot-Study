package com.spring.pt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.pt.controller.dto.CommonRespDto;
import com.spring.pt.model.Post;
import com.spring.pt.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService;

	//생성자로 DI하기
//	public PostController(PostService postService) {
//		this.postService = postService;
//	}
	
	@GetMapping("/post/saveForm")
	public String postForm() {
		return "post/saveForm";
	}
	
	@PostMapping("/post")
	public @ResponseBody CommonRespDto<?> postPorc(@RequestBody Post post) {
		postService.글쓰기(post);
		return new CommonRespDto<String>(1, "글쓰기 성공");
	}

	//인증 필요없음
	//post관련된 것은 전부다 인증 필요하게 해야함
	@GetMapping("/posts")
	public String getPosts(Model model) {
		model.addAttribute("posts", postService.목록보기());
		return "index";
	}
	
	//주소값은 전부 스트링이다.
	//?주소 - > 쿼리스트링을 받는것
	// /post/{id} -> 파라메터를 받는 것
	@GetMapping("/post/{id}")
	public String getPost(@PathVariable int id, Model model) {
		model.addAttribute("postDetailRespDto", postService.상세보기(id));
		return "post/detail";
	}
	
	@DeleteMapping("/post/{id}")
	public @ResponseBody CommonRespDto<?> deleteById(@PathVariable int id) {
		postService.삭제하기(id);
		return new CommonRespDto<String>(1, "삭제성공");
	}
}

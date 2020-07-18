package com.practice.demo.repository;

import java.util.List;

import com.practice.demo.model.Member;

public interface MemberRepository {
	public Member findById(int id);
	public List<Member> findAll();
} 
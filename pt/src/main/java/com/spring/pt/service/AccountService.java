package com.spring.pt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.pt.dto.SendRequestDto;
import com.spring.pt.dto.WithDrawRequestDto;
import com.spring.pt.model.Account;
import com.spring.pt.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	//알아서 롤백해주고 알아서 커밋해주는 어노테이션
	@Transactional
	public void 송금(SendRequestDto dto) {
		//보내는 사람 업데이트
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getSenderaccountNumber());
		홍길동.setMoney(홍길동.getMoney() - dto.getMoney());
		accountRepository.update(홍길동);

		//장보고 업데이트
		Account 장보고 = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
		장보고.setMoney(장보고.getMoney() + dto.getMoney());
		accountRepository.update(장보고);

	}

	@Transactional
	public void 인출(WithDrawRequestDto dto) {
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getAccountNumber());
		홍길동.setMoney(홍길동.getMoney() - dto.getMoney());
		accountRepository.update(홍길동);
	}

	//select할때도 트랜젝션을 걸어주어야한다 이유는 고립성 때문이다.
	@Transactional(readOnly = true)
	public List<Account> 계좌정보보기() {
		return accountRepository.findAll();

	}
}
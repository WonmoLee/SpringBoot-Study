package com.spring.pt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SendRequestDto {
	private String senderaccountNumber;
	private String receiverAccountNumber;
	private int money;

}

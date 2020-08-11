package com.lwm.validex01;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespDto<T> {

	private int statusCode; //1,2,3,4,5,6,7,8,9,10
	private String msg;
	private T data;
	
}

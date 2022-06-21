package com.girish.crudoperation.Exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionMessage {

	private String errorcode;
	private String msg;
	private LocalDateTime localdatetime;
}

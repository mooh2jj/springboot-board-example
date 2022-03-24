package com.dsg.springbootboardexample.dto;

import com.dsg.springbootboardexample.exception.BlogErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String description;
    private BlogErrorCode errorCode;
}

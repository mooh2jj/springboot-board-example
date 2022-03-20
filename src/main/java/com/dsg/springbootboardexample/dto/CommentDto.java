package com.dsg.springbootboardexample.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long id;
    @NotEmpty
    @Size(min = 2, message = "name은 2글자 이상이어야 합니다.")
    private String name;
    @NotEmpty
    @Size(min = 10, message = "email은 10글자 이상이어야 합니다.")
    private String email;
    @NotEmpty
    @Size(min = 10, message = "body는 10글자 이상이어야 합니다.")
    private String body;
}

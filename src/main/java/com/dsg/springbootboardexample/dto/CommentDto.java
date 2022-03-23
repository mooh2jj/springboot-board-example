package com.dsg.springbootboardexample.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "board  Comment information")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    @ApiModelProperty(value = "board comment id")
    private Long id;

    @ApiModelProperty(value = "board comment name")
    @NotEmpty
    @Size(min = 2, message = "name은 2글자 이상이어야 합니다.")
    private String name;

    @ApiModelProperty(value = "board comment email")
    @NotEmpty
    @Size(min = 10, message = "email은 10글자 이상이어야 합니다.")
    private String email;

    @ApiModelProperty(value = "board comment body")
    @NotEmpty
    @Size(min = 10, message = "body는 10글자 이상이어야 합니다.")
    private String body;
}

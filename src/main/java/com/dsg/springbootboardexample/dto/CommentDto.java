package com.dsg.springbootboardexample.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long id;
    private String name;
    private String email;
    private String body;
}

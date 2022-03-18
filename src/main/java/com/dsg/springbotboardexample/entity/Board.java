package com.dsg.springbotboardexample.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "board")
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String filename;

    private String filepath;
}

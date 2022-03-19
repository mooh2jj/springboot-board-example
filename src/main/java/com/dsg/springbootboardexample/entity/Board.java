package com.dsg.springbootboardexample.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "board", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1500, nullable = false)
    private String content;

    private String filename;

    private String filepath;

    @Column(length = 50, nullable = false)
    private String writer;
}

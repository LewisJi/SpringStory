package com.Lewis.app.hello.model;

import javax.persistence.*;

@Entity
@Table(name = "student", schema = "test") // 指定資料表名稱與 test 綱要(Schema)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動遞增 ID
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "score")
    private Integer score;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
}

package com.Lewis.app.hello.model;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "student", schema = "test") // 指定資料表名稱與 test 綱要(Schema)
@ApiModel("學生資料")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動遞增 ID
    @ApiModelProperty(value = "編號")
    private Long id;

    @ApiModelProperty(value = "姓名")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "分數")
    @Column(name = "score")
    private Integer score;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
}

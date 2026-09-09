package com.Lewis.app.hello.model;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "student", schema = "test") // 指定資料表名稱與 test 綱要(Schema)
@ApiModel("學生資料")
@Data
public class Student {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動遞增 ID
    @ApiModelProperty(value = "編號")
    private Long id;

    @ApiModelProperty(value = "姓名")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "分數")
    @Column(name = "score")
    private Integer score;

}

package com.newfeature.pojo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lijichen
 * @date 2021/1/11 - 16:20
 */
@Data//get set
@NoArgsConstructor// 无参构造
@AllArgsConstructor// 全参构造
@EqualsAndHashCode// equals and hashcode
@ToString// toString
@Slf4j // 日志对象
public class Cat {
    private Integer id;
    private String name;

    public Cat(Integer id) {
        log.info("访问了Cat的id参数构造器");
        this.id = id;
    }
}

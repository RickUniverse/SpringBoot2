package com.web.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author lijichen
 * @date 2021/1/13 - 15:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private Integer id;
    private String name;
}

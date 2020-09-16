package com.learn.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-08-29 13:40
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    /**
     *id
     **/
    private Long id;
    /**
     * 流水号
     **/
    private String serial;
}

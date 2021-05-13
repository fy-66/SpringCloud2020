package com.yu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *@descript 
 *@author yu
 *@date 2021/5/9 9:55
 *@version 1.0
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    private String serial;

}

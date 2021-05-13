package com.yu.springcloud.common;

import com.yu.springcloud.constants.CommonConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *@descript 统一返回结果
 *@author yu
 *@date 2021/5/9 9:58
 *@version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;
    //private boolean success = true;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }

    public static <T> CommonResult<T> success(Integer code,String message,T data){
        return new CommonResult<T>(code,message,data);
    }
    /**
     * @descript 成功方法,code : <200> message：<success>
     * @author yu
     * @date 2021/5/9
     * @param data 返回的数据
     * @return com.yu.springcloud.common.CommonResult<T>
     */
    public static <T> CommonResult<T> success(T data){
        return success(CommonConstant.SC_OK_200,"success",data);
    }
    /**
     * @descript responseBody
     * @author yu
     * @date 2021/5/11
     * @param code 状态码
     * @param message 响应信息
     * @param data 返回数据
     * @return com.yu.springcloud.common.CommonResult<T>
     */
    public static <T> CommonResult<T> universal(Integer code, String message, T data){
        return success(code,message,data);
    }

    public static <T> CommonResult<T> failed(Integer code,String message){
        return new CommonResult<>(code,message);
    }
}

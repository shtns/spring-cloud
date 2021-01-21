package com.sh.api.common.util;

import com.sh.api.common.constan.CommonConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 响应信息主体
 *
 *
 * @author 盛浩
 * @date 2020/12/25 20:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "R", description = "响应信息主体")
public class R<T> {

    /**
     * 状态码：0 成功 1 失败
     */
    @ApiModelProperty(value = "状态码：0 成功 1 失败")
    private Integer code;

    /**
     * 数据
     */
    @ApiModelProperty(value = "数据")
    private T data;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息")
    private String msg;

    public static <T> R<T> ok() {
        return restResult(CommonConstants.ResponseInfoBody.SUCCESS, null, CommonConstants.ResponseInfoBody.MSG_SUCCESS);
    }

    public static <T> R<T> ok(T data) {
        return restResult(CommonConstants.ResponseInfoBody.SUCCESS, data, CommonConstants.ResponseInfoBody.MSG_SUCCESS);
    }

    public static <T> R<T> ok(String msg, T data) {
        return restResult(CommonConstants.ResponseInfoBody.SUCCESS, data, msg);
    }

    public static <T> R<T> failed() {
        return restResult(CommonConstants.ResponseInfoBody.FAIL, null, null);
    }

    public static <T> R<T> failed(String msg) {
        return restResult(CommonConstants.ResponseInfoBody.FAIL,null, msg);
    }

    public static <T> R<T> failed(T data) {
        return restResult(CommonConstants.ResponseInfoBody.FAIL, data, null);
    }

    public static <T> R<T> failed(T data, String msg) {
        return restResult(CommonConstants.ResponseInfoBody.FAIL, data, msg);
    }

    private static <T> R<T> restResult(Integer code, T data, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}

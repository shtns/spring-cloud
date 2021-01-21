package com.sh.api.common.constan;

/**
 * 公共常量
 *
 *
 * @author 盛浩
 * @date 2020/12/25 20:24
 */
public interface CommonConstants {

    /**
     * 微服务名称
     */
    interface MicroServiceName {

        /**
         * 支付服务
         */
        String PROVIDER_PAYMENT_SERVICE_ONE_NAME = "PROVIDER-PAYMENT-CLUSTER-ONE";

        /**
         * 支付hystrix服务
         */
        String PROVIDER_PAYMENT_SERVICE_HYSTRIX_NAME = "PROVIDER-PAYMENT-HYSTRIX";
    }

    /**
     * 微服务调用地址
     */
    interface MicroCallingLocation {

        /**
         * 支付调用地址
         */
        String PAYMENT_CALL_URL = "http://127.0.0.1:8001/provider/payment/";
    }

    /**
     * 数字
     */
    interface Digital {

        /**
         * 零
         */
        Integer ZERO = 0;

        /**
         * 一
         */
        Integer ONE = 1;
    }

    /**
     * 前台提示语
     */
    interface ForegroundPrompt {

        /**
         * 前台提示语：字符串不能为空
         */
        String STR_CANNOT_BE_EMPTY = "字符串不能为空";

        /**
         * 前台提示语：id不能为空
         */
        String ID_CANNOT_BE_EMPTY = "id不能为空";

        /**
         * 前端提示语：服务器繁忙，请稍后再试
         */
        String SERVER_BUSY_PLEASE_TRY_AGAIN_LATER = "服务器繁忙，请稍后再试";

        /**
         * 前台提示语：id不能是负数
         */
        String ID_CANNOT_BE_NEGATIVE = "id不能是负数";
    }

        /**
         * 接口文档
         */
        interface Swagger {

            String NAME = "e";

            String URL = "http://127.0.0.1/";

            String EMAIL = "980962735@qq.com";

            String TITLE = "项目API接口";

            String DESCRIPTION = "API接口";

            String VERSION = "0.0.1";

            String PATH_PATTERNS_UI  = "swagger-ui.html";

            String CLASS_PATH_UI_RESOURCE = "classpath:/META-INF/resources/";

            String PATH_PATTERNS_WEBJARS = "/webjars/**";

            String CLASS_PATH_WEBJARS_RESOURCE = "classpath:/META-INF/resources/webjars/";
        }

    /**
     * 响应信息主体
     */
    interface ResponseInfoBody {

        /**
         * 业务错误码（0成功    1失败）
         */
        Integer SUCCESS = 0;

        /**
         * 业务错误码（0成功    1失败）
         */
        Integer FAIL = 1;

        /**
         * 描述：执行成功
         */
        String MSG_SUCCESS = "执行成功";
    }
}

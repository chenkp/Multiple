package com.chenkp.multiple.kuaidi.util;

import java.util.HashMap;
import java.util.Map;

public class ResultCode {

    public class STATUS{
        public static final String SUCC_STATUS = "0";
        public static final String FAIL_STATUS = "1";
        public static final String PARAM_STATUS = "2";
    }

    public class MSG{
        public static final String SUCC_MSG = "成功";
        public static final String FAIL_MSG = "失败";
    }

    public static String getValidParam(String param) {
        return param + "不能为空";
    }

    public static Map<String, String> getFailResult(String status, String msg)
    {
        Map<String, String> resultMap = new HashMap();

        resultMap.put("status", status);
        resultMap.put("msg", msg);

        return resultMap;
    }
}

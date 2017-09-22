package com.chenkp.multiple.kuaidi.service.impl;

import com.chenkp.multiple.kuaidi.service.KuaidiService;
import com.chenkp.multiple.kuaidi.util.HttpUtil;
import com.chenkp.multiple.kuaidi.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Service
public class KuaidiServiceImpl implements KuaidiService {
    private static final Logger logger = LoggerFactory.getLogger(KuaidiServiceImpl.class);
    private static final String[] COMCODE = { "shentong", "shunfeng", "yuantong", "zhongtong", "yunda", "tiantian", "huitongkuaidi", "quanfengkuaidi", "debangwuliu", "zhaijisong" };

    public String query(String comCode, String perCode) {
        String urlStr = "http://www.kuaidi100.com/query?type=" + comCode + "&postid=" + perCode;
        return HttpUtil.doGet(urlStr);
    }

    public String query(String perCode) {
        logger.info("service query start,perCode={}",perCode);
        String result = "";
        for (int i = 0; i < COMCODE.length; i++) {
//            String urlStr = "http://www.kuaidi100.com/query?type=" + COMCODE[i] + "&postid=" + perCode;
            double temp = Math.random();
            String urlStr = "https://www.kuaidi100.com/query?type="+COMCODE[i]+"&postid="+perCode+"&id=1&valicode=&temp="+temp;
            result = HttpUtil.doGet(urlStr);
            Map<String, Object> resultMap = Utils.strToObject(result, Map.class);
            if ("200".equals(resultMap.get("status"))) {
                break;
            }
        }
        return result;
    }
}

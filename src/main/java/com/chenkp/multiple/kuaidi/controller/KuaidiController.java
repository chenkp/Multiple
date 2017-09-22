package com.chenkp.multiple.kuaidi.controller;

import com.chenkp.multiple.kuaidi.domain.Code;
import com.chenkp.multiple.kuaidi.service.KuaidiService;
import com.chenkp.multiple.kuaidi.util.ResultCode;
import com.chenkp.multiple.kuaidi.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chenkp
 * 快递查询
 */
@RestController
@RequestMapping("/kuaidi")
public class KuaidiController {

    private static final Logger logger = LoggerFactory.getLogger(KuaidiController.class);

    @RequestMapping("/test")
    public String test(){
        logger.info("test success...");
        return "success";
    }

    @Autowired
    private KuaidiService kuaidiService;

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("kuaidi/index");
    }

    @RequestMapping(value="/test", method = RequestMethod.POST)
    public String test(@RequestBody Code code)
    {
        logger.info("testing...");
        String comCode = code.getComCode();
        String perCode = code.getPerCode();
        Map<String, String> map = new HashMap();
        if (Utils.isNull(comCode)) {
            return Utils.ObjToStr(ResultCode.getFailResult("2", ResultCode.getValidParam("comCode")));
        }
        if (Utils.isNull(perCode)) {
            return Utils.ObjToStr(ResultCode.getFailResult("2", ResultCode.getValidParam("perCode")));
        }
        return this.kuaidiService.query(comCode, perCode);
    }

    @RequestMapping(value="/query", method = RequestMethod.POST)
    public String query(@RequestBody Code code){
        logger.info("query...");
        String perCode = code.getPerCode();
        Map<String, String> map = new HashMap();
        if (Utils.isNull(perCode)) {
            logger.error("perCode为空");
            return Utils.ObjToStr(ResultCode.getFailResult("2", ResultCode.getValidParam("perCode")));
        }
        return this.kuaidiService.query(perCode);
    }
}

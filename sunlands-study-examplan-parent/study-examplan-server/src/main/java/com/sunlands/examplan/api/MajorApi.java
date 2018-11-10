package com.sunlands.examplan.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.sunlands.examplan.base.controller.BaseController;
import com.sunlands.examplan.entity.Proj2ndEntity;
import com.sunlands.examplan.service.Proj2ndService;

/**
 * @author kangjianfei
 * @Title: 专业接口
 * @Description:
 * @date 2018/11/8 19:43
 */
@RestController
@RequestMapping("/major")
public class MajorApi extends BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MajorApi.class);

    @Autowired
    private Proj2ndService proj2ndService;


    @PostMapping(value = "getMajorList.post", produces = "application/json; charset=UTF-8")
    public void getMajorList(@RequestBody Proj2ndEntity projBean, BindingResult result, HttpServletResponse response) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("PackageApi.getMajorList invoked! param projBean :{}" + projBean);
        }
        try {
        		List<Proj2ndEntity> projList = proj2ndService.getMajorList(projBean);
        		if(projList!=null && projList.size()>0){
        			JSONArray jsonArray = new JSONArray();
        			Map<String,List<String>> retMap = new HashMap<String,List<String>>();
        			for(int i=65;i<=90;i++){
        				retMap.put(String.valueOf((char)i), null);
        			}
        			int projSize = projList.size();
        			for(int i=0;i<projSize;i++){
        				Proj2ndEntity proj = projList.get(i);
            			String projName = proj.getName();
            			String titel = getPinYinHeadChar(projName);
            			List<String> projTempList = retMap.get(titel);
        				if(projTempList!=null){
        					projTempList.add(projName);
        					retMap.put(titel,projTempList);
        				}else{
        					List<String> tempList = new ArrayList<String>();
        					tempList.add(projName);
        					retMap.put(titel,tempList);
        				}
            		}
        			jsonArray.add(retMap);
        			renderSuccess(response, jsonArray);
        		}else{
        			renderSuccess(response, "没有专业！");
        		}
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("专业接口异常:" + e.getMessage(), e);
            renderError(response, null);
        }
    }

    // 返回中文的首字母
    public static String getPinYinHeadChar(String str) {
        String temp = "";
        String demo = "";
        String convert = "";
        for (int j = 0; j < 1; j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        for(int i=0;i<convert.length();i++){//convert目前为小写首字母,下面是将小写首字母转化为大写
            if(convert.charAt(i)>='a' && convert.charAt(i)<='z'){
                temp=convert.substring(i,i+1).toUpperCase();
                demo += temp;
            }
        }
        return demo;
    }
    
}

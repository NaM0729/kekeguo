package com.sportsxdata.adms.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 渲染工具类
 *
 * @author stylefeng
 * @date 2017-08-25 14:13
 */
@Slf4j
public class RenderUtil {

    /**
     * 渲染json对象
     */
    public static void renderJson(HttpServletResponse response, Object jsonObject) {
        try (PrintWriter writer = response.getWriter()){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            writer.write(JsonUtils.objectToJson(jsonObject));
        } catch (IOException e) {
            log.error("写出数据报错:",e);
        }
    }
}

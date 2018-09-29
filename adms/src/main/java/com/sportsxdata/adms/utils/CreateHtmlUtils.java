package com.sportsxdata.adms.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Map;

public class CreateHtmlUtils {


    public static void createHtml(String templateName,String targetFileName,Map<String, Object> map) throws Exception{
        //创建fm的配置
        Configuration config = new Configuration();
        //指定默认编码格式
        config.setDefaultEncoding("UTF-8");
        //设置模版文件的路径
        File file = ResourceUtils.getFile("classpath:templates");
        config.setDirectoryForTemplateLoading(file);
        //获得模版包
        Template template = config.getTemplate(templateName);
        //从参数文件中获取指定输出路径 ,路径示例：C:/Workspace/shop-test/src/main/webapp/html
        //String path = "C:\\Users\\HP\\Desktop\\html";
        //定义输出流，注意必须指定编码
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file.getPath()+"/"+targetFileName)),"UTF-8"));
        //生成模版
        template.process(map, writer);
    }
}

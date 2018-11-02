package com.kekeguo.admin.service;


import com.kekeguo.admin.excel.ReadExcelUtil;
import com.kekeguo.admin.util.LamdbaUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 读取数据并进行分组
 *
 * @author zhangyuna
 * @date 2018年10月30日10:42:52
 */
public class ClassifyByExcel {

    /**
     * 读取ClassifyByExcel.xls中"知识点描述"进行等级分类
     */
    public void ClassifyByCell() throws IOException {
        String path = "/Users/admin/Documents/TestImportExcel/ClassifyByExcel.xls";
        Workbook workbook = ReadExcelUtil.creatWorkbook(path);
        List<Map> lists = ReadExcelUtil.getDatasAndRow(null, 1, workbook);
        // 以知识点编号去重
        List<Map> listDistinct = lists.stream().filter(LamdbaUtil.distinctByKey(map -> map.get("知识点编号"))).collect(Collectors.toList());
        String pat1 = "\\d+\\、";
        Pattern pattern = Pattern.compile(pat1);
        int size = listDistinct.size();
        for (int i = 0; i < size; i++) {
            Map<String, Object> map = listDistinct.get(i);
            String str = String.valueOf(map.get("知识点描述"));
            List list = groupBy(str);
            map.put("知识点描述", list);
            listDistinct.set(i, map);
        }
        System.out.println(listDistinct);
    }

    private static final String  one_Level = "\\d+\\、";
    private static final String  two_Level = "\\（+\\d+\\）";

    /**
     * 执行拆分操作
     * @param value
     * @param pattern
     * @return
     */
    public String[] split(String value,String pattern){
        return Pattern.compile(pattern).split(value);
    }

    private List groupBy(String str) {
        List<Object> list = new ArrayList<>();
        List<Object> list1 = new ArrayList<>();
        String s1[] = this.split(str,one_Level);
        if (s1.length > 0) {
            for (int i = 0; i < s1.length; i++) {
                if (!StringUtils.isEmpty(s1[i].trim())) {
                    list1.add(i + "、" + s1[i].trim());
                }
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            Map<String, Object> map1 = new HashMap<>();
            String s2[] = this.split((String) list1.get(i),two_Level);
            List<Object> list2 = new ArrayList<>();
            if (s2.length > 1) {
                for (int j = 1; j < s2.length; j++) {
                    if (!StringUtils.isEmpty(s2[j].trim())) {
                        list2.add("（" + j + "）" + s2[j].trim());
                    }
                }
            }
            map1.put("header", s2[0].trim());
            map1.put("option", list2);
            list.add(map1);
        }
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map2 = (Map<String, Object>) list.get(i);
            List list3 = (List) map2.get("option");
            List list5 = new ArrayList();
            if (list3.size() > 0) {
                for (int j = 0; j < list3.size(); j++) {
                    Map<String, Object> map4 = new HashMap<>();
                    List list4 = new ArrayList();
                    String data2 = (String) list3.get(j);
                    String[] split = data2.split("\\n");
                    if(split.length == 1){
                        map4.put("header", split[0].trim());
                        map4.put("option", list4);
                    }
                    if (split.length > 1) {
                        for (int k = 1; k < split.length; k++) {
                            Map<String, String> map3 = new HashMap<>();
                            if (StringUtils.isEmpty(split[k].trim())) {
                                continue;
                            }
                            map3.put("header", split[k].trim());
                            list4.add(map3);
                        }
                        map4.put("header", split[0].trim());
                        map4.put("option", list4);
                    }
                    list5.add(map4);
                }
                map2.put("option", list5);
            }
        }

        System.out.println(list);
        return list;
    }

    public static void main(String[] args) throws IOException {
        ClassifyByExcel classifyByExcel = new ClassifyByExcel();
        classifyByExcel.ClassifyByCell();
    }
}

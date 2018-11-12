package com.kekeguo.admin.service;


import com.kekeguo.admin.excel.ReadExcelUtil;
import com.kekeguo.admin.util.LamdbaUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.ObjectUtils;
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

    private static final String one_Level = "\\d+\\、";
    private static final String two_Level = "\\（+\\d+\\）";

    /**
     * 执行拆分操作
     *
     * @param value
     * @param pattern
     * @return
     */
    public String[] split(String value, String pattern) {
        return Pattern.compile(pattern).split(value);
    }

    private List groupBy(String str) {
        List<Object> list = new ArrayList<>();
        List<Object> list1 = new ArrayList<>();
        String s1[] = this.split(str, one_Level);
        if (s1.length > 0) {
            for (int i = 0; i < s1.length; i++) {
                if (!StringUtils.isEmpty(s1[i].trim())) {
                    list1.add(i + "、" + s1[i].trim());
                }
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            Map<String, Object> map1 = new HashMap<>();
            String s2[] = this.split((String) list1.get(i), two_Level);
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
                    if (split.length == 1) {
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

    public static String[] deleteEmpty(String[] strings) {
        String[] newstr = new String[strings.length];
        int num = 0;
        for (int i = 0; i < strings.length; i++) {
            if (!StringUtils.isEmpty(strings[i])) {
                newstr[num++] = strings[i];
            }
        }
        return newstr;
    }

    public static void main(String[] args) throws IOException {
//        ClassifyByExcel classifyByExcel = new ClassifyByExcel();
//        classifyByExcel.ClassifyByCell();
        String str = "1、资本一帝国主义列强对中国的侵略，首先和主要的是进行军事侵略\n" +
                "\n" +
                "2、第一次鸦片战争后\n" +
                "（1）1842年8月，中英《南京条约（江宁条约）》（第一个不平等条约）\n" +
                "\n" +
                "①割让香港岛给英国\n" +
                "\n" +
                "②开放广州、厦门、福州、宁波、上海等港口城市作通商口岸\n" +
                "\n" +
                "③赔款2100万银元";
        String one_Level = "\\d+\\、";
        String two_Level = "\\（+\\d+\\）";

        List<Object> list1 = new ArrayList<>();
        String[] string1 = deleteEmpty(Pattern.compile(one_Level).split(str));
        int length1 = string1.length;
        for (int i = 0; i < length1; i++) {
            if(StringUtils.isEmpty(string1[i])){
                continue;
            }
            Map<String, Object> map1 = new HashMap<>();
            List<Object> list2 = new ArrayList<>();
            String[] string2 = deleteEmpty(Pattern.compile(two_Level).split(string1[i]));
            int length2 = string2.length;
            if (length2 == 1) {
                String[] string3 = deleteEmpty(string2[0].split("\\n"));
                Map<String, Object> map2 = new HashMap<>();
                List<Map> list3 = new ArrayList<>();
                int length3 = string3.length;
                if (length3 == 1) {  //当一级标题为空
                    map1.put("header", string3[0].trim());
                }
                if (length3 > 1) {
                    map1.put("header", string3[0].trim());
                    for (int k = 1; k < string3.length; k++) {
                        Map<String, Object> map3 = new HashMap<>();
                        map3.put("header", string3[0].trim());
                        list3.add(map3);
                    }
                    map2.put("option", list3);
                    map2.put("header", "(2)");
                    list2.add(map2);
                    map1.put("option", list2);
                }
                continue;
            }
            if (length2 > 1) {
                map1.put("header", string2[0].trim());
                for (int j = 1; j < length2; j++) {
                    String[] string3 = deleteEmpty(string2[j].split("\\n"));
                    Map<String, Object> map2 = new HashMap<>();
                    List<Map> list3 = new ArrayList<>();
                    int length3 = string3.length;

                    if (length3 == 1) {
                        map2.put("header", string3[0].trim());
                    }
                    if (length3 > 1) {
                        map2.put("header", string3[0].trim());
                        for (int k = 1; k < string3.length; k++) {
                            Map<String, Object> map3 = new HashMap<>();
                            map3.put("header", string3[k].trim());
                            list3.add(map3);
                        }
                        map2.put("option", list3);
                    }
                    list2.add(map2);
                    map1.put("option", list2);
                }
            }

            list1.add(map1);
        }
        System.out.println("success");
    }
}

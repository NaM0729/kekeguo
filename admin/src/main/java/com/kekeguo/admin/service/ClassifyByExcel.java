package com.kekeguo.admin.service;


import com.kekeguo.admin.excel.ReadExcelUtil;
import com.kekeguo.admin.util.LamdbaUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 读取数据并进行分组
 *
 * @author zhangyuna
 * @date 2018年10月30日10:42:52
 */
@Component
public class ClassifyByExcel {

    /**
     * 读取ClassifyByExcel.xls中"知识点描述"进行等级分类
     */
    public List<Map> ClassifyByCell() throws IOException {
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
        return listDistinct;
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
        // 拆分一级
        if (s1.length > 0) {
            for (int i = 0; i < s1.length; i++) {
                if (!StringUtils.isEmpty(s1[i].trim())) {
                    list1.add(i + "、" + s1[i].trim());
                }
            }
        }
        // 拆分二级
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


        // 拆分三级
        List result = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map2 = (Map<String, Object>) list.get(i);
            Map<String, Object> mapOne = new HashMap<>();
            List listTwo = new ArrayList();
            String stringHeader = String.valueOf(map2.get("header"));
            String[] splitHeader = stringHeader.split("\\n");
            Map<String, Object> mapTwo = new HashMap<>();
            if (splitHeader.length > 1) {
                List listThree = new ArrayList();
                for (int m = 1; m < splitHeader.length; m++) {
                    Map<String, Object> mapThree = new HashMap<>();
                    if (StringUtils.isEmpty(splitHeader[m].trim())) {
                        continue;
                    }
                    mapThree.put("header", splitHeader[m].trim());
                    listThree.add(mapThree);
                }
                mapTwo.put("header", "（1）");
                mapTwo.put("option", listThree);
                listTwo.add(mapTwo);
                mapOne.put("header", splitHeader[0].trim());
                mapOne.put("option", listTwo);
                result.add(mapOne);
            } else {
                mapOne.put("header", stringHeader);
                result.add(mapOne);
            }
            List listOption = (List) map2.get("option");
            if (listOption.size() > 0) {
                for (int j = 0; j < listOption.size(); j++) {
                    Map<String, Object> mapThree = new HashMap<>();
                    List listThree = new ArrayList();
                    String data2 = (String) listOption.get(j);
                    String[] split1 = data2.split("\\n");
                    if (split1.length == 1) {
                        mapThree.put("header", split1[0].trim());
                        mapThree.put("option", listThree);
                    }
                    if (split1.length > 1) {
                        for (int k = 1; k < split1.length; k++) {
                            Map<String, String> map3 = new HashMap<>();
                            if (StringUtils.isEmpty(split1[k].trim())) {
                                continue;
                            }
                            map3.put("header", split1[k].trim());
                            listThree.add(map3);
                        }
                        mapThree.put("header", split1[0].trim());
                        mapThree.put("option", listThree);
                    }
                    listTwo.add(mapThree);
                    mapOne.put("option", listTwo);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        ClassifyByExcel classifyByExcel = new ClassifyByExcel();
//        classifyByExcel.ClassifyByCell();

        String str = "" +
                "1、资本一帝国主义列强对中国的侵略，首先和主要的是进行军事侵略\n" +
                "\n" +
                "2、第一次鸦片战争后\n" +
                "（1）1842年8月，中英《南京条约（江宁条约）》（第一个不平等条约）\n" +
                "\n" +
                "①割让香港岛给英国\n" +
                "\n" +
                "②开放广州、厦门、福州、宁波、上海等港口城市作通商口岸\n" +
                "\n" +
                "③赔款2100万银元" +
                "3、第二次鸦片战争后\n" +
                "\n" +
                "①割让香港岛给英国\n" +
                "\n" +
                "②开放广州、厦门、福州、宁波、上海等港口城市作通商口岸\n" +
                "\n" +
                "③赔款2100万银元" +
                "4、第三次鸦片战争后\n" +
                "\n" +
                "①割让香港岛给英国\n" +
                "（1）1842年8月，中英《南京条约（江宁条约）》（第一个不平等条约）\n" +
                "\n" +
                "①开放广州、厦门、福州、宁波、上海等港口城市作通商口岸\n" +
                "\n" +
                "③赔款2100万银元";

        List list = classifyByExcel.groupBy(str);

        System.out.println("success");
    }
}

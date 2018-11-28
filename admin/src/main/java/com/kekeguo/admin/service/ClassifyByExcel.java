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
            int num = 1;
            for (int i = 0; i < s1.length; i++) {
                if (!StringUtils.isEmpty(s1[i].trim())) {
                    list1.add((num++) + "、" + s1[i].trim());
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

        String splitThree[] = {"①", "②", "③", "④", "⑤", "⑥", "⑦", "⑧", "⑨", "⑩", "⑪", "⑫", "⑬", "⑭", "⑮", "⑯"};

        // 拆分三级
        List result = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map2 = (Map<String, Object>) list.get(i);
            Map<String, Object> mapOne = new HashMap<>();
            List listTwo = new ArrayList();
            String stringHeader = String.valueOf(map2.get("header"));
//            String[] splitHeader = stringHeader.split("\\n");
            String[] splitHeader = stringHeader.split("[①,②,③,④,⑤,⑥,⑦,⑧,⑨,⑩,⑪,⑫,⑬,⑭,⑮,⑯]");
            Map<String, Object> mapTwo = new HashMap<>();
            if (splitHeader.length > 1) {
                List listThree = new ArrayList();
                int threeNum = 0;
                for (int m = 1; m < splitHeader.length; m++) {
                    Map<String, Object> mapThree = new HashMap<>();
                    if (StringUtils.isEmpty(splitHeader[m].trim())) {
                        continue;
                    }
                    mapThree.put("header", (splitThree[threeNum++]) + splitHeader[m].trim().replaceAll("\\n", ""));
                    listThree.add(mapThree);
                }
                mapTwo.put("header", "（1）");
                mapTwo.put("option", listThree);
                listTwo.add(mapTwo);
                mapOne.put("header", splitHeader[0].trim().replaceAll("\\n", ""));
                mapOne.put("option", listTwo);
                result.add(mapOne);
            } else {
                mapOne.put("header", stringHeader.replaceAll("\\n", ""));
                result.add(mapOne);
            }
            List listOption = (List) map2.get("option");
            if (listOption.size() > 0) {
                for (int j = 0; j < listOption.size(); j++) {
                    Map<String, Object> mapThree = new HashMap<>();
                    List listThree = new ArrayList();
                    String data2 = (String) listOption.get(j);
//                    String[] split1 = data2.split("\\n");
                    String[] split1 = data2.split("[①,②,③,④,⑤,⑥,⑦,⑧,⑨,⑩,⑪,⑫,⑬,⑭,⑮,⑯]");
                    if (split1.length == 1) {
                        mapThree.put("header", split1[0].trim().replaceAll("\\n", ""));
                        mapThree.put("option", listThree);
                    }
                    if (split1.length > 1) {
                        int threeNum = 0;
                        for (int k = 1; k < split1.length; k++) {
                            Map<String, String> map3 = new HashMap<>();
                            if (StringUtils.isEmpty(split1[k].trim())) {
                                continue;
                            }
                            map3.put("header", (splitThree[threeNum++]) + split1[k].trim().replaceAll("\\n", ""));
                            listThree.add(map3);
                        }
                        mapThree.put("header", split1[0].trim().replaceAll("\\n", ""));
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

//        String str = "1、经济全球化的本质：资源配置的国际化。" +
//                "2、经济全球化的内容包括：生产全球化、贸易全球化、资本全球化。" +
//                "（1）生产全球化。这是指随着科学技术的发展，一系列高精尖产品和工艺技术的出现、生产领域的国际分工和协作的加强、各国在生产上密切配合的趋势。" +
//                "（2）贸易全球化。贸易全球化迅猛发展的主要原因是：首先，新科技革命中出现了很多新兴产业，\n" +
//                "国际产业结构的变化、各国间产业分工的深化和产业在不同国家间的梯度转移。\n" +
//                "①其次，新科技革命推动下的高效率、大批量生产，也要求在全球范围内开拓市场、扩大国际贸易规模。\n" +
//                "②再次，随着生产水平的提高，人们的生活水平也普遍提高了，对各国产品的需求也相应增加，这又从一个侧面促进了贸易的全球化。" +
//                "（3）资本全球化。近二三十年来，在新科技革命的推动下，资本在国际间的流动以前所未有的速度增加，形成了资本全球化趋势。";
        String str="一切从实际出发，是思想路线的前提和基础。 理论联系实际，是思想路线的途径和方法。实事求是，是党的思想路线的实质和核心。在实践中检验真理和发展真理，是思想路线验证的条件和目的。";

        List list = classifyByExcel.groupBy(str);
        System.out.println(list);
    }
}

package com.kekeguo.admin.util;

import java.util.*;

/**
 * @author zhangyuna
 * @date 2018年11月05日16:31:23
 */
public class CityGroup {

    /**
     * 按字母分类，将不同字母开头的城市，放到不同的集合中，并将这些集合存放到以A-Z为key的map集合中
     * ,因为取出来的时候要按照A-Z的顺序取出，因此，用TreeMap集合存放数据
     */
    public static Map<String, List<String>> GroupByName(List<String> lists) {
        Map<String, List<String>> map = new TreeMap<String, List<String>>();//分组后的城市集合
        String arr[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        //创建不同key的map集合,Map("A",list1),Map("B",list2)
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], new ArrayList<String>());
        }
        for (String str : lists) {
            String upperCase = ChineseCharacterUtil.getUpperCase(str, false).substring(0,1);
            if (map.containsKey(upperCase)) {
                map.get(upperCase).add(str);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("安徽省", "澳门", "北京市", "福建省", "甘肃省", "广西", "广东省",
                "贵州省", "海南省", "河北省", "河南省", "黑龙江", "湖北省", "湖南省",
                "吉林省", "江苏省", "江西省", "辽宁省", "内蒙古", "宁夏", "青海省",
                "山东省", "山西省", "陕西省", "上海市", "四川省", "台湾省", "天津市",
                "西藏", "香港", "新疆", "云南省", "浙江省", "重庆市");
        Map<String, List<String>> map = GroupByName(list);

//        遍历打印出集合中的值
        Set<Map.Entry<String, List<String>>> set = map.entrySet();
        for (Map.Entry<String, List<String>> m : set) {
            if (m.getValue() != null) {
                //key下面的集合不为空，才显示首字母以及下面的城市
                System.out.println("=========" + m.getKey() + "========");
                for (String c : m.getValue())
                    System.out.println(c);
            }
        }
    }

}


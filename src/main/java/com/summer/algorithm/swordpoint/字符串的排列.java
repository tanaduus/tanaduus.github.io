package com.summer.algorithm.swordpoint;

import java.util.ArrayList;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class 字符串的排列 {

    public ArrayList<String> Permutation(String str) {

        if (str.length() == 0) {
            return new ArrayList<>();
        }

        char[] chars = str.toCharArray();

        ArrayList<String> resultList = arrange(chars);

        return resultList;
    }

    /**
     * 排列组合函数
     *
     * @param chars
     * @return
     */
    private ArrayList<String> arrange(char[] chars) {
        ArrayList<String> resultList = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            ArrayList<String> innerList = new ArrayList<>();
            char first = chars[i];

            //去重复判断,防止输入aa时出现aa,aa
            boolean flag = false;
            for(int n=0;n<i;n++){
                if(chars[n]==first){
                    flag = true;
                }
            }

            if(flag){
                continue;
            }

            char[] others = getOthers(i, chars);
            if (others.length == 0) {
                innerList.add(String.valueOf(first));
            } else {

                //递归
                ArrayList<String> otherList = arrange(others);
                for (int k = 0; k < otherList.size(); k++) {
                    String oth = otherList.get(k);
                    oth = first + oth;
                    otherList.set(k, oth);
                }
                innerList.addAll(otherList);
            }
            resultList.addAll(innerList);
        }
        return resultList;
    }

    /**
     * 获取其它元素
     *
     * @param i
     * @param chars
     * @return
     */
    private char[] getOthers(int i, char[] chars) {
        char[] others = new char[chars.length - 1];
        for (int j = 0, k = 0; j < chars.length; j++) {
            if (i != j) {
                others[k] = chars[j];
                k++;
            }
        }
        return others;
    }

    public static void main(String[] args) {
        字符串的排列 a = new 字符串的排列();

        ArrayList<String> resultList = a.Permutation("abca");

        resultList.forEach(e -> System.out.println(e));
    }
}

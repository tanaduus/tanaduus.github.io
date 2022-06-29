package tanaduus.github.io.algorithm.理论;

import java.util.*;

public class 时间匹配 {

    static List<Integer> getArray(){
        Scanner  s = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        System.out.print("输入数字数量n：");
        int n = s.nextInt();
        if(n<6){
            System.out.println("请重新输入n:");
        }
        System.out.println("输入"+n+"个数字：");
        for(int i=0;i<n;i++){
            System.out.print("第"+(i+1)+"个数字：");
            int e = s.nextInt();
            while(e<0||e>9) {
                System.out.print("请输入0-9之间的数字:");
                e = s.nextInt();
            }
            list.add(e);
        }
        s.close();
        return list;
    }

    static boolean validH(Integer h){
        return h >= 0 && h <= 23;
    }

    static boolean validM(Integer m){
        return m >= 0 && m <= 59;
    }

    static boolean validS(Integer s){
        return s >= 0 && s <= 59;
    }

    public static void main(String[] args) {
//        List<Integer> list = getArray();
        List list = new ArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(9);
        list.add(8);
        list.forEach(e->System.out.print(e+" "));
        System.out.println();
        Collections.sort(list);
        list.forEach(e->System.out.print(e+" "));
        System.out.println();
        String minH = list.get(0)+""+list.get(1);
        String minM = list.get(2)+""+list.get(3);
        String minS = list.get(4)+""+list.get(5);
        System.out.println(minH+":"+minM+":"+minS);
        boolean flagMin = validH(Integer.parseInt(minH))&&validM(Integer.parseInt(minM))&&validS(Integer.parseInt(minS));
        if(!flagMin){
            System.out.println("end!wrong datetime");
        }

        System.out.println(list.contains(2));

    }
}

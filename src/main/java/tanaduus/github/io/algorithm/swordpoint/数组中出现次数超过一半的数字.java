package tanaduus.github.io.algorithm.swordpoint;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * <p>
 * 思路一：直接排序。取中间数即可。(缺点是如果不存在超过半数的元素，取中间数字不正确)
 * <p>
 * 思路二：采用阵地攻守的思想：
 * 第一个数字作为第一个士兵，守阵地；count = 1；
 * 遇到相同元素，count++;
 * 遇到不相同元素，即为敌人，同归于尽,count--；
 * 当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
 * 再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
 * <text>因为超过半数的话，一定可以把所有对手都干掉。无论对手有没有内耗。</text>
 */
public class 数组中出现次数超过一半的数字 {

    /**
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {

        if (array.length == 0) {
            return 0;
        }

        int flag = array.length / 2;

        //使用[思路二:阵地攻守]来解题
        int count = 0;
        int general = 0;
        //进行攻守
        for(int i=0;i<array.length;i++){
            if(i==0){
                general = array[i];
                count++;
                continue;
            }

            //攻守
            if(array[i]!=general){
                count--;
                if(count==0){
                    general = array[i];
                    count++;
                }
            }else{
                count++;
            }
        }

        int amt = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]==general){
                amt++;
            }
        }

        if(amt>flag){
            return general;
        }

        return 0;
    }


    public static void main(String[] args) {
        数组中出现次数超过一半的数字 a = new 数组中出现次数超过一半的数字();
        int[] array = {1,2,3,2,2,2,5,4,2};

        int r = a.MoreThanHalfNum_Solution(array);
        System.out.println(r);
    }
}

package tanaduus.github.io.algorithm.数组;

/**
 * [2,4*,1,2,7,8*,4]
 *
 * @author 夏冬
 * @date 2022/6/22
 */
public class 寻找峰值 {

    public int findPeakElement (int[] nums) {
        int index=0;//存储索引的位置
        //排除只有一个数字的情况
        if(nums.length==1){
            return 0;
        }
        int i=0;
        //如果发现只要第一个数字比第二个数字大,就直接返回第一个数字的索引
        if(nums[0]>nums[1]){
            return 0;
        }
        for(i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                index=i;
                break;
            }
        }
        //如果上面循环发现还没有找到峰值,直接返回最后一个
        if(i==nums.length-1){
            return nums.length-1;
        }
        return index;
    }
}

package week1_OOP;

import java.util.ArrayList;

public class Solution {
    /**
     * 失物排序方法
     * @param lostArray 待排序的失物数组
     * 按照丢失时间排序
     */
    public void sortLost(Lost[] lostArray){
        //冒泡排序
        for(int i = 0;i < lostArray.length-1;i++){
            for(int j = 0;j < lostArray.length - i -1;j++){
                if(lostArray[j].getDate()>lostArray[j+1].getDate()){
                    Lost temp = lostArray[j];
                    lostArray[j] = lostArray[j+1];
                    lostArray[j+1] = temp;

                }
            }
        }
    }

    /**
     * 按关键字搜索失物的方法，这里假设按照失物的领取地点进行搜索
     * @param lostArray 失物数组
     * @param keyword 用户输入的关键字
     * @return 返回查找到的失物
     */
    public Lost[] selectByKeyword(Lost[] lostArray,String keyword){
        //暂存匹配到的失物
        ArrayList<Lost> temp = new ArrayList<>();
        for(int i = 0;i < lostArray.length;i++){
            if(lostArray[i].getGetPlace().equals(keyword)){
                temp.add(lostArray[i]);
            }
        }

        //ArrayList转数组
        int i = temp.size();
        Lost[] outcome = (Lost[])temp.toArray(new Lost[i]);
        return outcome;
    }
}

package week3;

import java.util.ArrayList;

//    写一个 RecentCounter 类来计算特定时间范围内最近的请求。
//    请你实现 RecentCounter 类：
//    RecentCounter() 初始化计数器，请求数为 0 。
//    int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间.
//    并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
//    保证 每次对 ping 的调用都使用比之前更大的 t 值。
//    1 <= t <= 1E9
//    保证每次对 ping 调用所使用的 t 值都 严格递增
//    至多调用 ping 方法 1E4 次
public class RecentCounter {

    static final int RANGE = 3000;
    ArrayList<Integer> list;
    public RecentCounter() {
        list = new ArrayList<>();
    }

    //把储存的值当作时间，差值大于3000则删除此数据前的所有数据
    public int ping(int t) {
        list.add(t);
        int j = list.size();
        for(int i = 0;i < j;i++) {
            if (t - list.get(0) > RANGE) {
                list.remove(0);
            }
        }
        return list.size();
    }

    //leetcode提交通过
//    执行用时：138 ms, 在所有 Java 提交中击败了13.68%的用户
//    内存消耗：49.2 MB, 在所有 Java 提交中击败了64.96%的用户
//    通过测试用例：68 / 68
    public static void main(String[] args) {
        RecentCounter r = new RecentCounter();
        //[156166],[156423],[158304],[211387]
        r.ping(156166);//1
        r.ping(156423);//2
        r.ping(158304);//3
        int ans = r.ping(211387);//1

        System.out.println(ans);
    }
}
//官方题解用了队列，第一次接触，翻了翻api，能看懂
//    static final int RANGE = 3000;
//    Queue<Integer> queue;
//
//    public RecentCounter() {
//        queue = new ArrayDeque<Integer>();
//    }
//
//    public int ping(int t) {
//        while (!queue.isEmpty() && queue.peek() < t - RANGE) {
//            queue.poll();
//        }
//        queue.offer(t);
//        return queue.size();
//    }

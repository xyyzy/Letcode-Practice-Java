package BFS._752_打开转盘锁;

import com.sun.xml.internal.bind.v2.util.StackRecorder;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。
 * 每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 */
public class Solution {
    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }

    public static int openLock(String[] deadends, String target) {
        //记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        //记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        //从起点开始启动广度优先搜索
        int setp = 0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            /*将当前队列中的所有节点向周围扩散*/
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                /*判断是否到达终点*/
                if (deads.contains(cur))
                    continue;
                if (cur.equals(target))
                    return setp;
                /*将一个节点的未遍历相邻节点加入队列*/
                /**
                 * 第一步，我们不管所有的限制条件，不管deadends和target的限制，就思考一个问题：如果让你设计一个算法，穷举所有可能的密码组合，你怎么做？
                 *
                 * 穷举呗，再简单一点，如果你只转一下锁，有几种可能？总共有 4 个位置，每个位置可以向上转，也可以向下转，也就是有 8 种可能对吧。
                 *
                 * 比如说从"0000"开始，转一次，可以穷举出"1000", "9000", "0100", "0900"...共 8 种密码。然后，再以这 8 种密码作为基础，对每个密码再转一下，穷举出所有可能…
                 *
                 * 仔细想想，这就可以抽象成一幅图，每个节点有 8 个相邻的节点，又让你求最短距离，这不就是典型的 BFS 嘛
                 * */
                //穷举所有的密码情况
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            //增加部署
            setp++;
        }
        return -1;
    }

    /*
     * 利用双向的BFS遍历
     * */
    public static int openLock2(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        //用集合不用队列，可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int step = 0;
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();
            /* 将 q1 中的所有节点向周围扩散 */
            for (String cur : q1) {
                /*判断是否是终点*/
                if (deads.contains(cur))
                    continue;
                //交集
                if (q2.contains(cur))
                    return step;
                visited.add(cur);
                /* 将一个节点的未遍历相邻节点加入集合 */
                for (int i = 0; i < 4; i++) {
                    String up = plusOne(cur, i);
                    if (!visited.contains(up))
                        temp.add(up);

                    String down = minusOne(cur,i);
                    if (!visited.contains(down))
                        temp.add(down);
                }
            }
            /* 在这里增加步数 */
            step++;
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }


    //将s[j]向上拨动一次
    static String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }

    //将s[j]向下拨动一次
    static String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }

}

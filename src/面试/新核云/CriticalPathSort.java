package 面试.新核云;

import com.sun.javafx.geom.Edge;

import java.util.Stack;

public class CriticalPathSort {

    static class EdgeNode {

        public int adjevex;
        public double weight;
        public EdgeNode next;


        public EdgeNode(int adjevex, double weight, EdgeNode next) {
            this.adjevex = adjevex;
            this.weight = weight;
            this.next = next;
        }
    }

    static class VertexNode {

        public int in;
        public Object data;
        public EdgeNode firstedge;

        public VertexNode(Object data, int in, EdgeNode firstedge) {
            this.data = data;
            this.in = in;
            this.firstedge = firstedge;
        }
    }
    //最早发生时间，最晚发生时间
    Double[] etv, ltv;
    Stack stack = new Stack(); //存储入度为0的顶点，便于每次寻找入度为0的顶点时都遍历整个邻接表
    Stack stack2 = new Stack(); //将顶点序号压入拓扑序列的栈
    static VertexNode[] adjList;
    int cost = 0;


    public boolean ToplogicalSort() {
        EdgeNode e;
        int k, gettop;
        int count = 0;
        etv = new Double[adjList.length];
        for (int i = 0; i < adjList.length; i++) {
            if (adjList[i].in == 0) {
                stack.push(i);
            }
        }
        for (int i = 0; i < adjList.length; i++) {
            etv[i] = Double.valueOf(0);
        }

        while (!stack.isEmpty()) {
            //取出入度为0的节点
            gettop = (int) stack.pop();
            count++;
            stack2.push(gettop);
            //以gettop节点起始遍历相邻节点
            for (e = adjList[gettop].firstedge; e != null; e = e.next) {
                //相邻节点
                k = e.adjevex;
                if ((--adjList[k].in) == 0) {
                    stack.push(k);
                }
                //计算最早开始时间
                if (etv[gettop] + e.weight > etv[k]) {
                    etv[k] = etv[gettop] + e.weight;
                }
            }
        }
        if (count < adjList.length) return false;
        else return true;

    }


    public void CriticalPath() {
        EdgeNode e;
        int gettop, k, j;
        //最早开工时间 = 最早发生时间
        Double ete;
        //最晚开工时间
        double lte;
        if (!this.ToplogicalSort()) {
            System.out.println("该网中存在回路!");
            return;
        }
        //最晚发生时间
        ltv = new Double[adjList.length];
        for (int i = 0; i < adjList.length; i++) {
            ltv[i] = etv[etv.length - 1];
        }

        while (!stack2.isEmpty()) {
            //取出栈顶端的节点
            gettop = (int) stack2.pop();
            for (e = adjList[gettop].firstedge; e != null; e = e.next) {
                k = e.adjevex;
                if (ltv[k] - e.weight < ltv[gettop]) {
                    ltv[gettop] = ltv[k] - e.weight;
                }
            }
        }

        for (int i = 0; i < adjList.length; i++) {
            for (e = adjList[i].firstedge; e != null; e = e.next) {
                k = e.adjevex;
                ete = etv[i];
                lte = ltv[k] - e.weight;
                //最早开工==最晚开工  则为关键路径
                if (ete == lte) {
                    cost += e.weight;
                    System.out.print( adjList[k].data +" ");
                }
            }
        }
        System.out.println("花费时间:"+ cost);
    }


    public static EdgeNode getAdjvex(VertexNode node) {
        EdgeNode e = node.firstedge;
        while (e != null) {
            if (e.next == null) break;
            else
                e = e.next;
        }
        return e;
    }

    public static void main(String[] args) {
        int[] ins = {0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1};
        int[][] adjvexs = {
                {3, 2, 1},
                {4},
                {5},
                {6},
                {7},
                {7},
                {8},
                {9},
                {10},
                {10},
                {11},
                {}
        };
        double[][] widths = {
                {1, 0.5, 0.5},
                {0.5},
                {1},
                {1},
                {0.5},
                {0.5},
                {2},
                {0.5},
                {1},
                {1},
                {0},
                {}
        };
        String[] name = {"开始", "桌面开料", "桌腿开料", "抽屉板开料", "抛光", "打磨", "抽屉组装", "组装", "油漆", "抽屉油漆", "全桌组装", "结束"};
        adjList = new VertexNode[ins.length];
        for (int i = 0; i < ins.length; i++) {
            adjList[i] = new VertexNode(name[i], ins[i], null);
            if (adjvexs[i].length > 0) {
                for (int j = 0; j < adjvexs[i].length; j++) {
                    if (adjList[i].firstedge == null)
                        adjList[i].firstedge = new EdgeNode(adjvexs[i][j], widths[i][j], null);
                    else {
                        getAdjvex(adjList[i]).next = new EdgeNode(adjvexs[i][j], widths[i][j], null);
                    }
                }
            }
        }


        CriticalPathSort c = new CriticalPathSort();
        c.CriticalPath();
    }
}

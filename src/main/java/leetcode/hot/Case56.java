package leetcode.hot;

/*
 56. 合并区间
 中等
 相关标签
 相关企业
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

 示例 1：

 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 输出：[[1,6],[8,10],[15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 示例 2：
 输入：intervals = [[1,4],[4,5]]
 输出：[[1,5]]
 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 提示：
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

 */

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

@Slf4j
public class Case56 {
    public static void main(String[] args) {
        Case56 case56 = new Case56();
        int[][] intervals = {{1,4},{4,5}};
        case56.merge(intervals);

    }

    /*
    用优先队列排序过后再用 类似括号匹配的思路 相同的值  开始排在结束前面
    [1,3],[1,6] [2, 7] [8,10],[15,18]

    [1 [1 [2  3] 6] 7] [8 10] [15 18]

    [1,3] [2,3]

    [1 [2 3] 3]
     */
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        PriorityQueue<EndPoint> priorityQueue = new PriorityQueue<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int start = intervals[i][0];
            EndPoint s = new EndPoint(start, "start");
            priorityQueue.offer(s);
            int end = intervals[i][1];
            EndPoint e = new EndPoint(end, "end");
            priorityQueue.offer(e);
        }
        Stack<EndPoint> operation = new Stack<>();

        while (!priorityQueue.isEmpty()) {
            EndPoint p = priorityQueue.poll();
            if(operation.isEmpty()) {
                operation.push(p);
                continue;
            }
            EndPoint last = operation.peek();
            if ("start".equals(last.type) && ("end".equals(p.type)))  {
                operation.pop();
                if(operation.isEmpty()) {
                    System.out.println(last.number + " - " + p.number );
                    int[] pair = new int[] {last.number, p.number};
                    result.add(pair);
                }
            } else {
                operation.push(p);
            }

        }
        return result.toArray(new int[][]{});
    }

    static class EndPoint implements Comparable<EndPoint> {
        public int number;
        public String type;

        public EndPoint(int number, String type) {
            this.number = number;
            this.type = type;
        }

        @Override
        public int compareTo(EndPoint o) {
            // 比较 number
            if (this.number != o.number) {
                return this.number - o.number;
            }
            // 如果 number 相等，按 type 比较 ("start" < "end")
            if (this.type.equals("start") && o.type.equals("end")) {
                return -1; // "start" 在前
            } else if (this.type.equals("end") && o.type.equals("start")) {
                return 1; // "end" 在后
            }
            return 0; // 如果 type 也相等，保持顺序不变
        }

        @Override
        public String toString() {
            return "EndPoint{" +
                    "number=" + number +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}

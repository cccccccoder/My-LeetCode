package org.blue.learning.leetcode.day50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by klein on 2016/11/21.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> result = merge(intervals);
        result.forEach(System.out::println);
    }

    /**
     * 先排序，然后两两比较是否有重叠
     * 如果有重叠，更新end的值，取之前和当前interval的较大值
     * 否则，把之前累计的重叠的结果加入到数组中
     * @param intervals
     * @return
     */
    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return new ArrayList<>();
        }
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i ++) {
            Interval interval = intervals.get(i);
            if (interval.start > end) {
                // 与上一个没有重叠
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            } else {
                end = Math.max(end, interval.end);
            }
        }
        result.add(new Interval(start, end));
        return result;
    }

    public static class Interval {
        public int start;
        public int end;
        Interval() { start = 0; end = 0; }
        public Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}

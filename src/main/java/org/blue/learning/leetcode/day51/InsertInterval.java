package org.blue.learning.leetcode.day51;

import org.blue.learning.leetcode.day50.MergeIntervals.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klein on 2016/11/21.
 */
public class InsertInterval {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
//        intervals.add(new Interval(3, 5));
//        intervals.add(new Interval(6, 7));
//        intervals.add(new Interval(8, 10));
//        intervals.add(new Interval(12, 16));
        List<Interval> result = insert(intervals, new Interval(2, 7));
        result.forEach(System.out::println);
    }

    /**
     * 数组已经排好序，依次遍历寻找插入位置
     * 找到后与前面一个和后续的是否有重叠，有重叠就合并
     * @param intervals
     * @param newInterval
     * @return
     */
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        int i = 0;
        for (; i < intervals.size(); i ++) {
            Interval interval = intervals.get(i);
            if (newInterval.start <= interval.start) {
                if (i > 0 && intervals.get(i - 1).end >= newInterval.start) {
                    Interval last = intervals.get(i - 1);
                    result.remove(result.size() - 1);
                    newInterval.start = last.start;
                    newInterval.end = Math.max(last.end, newInterval.end);
                }
                while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
                    newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                    i ++;
                }
                result.add(newInterval);
                break;
            } else {
                result.add(interval);
            }
        }
        if (i != intervals.size()) {
            while (i < intervals.size()) {
                result.add(intervals.get(i++));
            }
        } else {
            // 在最后位置
            Interval lastOne = result.get(result.size() - 1);
            if (lastOne.end >= newInterval.start) {
                lastOne.end = Math.max(lastOne.end, newInterval.end);
            } else {
                result.add(newInterval);
            }
        }
        return result;
    }
}

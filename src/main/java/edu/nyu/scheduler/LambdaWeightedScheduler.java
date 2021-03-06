package edu.nyu.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: Mrunal Dave
 * Date: 4/5/17
 */
public class LambdaWeightedScheduler {

    private static int[] compatibleJobIndex;
    private static int[] memoizedCost;

    public static List<LambdaJob> getListOfWeightedScheduledJobs(List<LambdaJob> jobList) {
        if (jobList == null) throw new IllegalArgumentException("Input joblist should not be null");
        if (jobList.size() == 1) return jobList;
        Collections.sort(jobList);
        compatibleJobIndex = new int[jobList.size()];//Contains index of latest job compatible with the corresponding job
        computeCompatibleJobIndex(jobList);
        memoizedCost = new int[jobList.size()];
        computeMemoizedCost(jobList);
        ArrayList<LambdaJob> scheduledList = new ArrayList<>();
        getWeightedScheduledList(scheduledList, jobList, jobList.size() - 1);
        return scheduledList;

    }

    //Compute last compatible job index for each job
    private static void computeCompatibleJobIndex(List<LambdaJob> jobList) {
        compatibleJobIndex[0] = -1;
        for (int i = 1; i < jobList.size(); i++) {
            compatibleJobIndex[i] = getLastCompatibleJobIndex(jobList, i);
        }
    }


    //Compute memoized cost
    private static void computeMemoizedCost(List<LambdaJob> jobList) {
        memoizedCost[0] = jobList.get(0).getCost();
        for (int j = 1; j < jobList.size(); j++) {
            if (compatibleJobIndex[j] != -1)
                memoizedCost[j] = Math.max((jobList.get(j).getCost() + memoizedCost[compatibleJobIndex[j]]), memoizedCost[j - 1]);
            else memoizedCost[j] = jobList.get(j).getCost();
        }
    }

    //Backtrack
    private static void getWeightedScheduledList(List<LambdaJob> scheduledList, List<LambdaJob> jobList, int index) {
        if (index == -1)
            return;
        if (compatibleJobIndex[index] != -1 && (jobList.get(index).getCost() + memoizedCost[compatibleJobIndex[index]] >= memoizedCost[index - 1])) {
            scheduledList.add(jobList.get(index));
            getWeightedScheduledList(scheduledList, jobList, compatibleJobIndex[index]);
        } else getWeightedScheduledList(scheduledList, jobList, index - 1);

    }

    private static int getLastCompatibleJobIndex(List<LambdaJob> jobList, int jobIndex) {
        for (int i = jobIndex - 1; i >= 0; i--) {
            if (jobList.get(i).getFinishTime() <= jobList.get(jobIndex).getStartTime())
                return i;
        }
        return -1;
    }

}

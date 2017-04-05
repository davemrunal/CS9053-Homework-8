package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: Mrunal Dave
 * Date: 4/4/17
 */
public class LambdaScheduler {

    public static List<LambdaJob> getListOfScheduledJobs(List<LambdaJob> jobList) {
        if (jobList == null) throw new IllegalArgumentException("Input joblist should not be null");
        if (jobList.size() == 1) return jobList;
        Collections.sort(jobList);
        List<LambdaJob> scheduledList = new ArrayList<>();
        scheduledList.add(jobList.get(0));

        for (int i = 1; i < jobList.size(); i++) {
            if (jobList.get(i).getStartTime() >= scheduledList.get(scheduledList.size() - 1).getFinishTime())
                scheduledList.add(jobList.get(i));
        }
        return scheduledList;
    }

}

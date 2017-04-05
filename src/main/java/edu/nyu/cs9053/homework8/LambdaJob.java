package edu.nyu.cs9053.homework8;

/**
 * User: Mrunal Dave
 * Date: 4/4/17
 */
public class LambdaJob implements Comparable<LambdaJob> {

    private final int startTime;
    private final int finishTime;
    private final int cost;

    public LambdaJob(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.cost = 1;
    }

    public LambdaJob(int startTime, int finishTime, int cost) {
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.cost = cost;
    }

    @Override
    public int compareTo(LambdaJob lambdaJob) {
        return Integer.compare(this.finishTime, lambdaJob.finishTime);
    }


    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public int getCost() {
        return cost;
    }
}

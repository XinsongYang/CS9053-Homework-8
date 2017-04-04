package edu.nyu.cs9053.homework8;

import java.util.List;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		lambdaSchedulerTest();
		weightedSchedulerTest();
	}

	public static void lambdaSchedulerTest() {
		List<LambdaJob> jobs = new ArrayList<LambdaJob>();
		jobs.add(new LambdaJob(1, 5));
		jobs.add(new LambdaJob(2, 9));
		jobs.add(new LambdaJob(3, 7));
		jobs.add(new LambdaJob(4, 7));
		jobs.add(new LambdaJob(6, 11));
		jobs.add(new LambdaJob(11, 14));
		jobs.add(new LambdaJob(12, 16));
		jobs.add(new LambdaJob(13, 17));
		jobs.add(new LambdaJob(14, 16));
		jobs.add(new LambdaJob(15, 18));
		jobs.add(new LambdaJob(17, 20));
		System.out.println("Test jobs for LambdaScheduler:");
		LambdaScheduler.printJobs(jobs);
		LambdaScheduler.schedule(jobs);
	}

	public static void weightedSchedulerTest() {
		List<WeightedJob> jobs = new ArrayList<WeightedJob>();
		jobs.add(new WeightedJob(1, 5, 10d));
		jobs.add(new WeightedJob(2, 9, 20d));
		jobs.add(new WeightedJob(3, 7, 15d));
		jobs.add(new WeightedJob(4, 7, 18d));
		jobs.add(new WeightedJob(6, 11, 12d));
		jobs.add(new WeightedJob(11, 14, 8d));
		jobs.add(new WeightedJob(12, 16, 15d));
		jobs.add(new WeightedJob(13, 17, 17d));
		jobs.add(new WeightedJob(14, 16, 19d));
		jobs.add(new WeightedJob(15, 18, 10d));
		jobs.add(new WeightedJob(17, 20, 13d));
		jobs.add(new WeightedJob(1, 16, 30d));
		System.out.println("Test jobs for LambdaWeightedScheduler:");
		LambdaWeightedScheduler.printJobs(jobs);
		LambdaWeightedScheduler.schedule(jobs);
	}

}
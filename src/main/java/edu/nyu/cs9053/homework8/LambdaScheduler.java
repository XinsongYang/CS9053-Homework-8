package edu.nyu.cs9053.homework8;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaScheduler {
	
	public static void schedule(List<LambdaJob> jobs) {
		List<LambdaJob> scheduledJobs = maxSizeJobs(jobs);
		System.out.printf("The size of the largest compatible set is %d.%n", scheduledJobs.size());
		printJobs(scheduledJobs);
	}

	public static void sortJobsByEndTime(List<LambdaJob> jobs) {
		Collections.sort(jobs, new Comparator<LambdaJob>() {
			@Override public int compare(LambdaJob job1, LambdaJob job2) {
				return job1.getEndTime().compareTo(job2.getEndTime());
			}
		});
	}

	public static List<LambdaJob> maxSizeJobs(List<LambdaJob> jobs) {
		List<LambdaJob> scheduledJobs = new ArrayList<LambdaJob>();
		if (jobs == null || jobs.isEmpty()) {
			return scheduledJobs;
		}
		sortJobsByEndTime(jobs);
		scheduledJobs.add(jobs.get(0));
		LambdaJob lastJob = jobs.get(0);
		for (LambdaJob job : jobs) {
			if (job.getStartTime() > lastJob.getEndTime()) {
				scheduledJobs.add(job);
				lastJob = job;
			}
		}
		return scheduledJobs;
	}

	public static void printJobs(List<LambdaJob> jobs) {
		for (int i = 0; i < jobs.size(); i++) {
			System.out.printf("job%d: %d - %d%n", i, jobs.get(i).getStartTime(), jobs.get(i).getEndTime());
		}
	}

}

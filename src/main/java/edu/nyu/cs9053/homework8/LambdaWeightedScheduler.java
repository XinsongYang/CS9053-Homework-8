package edu.nyu.cs9053.homework8;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaWeightedScheduler {

	public static void schedule(List<WeightedJob> jobs) {
		sortJobsByEndTime(jobs);
		List<WeightedJob> scheduledJobs = maxValueJobs(jobs, jobs.size() - 1);
		System.out.printf("The maximum total value is %f.%n", totalValue(scheduledJobs));
		printJobs(scheduledJobs);
	}

	public static void sortJobsByEndTime(List<WeightedJob> jobs) {
		Collections.sort(jobs, new Comparator<WeightedJob>() {
			@Override public int compare(WeightedJob job1, WeightedJob job2) {
				return job1.getEndTime().compareTo(job2.getEndTime());
			}
		});
	}

	public static Double totalValue(List<WeightedJob> jobs) {
		Double total = 0d;
		for (WeightedJob job : jobs) {
			total += job.getWeight();
		}
		return total;
	}

	private static List<WeightedJob> maxValueJobs(List<WeightedJob> sortedJobs, int endIndex) {
		List<WeightedJob> scheduledJobs = new ArrayList<WeightedJob>();
		if (sortedJobs == null || sortedJobs.size() == 0 || endIndex < 0 || endIndex >= sortedJobs.size()) {
			return scheduledJobs;
		}
		if (endIndex == 0) {
			scheduledJobs.add(sortedJobs.get(0));
			return scheduledJobs;
		}
		List<WeightedJob> lastScheduledJobs = maxValueJobs(sortedJobs, endIndex - 1);
		WeightedJob endJob = sortedJobs.get(endIndex);
		for (WeightedJob job : lastScheduledJobs) {
			if (job.getEndTime() < endJob.getStartTime()) {
				scheduledJobs.add(job);
			}
		}
		scheduledJobs.add(endJob);
		return totalValue(scheduledJobs) > totalValue(lastScheduledJobs) ? scheduledJobs : lastScheduledJobs;
	}

	public static void printJobs(List<WeightedJob> jobs) {
		for (int i = 0; i < jobs.size(); i++) {
			WeightedJob job = jobs.get(i);
			System.out.printf("job%d: %d - %d, weight %f%n", i, job.getStartTime(), job.getEndTime(), job.getWeight());
		}
	}
}
package edu.nyu.cs9053.homework8;

public class LambdaJob {
	
	private final Integer startTime;
	private final Integer endTime;

	public LambdaJob(Integer startTime, Integer endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}
}
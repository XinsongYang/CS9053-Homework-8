package edu.nyu.cs9053.homework8;

public class WeightedJob extends LambdaJob {

	private final Double weight;

	public WeightedJob(Integer startTime, Integer endTime, Double weight) {
		super(startTime, endTime);
		this.weight = weight;
	}

	public Double getWeight() {
		return weight;
	}
}
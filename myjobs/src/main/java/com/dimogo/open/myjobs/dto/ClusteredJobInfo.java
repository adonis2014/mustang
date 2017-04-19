package com.dimogo.open.myjobs.dto;

/**
 * Created by Ethan Xiao on 2017/4/19.
 */
public class ClusteredJobInfo {

	private String jobName = "";
	private String cron = "";
	private String paras = "";
	private int executors = 0;
	private int executions = 0;
	private int maxInstances = 0;

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getParas() {
		return paras;
	}

	public void setParas(String paras) {
		this.paras = paras;
	}

	public int getExecutors() {
		return executors;
	}

	public void setExecutors(int executors) {
		this.executors = executors;
	}

	public int getExecutions() {
		return executions;
	}

	public void setExecutions(int executions) {
		this.executions = executions;
	}

	public int getMaxInstances() {
		return maxInstances;
	}

	public void setMaxInstances(int maxInstances) {
		this.maxInstances = maxInstances;
	}
}

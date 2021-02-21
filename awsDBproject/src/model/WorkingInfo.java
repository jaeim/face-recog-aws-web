package model;

import java.sql.Timestamp;

public class WorkingInfo {
	private int history_id;
	private int usr_id;
	// DATETIME 타입
	private String dateTime;
	private String workType;
	private int totalTime;
	private int workTime;
	private int notWorkTime;
	private int log_id;
	
	public WorkingInfo() {}

	public WorkingInfo(int history_id, int usr_id, String dateTime, String workType, int totalTime, int workTime,
			int notWorkTime, int log_id) {
		super();
		this.history_id = history_id;
		this.usr_id = usr_id;
		this.dateTime = dateTime;
		this.workType = workType;
		this.totalTime = totalTime;
		this.workTime = workTime;
		this.notWorkTime = notWorkTime;
		this.log_id = log_id;
	}

	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	public int getWorkTime() {
		return workTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
	public int getNotWorkTime() {
		return notWorkTime;
	}
	public void setNotWorkTime(int notWorkTime) {
		this.notWorkTime = notWorkTime;
	}

	public int getHistory_id() {
		return history_id;
	}

	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}

	public int getUsr_id() {
		return usr_id;
	}

	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}

	public int getLog_id() {
		return log_id;
	}

	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	
	
}

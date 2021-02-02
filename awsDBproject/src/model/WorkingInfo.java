package model;

public class WorkingInfo {
	private String dateTime;
	private String workType;
	private int totalTime;
	private int workTime;
	private int notWorkTime;
	
	public WorkingInfo() {}
	
	public WorkingInfo(String dateTime, String workType, int totalTime, int workTime, int notWorkTime) {
		super();
		this.dateTime = dateTime;
		this.workType = workType;
		this.totalTime = totalTime;
		this.workTime = workTime;
		this.notWorkTime = notWorkTime;
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
	
	
}

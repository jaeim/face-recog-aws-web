package model;

import java.sql.Date;
import java.sql.Timestamp;

public class LogInfo {
	private int LOG_ID;
	private Timestamp CREATED_DT;
	private byte[] CONTENT;
	private String TITLE;
	private int USR_ID;
	
	
	public LogInfo(int lOG_ID, Timestamp cREATED_DT, byte[] cONTENT, String tITLE, int uSR_ID) {
		super();
		LOG_ID = lOG_ID;
		CREATED_DT = cREATED_DT;
		CONTENT = cONTENT;
		TITLE = tITLE;
		USR_ID = uSR_ID;
	}


	public LogInfo() {
		super();
	}


	public int getLOG_ID() {
		return LOG_ID;
	}


	public void setLOG_ID(int lOG_ID) {
		LOG_ID = lOG_ID;
	}


	public Timestamp getCREATED_DT() {
		return CREATED_DT;
	}


	public void setCREATED_DT(Timestamp cREATED_DT) {
		CREATED_DT = cREATED_DT;
	}


	public byte[] getCONTENT() {
		return CONTENT;
	}


	public void setCONTENT(byte[] cONTENT) {
		CONTENT = cONTENT;
	}


	public String getTITLE() {
		return TITLE;
	}


	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}


	public int getUSR_ID() {
		return USR_ID;
	}


	public void setUSR_ID(int uSR_ID) {
		USR_ID = uSR_ID;
	}
	
	
	
	
}

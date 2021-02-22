package model;

import java.sql.Date;
import java.sql.Timestamp;

public class LogInfo {
	private int LOG_ID;
	private String CREATED_DT;
	private String LOGOUT_DT;
	private String TITLE;
	private int USR_ID;
	private String PATH;
	private String IP;
	
	public LogInfo(int lOG_ID, String cREATED_DT, String tITLE, int uSR_ID, String pATH) {
		super();
		LOG_ID = lOG_ID;
		CREATED_DT = cREATED_DT;
		TITLE = tITLE;
		USR_ID = uSR_ID;
		PATH = pATH;
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


	public String getCREATED_DT() {
		return CREATED_DT;
	}


	public void setCREATED_DT(String cREATED_DT) {
		CREATED_DT = cREATED_DT;
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


	public String getPATH() {
		return PATH;
	}


	public void setPATH(String pATH) {
		PATH = pATH;
	}


	public String getIP() {
		return IP;
	}


	public void setIP(String iP) {
		IP = iP;
	}


	public String getLOGOUT_DT() {
		return LOGOUT_DT;
	}


	public void setLOGOUT_DT(String lOGOUT_DT) {
		LOGOUT_DT = lOGOUT_DT;
	}
	
	
	
	
	
}

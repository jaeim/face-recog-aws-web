package model;

import java.sql.Timestamp;

public class ImageInfo {
	
	private int IMAGE_ID;
	private int USER_ID;
	private int WORK_ID;
	private String PATH;
	private String DATE;
	private String TITLE;
	
	public ImageInfo() {
		
	}
	
	public ImageInfo(int iMAGE_ID, int uSER_ID, String pATH, String dATE) {
		super();
		IMAGE_ID = iMAGE_ID;
		USER_ID = uSER_ID;
		PATH = pATH;
		DATE = dATE;
	}

	public int getIMAGE_ID() {
		return IMAGE_ID;
	}
	public void setIMAGE_ID(int iMAGE_ID) {
		IMAGE_ID = iMAGE_ID;
	}
	public int getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getPATH() {
		return PATH;
	}
	public void setPATH(String pATH) {
		PATH = pATH;
	}

	public int getWORK_ID() {
		return WORK_ID;
	}

	public void setWORK_ID(int wORK_ID) {
		WORK_ID = wORK_ID;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getDATE() {
		return DATE;
	}

	public void setDATE(String dATE) {
		DATE = dATE;
	}

//	public Timestamp getDATE() {
//		return DATE;
//	}
//
//	public void setDATE(Timestamp dATE) {
//		DATE = dATE;
//	}
	
	
}

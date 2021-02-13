package model;

public class ImageInfo {
	
	private int IMAGE_ID;
	private int USER_ID;
	private String PATH;
	Member user;
	
	
	public ImageInfo() {
		
	}
	
	public ImageInfo(int iMAGE_ID, int uSER_ID, String pATH) {
		super();
		IMAGE_ID = iMAGE_ID;
		USER_ID = uSER_ID;
		PATH = pATH;
	}
	
	public ImageInfo(int iMAGE_ID, int uSER_ID, String pATH, Member user) {
		super();
		IMAGE_ID = iMAGE_ID;
		USER_ID = uSER_ID;
		PATH = pATH;
		this.user = user;
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

	public Member getUser() {
		return user;
	}

	public void setUser(Member user) {
		this.user = user;
	}
	
	

}

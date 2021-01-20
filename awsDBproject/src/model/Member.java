package model;

import com.mysql.cj.jdbc.Blob;

public class Member {
	private int _id;
	private String login_id;
	private String password;
	private String member_name;
	private Blob image_blob;
	
	public Member( ) {
		// 기본 생성자
	}

	public Member(int _id, String login_id, String password, String name, Blob imageBlob) {
		super();
		this._id = _id;
		this.login_id = login_id;
		this.password = password;
		this.member_name = name;
		this.image_blob = imageBlob;
	}

	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String name) {
		this.member_name = name;
	}
	public Blob getImage_blob() {
		return image_blob;
	}
	public void setImage_blob(Blob imageBlob) {
		this.image_blob = imageBlob;
	}
}

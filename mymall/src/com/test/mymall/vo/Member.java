package com.test.mymall.vo;

public class Member {
	private int no;
	private String id;
	private String pw;
	private int level;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		System.out.println(no+"<--setNo() Member");
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		System.out.println(id+"<--setId() Member");
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		System.out.println(pw+"<--setPw() Member");
		this.pw = pw;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		System.out.println(level+"<--setLevel() Member");
		this.level = level;
	}
}

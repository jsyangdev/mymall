package com.test.mymall.vo;

public class MemberItem {
	private int member_no;
	private int item_no;
	private String order_date;
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		System.out.println(member_no+"<--setMember_no() MemberItem");
		this.member_no = member_no;
	}
	public int getItem_no() {
		return item_no;
	}
	public void setItem_no(int item_no) {
		System.out.println(item_no+"<--setItem_no() MemberItem");
		this.item_no = item_no;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		System.out.println(order_date+"<--setOrder_date() MemberItem");
		this.order_date = order_date;
	}
}

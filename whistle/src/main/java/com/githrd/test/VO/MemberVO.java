package com.githrd.test.VO;

public class MemberVO {
	private int mno, avt;
	private String name, id, mail, tel, joindate, gen;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getAvt() {
		return avt;
	}
	public void setAvt(int avt) {
		this.avt = avt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", avt=" + avt + ", name=" + name + ", id=" + id + ", mail=" + mail + ", tel="
				+ tel + ", joindate=" + joindate + ", gen=" + gen + "]";
	}
	
	
}

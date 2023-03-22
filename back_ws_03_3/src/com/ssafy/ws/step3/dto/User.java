package com.ssafy.ws.step3.dto;

public class User {
	private String id;
	private String pass;
	private String name;
	private String recId;
	
	public User() {
		super();
	}
	public User(String id, String pass, String name, String recId) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.recId = recId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + ", name=" + name + ", recId=" + recId + "]";
	}
}

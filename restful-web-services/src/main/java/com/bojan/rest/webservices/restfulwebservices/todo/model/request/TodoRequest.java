package com.bojan.rest.webservices.restfulwebservices.todo.model.request;

import java.util.Date;

public class TodoRequest {
	private Long id;
	private String username;
	private String description;
	private Date targetDate;
	private Boolean isDone;

	public TodoRequest() {
	}

	public TodoRequest(String username, String description, Date targetDate, Boolean isDone) {
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public TodoRequest(Long id, String username, String description, Date targetDate, Boolean isDone) {
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public Boolean getDone() {
		return isDone;
	}

	public void setDone(Boolean done) {
		isDone = done;
	}
}

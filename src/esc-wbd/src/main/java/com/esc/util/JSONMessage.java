package com.esc.util;

import com.google.gson.JsonElement;

public class JSONMessage {
	private int status;
	private String detail;
	private JsonElement content;

	public JSONMessage(int status, String detail, JsonElement content) {
		this.status = status;
		this.detail = detail;
		this.content = content;
	}
	
	public JSONMessage(int status) {
		this.status = status;
		if (status == 200) {
			this.detail = "OK";
		} else if (status == 201) {
			this.detail = "Created";
		} else if (status == 204) {
			this.detail = "No Content";
		} else if (status == 401) {
			this.detail = "Unauthorized";
		} else if (status == 404) {
			this.detail = "Not Found";
		} else if (status == 500) {
			this.detail = "Internal Server Error";
		}
		this.content = null;
	}
	
	public JSONMessage(int status, JsonElement content) {
		this(status);
		this.content = content;
	}
	
	public JSONMessage(int status, String detail) {
		this.status = status;
		this.detail = detail;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public JsonElement getContent() {
		return content;
	}

	public void setContent(JsonElement content) {
		this.content = content;
	}

}

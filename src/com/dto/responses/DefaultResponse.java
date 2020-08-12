package com.dto.responses;

import java.io.Serializable;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class DefaultResponse implements Serializable {

	/**
	 * DefaultResponse
	 */
	private static final long serialVersionUID = 1L;

	private String status;
	private int statusCode;
	private String statusText;

	public DefaultResponse() {
		this.setStatus("");
		this.setStatusCode(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
		this.setStatusText("InternalError");
	}

	public DefaultResponse( String status, int code, String text) {
		this.setStatus(status);
		this.setStatusCode(code);
		this.setStatusText(text);
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int status) {
		this.statusCode = status;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    public JSONObject toJSON() {
        JSONObject jo = new JSONObject();
        jo.put("status", this.getStatus());
        jo.put("code", this.getStatusCode());
        jo.put("text", this.getStatusText());
        return jo;
    }

}

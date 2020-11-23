package xyz.foobar;

import java.io.Serializable;

public class Activity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String operation = null;
	private String method = null;
	private String value = null;

	public Activity(String operation, String method, String value) {
		super();
		this.operation = operation;
		this.method = method;
		this.value = value;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

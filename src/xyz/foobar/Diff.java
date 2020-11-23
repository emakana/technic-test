package xyz.foobar;

import java.io.Serializable;
import java.util.List;

/**
 * The object representing a diff.
 * Implement this class as you see fit. 
 *
 */
public class Diff<T extends Serializable> {
	 List<Activity> list = null;

	public Diff(List<Activity> list) {
		super();
		this.list = list;
	}

	public List<Activity> getList() {
		return list;
	}

	public void setList(List<Activity> list) {
		this.list = list;
	}
	 
	
}

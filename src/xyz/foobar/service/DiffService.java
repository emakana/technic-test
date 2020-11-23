package xyz.foobar.service;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import xyz.foobar.Activity;
import xyz.foobar.Diff;
import xyz.foobar.DiffException;

public class DiffService implements DiffEngine {

	@Override
	public <T extends Serializable> T apply(T original, Diff<?> diff) throws DiffException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Calculate the difference We need to fetch the fields from the original
	 * object are not automatically fetched
	 */

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@Override
	public <T extends Serializable> Diff<T> calculate(T original, T modified) throws DiffException {
		// TODO Auto-generated method stub
		List<Activity> list = new ArrayList<Activity>();

		Field[] fields = original.getClass().getDeclaredFields();

		Object oldField = null;
		Object newField = null;

		for (Field field : fields) {
			field.setAccessible(true); // We need to access private fields
			try {
				oldField = field.get(original);
				newField = field.get(modified);
			} catch (IllegalArgumentException e) {
				throw new DiffException("Bad argument given" + e.getMessage());

			} catch (IllegalAccessException e) {
				throw new DiffException("Could not access the argument" + e.getMessage());

			}
              //a friend is a person object, apply recursion
			if (oldField.getClass().isAssignableFrom(original.getClass())) {
				 List<Activity> activeList = ((Diff<T>) calculate(oldField.getClass(), newField.getClass())).getList();
				 list.addAll(activeList);
			} else {
				if (oldField == null && newField != null) {
					Activity act = new Activity("Create", field.getName(), newField.toString());
					list.add(act);
				} else if (oldField != null && newField == null) {
					Activity act = new Activity("Delete", field.getName(), newField.toString());
					list.add(act);
				} else if (oldField != null && newField != null && !oldField.equals(newField)) {
					Activity act = new Activity("Update", field.getName(),
							"from " + oldField + " to " + newField.toString());
					list.add(act);
				}
			}

		}
		
		return new Diff(list);
	}
}

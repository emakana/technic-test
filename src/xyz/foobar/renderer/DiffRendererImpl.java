package xyz.foobar.renderer;

import xyz.foobar.Activity;
import xyz.foobar.Diff;
import xyz.foobar.DiffException;

public class DiffRendererImpl implements DiffRenderer {

	@Override
	public String render(Diff<?> diff) throws DiffException {
		StringBuilder builder = new StringBuilder();
		// TODO Auto-generated method stub
		for (Activity activity : diff.getList()) {
			builder.append(activity.getOperation()).append(": ").append(activity.getMethod()).append(" as ")
					.append(activity.getValue()).append("  ");
		}

		return builder.toString();
	}

}

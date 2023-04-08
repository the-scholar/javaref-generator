package scholar.generators.javaref.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores a {@link List} of {@link Element}s that can be modified by the caller.
 * This object simply prints each of its contained {@link Element}s. The
 * {@link List} of child {@link Element}s can be obtained with
 * {@link #getChildren()}.
 * 
 * @author The Scholar
 *
 */
public class CompoundElement implements Element {

	private final List<Element> children = new ArrayList<>();

	public List<Element> getChildren() {
		return children;
	}

	@Override
	public String print() {
		StringBuilder sb = new StringBuilder();
		children.forEach(sb::append);
		return sb.toString();
	}

}

package scholar.generators.javaref.api;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Generic {@link Paragraph} element. Can have any number of arbitrary classes
 * added to it. Duplicate classes are ignored.
 * 
 * @author The Scholar
 *
 */
public class Paragraph implements Element {

	private String content;

	public Paragraph(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private final Set<String> classes = new HashSet<>();

	public Set<String> getClasses() {
		return classes;
	}

	@Override
	public String print() {
		StringBuilder sb = new StringBuilder("<p");
		if (!classes.isEmpty()) {
			sb.append(" class=\"");

			Iterator<String> iterator = classes.iterator();
			sb.append(iterator.next());
			for (; iterator.hasNext();) {
				String s = iterator.next();
				sb.append(' ').append(s);
			}
			sb.append('"');
		}
		sb.append('>').append(content).append("</p>");
		return sb.toString();
	}

}

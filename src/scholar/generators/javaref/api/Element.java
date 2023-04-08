package scholar.generators.javaref.api;

import java.util.Iterator;

public interface Element {
	String print();

	static String print(Element... elements) {
		return print("", elements);
	}

	static String print(String delimiter, Element... elements) {
		if (elements == null || elements.length == 0)
			return "";
		StringBuilder sb = new StringBuilder(elements[0].print());
		for (var v : elements)
			sb.append(delimiter).append(v.print());
		return sb.toString();
	}

	static String print(Iterator<? extends Element> elements) {
		return print("", elements);
	}

	static String print(String delimiter, Iterator<? extends Element> elements) {
		if (elements == null || !elements.hasNext())
			return "";

		StringBuilder sb = new StringBuilder(elements.next().print());
		while (elements.hasNext())
			sb.append(delimiter).append(elements.next().print());
		return sb.toString();
	}

}

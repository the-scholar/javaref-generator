package scholar.generators.javaref.api;

import java.util.Iterator;

public interface Element {
	String print();

	static String print(Element... elements) {
		return print("", elements);
	}

	/**
	 * Prints all of the provided {@link Element}s, in order, with the specified
	 * delimiter between them. This method ignores any <code>null</code>
	 * {@link Element}s, for convenience.
	 * 
	 * @param delimiter The delimiter to print between each {@link Element}.
	 * @param elements  The array of {@link Element}s to print.
	 * @return The resulting {@link String}.
	 */
	static String print(String delimiter, Element... elements) {
		if (elements == null || elements.length == 0)
			return "";
		StringBuilder sb = new StringBuilder(elements[0] == null ? "" : elements[0].print());
		for (var v : elements)
			if (v != null)
				sb.append(delimiter).append(v.print());
		return sb.toString();
	}

	static String print(Iterator<? extends Element> elements) {
		return print("", elements);
	}

	/**
	 * Prints all of the provided {@link Element}s, in order, with the specified
	 * delimiter between them. This method ignores any <code>null</code>
	 * {@link Element}s, for convenience.
	 * 
	 * @param delimiter The delimiter to print between each {@link Element}.
	 * @param elements  The {@link Iterator} of {@link Element}s to print.
	 * @return The resulting {@link String}.
	 */
	static String print(String delimiter, Iterator<? extends Element> elements) {
		if (elements == null || !elements.hasNext())
			return "";

		Element e = elements.next();
		StringBuilder sb = new StringBuilder(e == null ? "" : e.print());
		while (elements.hasNext())
			if ((e = elements.next()) != null)
				sb.append(delimiter).append(e.print());
		return sb.toString();
	}

	static String print(String delimiter, Iterable<? extends Element> elements) {
		return print(delimiter, elements.iterator());
	}

	static String print(Iterable<? extends Element> elements) {
		return print("", elements);
	}

}

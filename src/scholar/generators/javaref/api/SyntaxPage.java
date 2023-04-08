package scholar.generators.javaref.api;

public class SyntaxPage {
	/**
	 * The location of the page in relation to the root of the website.
	 */
	private final String location;

	public String getLocation() {
		return location;
	}

	/**
	 * The page's title. This is the name of the syntax concept discussed by the
	 * page. This should be a simple string of text; no nodes or code.
	 */
	private final String title;
	/**
	 * An optional, short description of the concept that goes immediately after the
	 * title. This should be a string of text; it should (generally) not contain
	 * nodes, but can contain code. Wrapped in classed <code>&lt;p&gt;</code> tag.
	 */
	private final String conceptDescription;
	/**
	 * Content that comes after the {@link #conceptDescription}, but before the
	 * syntax section.
	 */
	private final String additionalDescription;
	/**
	 * The Syntax section of the page. Required.
	 */
	private final SyntaxSection syntaxSection;

	public SyntaxPage(String location, String title, String conceptDescription, String additionalDescription,
			SyntaxSection syntaxSection, String[] notes) {
		this.location = location;
		this.title = title;
		this.conceptDescription = conceptDescription;
		this.additionalDescription = additionalDescription;
		this.syntaxSection = syntaxSection;
		this.notes = notes;
	}

	public static final class SyntaxSection {
		/**
		 * Array of fragments that describe the syntax of the concept. The fragments
		 * need to be manually formatted. Wrapping pieces in unclassed &lt;span&gt;s is
		 * sufficient.
		 */
		private final String[] fragments;
		/**
		 * <p>
		 * Optional array of explanations, one per syntax piece used in the
		 * {@link #fragments}. This becomes the table of items that appear under
		 * "where:" after the syntax fragment table.
		 * </p>
		 * <p>
		 * This field is optional because the syntax {@link #fragments} may not actually
		 * contain any non-terminal syntax pieces. If they do, however, this field
		 * should contain an explanation for each piece.
		 * </p>
		 */
		private final String[] explanations;
		/**
		 * Optional, additional description that generally applies to all of the syntax
		 * fragments. This becomes the bulleted list of items that appear under "such
		 * that:" in the syntax section.
		 */
		private final String[] suchThat;

		/**
		 * Array of explanations of each syntax {@link #fragments}. This array should be
		 * the exact same size as {@link #fragments}.
		 */
		private final String[] syntaxElements;

		public SyntaxSection(String[] fragments, String[] explanations, String[] suchThat, String[] syntaxElements) {
			this.fragments = fragments;
			this.explanations = explanations;
			this.suchThat = suchThat;
			this.syntaxElements = syntaxElements;
		}

	}

	/**
	 * Optional array of notes that are included at the bottom of the page. These
	 * become a bulleted list that expand into the Notes section.
	 */
	private final String[] notes;

	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.append("<div id=\"Content\">\n");
		sb.append("\t<h1>").append(title).append("</h1>");
		if (conceptDescription != null)
			sb.append("<p class=\"description\">").append(conceptDescription).append("</p>\n");
		if (additionalDescription != null)
			sb.append(additionalDescription).append('\n');

		sb.append("<table class=\"syntax\">\n");
		for (var s : syntaxSection.fragments)
			sb.append("\t<tr>\n\t\t<td>1</td>\n\t\t<td>\n\t\t\t").append(s).append("\n</td>\n\t</tr>\n");
		sb.append("</table>\n");
		if (syntaxSection.explanations != null) {
			sb.append("<p>\n\t<i>where...</i>\n</p>\n");
			sb.append("<table class=\"syntax-breakdown\">\n");
			for (var s : syntaxSection.explanations)
				sb.append("\t<tr>\n\t\t").append(s).append("\n\t</tr>\n");
			sb.append("</table>\n");
		}
		if (syntaxSection.suchThat != null) {
			sb.append("<p>\n\t<i>such that...</i>\n</p>\n");
			sb.append("<ul>\n");
			for (var s : syntaxSection.suchThat)
				sb.append("\t<li>").append(s).append("</li>\n");
			sb.append("</ul>\n");
		}
		assert syntaxSection.syntaxElements.length == syntaxSection.fragments.length
				: "Syntax Elements array and Fragments array should be the same size.";

		sb.append("<h3>Syntax Elements</h3>\n");
		var syntaxElements = syntaxSection.syntaxElements;
		for (int i = 0; i < syntaxElements.length; i++)
			sb.append("<p>\n\t").append("<span class=\"syntax-number\">").append(i).append("</span> ")
					.append(syntaxElements[i]).append("\n</p>\n");
		if (notes != null) {
			sb.append("<h2>Notes</h2>\n<ol>\n");
			for (var s : notes)
				sb.append("\t<li>").append(s).append("</li>\n");
			sb.append("</ul>\n");
		}

		return sb.toString();
	}
}

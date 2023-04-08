package scholar.generators.javaref.api;

public class SyntaxPage {
	/**
	 * The location of the page in relation to the root of the website.
	 */
	private final String location;
	/**
	 * The page's title. This is the name of the syntax concept discussed by the
	 * page. This should be a simple string of text; no nodes or code.
	 */
	private final String title;
	/**
	 * An optional, short description of the concept that goes immediately after the
	 * title. This should be a string of text; it should (generally) not contain
	 * nodes, but can contain code.
	 */
	private final String conceptDescription;
	/**
	 * The Syntax section of the page. Required.
	 */
	private final SyntaxSection syntaxSection;

	public SyntaxPage(String location, String title, String conceptDescription, SyntaxSection syntaxSection,
			String additionalContent1, String[] notes, String additionalContent2) {
		this.location = location;
		this.title = title;
		this.conceptDescription = conceptDescription;
		this.syntaxSection = syntaxSection;
		this.additionalContent1 = additionalContent1;
		this.notes = notes;
		this.additionalContent2 = additionalContent2;
	}

	public static final class SyntaxSection {
		/**
		 * Array of fragments that describe the syntax of the concept.
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
		private final String suchThat;
		/**
		 * Optional string of additional content that appears in the syntax section, for
		 * flexibility.
		 */
		private final String additionalContent1;

		/**
		 * Array of explanations of each syntax {@link #fragments}. This array should be
		 * the exact same size as {@link #fragments}.
		 */
		private final String[] syntaxElements;
		/**
		 * Optional string of additional content that appears after the Syntax Elements
		 * section.
		 */
		private final String additionalContent2;

		public SyntaxSection(String[] fragments, String[] explanations, String suchThat, String additionalContent1,
				String[] syntaxElements, String additionalContent2) {
			this.fragments = fragments;
			this.explanations = explanations;
			this.suchThat = suchThat;
			this.additionalContent1 = additionalContent1;
			this.syntaxElements = syntaxElements;
			this.additionalContent2 = additionalContent2;
		}

	}

	/**
	 * Optional string of additional content that appears after the entire Syntax
	 * section.
	 */
	private final String additionalContent1;

	/**
	 * Optional array of notes that are included at the bottom of the page. These
	 * become a bulleted list that expand into the Notes section.
	 */
	private final String[] notes;

	/**
	 * Optional string of additional content that appears after the entire Notes
	 * section.
	 */
	private final String additionalContent2;
}

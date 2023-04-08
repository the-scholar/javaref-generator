package scholar.generators.javaref.api;

public class SyntaxPage extends Page {

	/**
	 * The title of the page. This is used both for the page
	 * <code>&lt;title&gt;</code> element, as well as for the top-level header
	 * (<code>&lt;h1&gt;</code>) that begins the article.
	 */
	private final String title;
	/**
	 * An OPTIONAL, short-and-sweet description of the topic. This goes immediately
	 * under the {@link #title} and usually renders italicized. It gives a very
	 * brief definition/description of what the concept that is the focus of the
	 * page, is.
	 */
	private String pageDescription;

	/**
	 * The contents that goes after the
	 */
	private SectionContent titleContent = new SectionContent();

	public SyntaxPage(String location) {
		super(location);
	}

}

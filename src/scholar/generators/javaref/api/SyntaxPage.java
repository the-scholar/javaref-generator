package scholar.generators.javaref.api;

public class SyntaxPage extends Page {

	private final SectionHeader topLevelSection;
	/**
	 * An OPTIONAL, short-and-sweet description of the topic. This goes immediately
	 * under the {@link #title} and usually renders italicized. It gives a very
	 * brief definition/description of what the concept that is the focus of the
	 * page, is.
	 */
	private Paragraph pageDescription;
	

	public SyntaxPage(String location, String title, String pageDescription) {
		super(location);
		topLevelSection = new SectionHeader(title, 1);
	}

	public String getTitle() {
		return topLevelSection.getTitle();
	}

	public void setTitle(String title) {
		topLevelSection.setTitle(title);
	}

	public String getPageDescription() {
		return pageDescription.getContent();
	}

	public void setPageDescription(String description) {
		pageDescription = description == null || description.isEmpty() ? null : new Paragraph(description);
	}

	@Override
	public String print() {
		return "<div id=\"Content\">" + Element.print(topLevelSection, pageDescription);
	}

}

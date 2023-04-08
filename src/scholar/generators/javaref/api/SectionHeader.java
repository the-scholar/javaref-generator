package scholar.generators.javaref.api;

public class SectionHeader implements Element {
	private String title;
	private int level;

	public SectionHeader(String title, int level) {
		this.title = title;
		this.level = level;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String print() {
		return "<h" + level + '>' + title + "</h" + level + ">";
	}

}

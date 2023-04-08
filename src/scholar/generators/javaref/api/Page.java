package scholar.generators.javaref.api;

public class Page {
	private String location;

	public Page(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Pages return their contents through {@link #toString()}.
	 */
	@Override
	public String toString() {
		return "";
	}
}

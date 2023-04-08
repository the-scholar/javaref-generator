package scholar.generators.javaref.api;

public abstract class Page implements Element {
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

}

package scholar.generators.javaref.api;

public class SectionContents implements Element {
	private final CompoundElement contents = new CompoundElement();

	@Override
	public String print() {
		return contents.print();
	}

}

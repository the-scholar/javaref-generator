package scholar.generators.javaref.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the content of a section. This class can store any generic content
 * that can go after any section header, such as paragraphs, raw text, and other
 * various tags. When created, it can be configured to be allowed to contain
 * headers that are a certain level or lower.
 * 
 * @author The Scholar
 *
 */
public class SectionContent {
	private final List<Object> contents = new ArrayList<>(5);
}

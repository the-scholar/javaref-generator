package scholar.generators.javaref;

import java.io.File;

import scholar.generators.javaref.api.Page;

public class JavarefGenerator {

	private File outputDir;

	public JavarefGenerator(File outputDir) {
		this.outputDir = outputDir;
	}

	public File getOutputDir() {
		return outputDir;
	}

	public void setOutputDir(File outputDir) {
		this.outputDir = outputDir;
	}
	
	public void generate(Page page) {
		
	}

}

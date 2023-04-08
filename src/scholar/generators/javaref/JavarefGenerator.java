package scholar.generators.javaref;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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

	public void generate(Page page) throws IOException {
		File f = new File(outputDir, page.getLocation());
		f.getParentFile().mkdirs();
		try (PrintWriter pw = new PrintWriter(f)) {
			pw.println(page);
		}
	}

}

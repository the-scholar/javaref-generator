package scholar.generators.javaref;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import scholar.generators.javaref.api.SyntaxPage;
import scholar.generators.javaref.api.SyntaxPage.SyntaxSection;
import scholar.generators.javaref.api.Tools;

public class Main {

	public static String[] promptLines(Scanner s) {
		String ln;
		List<String> strs = new ArrayList<>();
		while (!(ln = prompt(s)).isBlank())
			strs.add(ln);
		return strs.isEmpty() ? null : strs.toArray(new String[strs.size()]);
	}

	public static String prompt(Scanner s) {
		return Tools.codeEscape(s.nextLine());
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print(
				"1. Enter a location relative to the root of the website.\n\tExamples: literals/int/\n@location=");
		String location = prompt(s);
		System.out.print("2. Enter a title: ");
		String title = prompt(s);
		System.out.print("3. Enter a page description; may contain code:\nDescription: ");
		String description = prompt(s);

		System.out.println("4. Enter each syntax fragment, one per line. Enter a blank line to finish:");
		String[] fragments = promptLines(s);
		System.out.println("(You entered " + fragments.length + " items.)");
		System.out.println("5. Enter a set of syntax-piece explanations. Enter a blank line to finish:\n\t[Optional]");
		String[] explanations = promptLines(s);

		System.out.println("6. Enter any \"such that\" bullets you want listed. Blank line to finish:\n\t[Optional]");
		String[] suchThat = promptLines(s);
		System.out.println(
				"7. Enter a syntax element description for each syntax fragment you listed earlier. Blank line to finish:");
		String[] syntaxElements = promptLines(s);

		System.out.println("There are: " + fragments.length + " fragments and " + syntaxElements.length
				+ " descriptions of fragments.");
		if (fragments.length == syntaxElements.length)
			System.out.println("You're good to go!");
		else {
			System.out.println("This is not allowed; these should be equal in length.");
			return;
		}
		System.out.println("8. Enter any notes. These show up as a numbered list. Blank line to finish:");
		String[] notes = promptLines(s);

		SyntaxPage sp = new SyntaxPage(location, title, description,
				new SyntaxSection(fragments, explanations, suchThat, syntaxElements), notes);
		System.out.println("Resulting page:\n\n\n" + sp.print());

	}

}

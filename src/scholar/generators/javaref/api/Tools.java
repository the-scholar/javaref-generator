package scholar.generators.javaref.api;

public class Tools {
	public static String codeEscape(String input) {
		int prev = -1;
		boolean inCode = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '`') {
				if (inCode ^= true) {
					// We're now in an inline code piece.
					sb.append(input.substring(prev + 1, i)).append("<code>");
				} else {
					// We just exited an inline code piece.
					sb.append(input.substring(prev + 1, i)).append("</code>");
				}

				prev = i;
			}
		}
		return sb.append(input.substring(prev + 1)).toString();
	}
}

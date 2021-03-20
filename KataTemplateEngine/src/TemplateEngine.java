import java.util.regex.*;

public class TemplateEngine {

	public String evaluate(String pattern, MapExpressionValues map) {
		String result = pattern;
		Pattern regex = Pattern.compile("\\{\\$([a-z]+)\\}");
		
		Matcher matcher = regex.matcher(pattern);
		
		while (matcher.find()) {
			String nameOfValue = matcher.group(1);
			
			matcher.appendReplacement(sb, replacement)
			
			result.rep
			
			result = matcher.replaceFirst(map.getExpressionValue(nameOfValue));
		}
		
		return result;
	}

}

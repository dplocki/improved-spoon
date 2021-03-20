import java.util.Dictionary;
import java.util.Hashtable;

public class ExpressionMapper implements MapExpressionValues {

	private Dictionary<String, String> dictionary;

	public ExpressionMapper() {
		this.dictionary = new Hashtable<String, String>();
	}
	
	@Override
	public String getExpressionValue(String expression) {
		String value = this.dictionary.get(expression);
		
		if (value != null) {
			return value;
		}
		
		throw new UnknownExpression(expression);
	}

	public void map(String expression, String value) {
		if (value == null) {
			throw new NullInExpressionValue(expression);
		}
		
		String previousValue = this.dictionary.get(expression);
		
		if (previousValue != null) {
			throw new DuplicationInExpressionsValue(expression);
		}

		this.dictionary.put(expression, value);
	}

}

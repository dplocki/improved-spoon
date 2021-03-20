import static org.junit.Assert.*;
import org.junit.Test;


public class ExpressionMapperTests {

	@Test(expected=UnknownExpression.class)
	public void should_throw_exception_for_nonexisting_mapping() {
		ExpressionMapper expresionMapper = BuildExpressionMapper();
		
		assertNull(expresionMapper.getExpressionValue("test"));
	}

	@Test(expected=NullInExpressionValue.class)
	public void should_throw_exception_on_null_value() {
		ExpressionMapper expresionMapper = BuildExpressionMapper();
		
		expresionMapper.map("test", null);
		
		assertNull(expresionMapper.getExpressionValue("test"));
	}

	@Test
	public void should_return_correctly_assign_expression_value() {
		final String value = "lore ipsum";
		final String expression = "test";
		
		ExpressionMapper expressionMapper = BuildExpressionMapper();
		
		expressionMapper.map(expression, value);
		
		assertEquals(value, expressionMapper.getExpressionValue(expression));
	}
	
	@Test
	public void should_return_correctly_assign_few_expression_value() {
		final String value1 = "lore ipsum";
		final String expression1 = "test";
		
		final String value2 = "quia dolor";
		final String expression2 = "abs";

		ExpressionMapper expressionMapper = BuildExpressionMapper();

		expressionMapper.map(expression1, value1);
		expressionMapper.map(expression2, value2);
		
		assertEquals(value1, expressionMapper.getExpressionValue(expression1));
		assertEquals(value2, expressionMapper.getExpressionValue(expression2));
	}

	@Test(expected=DuplicationInExpressionsValue.class)
	public void should_throw_exception_on_duplicated_expressions() {
		final String expression = "test";
		final String value1 = "lore ipsum";
		final String value2 = "quia dolor";

		ExpressionMapper expressionMapper = BuildExpressionMapper();
		
		expressionMapper.map(expression, value1);
		expressionMapper.map(expression, value2);
	}

	private ExpressionMapper BuildExpressionMapper() {
		return new ExpressionMapper();
	}
	
}

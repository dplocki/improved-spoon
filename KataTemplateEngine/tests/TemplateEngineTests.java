import static org.junit.Assert.*;

import org.junit.Test;

public class TemplateEngineTests {

	@Test
	public void should_return_string_without_expressions() {
		final String pattern = "lore ipsum";

		TemplateEngine engine = new TemplateEngine();

		String result = engine.evaluate(pattern, null);

		assertEquals(pattern, result);
	}
	
	@Test
	public void should_return_string_with_single_replaced_expression() {

		ExpressionMapper mapper = new ExpressionMapper();

		mapper.map("test", "lore");

		TemplateEngine engine = new TemplateEngine();

		String result = engine.evaluate("|{$test}|", mapper);

		assertEquals("|lore|", result);
	}
	
	@Test
	public void should_return_string_with_few_replaced_expressions() {

		ExpressionMapper mapper = new ExpressionMapper();

		mapper.map("abcd", "lorem");
		mapper.map("efg", "ipsum");
		mapper.map("hijkl", "quia");

		TemplateEngine engine = new TemplateEngine();

		String result = engine.evaluate("do{$abcd} {$efg} {$hijkl}", mapper);

		assertEquals("dolorem ipsum quia", result);
	}
}

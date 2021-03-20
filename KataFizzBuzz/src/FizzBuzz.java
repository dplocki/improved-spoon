
public class FizzBuzz {

	public Object getFizzBuzz(int number) {
		String result = "";
		
		if (number % 3 == 0) {
			result += "Fizz";
		}
		
		if (number % 5 == 0) {
			result += "Buzz";
		}
		
		if (result == "") {
			return Integer.toString(number);
		}
		
		return result;
	}

}

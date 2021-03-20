
public class NumberNames {

	private static final int numericSystemBase = 10;

	public String spellOut(int i) {
		if (i < 20) {
			return spellOutLessThan20(i);
		} else if (i < 100) {
			return spellOutLessThan100(i);
		} else if (i < 1000) {
			return spellOutForMultiplayerWithAnd(i, 100, "hundred");
		} else if (i < 1000000){
			return spellOutForMultiplayerWithoutAnd(i, 1000, "thousand");
		} else {
			return spellOutForMultiplayerWithoutAnd(i, 1000000, "million");
		}
	}

	private String spellOutLessThan20(int number) {
		switch(number) {
			case 0: return "zero";
			case 1: return "one";
			case 2: return "two";
			case 3: return "three";
			case 4: return "four";
			case 5: return "five";
			case 6: return "six";
			case 7: return "seven";
			case 8: return "eight";
			case 9: return "nine";
			case 10: return "ten";
			case 11: return "eleven";
			case 12: return "twelve";
			case 13: return "thirteen";
			case 18: return "eighteen";
		}

		return spellOutLessThan20(number - 10) + "teen";
	}
	
	private String spellOutLessThan100(int number) {
		int decimal = number / numericSystemBase;
		int unit = number % numericSystemBase;
		
		String result = "";
		
		switch(decimal){
			case 2: result = "twenty";
				break;

			case 3: result = "thirty";
				break;

			case 4: result = "forty";
				break;

			case 5: result = "fifty";
				break;

			case 6: result = "sixty";
				break;

			case 7: result = "seventy";
				break;

			case 8: result = "eighty";
				break;

			case 9: result = "ninety";
				break;
		}
		
		if (unit > 0) {
			return result + "-" + spellOutLessThan20(unit);
		} else {
			return result;
		}
	}

	private String spellOutForMultiplayerWithAnd(int number, int multiplayer, String multiplayerName) {
		return spellOutForMultiplayer(number, multiplayer, multiplayerName, " and ");
	}
	
	private String spellOutForMultiplayerWithoutAnd(int number, int multiplayer, String multiplayerName) {
		return spellOutForMultiplayer(number, multiplayer, multiplayerName, " ");
	}
	
	private String spellOutForMultiplayer(int number, int multiplayer, String multiplayerName, String spliter) {
		String result = spellOut(number/multiplayer) + " " + multiplayerName; 
		
		if (number % multiplayer != 0) {
			result += spliter + spellOut(number % multiplayer);
		}
		
		return result;
	}
}

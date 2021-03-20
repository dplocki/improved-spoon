
public interface Strategy {
	int firstQuestion();
	
	void willYouReplaceYourGateWith(int gate);
	
	int secondQuestion();
	
	void finalResult(boolean youWin);
}

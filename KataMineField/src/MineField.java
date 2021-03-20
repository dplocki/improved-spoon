
public class MineField {

	private static final char MineSign = '*';
	private char[][] calculationTable;
	private int calculationTableHeight;
	private int calculationTableWidth;
	
	public Object calculate(int height, int width, String map) {
		if (height == 0 || width == 0) {
			return "";
		}
		
		PrepearCalculationTable(height, width, map);
		FillCalculateTable();
		return CalculationTableToResult();
	}

	private void FillCalculateTable() {
		for (int y = 0; y < calculationTableHeight; y++) {
			for (int x = 0; x < calculationTableWidth; x++) {
				if (!isMine(calculationTable[x][y])) {
					continue;
				}

				AddMineNeighbor(x-1, y-1);
				AddMineNeighbor(x, y-1);
				AddMineNeighbor(x+1, y-1);

				AddMineNeighbor(x-1, y);
				AddMineNeighbor(x, y);
				AddMineNeighbor(x+1, y);

				AddMineNeighbor(x-1, y+1);
				AddMineNeighbor(x, y+1);
				AddMineNeighbor(x+1, y+1);
			}
		}
	}

	private void AddMineNeighbor(int x, int y) {
		if (x >= 0 && x < calculationTableWidth
			&& y >= 0 && y < calculationTableHeight
			&& !isMine(calculationTable[x][y])) {
			calculationTable[x][y]++;
		}
	}

	private String CalculationTableToResult() {
		StringBuilder result = new StringBuilder();
		
		for (int y = 0; y < calculationTableHeight; y++) {
			for (int x = 0; x < calculationTableWidth; x++) {
				result.append(calculationTable[x][y]);
			}
			
			result.append('\n');
		}
		
		result.deleteCharAt(result.length()-1);
		
		return result.toString();
	}

	private boolean isMine(char c) {
		return c == MineSign;
	}

	private void PrepearCalculationTable(int height, int width, String map) {
		calculationTableHeight = height;
		calculationTableWidth = width;
		calculationTable = new char[calculationTableWidth][calculationTableHeight];

		for (int y = 0; y < calculationTableHeight; y++) {
			for (int x = 0; x < calculationTableWidth; x++) {
				char c = map.charAt(x + (calculationTableWidth+1)*y);
				
				if (isMine(c)) {
					calculationTable[x][y] = MineSign;
				} else {
					calculationTable[x][y] = '0';
				}
			}
		}
	}

}

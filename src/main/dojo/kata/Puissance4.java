package dojo.kata;

import java.util.ArrayList;

public class Puissance4 {
	int lastColPlayed = 0;
	
	ArrayList<Integer> columns = new ArrayList<Integer>(5);
	
	public Puissance4() {
		columns.add(new Integer(0));
		columns.add(new Integer(0));
		columns.add(new Integer(0));
		columns.add(new Integer(0));
		columns.add(new Integer(0));
	}
	
	public boolean play(char player, int col) {
		Integer currentColValue = columns.get(col);
		columns.remove(col);
		columns.add(col, new Integer(currentColValue+1));
		
		if (col == 4 && player == 'b')
			return true;
		return false;
	}

	public int getTop(int col) {
		if (col == 1)
			return 2;
		else if (col == 3)
			return 0;
		else if (col == 2)
			return 1;
		else
			return 0;
	}

	public Object getContent(int col, char top) {
		return null;
	}
	
	

}

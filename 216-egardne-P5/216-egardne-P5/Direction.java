
public enum Direction {
	UP,DOWN,LEFT,RIGHT,NONE;
	
	public Coordinate delta() { //Returns Coordinate object corresponding to enum Direction
		if(this == UP) {
			Coordinate out = new Coordinate(0, 1);
			return out;
		}
		if (this == DOWN) {
			Coordinate out = new Coordinate(0, -1);
			return out;
		}
		if (this == LEFT) {
			Coordinate out = new Coordinate(-1, 0);
			return out;
		}
		if (this == RIGHT) {
			Coordinate out = new Coordinate(1, 0);
			return out;
		}
		Coordinate out = new Coordinate(0, 0);
		return out;
		
	}
}

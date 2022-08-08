import java.util.*;

public class Drone {
	private Coordinate pos;
	private Grid grid;
	private List<Signalable<Drone>> listeners = new ArrayList<Signalable<Drone>>();;
	private int x;
	private int y;
	private int count = 0;

	public Drone(Coordinate start, Grid grid) { //creates Drone object taking Coordinate start and Grid grid, setting pos to start, grid to grid, and y and x to 0
		this.pos = start;
		this.grid = grid;
		x = 0;
		y = 0;
	}
	
	public Drone(int x, int y, Grid grid) { //creates drone object taking x and y ints and Grid grid, setting pos to Coordinate with x and y, grid as grid
		this.pos = new Coordinate(x, y);
		this.grid = grid;
	}
	
	public void addTokenListener(Signalable<Drone> listener) { //Add Signalable<Drone> object listener to list listeners
		listeners.add(listener);
	}
	
	public void removeTokenListener(Signalable<Drone> listener) { //Removes Signalable<Drone> listener from list listeners
		listeners.remove(listener);
	}
	
	public Coordinate getPosition() { //getter for pos
		return pos;
	}
	
	public void move(Direction d) { //Changes pos using Coordinate method plus(Direction d), gets boolean value at matching grid space, throws GridCoordsOutOfBoundsException
		try {
			pos = pos.plus(d);
			if(grid.hasToken(pos)) {
				System.out.println("Token Found" + this.getPosition());
				for(Signalable<Drone> l : listeners)
					l.signal(this);
			}
		}
		catch(Exception e) {
			if(d == Direction.UP) pos = pos.plus(Direction.DOWN);
			if(d == Direction.DOWN) pos = pos.plus(Direction.UP);
			if(d == Direction.RIGHT) pos = pos.plus(Direction.LEFT);
			if(d == Direction.LEFT) pos = pos.plus(Direction.RIGHT);
			throw new GridCoordsOutOfBoundsException();
		}
	}
	
	public void search() { //Recursive function, moves the drone over every space in grid starting at bottom left and moving in a clockwise spiral pattern until reaching the center
		this.move(Direction.NONE);
		if(count >= (grid.sizeX() * grid.sizeY()) ) {}
		else if(pos.getX() != x || pos.getY() != y) {
			if(pos.getX() > x)
				this.move(Direction.LEFT);
			if(pos.getX() < x)
				this.move(Direction.RIGHT);
			if(pos.getY() > y)
				this.move(Direction.DOWN);
			if(pos.getY() < y)
				this.move(Direction.UP);
			this.search();
		}
		else {
			for(int i = y; i < grid.sizeY() - y - 1; i++) {
				this.move(Direction.UP);
				count++;
			}
			for(int a = x; a < grid.sizeX() - x - 1; a++) {
				this.move(Direction.RIGHT);
				count++;
			}
			for(int i = y; i < grid.sizeY() - y - 1; i++) {
				this.move(Direction.DOWN);
				count++;
				
			}
			for(int a = x; a < grid.sizeX() - x - 2; a++) {
				this.move(Direction.LEFT);
				count++;
			}
			if(((x >= (grid.sizeX() / 2)) == false) || ((y >= (grid.sizeY() / 2)) == false)) {
				if((x >= (grid.sizeX() / 2)) == false)
						x++;
				if((y >= (grid.sizeY() / 2)) == false)
					y++;
				this.search();
			}
		}
		
	}

}

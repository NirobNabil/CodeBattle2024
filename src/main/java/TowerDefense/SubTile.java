package TowerDefense;

import javax.swing.border.TitledBorder;
import java.util.ArrayList;

public class SubTile {
	public final static int SUBTILE_SIZE = 10;
	private Tile tile;
	private int subX;
	private int subY;
	private ArrayList<SubTile> neighbors;

	public SubTile(Tile tile, int subX, int subY) {
		this.tile = tile;
		this.subX = subX;
		this.subY = subY;
	}

	public Tile getTile() {
		return tile;
	}

	public double getX() {
		return tile.getX() + (double) subX / SUBTILE_SIZE;
	}

	public double getY() {
		return tile.getY() + (double) subY / SUBTILE_SIZE;
	}

//	public SubTile mirror(Tile[][] grid, int width, int height) {
//		Tile t = new Tile(width - 2 - tile.getX(), height - 2 - tile.getY(), true);
//		SubTile result = new SubTile(t, SUBTILE_SIZE - subX, SUBTILE_SIZE - subY);
//		return result;
//	}
	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };
	public ArrayList<SubTile> getNeighbors(Tile [][] grid) {
		ArrayList<SubTile> neighbors = new ArrayList<>();
		for (int dir = 0; dir < 4; dir++) {
			int x_ = this.subX + dx[dir];
			int tx_ = tile.getX() + dx[dir];
			int y_ = this.subY + dy[dir];
			int ty_ = tile.getY() + dx[dir];
			if (x_ < 0) {
				if (tx_ >= 0 && tx_ < grid.length && ty_ >= 0 && ty_ < grid[0].length) {
					neighbors.add(new SubTile(new Tile(tx_,ty_,true), SUBTILE_SIZE + x_, y_));
				}
			}
			else if (y_ < 0) {
				if (tx_ >= 0 && tx_ < grid.length && ty_ >= 0 && ty_ < grid[0].length) {
					neighbors.add(new SubTile(new Tile(tx_,ty_,true), x_, SUBTILE_SIZE + y_));
				}
			}
			else if(x_ > SUBTILE_SIZE){
				if (tx_ >= 0 && tx_ < grid.length && ty_ >= 0 && ty_ < grid[0].length) {
					neighbors.add(new SubTile(new Tile(tx_,ty_,true), SUBTILE_SIZE - x_, y_));
				}
			}
			else if(y_ > SUBTILE_SIZE) {
				if (tx_ >= 0 && tx_ < grid.length && ty_ >= 0 && ty_ < grid[0].length) {
					neighbors.add(new SubTile(new Tile(tx_,ty_,true), x_, SUBTILE_SIZE - y_));
				}
			}
			if (tx_ >= 0 && tx_ < grid.length && ty_ >= 0 && ty_ < grid[0].length) {
				neighbors.add(new SubTile(this.getTile(), x_, y_));
			}
		}
		return neighbors;
	}

	@Override
	public String toString() {
		return String.format("%.1f %.1f", getX(), getY());
	}
}

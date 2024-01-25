package TowerDefense;

import java.util.ArrayList;
import java.util.List;

import com.codingame.game.Player;

import view.AttackerView;

public class Attacker {
	//private List<SubTile> remainingPath;
	private Tile[][] grid;
	private Tile currentTile;
	private SubTile currentSubtile;
	private int id;
	private int maxHealth;
	private int hitPoints;
	private int maxSpeed;
	private int slowCountdown;
	private int bounty;
	private Player owner;
	private Player enemy;
	private AttackerView view;
	private static int idCounter;
	private ArrayList<SubTile> steps;

	private boolean reachOpponentBase;

	public Attacker(Tile[][] grid, int hp, int speed, int bounty, Player owner, Player enemy) {
		id = idCounter++;
		//this.remainingPath = path;
		if(owner.getIndex() == 1) {
			this.currentTile = new Tile(Constants.MAP_WIDTH-1, 0, true);
		}
		else {
			this.currentTile = new Tile(0, Constants.MAP_HEIGHT-1 , true);
		}
		this.currentSubtile = new SubTile(this.currentTile,0 , 0);
		this.grid = grid;
		this.owner = owner;
		this.enemy = enemy;
		this.maxSpeed = speed;
		this.hitPoints = hp;
		this.bounty = bounty;
		this.maxHealth = hitPoints;
		this.reachOpponentBase = false;
	}

	public int getId() {
		return id;
	}

	public int getSpeed() {
		if (slowCountdown == 0)
			return maxSpeed;
		return maxSpeed / Constants.GLUE_SLOWDOWN;
	}

	public boolean isSlow() {
		return slowCountdown > 0;
	}

	public int getBounty() {
		return bounty;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getSlowCountdown() {
		return slowCountdown;
	}

//	public int getPathLength() {
//		return remainingPath.size();
//	}

	public SubTile getLocation() {
		return currentSubtile;
	}

	public Tile getCurrentTile() {
		return currentTile;
	}

	public SubTile getCurrentSubTile() {
		return currentSubtile;
	}

	public void kill() {
		dealDamage(hitPoints);
	}

	public boolean canRespawn() {
		return reachOpponentBase;
	}

	public boolean canHeal() {
		return hitPoints < maxHealth;
	}

	public void heal(int health) {
		hitPoints = Math.min(hitPoints + health, maxHealth);
	}

	public void dealDamage(int damage) {
		this.hitPoints = Math.max(0, hitPoints - damage);
		if (isDead())
			view.kill();
	}

	public void slowDown(int countdown) {
		this.slowCountdown = countdown;
	}

	public boolean isDead() {
		return hitPoints <= 0;
	}

//	public boolean hasSucceeded() {
//		return remainingPath.size() == 1;
//	}

	public void setView(AttackerView view) {
		this.view = view;
	}
// ekhane destination er distance ta rakhbo ?
	public ArrayList<SubTile> getSteps() {
		return steps;
	}



	public void move() {
		int speed = getSpeed();
		steps = new ArrayList<>();
		while (steps.size() < speed && remainingPath.size() > 1) {
			steps.add(remainingPath.get(remainingPath.size() - 1));
			remainingPath.remove(remainingPath.size() - 1);
		}
		view.move();
		if (slowCountdown > 0)
			slowCountdown--;
	}

	public Player getOwner() {
		return owner;
	}

	public Player getEnemy() {
		return enemy;
	}

	public String getPlayerInput() {
		StringBuilder sb = new StringBuilder();
		sb.append(id).append(" ");
		sb.append(owner.getIndex()).append(" ");
		//sb.append(getLocation().toString()).append(" ");
		sb.append(hitPoints).append(" ");
		sb.append(maxHealth).append(" ");
		sb.append(getSpeed()).append(" ");
		sb.append(maxSpeed).append(" ");
		sb.append(slowCountdown).append(" ");
		sb.append(bounty);

		return sb.toString();
	}
}

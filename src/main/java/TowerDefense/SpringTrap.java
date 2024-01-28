package TowerDefense;

import com.codingame.gameengine.module.entities.GraphicEntityModule;
import com.codingame.gameengine.module.entities.Group;
import com.codingame.gameengine.module.tooltip.TooltipModule;
import view.GunTowerView;
import view.TowerView;

import java.util.List;

public class SpringTrap extends Tower {
	Board board;
	public SpringTrap(Tile tile, Board board) {
		super("SPRINGTRAP", tile);
		properties[TowerProperty.DAMAGE.ordinal()] = Constants.GUNTOWER_DAMAGE;
		properties[TowerProperty.RANGE.ordinal()] = Constants.SPRINGTRAP_RANGE;
		properties[TowerProperty.RELOAD.ordinal()] = Constants.SPRINGTRAP_RELOAD;
		cost = Constants.GUNTOWER_COST;
		this.board = board;
	}

	@Override
	boolean doAttack(List<Attacker> attackers) {
		Attacker target = null;
		for (Attacker a : attackers) {
			if (getOwner() == a.getOwner() || !inRange(a))
				continue;
			if (target == null)  // lagte pare
				target = a;
			if( a == lastAttacked ) {
				target = a;
				break;
			}
		}
		if (target == null)
			return false;

		this.lastAttacked = target;
		System.out.println(board.getGrid()[this.tile.getX()][this.tile.getY()]);
		double x = this.tile.getX();
		double y = this.tile.getY();
		target.disappear();
		target.kill();

		Tile t = board.getGrid()[target.getCurrentTile().getX()][target.getCurrentTile().getY()+2];
		target.respawnAt(t);
//		SubTile stt = t.getSubTile((int)target.getCurrentSubTile().subX, (int)target.getCurrentSubTile().subY);
//		target.relocate( stt );
		Tile tt = target.getCurrentTile();
		SubTile st = target.getCurrentSubTile();
//		getView().attack(target);
		return true;
	}

	@Override
	public TowerView createView(Group boardGroup, GraphicEntityModule graphics, TooltipModule tooltipModule) {
		return new GunTowerView(this, boardGroup, graphics, tooltipModule);
	}
}

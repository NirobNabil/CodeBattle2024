package view;

import java.util.HashMap;

import com.codingame.game.Referee;
import com.codingame.gameengine.module.entities.GraphicEntityModule;
import com.codingame.gameengine.module.entities.Sprite;
import com.codingame.gameengine.module.entities.SpriteAnimation;

public class Utils {
	private static HashMap<String, String[]> spriteSheets = new HashMap<>();

	public static String[] loadSheet(GraphicEntityModule graphics, String image, int width, int height, int imageCount, int rowCount) {
		if (spriteSheets.containsKey(image))
			return spriteSheets.get(image);

		String name = String.valueOf((char) ('a' + spriteSheets.size()));
		String[] sprites = graphics.createSpriteSheetSplitter().setSourceImage(image).setName(name).setWidth(width).setHeight(height).setImageCount(imageCount).setImagesPerRow(rowCount).setOrigCol(0).setOrigRow(0).split();

		spriteSheets.put(image, sprites);
		return sprites;
	}

	public static Sprite createBoardSprite(GraphicEntityModule graphics, String image, int x, int y) {
		return graphics.createSprite().setImage(image).setX(BoardView.CELL_SIZE * x).setY(BoardView.CELL_SIZE * y);
	}

	public static SpriteAnimation createAnimation(GraphicEntityModule graphics, String[] images) {
		return graphics.createSpriteAnimation().setImages(images).setDuration(Referee.FRAME_DURATION).setLoop(true).play();
	}

	public static Sprite createAttackerSprite(GraphicEntityModule graphics, String image, double x, double y) {
		return graphics.createSprite().setImage(image).setX((int) (BoardView.CELL_SIZE * x)).setY((int) (BoardView.CELL_SIZE * y));
	}

	public static Sprite createTowerSprite(GraphicEntityModule graphics, String image, int x, int y) {
		return graphics.createSprite().setImage(image).setX(BoardView.CELL_SIZE * x).setY(BoardView.CELL_SIZE * y);
	}
}

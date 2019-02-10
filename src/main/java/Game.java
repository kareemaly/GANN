import org.newdawn.slick.*;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

import java.util.ArrayList;

public class Game extends BasicGame {
    ArrayList<Wall> walls = new ArrayList<>();
    ArrayList<Creature> creatures = new ArrayList<>();
    private Info info;
    Game() {
        super("GANN");
    }

    public void init(GameContainer gameContainer) throws SlickException {
        int thickness = 10;
        int screenWidth = GameConfig.SCREEN_WIDTH;
        int screenHeight = GameConfig.SCREEN_HEIGHT;

        walls.add(new Wall(new Point(0, 0), screenWidth, thickness));
        walls.add(new Wall(new Point(0, 0), thickness, screenHeight));
        walls.add(new Wall(new Point(0, screenHeight - thickness), screenWidth, thickness));
        walls.add(new Wall(new Point(screenWidth - thickness, 0), thickness, screenHeight));

        walls.add(new Wall(new Point(700, 300), 400, thickness));
        walls.add(new Wall(new Point(0, 300), 400, thickness));
        walls.add(new Wall(new Point(500, 0), thickness, 200));

        creatures.add(new Creature(new Point(50, 50)));

        info = new Info();
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        walls.forEach(wall -> wall.render(graphics));
        creatures.forEach(creature -> creature.render(graphics));
        info.render(graphics);
    }
}

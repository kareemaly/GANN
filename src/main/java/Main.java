import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            AppGameContainer container = new AppGameContainer(game);
            container.setDisplayMode(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT, false);
            container.setTargetFrameRate(60);
            container.start();
        } catch(SlickException e) {
            e.printStackTrace();
        }
    }
}

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Info extends GameObject {
    @Override
    public void render(Graphics graphics) {
        float width = 200;
        float height = 200;
        float margin = 20;

        float x = GameConfig.SCREEN_WIDTH - width;
        float y = GameConfig.SCREEN_HEIGHT - height;

        graphics.setColor(Color.white);
        graphics.draw(new Rectangle(x, y, width, height));
        graphics.drawString("Testing Info = 10", x + margin, y + margin);
    }
}

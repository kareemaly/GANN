import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Wall extends GameObject {
    private Point location;
    private float width;
    private float height;

    public Wall(Point location, float width, float height) {
        this.location = location;
        this.width = width;
        this.height = height;
    }

    public Shape getCanvas() {
        return new Rectangle(location.getX(), location.getY(), width, height);
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.gray);
        graphics.fill(this.getCanvas());
    }
}

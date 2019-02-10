import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

import java.util.ArrayList;

public class Creature extends GameObject {
    private Point location;
    private ArrayList<EyeSensor> eyeSensors = new ArrayList<>();
    private float width = 10;
    private float height = width;

    Creature(Point location) {
        this.location = location;
        this.eyeSensors.add(new EyeSensor(this));
    }

    public Point getMiddleLocation() {
        return new Point(
                location.getX() + width/2,
                location.getY() + height/2
        );
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fill(new Rectangle(this.location.getX(), location.getY(), width, height));

        this.eyeSensors.forEach(eyeSensor -> eyeSensor.render(graphics));
    }
}

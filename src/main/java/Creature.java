import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;

public class Creature extends GameObject {
    private Point location;
    private ArrayList<EyeSensor> eyeSensors = new ArrayList<>();
    private float width = 10;
    private float height = width;
    private double angle = Math.toRadians(45);

    Creature(Point location) {
        this.location = location;
        this.eyeSensors.add(new EyeSensor(this, 0));
        this.eyeSensors.add(new EyeSensor(this, 25));
        this.eyeSensors.add(new EyeSensor(this, 45));
        this.eyeSensors.add(new EyeSensor(this, -25));
        this.eyeSensors.add(new EyeSensor(this, -45));
    }

    public double getAngle() {
        return angle;
    }

    public Point getMiddleLocation() {
        return new Point(
                location.getX() + width/2,
                location.getY() + height/2
        );
    }

    public void update(ArrayList<Wall> walls) {
        float distance = 1;

        float x1 = location.getX();
        float y1 = location.getY();

        float x = (float)(distance * Math.sin(angle));
        float y = (float)(distance * Math.cos(angle));

        float x2 = x1 + x;
        float y2 = y1 + y;

        location.setX(x2);
        location.setY(y2);

        this.eyeSensors.forEach(eyeSensor -> eyeSensor.update(walls));
    }

    public Shape getCanvas() {
        return new Rectangle(this.location.getX(), location.getY(), width, height);
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fill(this.getCanvas());

        this.eyeSensors.forEach(eyeSensor -> eyeSensor.render(graphics));
    }
}

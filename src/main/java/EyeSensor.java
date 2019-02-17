import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;

public class EyeSensor extends GameObject {
    private Creature creature;
    private float distance = 70;
    private float deviationAngle = 0;
    private boolean isDanger = false;

    public EyeSensor(Creature creature, float deviationAngle) {
        this.creature = creature;
        this.deviationAngle = deviationAngle;
    }

    public void update(ArrayList<Wall> walls) {
        isDanger = walls.stream().anyMatch(wall -> wall.collides(this));
    }

    @Override
    public Shape getCanvas() {
        double angle = this.creature.getAngle() + Math.toRadians(deviationAngle);
        float x1 = this.creature.getMiddleLocation().getX();
        float y1 = this.creature.getMiddleLocation().getY();

        float x = (float)(distance * Math.sin(angle));
        float y = (float)(distance * Math.cos(angle));

        float x2 = x1 + x;
        float y2 = y1 + y;

        return new Line(x1, y1, x2, y2);
    }

    @Override
    public void render(Graphics graphics) {
        if (isDanger) {
            graphics.setColor(Color.red);
        } else {
            graphics.setColor(Color.gray);
        }
        graphics.draw(this.getCanvas());
    }
}

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Line;

public class EyeSensor extends GameObject {
    private Creature creature;
    private float distance = 70;

    public EyeSensor(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void render(Graphics graphics) {
        float x1 = this.creature.getMiddleLocation().getX();
        float y1 = this.creature.getMiddleLocation().getY();

        float x2 = x1 + distance;
        float y2 = y1;

        graphics.setColor(Color.gray);
        graphics.draw(new Line(x1, y1, x2, y2));
    }
}

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class GameObject {
    public abstract void render(Graphics graphics);
    public Shape getCanvas() {
        throw new NotImplementedException();
    }
    public boolean collides(GameObject gameObject) {
       return this.getCanvas().intersects(gameObject.getCanvas());
    }
}

package homework5.shape;

import homework5.enums.Direction;
import homework5.enums.Type;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.List;

public abstract class BaseShape implements Shape {
    protected final GraphicsContext gc;
    private final int SIZE = 50;
    private double x;
    private double y;
    private double speedX;
    private double speedY;
    private boolean inFocus;
    private Type type;

    public BaseShape(GraphicsContext gc, List<Shape> shapes, boolean inFocus) {
        this.gc = gc;
        speedX = 10;
        speedY = 10;
        x = 5;
        y = 5;
        this.inFocus = inFocus;

    }

    @Override
    public void move(Direction direction) {
        if (direction == Direction.UP){
            y -= speedY;
        }
        if (direction == Direction.DOWN){
            y += speedY;
        }
        if (direction == Direction.RIGHT){
            x += speedX;
        }
        if (direction == Direction.LEFT){
            x -= speedX;
        }
    }

    @Override
    public void draw() {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(6);

    }

    @Override
    public void setInFocus(boolean inFocus) {
        this.inFocus = inFocus;
    }

    @Override
    public boolean getInFocus() {
        return inFocus;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSIZE() {
        return SIZE;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

package homework5.shape;

import homework5.enums.Direction;
import homework5.enums.Type;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.List;

public abstract class BaseShape implements Shape {
    GraphicsContext gc;
    private double size;
    private double maxSize;
    private double minSize;
    private double x;
    private double y;
    private double speedX;
    private double speedY;
    private boolean inFocus;
    public BaseShape(GraphicsContext gc, List<Shape> shapes) {
        this.gc = gc;
        size = 50;
        maxSize = 150;
        minSize = 50;
        speedX = 10;
        speedY = 10;
        x = 5;
        y = 5;
        inFocus = true;
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
    public void increase() {
        if (size < maxSize){
            size += speedX;
        }
    }

    @Override
    public void decrease() {
        if (size > minSize){
            size -= speedX;
        }
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

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}

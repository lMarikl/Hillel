package homework5.shape;

import javafx.scene.canvas.GraphicsContext;

public abstract class Shape {
    public final GraphicsContext GC;
    public double size = 50;
    public double x = 5;
    public double y = 5;
    public double speedX = 10;
    public double speedY = 10;

    public Shape(GraphicsContext GC) {
        this.GC = GC;
    }

    public abstract void draw();

    public void move() {
        x =+ speedX;
    }

}

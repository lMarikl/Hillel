package homework5;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle {
    private final GraphicsContext GC;
    private double width;
    private double height;
    private double x;
    private double y;
    private double speedX;
    private double speedY;

    public Rectangle(GraphicsContext gc) {
        this.GC = gc;
        width = 50;
        height = 50;
        x = 80;
        y = 5;
        speedX = 2;
        speedY = 2;
    }

    public void draw(){
        GC.setFill(Color.GREEN);
        GC.setStroke(Color.BLACK);
        GC.setLineWidth(3);
        GC.fillRect(x, y, width, height);
        GC.strokeRect(x, y, width, height);

    }
}

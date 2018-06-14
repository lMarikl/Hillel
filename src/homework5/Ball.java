package homework5;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {
    private final GraphicsContext GC;
    private double diameter;
    private double x;
    private double y;
    private double speedX;
    private double speedY;

    public Ball(GraphicsContext gc) {
        this.GC = gc;
        diameter = 50;
        x = 5;
        y = 5;
        speedX = 2;
        speedY = 2;
    }

    public void draw(){
        GC.setFill(Color.BLUEVIOLET);
        GC.setStroke(Color.BLACK);
        GC.setLineWidth(3);
        GC.fillOval(x, y, diameter, diameter);
        GC.strokeOval(x, y, diameter, diameter);
    }
}

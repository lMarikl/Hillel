package homework5;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle {
    private final GraphicsContext GC;
    private double width;
    private double x;
    private double y;
    private double speedX;
    private double speedY;

    public Triangle(GraphicsContext gc) {
        this.GC = gc;
        width = 50;
        x = 5;
        y = 5;
        speedX = 2;
        speedY = 2;
    }

    public void draw(){

        GC.setFill(Color.RED);
        GC.setStroke(Color.BLACK);
        GC.setLineWidth(3);
        GC.fillPolygon(new double[] { x, x + width / 2, x + width }, new double[] { y + width, y, y + width }, 3);
        GC.strokePolygon(new double[] { x, x + width / 2, x + width }, new double[] { y + width, y, y + width }, 3);

    }
}

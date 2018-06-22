package homework5.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {

    public Triangle(GraphicsContext GC) {
        super(GC);
        draw();
    }


    public void draw(){

        GC.setFill(Color.RED);
        GC.setStroke(Color.BLACK);
        GC.setLineWidth(3);
        GC.fillPolygon(new double[] { x, x + size / 2, x + size }, new double[] { y + size, y, y + size }, 3);
        GC.strokePolygon(new double[] { x, x + size / 2, x + size }, new double[] { y + size, y, y + size }, 3);
    }
}

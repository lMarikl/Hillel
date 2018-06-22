package homework5.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {


    public Rectangle(GraphicsContext GC) {
        super(GC);
        draw();
    }

    public void draw(){
        GC.setFill(Color.GREEN);
        GC.setStroke(Color.BLACK);
        GC.setLineWidth(3);
        GC.fillRect(x, y, size, size);
        GC.strokeRect(x, y, size, size);
    }
}

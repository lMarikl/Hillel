package homework5.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends Shape {

    public Ball(GraphicsContext GC) {
        super(GC);
        draw();
    }

    public void draw(){
        GC.setFill(Color.BLUEVIOLET);
        GC.setStroke(Color.BLACK);
        GC.setLineWidth(3);
        GC.fillOval(this.x, y, size, size);
        GC.strokeOval(x, y, size, size);
    }
}

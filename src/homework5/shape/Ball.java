package homework5.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Ball extends BaseShape {

    public Ball(GraphicsContext GC, List<Shape> shapes) {
        super(GC, shapes);
    }

    public void draw(){
        super.draw();
        if (getInFocus()){
            gc.setFill(Color.YELLOW);
            gc.fillOval(getX(), getY(), getSize(), getSize());
        }
        gc.strokeOval(getX(), getY(), getSize(), getSize());
    }
}

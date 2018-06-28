package homework5.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Rectangle extends BaseShape {


    public Rectangle(GraphicsContext GC, List<Shape> shapes, boolean inFocus) {
        super(GC, shapes, inFocus);
    }

    public void draw(){
        super.draw();
        if (getInFocus()){
            gc.setFill(Color.GREEN);
            gc.fillRect(getX(), getY(), getSIZE(), getSIZE());
        }
        gc.strokeRect(getX(), getY(), getSIZE(), getSIZE());
    }
}

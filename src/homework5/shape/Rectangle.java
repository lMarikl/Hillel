package homework5.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Rectangle extends BaseShape {


    public Rectangle(GraphicsContext GC, List<Shape> shapes) {
        super(GC, shapes);
    }

    public void draw(){
        super.draw();
        if (getInFocus()){
            gc.setFill(Color.GREEN);
            gc.fillRect(getX(), getY(), getSize(), getSize());
        }
        gc.strokeRect(getX(), getY(), getSize(), getSize());
    }
}

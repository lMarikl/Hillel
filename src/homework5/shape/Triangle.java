package homework5.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Triangle extends BaseShape {

    public Triangle(GraphicsContext GC, List<Shape> shapes) {
        super(GC, shapes);
    }


    public void draw(){
        super.draw();
        if (getInFocus()){
            gc.setFill(Color.RED);
            gc.fillPolygon(new double[] { getX(), getX() + getSize() / 2, getX() + getSize() },
                    new double[] { getY() + getSize(), getY(), getY() + getSize() }, 3);
        }
        gc.strokePolygon(new double[] { getX(), getX() + getSize() / 2, getX() + getSize() },
                new double[] { getY() + getSize(), getY(), getY() + getSize() }, 3);
    }
}

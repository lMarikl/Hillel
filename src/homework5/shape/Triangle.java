package homework5.shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class Triangle extends BaseShape {

    public Triangle(GraphicsContext GC, List<Shape> shapes, boolean inFocus) {
        super(GC, shapes, inFocus);
    }


    public void draw(){
        super.draw();
        if (getInFocus()){
            gc.setFill(Color.RED);
            gc.fillPolygon(new double[] { getX(), getX() + getSIZE() / 2, getX() + getSIZE() },
                    new double[] { getY() + getSIZE(), getY(), getY() + getSIZE() }, 3);
        }
        gc.strokePolygon(new double[] { getX(), getX() + getSIZE() / 2, getX() + getSIZE() },
                new double[] { getY() + getSIZE(), getY(), getY() + getSIZE() }, 3);
    }
}

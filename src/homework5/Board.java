package homework5;

import homework5.shape.Ball;
import homework5.shape.Rectangle;
import homework5.shape.Shape;
import homework5.shape.Triangle;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Board {
    public GraphicsContext GC;
    private ArrayList<Shape> shapes = new ArrayList<>();


    public Board(GraphicsContext gc) {
        this.GC = gc;

    }

    public void add(Shape shape){
        shapes.add(shape);

    }

    public void drawAllShape(){
        for (int i = 0; i < shapes.size() ; i++) {
            shapes.get(i).draw();
        }

    }

    public void remove(){
        if (shapes.size() != 0){
            shapes.remove(shapes.size() - 1);
            this.GC.clearRect(0, 0, 800, 700);
            drawAllShape();
            System.out.println(shapes.size());

        }

    }

    public void move(){
        for (Shape shape : shapes){
            shape.move();

        }
    }

}

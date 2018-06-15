package homework5;

import javafx.scene.canvas.GraphicsContext;

public class Board {
    private final GraphicsContext GC;
    private Ball ball;
    private Rectangle rectangle;
    private Triangle triangle;

    public Board(GraphicsContext gc) {
        this.GC = gc;
        ball = new Ball(gc);
        rectangle = new Rectangle(gc);
        triangle = new Triangle(gc);
    }

    public void draw(){
        triangle.draw();
    }
}

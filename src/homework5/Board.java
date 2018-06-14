package homework5;

import javafx.scene.canvas.GraphicsContext;

public class Board {
    private final GraphicsContext GC;
    private Ball ball;

    public Board(GraphicsContext gc) {
        this.GC = gc;
        ball = new Ball(gc);
    }

    public void draw(){
        ball.draw();
    }
}

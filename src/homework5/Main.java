package homework5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 700;
    private static final int FPS = 60;
    private boolean closed;
    private Board board;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MyPaint");
        Canvas canvas = new Canvas();
        board = new Board(canvas.getGraphicsContext2D());
        canvas.setWidth(WIDTH);
        canvas.setHeight(HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        drawFrame();
    }

    @Override
    public void stop() {
        closed = true;
    }

    private void drawFrame() {
        board.draw();
    }
}

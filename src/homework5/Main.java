package homework5;


import homework5.shape.Ball;
import homework5.shape.Rectangle;
import homework5.shape.Triangle;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 700;
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
        registerOnKeyPressListener(scene);
        //drawFrame();
    }

//    private void drawFrame() {
//        board.draw();
//    }

    public void registerOnKeyPressListener(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:

                        break;
                    case RIGHT:
                        board.move();
                        System.out.println("move right");
                        break;
                    case DOWN:

                        break;
                    case LEFT:

                        break;
                    case DIGIT1:
                        board.add(new Ball(board.GC));
                        break;
                    case DIGIT2:
                        board.add(new Triangle(board.GC));
                        break;
                    case DIGIT3:
                        board.add(new Rectangle(board.GC));
                        break;
                    case PAGE_DOWN:

                        break;
                    case PAGE_UP:

                        break;
                    case Q:

                        break;
                    case W:

                        break;
                    case DELETE:
                        board.remove();
                        break;
                    case S:

                        break;
                    case L:

                        break;
                }
            }
        });
    }

}

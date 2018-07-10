package homework5;


import homework5.enums.Direction;
import homework5.enums.Type;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
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
        registerOnMousePressListener(scene);
    }

    private void clean() {
        board.GC.clearRect(0, 0, WIDTH, HEIGHT);
    }

    private void registerOnKeyPressListener(Scene scene) {
        scene.setOnKeyPressed(event -> {
            clean();
            switch (event.getCode()) {
                case UP:
                    board.move(Direction.UP);
                    break;
                case RIGHT:
                    board.move(Direction.RIGHT);
                    break;
                case DOWN:
                    board.move(Direction.DOWN);
                    break;
                case LEFT:
                    board.move(Direction.LEFT);
                    break;
                case DIGIT1:
                    board.add(Type.BALL);
                    break;
                case DIGIT2:
                    board.add(Type.TRIANGLE);
                    break;
                case DIGIT3:
                    board.add(Type.RECTANGLE);
                    break;
                case PAGE_DOWN:
                    board.prevShape();
                    break;
                case PAGE_UP:
                    board.nextShape();
                    break;
                case Q:
                    board.increase();
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
            board.draw();
        });
    }

    private void registerOnMousePressListener(Scene scene) {
        scene.setOnMousePressed(event -> {
            if (event.isControlDown()) {
                double mouseX = event.getSceneX();
                double mouseY = event.getSceneY();
                board.toGroup(mouseX, mouseY);
            }
            if (event.isShiftDown()) {
                double mouseX = event.getSceneX();
                double mouseY = event.getSceneY();
                board.cloneShape(mouseX, mouseY);
            }
        });
    }
}

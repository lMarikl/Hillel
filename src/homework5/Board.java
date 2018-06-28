package homework5;

import homework5.enums.Direction;
import homework5.enums.Type;
import homework5.shape.Ball;
import homework5.shape.Rectangle;
import homework5.shape.Shape;
import homework5.shape.Triangle;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Board {
    GraphicsContext GC;
    private List<Shape> shapes = new ArrayList<>();
    private List<Shape> activeShapeList = new ArrayList<>();


    public Board(GraphicsContext gc) {
        this.GC = gc;

    }

    public void add(Type shapeType) {
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).setInFocus(false);
        }

        if (shapeType == Type.BALL) {
            shapes.add(shapes.size(), new Ball(GC, shapes, true));
        }
        if (shapeType == Type.TRIANGLE) {
            shapes.add(shapes.size(), new Triangle(GC, shapes, true));
        }
        if (shapeType == Type.RECTANGLE) {
            shapes.add(shapes.size(), new Rectangle(GC, shapes, true));
        }
    }

    public void draw() {
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).draw();
        }

    }

    public void remove() {
        if (shapes.size() != 1) {
            shapes.remove(shapes.size() - 1);
            this.GC.clearRect(0, 0, 800, 700);
            draw();
            shapes.get(shapes.size() - 1).setInFocus(true);
            System.out.println(shapes.size());

        }

    }

    public void move(Direction direction) {
        for (Shape shape : shapes) {
            if (shape.getInFocus()) {
                shape.move(direction);
            }
        }
    }

    public void prevShape() {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).getInFocus()) {
                shapes.get(i).setInFocus(false);
                if (i == 0) {
                    shapes.get(shapes.size() - 1).setInFocus(true);
                } else {
                    shapes.get(i - 1).setInFocus(true);
                }
                break;
            }
        }
    }

    public void nextShape() {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).getInFocus()) {
                shapes.get(i).setInFocus(false);
                if (i == shapes.size() - 1) {
                    shapes.get(0).setInFocus(true);
                } else {
                    shapes.get(i + 1).setInFocus(true);
                }
                break;
            }
        }
    }

    public void toGroup() {

    }

    public void cloneShape(double mouseX, double mouseY) {

        for (int i = 0; i < shapes.size(); i++) {
            if ((mouseX >= shapes.get(i).getX() && mouseX <= shapes.get(i).getX() + shapes.get(i).getSIZE()) &&
                    (mouseY >= shapes.get(i).getY() && mouseY <= shapes.get(i).getY() + shapes.get(i).getSIZE())) {
                activeShapeList.add(shapes.get(i));
                shapes.get(i).setInFocus(true);
                draw();
            }

        }

        for (int i = 0; i < activeShapeList.size(); i++) {
            Shape shape;
            if (activeShapeList.get(i) instanceof Ball) {
                shape = new Ball(GC, shapes, false);
                shape.setX(activeShapeList.get(i).getX());
                shape.setY(activeShapeList.get(i).getY());
                shapes.add(shapes.size(), shape);
            }
            if (activeShapeList.get(i) instanceof Triangle) {
                shape = new Triangle(GC, shapes, false);
                shape.setX(activeShapeList.get(i).getX());
                shape.setY(activeShapeList.get(i).getY());
                shapes.add(shapes.size(), shape);
            }
            if (activeShapeList.get(i) instanceof Rectangle) {
                shape = new Rectangle(GC, shapes, false);
                shape.setX(activeShapeList.get(i).getX());
                shape.setY(activeShapeList.get(i).getY());
                shapes.add(shapes.size(), shape);
            }

        }

    }

}

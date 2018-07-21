package homework5;

import homework5.enums.Direction;
import homework5.enums.Type;
import homework5.shape.*;
import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.List;

public class Board {
    GraphicsContext GC;
    private Shape shapeInFocus;
    private Shape shapeToAdd;
    private List<Shape> shapes = new ArrayList<>();
    private List<Shape> inFocusShapes = new ArrayList<>();

    Board(GraphicsContext gc) {
        this.GC = gc;
    }

    public void add(Type shapeType) {
        for (Shape shape : shapes) {
            shape.setInFocus(false);
        }
        if (shapeType == Type.BALL) {
            shapes.add(shapes.size(), new Ball(GC, shapes));
        }
        if (shapeType == Type.TRIANGLE) {
            shapes.add(shapes.size(), new Triangle(GC, shapes));
        }
        if (shapeType == Type.RECTANGLE) {
            shapes.add(shapes.size(), new Rectangle(GC, shapes));
        }
        if (shapeType == Type.GROUP){
            shapes.add(shapes.size(), new Group(shapeInFocus, shapeToAdd));
        }
    }

    void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    void remove() {
        if (shapes.size() != 1) {
            shapes.remove(shapes.size() - 1);
            this.GC.clearRect(0, 0, 800, 700);
            draw();
            shapes.get(shapes.size() - 1).setInFocus(true);
            System.out.println(shapes.size());
        }
    }

    void move(Direction direction) {
        for (Shape shape : shapes) {
            if (shape.getInFocus()) {
                shape.move(direction);
            }
        }
    }

    void increase(){
        for (Shape shape : shapes) {
            if (shape.getInFocus()){
                shape.increase();
            }
        }
    }

    void decrease(){
        for (Shape shape : shapes) {
            if (shape.getInFocus()){
                shape.decrease();
            }
        }
    }

    void prevShape() {
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

    void nextShape() {
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i).getInFocus()) {
                shapes.get(i).setInFocus(false);
                if (i == shapes.size() - 1) {
                    shapes.get(0).setInFocus(true);
                }else {
                    shapes.get(i + 1).setInFocus(true);
                }
                break;
            }
        }
    }

    void toGroup(double mouseX, double mouseY) {
        for (Shape shape : shapes) {

            if (shape.getInFocus()) {
                shapeInFocus = shape;
            }

            if ((mouseX >= shape.getX() && mouseX <= shape.getX() + shape.getSize()) &&
                    (mouseY >= shape.getY() && mouseY <= shape.getY() + shape.getSize())) {
                shapeToAdd = shape;
                shapeToAdd.setInFocus(true);
            }
        }
        shapes.remove(shapeInFocus);
        shapes.remove(shapeToAdd);
        add(Type.GROUP);
        draw();
    }

    void cloneShape(double mouseX, double mouseY) {
        for (Shape shape : shapes) {
            if ((mouseX >= shape.getX() && mouseX <= shape.getX() + shape.getSize()) &&
                    (mouseY >= shape.getY() && mouseY <= shape.getY() + shape.getSize())) {
                inFocusShapes.add(shape);
                shape.setInFocus(true);
                draw();
            }
        }

        for (Shape inFocusShape : inFocusShapes) {
            Shape shape;
            if (inFocusShape instanceof Ball) {
                shape = new Ball(GC, shapes);
                shape.setInFocus(false);
                shape.setSize(inFocusShape.getSize());
                shape.setX(inFocusShape.getX());
                shape.setY(inFocusShape.getY());
                shapes.add(shapes.size(), shape);
            }
            if (inFocusShape instanceof Triangle) {
                shape = new Triangle(GC, shapes);
                shape.setInFocus(false);
                shape.setSize(inFocusShape.getSize());
                shape.setX(inFocusShape.getX());
                shape.setY(inFocusShape.getY());
                shapes.add(shapes.size(), shape);
            }
            if (inFocusShape instanceof Rectangle) {
                shape = new Rectangle(GC, shapes);
                shape.setInFocus(false);
                shape.setSize(inFocusShape.getSize());
                shape.setX(inFocusShape.getX());
                shape.setY(inFocusShape.getY());
                shapes.add(shapes.size(), shape);
            }
        }
    }
}

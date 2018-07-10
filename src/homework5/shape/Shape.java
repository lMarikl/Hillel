package homework5.shape;

import homework5.enums.Direction;
import homework5.enums.Type;

public interface Shape {
    void draw();
    void move(Direction direction);
    void setInFocus(boolean inFocus);
    boolean getInFocus();
    double getX();
    double getY();
    double getSize();
    void setSize(double size);
    void increase();
    void decrease();
    void setX(double x);
    void setY(double y);
}

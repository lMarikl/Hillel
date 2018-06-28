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
    double getSIZE();
    Type getType();
    void setType(Type type);
    void setX(double x);
    void setY(double y);
}

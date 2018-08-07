package homework5.shape;

import homework5.enums.Direction;
import java.util.ArrayList;
import java.util.List;

public class Group implements Shape {
    private List<Shape> groupList = new ArrayList<>();
    private boolean active;

    public Group(Shape shape1, Shape shape2){
        add(shape1);
        add(shape2);
        active = true;
    }

    public void add(Shape shape) {
        if (shape instanceof Group) {
            Group group = (Group) shape;
            groupList.addAll(group.getGroupList());
        } else {
            groupList.add(shape);
        }
    }

    @Override
    public void draw() {
        for (Shape shape : groupList) {
            shape.draw();
        }
    }

    @Override
    public void move(Direction direction) {
        for (Shape shape : groupList) {
            shape.move(direction);
            shape.draw();
        }
    }

    @Override
    public void setInFocus(boolean inFocus) {
        if (inFocus){
            this.active =  true;
            for (Shape shape : groupList) {
                shape.setInFocus(true);
            }
        }else {
            this.active = false;
            for (Shape shape : groupList) {
                shape.setInFocus(false);
            }
        }
    }

    @Override
    public boolean getInFocus() {
        for (Shape shape : groupList) {
            shape.getInFocus();
        }
        return this.active;
    }

    @Override
    public void increase() {
        for (Shape shape : groupList) {
            shape.increase();
        }
    }

    @Override
    public void decrease() {
        for (Shape shape : groupList) {
            shape.decrease();
        }
    }

    @Override
    public void setX(double x) {

    }

    @Override
    public void setY(double y) {

    }

    private List<Shape> getGroupList() {
        return groupList;
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public double getSize() {
        return 0;
    }

    @Override
    public void setSize(double size) {
    }
}
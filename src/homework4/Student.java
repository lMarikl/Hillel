package homework4;

import homework4.enums.Group;
import homework4.enums.Name;
import homework4.enums.Surname;
import java.util.Random;

public class Student extends User implements Comparable<User> {
    private Group group;
    private static Random random = new Random();

    Student(Surname surname, Name name, int age, Group group) {
        super(surname, name ,age);
        this.group = group;
    }

    static Group getRandomGroup() {
        if (random.nextInt(6) == 0) {
            return Group.Java;
        }
        if (random.nextInt(6) == 1) {
            return Group.CPlusPlus;
        }
        if (random.nextInt(6) == 2) {
            return Group.Python;
        }
        if (random.nextInt(6) == 3) {
            return Group.QA;
        }
        if (random.nextInt(6) == 4) {
            return Group.Design;
        } else {
            return Group.Frontend;
        }
    }

    @Override
    public String toString() {
        return "Student{" + getSurname() + " " + getName() + " " + getAge() + " " + group + '}';
    }

    @Override
    public int compareTo(User o) {
        Student student = (Student) o;
        int result = Integer.compare(group.value, student.group.value);
        if (result == 0){
            result = Integer.compare(getSurname().value, student.getSurname().value);
            if (result == 0){
                result = Integer.compare(getName().value, student.getName().value);
                if (result == 0){
                    result = Integer.compare(getAge(), student.getAge());
                }
            }
        }
        return result;
    }
}

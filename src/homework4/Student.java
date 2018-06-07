package homework4;

import homework4.Enums.Groups;
import homework4.Enums.Names;
import homework4.Enums.Surnames;
import java.util.Random;

public class Student extends User implements Comparable<User> {
    private Groups group;
    private static Random random = new Random();

    Student(Surnames surname, Names name, int age, Groups group) {
        super(surname, name ,age);
        this.group = group;
    }

    static Groups getRandomGroup() {
        if (random.nextInt(6) == 0) {
            return Groups.Java;
        }
        if (random.nextInt(6) == 1) {
            return Groups.CPlusPlus;
        }
        if (random.nextInt(6) == 2) {
            return Groups.Python;
        }
        if (random.nextInt(6) == 3) {
            return Groups.QA;
        }
        if (random.nextInt(6) == 4) {
            return Groups.Design;
        } else {
            return Groups.Frontend;
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

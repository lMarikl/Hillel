package homework4;

import homework4.enums.Group;
import homework4.enums.Name;
import homework4.enums.Surname;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100 ; i++) {
            Surname surname = User.getRandomSurname();
            Name name = User.getRandomName();
            Group group = Student.getRandomGroup();
            users.add(new User(surname, name, random.nextInt(32) + 18));
            students.add(new Student(surname, name, random.nextInt(18) + 18, group));
        }
        Collections.sort(users);
        System.out.println(users);
        Collections.sort(students);
        System.out.println(students);
    }
}

package homework4;

import homework4.enums.Name;
import homework4.enums.Surname;
import java.util.Random;

public class User implements Comparable<User> {
    private Name name;
    private Surname surname;
    private int age;
    private static Random random = new Random();

    User(Surname surname, Name name, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    static Surname getRandomSurname() {
        if (random.nextInt(6) == 0) {
            return Surname.Пердыщенко;
        }
        if (random.nextInt(6) == 1) {
            return Surname.Прыбыток;
        }
        if (random.nextInt(6) == 2) {
            return Surname.Матюшкин;
        }
        if (random.nextInt(6) == 3) {
            return Surname.Шмырев;
        }
        if (random.nextInt(6) == 4) {
            return Surname.Шмелёв;
        } else {
            return Surname.Базин;
        }
    }

    static Name getRandomName() {
        if (random.nextInt(6) == 0) {
            return Name.Николай;
        }
        if (random.nextInt(6) == 1) {
            return Name.Сергей;
        }
        if (random.nextInt(6) == 2) {
            return Name.Иван;
        }
        if (random.nextInt(6) == 3) {
            return Name.Вадим;
        }
        if (random.nextInt(6) == 4) {
            return Name.Андрей;
        } else {
            return Name.Дмитрий;
        }
    }

    Name getName() {
        return name;
    }

    Surname getSurname() {
        return surname;
    }

    int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" + surname + " " + name + " " + age + '}';
    }

    @Override
    public int compareTo(User o) {
        int result = Integer.compare(surname.value, o.surname.value);
        if (result == 0) {
            result = Integer.compare(name.value, o.name.value);
            if (result == 0) {
                result = Integer.compare(age, o.age);
            }
        }
        return result;
    }
}

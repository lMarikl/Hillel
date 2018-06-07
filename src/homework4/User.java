package homework4;

import homework4.Enums.Names;
import homework4.Enums.Surnames;
import java.util.Random;

public class User implements Comparable<User> {
    private Names name;
    private Surnames surname;
    private int age;
    private static Random random = new Random();

    User(Surnames surname,Names name, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    static Surnames getRandomSurname() {
        if (random.nextInt(6) == 0) {
            return Surnames.Пердыщенко;
        }
        if (random.nextInt(6) == 1) {
            return Surnames.Прыбыток;
        }
        if (random.nextInt(6) == 2) {
            return Surnames.Матюшкин;
        }
        if (random.nextInt(6) == 3) {
            return Surnames.Шмырев;
        }
        if (random.nextInt(6) == 4) {
            return Surnames.Шмелёв;
        } else {
            return Surnames.Базин;
        }
    }

    static Names getRandomName() {
        if (random.nextInt(6) == 0) {
            return Names.Николай;
        }
        if (random.nextInt(6) == 1) {
            return Names.Сергей;
        }
        if (random.nextInt(6) == 2) {
            return Names.Иван;
        }
        if (random.nextInt(6) == 3) {
            return Names.Вадим;
        }
        if (random.nextInt(6) == 4) {
            return Names.Андрей;
        } else {
            return Names.Дмитрий;
        }
    }

    Names getName() {
        return name;
    }

    Surnames getSurname() {
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

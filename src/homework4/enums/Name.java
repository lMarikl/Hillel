package homework4.enums;

public enum Name {
    Николай(0),
    Сергей(1),
    Иван(2),
    Вадим(3),
    Андрей(4),
    Дмитрий(5);

    public int value;

    Name(int value) {
        this.value = value;
    }
}

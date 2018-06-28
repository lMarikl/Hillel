package homework4.enums;

public enum Group {
    Java(0),
    CPlusPlus(1),
    Python(2),
    QA(3),
    Design(4),
    Frontend(5);
    public int value;

    Group(int value) {
        this.value = value;
    }
}

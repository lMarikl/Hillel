package homework4.Enums;

public enum Groups {
    Java(0),
    CPlusPlus(1),
    Python(2),
    QA(3),
    Design(4),
    Frontend(5);
    public int value;

    Groups(int value) {
        this.value = value;
    }
}

package task1;

public class MyCollection<T extends Number, R > {

    private T value;

    private R value2;

    public T getValue() {
        //value. - и будут методы класса Number, т.к. Т наследуется от него
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public R getValue2() {
        return value2;
    }

    public void setValue2(R value2) {
        this.value2 = value2;
    }
}

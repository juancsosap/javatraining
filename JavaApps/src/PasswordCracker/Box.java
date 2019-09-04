package PasswordCracker;

public class Box<T> {
    private T value;
    private final Converter<T> converter;

    public Box(Converter<T> converter) {
        this.converter = converter;
    }

    public void convert(String value) throws RuntimeException {
        this.value = this.converter.convert(value);
    }

    public T get() {
        return this.value;
    }
}
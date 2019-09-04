package PasswordCracker;

public interface Converter<T> {
    public T convert(String value) throws RuntimeException;

    public static Converter<Integer> INT = s -> Integer.parseInt(s);

    public static Converter<Boolean> BOOL = s -> {
        if(s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("y"))
            return true;
        if(s.equalsIgnoreCase("no") || s.equalsIgnoreCase("n"))
            return false;
        throw new RuntimeException();
    };

    public static Converter<String> NO = s -> s;
}
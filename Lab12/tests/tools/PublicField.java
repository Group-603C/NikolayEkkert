package tools;

public class PublicField <T> {

    private T value;


    public PublicField(T value) {
        this.value = value;
        
    }

    public T getValue() {
        return value;
    }
}

package tools;

public class Cyclic {

    private Cyclic field;


    public Cyclic() {}

    public Cyclic(Cyclic field) {
        this.field = field;

    }

    public Cyclic getField() {
        return field;

    }
}

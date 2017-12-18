package tools;

public class Cyclic {
    
    public Cyclic field;

    public Cyclic() {
    }

    public Cyclic(Cyclic field) {
        this.field = field;
    }
}

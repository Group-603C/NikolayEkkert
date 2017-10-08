public class Main
{
    public static void main(String[] args)
    {
        String expresion = "6+7+10*4";

        Calculator instance = new Calculator();
        System.out.println(instance.calculate(expresion));
    }
}

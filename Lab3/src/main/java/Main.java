public class Main
{
    public static void main(String[] args)
    {
//        String expresion = "6.2+(7+10)*4";
//        String expresion = "6.2+7+10*4";
        String expresion = "2+3-4*5";
//        String expresion = "4*5-2+3";

        Calculator instance = new Calculator();
        double var = instance.calculate(expresion);
        System.out.println("Result: "+var);
    }
}

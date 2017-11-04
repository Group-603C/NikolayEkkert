public class Main
{
    public static void main(String[] args)
    {
        FileAnalizer customAnalizer = new FileAnalizer("file.txt");

        System.out.println("Количество букв: " + customAnalizer.countLetters());
        System.out.println("Количество слов: " + customAnalizer.countWords());
        System.out.println("Количество строк: " + customAnalizer.countLines());
        System.out.println("Частотный анализ: " + customAnalizer.countFrequencyCharacteristic());
    }
}

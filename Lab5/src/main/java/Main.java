import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        Formatter exemplar = new Formatter();
        String text = exemplar.build1("здесь {0}, а здесь {1}, а вот {2}", "мама", "папа", 32, "fdfd");

        System.out.println(text);


//        ArrayList<String> states = new ArrayList<String>();

////        int[][] nums2 = {{0, 1, 2}, {3, 4, 5}};
//        int[][] nums2 = new int[4][];
//        int[] num = {9,5,1};
//        nums2[0] = num;
//        nums2[1] = num;
//        nums2[2] = num;
//        nums2[3] = num;
//        for (int i = 0; i < nums2.length; i++)
//        {
//            for (int j = 0; j < nums2[i].length; j++)
//            {
//                System.out.println(nums2[i][j]);
//            }
//        }

    }
}
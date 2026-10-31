import java.util.*;
public class load{
    public static void main(String[] args) {
        String paragraph = "Java is easy. Java is powerful. " + "Java is popular and easy to learn.";
        String[] words = paragraph.toLowerCase().replaceAll("[^a-z ]", "") .split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a,

            Map.Entry<String, Integer> b) {
                return b.getValue().compareTo(a.getValue());
             }
        });

        System.out.println("Word Frequencies (Highest First):");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

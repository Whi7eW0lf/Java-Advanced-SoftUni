import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Set<String>> players = new LinkedHashMap<>();
        
        String input;
        
        while(!"JOKER".equals(input=read.readLine())){

            String [] data = input.split(": ");

            if (!players.containsKey(data[0])){
                players.put(data[0],new LinkedHashSet<>());
                players.get(data[0]).addAll(Arrays.asList(data[1].split(", ")));
            }else {
                players.get(data[0]).addAll(Arrays.asList(data[1].split(", ")));
            }


        }

        Map<String,Integer> result = new LinkedHashMap<>();

        for (Map.Entry<String, Set<String>> kvp : players.entrySet()) {
            result.put(kvp.getKey(),0);
            int oldPoints = result.get(kvp.getKey());
            result.put(kvp.getKey(),oldPoints+calculatePoints(kvp.getValue()));
        }

        result.forEach((key, value) -> System.out.println(String.format("%s: %d", key, value)));

    }

    private static int calculatePoints(Set<String> value) {
        int points = 0;

        Map<Character,Integer> values = new LinkedHashMap<>();
        values.put('S',4);
        values.put('H',3);
        values.put('D',2);
        values.put('C',1);
        values.put('J',11);
        values.put('Q',12);
        values.put('K',13);
        values.put('A',14);

        for (String element : value) {
            if (Character.isDigit(element.charAt(0))&&!Character.isDigit(element.charAt(1))){
                points+=Integer.parseInt(String.valueOf(element.charAt(0)))*values.get(element.charAt(1));
            }else if (Character.isDigit(element.charAt(0))&&Character.isDigit(element.charAt(1))){
                points+=Integer.parseInt(String.valueOf(element.charAt(0))+element.charAt(1))*values.get(element.charAt(2));
            }else {
                points+=values.get(element.charAt(0))*values.get(element.charAt(1));
            }
        }

        return points;
    }
}

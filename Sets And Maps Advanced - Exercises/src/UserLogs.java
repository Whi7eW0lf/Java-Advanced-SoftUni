import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        Pattern pattern = Pattern.compile("IP=(?<ip>.+) message='.*' user=(?<user>.+)");

        String input;

        while (!"end".equals(input = read.readLine())) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                users.putIfAbsent(matcher.group("user"), new LinkedHashMap<>());
                users.get(matcher.group("user")).putIfAbsent(matcher.group("ip"),0);
                int oldCount = users.get(matcher.group("user")).get(matcher.group("ip"));
                users.get(matcher.group("user")).put(matcher.group("ip"),oldCount+1);

            }

        }
        users.forEach((username,value)->{
            System.out.println(username+": ");
            String print = "";
            for (Map.Entry<String, Integer> stringIntegerEntry : value.entrySet()) {
                print+=stringIntegerEntry.getKey()+" => "+stringIntegerEntry.getValue()+", ";
            }
            print=print.substring(0,print.length()-2)+".";
            System.out.println(print);
        });
    }
}

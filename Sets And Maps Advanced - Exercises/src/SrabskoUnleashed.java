import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> singers = new LinkedHashMap<>();

        String input;

        Pattern pattern = Pattern.compile("(?<name>.+) @(?<town>.+?) (?<price>[\\d]+) (?<count>\\d+)");

        while (!"End".equals(input = read.readLine())) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String name = matcher.group("name");
                String town = matcher.group("town");
                int price = Integer.parseInt(matcher.group("price"));
                int count = Integer.parseInt(matcher.group("count"));

                singers.putIfAbsent(town, new LinkedHashMap<>());
                singers.get(town).putIfAbsent(name, 0L);
                long oldValue = singers.get(town).get(name);
                long totalPrice = price * count;
                singers.get(town).put(name, oldValue + totalPrice);
            }

        }

        singers.forEach((key,value)->{
            System.out.println(key);
            value.entrySet().stream()
                    .sorted((e1,e2)->Long.compare(e2.getValue(),e1.getValue()))
                    .forEach(e-> System.out.println(String.format("#  %s -> %s",e.getKey(),e.getValue())));
        });

    }
}

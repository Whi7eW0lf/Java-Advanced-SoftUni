import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Map<String,Long>> countries = new LinkedHashMap<>();
        
        String input;
        
        while(!"report".equals(input=read.readLine())){
        
            String[] data = input.split("\\|");

            String country = data[1];
            String town = data[0];
            long population = Long.parseLong(data[2]);

            countries.putIfAbsent(country,new LinkedHashMap<>());
            countries.get(country).putIfAbsent(town,0L);
            long oldPopulation = countries.get(country).get(town);
            countries.get(country).put(town,oldPopulation+population);
            
        }

        Map<String,Long> finalCounts = new LinkedHashMap<>();

        countries.forEach((key, value) -> {

            long sum = 0;

            for (Map.Entry<String, Long> kvp : value.entrySet()) {
                sum += kvp.getValue();
            }
            finalCounts.put(key, sum);

        });

        finalCounts.entrySet().stream()
                .sorted((e1,e2)->Long.compare(e2.getValue(),e1.getValue()))
                .forEach(e->{
                    System.out.println(String.format("%s (total population: %d)",e.getKey(),e.getValue()));
                    countries.get(e.getKey()).entrySet().stream().sorted((b1,b2)->Long.compare(b2.getValue(), b1.getValue()))
                            .forEach(b -> System.out.println(String.format("=>%s: %d", b.getKey(), b.getValue())));
        });
    }
}

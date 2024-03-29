import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        Map<String,Integer>durations = new TreeMap<>();
        Map<String, Set<String>> ips = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = read.readLine().split("\\s+");

            if (!durations.containsKey(data[1])){
                durations.put(data[1],0);
                durations.put(data[1],durations.get(data[1])+Integer.parseInt(data[2]));
                ips.put(data[1],new TreeSet<>());
                ips.get(data[1]).add(data[0]);
            }else {
                durations.put(data[1],durations.get(data[1])+Integer.parseInt(data[2]));
                ips.get(data[1]).add(data[0]);
            }

        }

        durations.forEach((name,value)-> System.out.println(String.format("%s: %d %s",name,value,ips.get(name).toString())));

    }
}

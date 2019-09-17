package hashtable;

import java.util.*;
import java.util.stream.Collectors;

public class Solution820 {

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(
            Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            })).values()
        );
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        Collection<List<String>> values = Arrays.stream(strs).collect(Collectors.groupingBy(str -> {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        })).values();
        System.out.println(values);
    }

}

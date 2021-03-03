package CriticalConnectionsNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
//    public static List<List<Integer>> stringToInt2dList(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        if (jsonArray.size() == 0) {
//            return new ArrayList<List<Integer>>();
//        }
//
//        List<List<Integer>> list = new ArrayList<>(jsonArray.size());
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JsonArray cols = jsonArray.get(i).asArray();
//            list.add(stringToIntegerList(cols.toString()));
//        }
//        return list;
//    }
//
//    public static String integerArrayListToString(List<Integer> nums, int length) {
//        if (length == 0) {
//            return "[]";
//        }
//
//        String result = "";
//        for(int index = 0; index < length; index++) {
//            Integer number = nums.get(index);
//            result += Integer.toString(number) + ", ";
//        }
//        return "[" + result.substring(0, result.length() - 2) + "]";
//    }
//
//    public static String integerArrayListToString(List<Integer> nums) {
//        return integerArrayListToString(nums, nums.size());
//    }
//
//    public static String int2dListToString(List<List<Integer>> nums) {
//        StringBuilder sb = new StringBuilder("[");
//        for (List<Integer> list: nums) {
//            sb.append(integerArrayListToString(list));
//            sb.append(",");
//        }
//
//        sb.setCharAt(sb.length() - 1, ']');
//        return sb.toString();
//    }
//
//    private static List<Integer> stringToIntegerList(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        List<Integer> arr = new ArrayList<>(jsonArray.size());
//        for (int i = 0; i < jsonArray.size(); i++) {
//            arr.add(jsonArray.get(i).asInt());
//        }
//        return arr;
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int n = Integer.parseInt(line);
//            line = in.readLine();
//            List<List<Integer>> connections = stringToInt2dList(line);
//
//            List<List<Integer>> ret = new Solution().criticalConnections(n, connections);
//
//            String out = int2dListToString(ret);
//
//            System.out.print(out);
//        }
//    }
}

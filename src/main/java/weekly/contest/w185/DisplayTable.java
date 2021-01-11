package weekly.contest.w185;

import com.google.common.collect.ArrayListMultimap;

import java.util.*;

public class DisplayTable {
    public static void main(String[] args) {
        List<List<String>> orders = new ArrayList<>();
        orders.add(Arrays.asList("David", "3", "Ceviche"));
        orders.add(Arrays.asList("Corina", "10", "Beef Burrito"));
        orders.add(Arrays.asList("David", "3", "Fried Chicken"));
        orders.add(Arrays.asList("Carla", "5", "Water"));
        orders.add(Arrays.asList("Carla", "5", "Ceviche"));
        orders.add(Arrays.asList("Rous", "3", "Ceviche"));
        DisplayTable displayTable = new DisplayTable();
        List<List<String>> lists = displayTable.displayTable(orders);
        int i = 0;
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ret = new ArrayList<>();
        Set<String> foods = new HashSet<>();
        Map<Integer, Map<String, Integer>> tableMap = new HashMap<>();
        for (List<String> order : orders) {
            String name = order.get(0);
            int tableNumber = Integer.parseInt(order.get(1));
            String food = order.get(2);
            foods.add(food);
            if (!tableMap.containsKey(tableNumber)) {
                tableMap.put(tableNumber, new HashMap<>());
            }
            Map<String, Integer> foodCount = tableMap.get(tableNumber);
            foodCount.put(food, foodCount.getOrDefault(food, 0) + 1);
        }
        List<String> first = new ArrayList<>(foods);
        Collections.sort(first);
        first.add(0, "Table");
        ret.add(first);
        List<List<String>> tables = new ArrayList<>();
        List<Integer> tableNumbers = new ArrayList<>(tableMap.keySet());
        Collections.sort(tableNumbers);
        for (Integer tableNumber : tableNumbers) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(tableNumber));
            Map<String, Integer> foodCountMap = tableMap.get(tableNumber);
            for (int i = 1; i < first.size(); i++) {
                String foodName = first.get(i);
                list.add(String.valueOf(foodCountMap.getOrDefault(foodName, 0)));
            }
            tables.add(list);
        }
        ret.addAll(tables);
        return ret;
    }
}

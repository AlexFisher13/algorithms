package org.fisher.adventofcode.day1;

import org.fisher.adventofcode.utils.SuperFileReader;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CalorieCounting {
    public static void main(String[] args) {
        String fileName = "/Users/fisher/IdeaProjects/Algorithms/src/main/java/org/fisher/adventofcode/day1/input.txt";
        List<String> list = SuperFileReader.getListOfStringFromFile(fileName);

        List<Integer> calories = new LinkedList();

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isEmpty()) {
                sum += Integer.parseInt(list.get(i));
            } else {
                calories.add(sum);
                sum = 0;
            }
        }
        calories.add(sum);

        Integer maxCalories = calories.stream().max(Integer::compareTo).get();

        System.out.println("Elf with max calories " + maxCalories);

        int sumOfTop3 = calories.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of calories of top 3 elf " + sumOfTop3);
    }



}

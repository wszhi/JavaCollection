package com.thoughtworks.collection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int max = Math.max(leftBorder, rightBorder);
        int min = Math.min(leftBorder, rightBorder);
        return IntStream.rangeClosed(min, max).filter(num -> num % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int max = Math.max(leftBorder, rightBorder);
        int min = Math.min(leftBorder, rightBorder);
        return IntStream.rangeClosed(min, max).filter(num -> num % 2 != 0).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(num -> num * 3 + 2).mapToInt(num -> num).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(num -> (num % 2 != 0) ? num * 3 + 2 : num).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(num -> num % 2 != 0).map(num -> num * 3 + 5).mapToInt(num -> num).sum();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> list = arrayList.stream().filter(num -> num % 2 == 0).sorted().collect(Collectors.toList());
        return list.size() % 2 == 0 ? list.stream().skip(list.size() / 2 - 1).limit(2).mapToDouble(num -> num).average().getAsDouble() :
                list.stream().skip(list.size() / 2).mapToDouble(num -> num).findFirst().getAsDouble();
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(num -> num % 2 == 0).mapToDouble(num -> num).average().getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(num -> num % 2 == 0).anyMatch(num -> num == specialElment);

    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(num -> num % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> list = arrayList.stream().filter(num -> num % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> list2 = arrayList.stream().filter(num -> num % 2 != 0).sorted((i1, i2) -> i2 - i1).collect(Collectors.toList());
        list.addAll(list2);
        return list;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        return IntStream.range(0, arrayList.size())
                .filter(i -> i < arrayList.size() - 1)
                .mapToObj(i -> (arrayList.get(i) + arrayList.get(i + 1)) * 3).collect(Collectors.toList());
    }
}

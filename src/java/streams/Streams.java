package java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    private List<String> names;
    private List<Integer> numbers;

    public Streams() {
        String [] namesArray = {"Zig-Zag Traversal", "Nikola Tesla", "Spiderman"
                , "Superman", "Edison", "Newton", "Timmy", "Archimed", "Einstein"};
        names = new ArrayList<>(Arrays.asList(namesArray));

        Integer [] numbersArray = {1, 2, 3, 5, 6, 7, 8, 9, 10};
        numbers = new ArrayList<>(Arrays.asList(numbersArray));
    }

    public void evensWithoutStream() {

        List<Integer> evenNumbers = new ArrayList<>();

        for(Integer aNumber : numbers) {
            if(aNumber % 2 == 0) {
                evenNumbers.add(aNumber);
            }
        }
        System.out.println(evenNumbers.size());
    }

    public void evensWithStreamFilterOperator() {

        List<Integer> evenNumbers = numbers.stream()
                .filter(aNumber->aNumber % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);
    }

    public void doublesWithoutStream() {

        List<Integer> doubleNumbers = new ArrayList<>();
        for(Integer aNumber : numbers) {
            doubleNumbers.add(aNumber * 2);
        }
        System.out.println(doubleNumbers);
    }

    public void doublesWithStreamMapOperator() {

        List<Integer> doubleNumbers = numbers.stream()
                .map(aNumber-> aNumber * 2)
                .collect(Collectors.toList());
        System.out.println(doubleNumbers);
    }

    public void count() {
        List<String> scientists = names.stream().filter(name->name.charAt(0) < 'O')
                .collect(Collectors.toList());
        System.out.println(scientists);

        long count = names.stream().filter(name->name.charAt(0) < 'O').count();
        System.out.println("Count:" + count);
    }

    public void sort() {
        List<String> sortedScientists = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedScientists);
    }

    public void customSort() {

        List<String> sortedPeople = names.stream().filter(name->name.charAt(0) < 'O')
                .sorted( (i1, i2) -> -1 * i1.compareTo(i2))
                .collect(Collectors.toList());
        System.out.println(sortedPeople);

    }

    public void customSort2() {

        List<String> sortedPeople = names.stream()
                .sorted(new StringComparator())
                .collect(Collectors.toList());
        System.out.println(sortedPeople);

    }

    private class StringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return -1 * o1.compareTo(o2);
        }
    }

    public void min() {
        Integer minValue = (int)numbers.stream().min( (i1, i2) -> i1.compareTo(i2)).get();
        System.out.println(minValue);
    }

    public void max() {
        Integer minValue = (int)numbers.stream().max( (i1, i2) -> i1.compareTo(i2)).get();
        System.out.println(minValue);
    }

    public void foreach() {
        for(Integer aNumber : numbers) {
            System.out.print(" " + aNumber);
        }

        System.out.println();

        numbers.stream().forEach(aNumber -> System.out.print(" " + aNumber));
    }

    public void foreach2() {
        numbers.stream().forEach(System.out::print);
        System.out.println();
        numbers.stream().forEach(this::printInteger);
    }

    private void printInteger(Integer anInteger) {
        System.out.print(" " + anInteger);
    }

    public void convertToArray() {
        Integer [] newNumberArray2 = numbers.stream().toArray(Integer []::new);
        for(Integer aNumber : newNumberArray2) {
            System.out.print(" " + aNumber);
        }
        System.out.println();

        Object [] newNumberArray = numbers.stream().toArray();
        for(Object aNumber : newNumberArray) {
            System.out.print(" " + aNumber);
        }
    }

    public void ofOperator() {

        Double[] doubleArray = {1.2, 2.3, 4.5};
        Stream doubleStream = Stream.of(doubleArray);
        doubleStream.forEach(System.out::println);

        Stream integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream.forEach(System.out::println);

        Stream stringStream = Stream.of("A", "B", "C");
        stringStream.forEach(System.out::println);

        Stream aStream = Stream.of("A", "B", "C", 1, 2, true);
        aStream.forEach(System.out::println);
    }
}

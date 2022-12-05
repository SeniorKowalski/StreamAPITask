package com.kowalski;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_00; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long task1 = persons.stream()
                .filter((i) -> i.getAge() < 18)
                .count();
        System.out.println(task1);

        List<String> task2 = persons.stream()
                .filter(i -> i.getAge()>18 && i.getAge()<27)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());


        List<Person> task3 = persons.stream()
                .filter(e -> e.getEducation() == Education.HIGHER)
                .filter(a -> (a.getSex() == Sex.MAN && a.getAge() > 18 && a.getAge() < 65) || (a.getSex() == Sex.WOMAN && a.getAge() > 18 && a.getAge() < 60))
                .sorted(Comparator.comparing(f -> f.getFamily()))
                .collect(Collectors.toList());

        task3.forEach(System.out::println);
    }
}

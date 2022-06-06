import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long count = persons.stream()
                .filter(x -> x.getAge() < 18)
                .count();

        List<String> armyBoy = persons.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() < 27)
                .filter(x -> x.getSex().name().contains("Man"))
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(armyBoy);
        List<Person> worcker = persons.stream()
                .filter(x -> x.getEducation().name().contains("HIGHER"))
                .filter(x -> (x.getAge() >= 18 && x.getAge() < 60 && x.getSex().name().contains("Woman")) ||
                        (x.getAge() >= 18 && x.getAge() < 65 && x.getSex().name().contains("Man")))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
    }

}
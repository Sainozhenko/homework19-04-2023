package homeworkTommorow;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Jack", 25, "Blaklash");
        Person person1 = new Person("Jim", 13, "Brooklyn");
        Person person2 = new Person("Jill", 43, "Nevada");
        Person person3 = new Person("Jerry", 6, "Ostom");

        List<Person> people = List.of(person, person1, person2, person3);
        System.out.println(changed(people));
        System.out.println(who17YearsOld(people));
        System.out.println(who17YearsOld2(people));
        System.out.println(who18YO(people));
    }

    public static Map<Integer, List<Person>> changed(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(s -> s.getAge()));
    }

    public static IntSummaryStatistics who17YearsOld(List<Person> people) {
        return people.stream().filter(p -> p.getAge() > 17).collect(Collectors.summarizingInt(Person::getAge));
    }

    public static int who17YearsOld2(List<Person> people) {
        return people.stream()
                .filter(s -> s.getAge() > 17)
                .mapToInt(p->p.getAge())
                .sum();
    }

    public static String who18YO(List<Person> people) {
        return "<in Germany " + people.stream().filter(s -> s.getAge() > 18).map(p -> p.getName())
                .collect(Collectors.joining(" and ", "<", ">"))
                + " are of legal age.>";

    }
}
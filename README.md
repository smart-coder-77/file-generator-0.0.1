import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private Date joiningDate;
    private String gender;

    public Person(String name, Date joiningDate, String gender) {
        this.name = name;
        this.joiningDate = joiningDate;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    @Override
    public String toString() {
        return name + " - " + joiningDate + " - " + gender;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Alice", new Date(2022, 10, 1), "Female"),
                new Person("Bob", new Date(2021, 9, 15), "Male"),
                new Person("Charlie", new Date(2020, 5, 10), "Transgender"),
                new Person("David", new Date(2022, 8, 20), "Male"),
                new Person("Eva", new Date(2023, 1, 5), "Female"),
                new Person("Frank", new Date(2021, 12, 25), "Transgender")
        );

        // Group persons by gender and find the maximum joining date in each group
        Map<String, Optional<Person>> maxJoiningDatesByGender = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        Collectors.maxBy(Comparator.comparing(Person::getJoiningDate))
                ));

        // Print the results
        maxJoiningDatesByGender.forEach((gender, person) -> {
            person.ifPresent(p -> System.out.println("Maximum joining date of " + gender + " group: " + p.getJoiningDate()));
        });
    }
}

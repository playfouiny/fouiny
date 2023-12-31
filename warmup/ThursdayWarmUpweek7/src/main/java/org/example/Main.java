package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        List<Person> database = Arrays.asList(
                new Person(1, "Jack", "Brown", "Architect", "Texas", 48855),
                new Person(2, "Bob", "Smith", "Nurse", "Pennsylvania", 100711),
                new Person(3, "Ivy", "Smith", "Teacher", "Florida", 109366),
                new Person(4, "Emily", "Miller", "Nurse", "California", 53896),
                new Person(5, "Alice", "Garcia", "Doctor", "California", 57275),
                new Person(6, "Ivy", "Martinez", "Teacher", "California", 128061),
                new Person(7, "Alice", "Smith", "Farmer", "Texas", 41560),
                new Person(8, "Jack", "Garcia", "Nurse", "California", 97243),
                new Person(9, "Emily", "Smith", "Engineer", "Texas", 71966),
                new Person(10, "Alice", "Johnson", "Chef", "North Carolina", 96226),
                new Person(11, "Ivy", "Smith", "Chef", "Michigan", 113865),
                new Person(12, "Charlie", "Lee", "Doctor", "Illinois", 104835),
                new Person(13, "Grace", "Jones", "Farmer", "California", 114999),
                new Person(14, "Jack", "Davis", "Teacher", "Michigan", 89819),
                new Person(15, "Emily", "Miller", "Farmer", "North Carolina", 41535),
                new Person(16, "David", "Martinez", "Engineer", "Georgia", 70593),
                new Person(17, "Bob", "Johnson", "Doctor", "New York", 93464),
                new Person(18, "Emily", "Lee", "Chef", "New York", 133583),
                new Person(19, "Frank", "Garcia", "Teacher", "Illinois", 82528),
                new Person(20, "Charlie", "Brown", "Doctor", "Florida", 105548),
                new Person(21, "Alice", "Martinez", "Engineer", "California", 77609),
                new Person(22, "Jack", "Lee", "Farmer", "California", 126977),
                new Person(23, "Ivy", "Martinez", "Chef", "Texas", 81136),
                new Person(24, "Alice", "Brown", "Architect", "Ohio", 51435),
                new Person(25, "Charlie", "Smith", "Architect", "North Carolina", 66140),
                new Person(26, "Jack", "Johnson", "Engineer", "Florida", 143981),
                new Person(27, "David", "Garcia", "Teacher", "Ohio", 107622),
                new Person(28, "Emily", "Smith", "Nurse", "Georgia", 74796),
                new Person(29, "Grace", "Johnson", "Scientist", "Georgia", 148055),
                new Person(30, "Henry", "Martinez", "Scientist", "Illinois", 127989));

        List<String> fullName = database.stream().map(x -> x.getFirstName() + " " + x.getLastName()).toList();
       /* List<Double> averageIncome = database.stream().map(x -> x.getYearlyIncome()).toList();*/
        //double averageIncome = database.stream().mapToDouble(Person::getYearlyIncome).average().orElse(0.0);
        List<String> texasLiving = database.stream().filter(x -> x.getState().equalsIgnoreCase("Texas")).map(Person::getProfession).toList();
        Optional<Person> personWithHighestIncome = database.stream().max(Comparator.comparingDouble(Person::getYearlyIncome));
        var averageIncome = database.stream().map(x -> x.getYearlyIncome()).reduce(0d,(temp, num)-> temp+=num) / database.size();
        List<String> doctorProfessions = database.stream().filter(x -> x.getProfession().equalsIgnoreCase("Doctor")).map(Person::getProfession).toList();
        var countPeopleInCalifornia = database.stream().filter(x -> x.getState().equalsIgnoreCase("California")).count();

        fullName.forEach(System.out::println);
        System.out.println("Average Yearly Income: " + averageIncome);
        texasLiving.forEach(System.out::println);


        //You don't always have to print to the console, but it could be helpful for testing!
        // 1. Print the full names of all people.
        // 2. Calculate the average yearly income of all people.
        // 3. List the professions of people living in Texas.
        // 4. Find the person with the highest income.
        // 5. Count the number of people living in California.
        // 6. Create a list of people who are not teachers.
        // 7. Find the total income of all doctors.
        // 8. Print the names of people with an income higher than 100000.
        // 9. Find the average income of engineers.
        // 10. List the first names of people whose last name starts with 'S'.
        // 11. List the last names of all people who have a yearly income greater than $75,000 and live in Florida.
        // 12. Find the average income of people whose profession is 'Teacher' or 'Doctor'.
    }
}

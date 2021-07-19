package Uebung1;

import java.time.LocalDate;

public class AboutMe {

    public static void main(String[] args) {

        int age = 28;

        String name = "Karima";

        String lastName = "Hussein";

        char gender = 'd';

        LocalDate dateOfBirth = LocalDate.of(1993,5,24);

        double averageGrade = 2.5;

        boolean isMarried = false;

        System.out.println("Hi! My name is " + name + " " + lastName + ". " + "I'm " + age + " years old and I was born on " +
                dateOfBirth + ". " + "My gender is " + gender + " and if you'd ask me if I'm married, I'd give you the answer " + isMarried + ". Finally, my average grade is " + averageGrade + ".");

    }

}

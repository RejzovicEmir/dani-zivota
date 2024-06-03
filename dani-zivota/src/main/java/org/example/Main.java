package com.example;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite datum rodjenja (u formatu dd-mm-gggg): ");
        String input = scanner.nextLine();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dateOfBirth = LocalDate.parse(input, formatter);

            if (dateOfBirth.isAfter(LocalDate.now())) {
                System.out.println("Datum rodjenja mora biti u proslosti");
                return;
            }

            long ageInDays = ChronoUnit.DAYS.between(dateOfBirth, LocalDate.now());
            System.out.println("Vasa starost u danima je: " + ageInDays + ".");

        } catch (DateTimeParseException e) {
            System.out.println("Netacan format datuma");
        } finally {
            scanner.close();
        }
    }
}

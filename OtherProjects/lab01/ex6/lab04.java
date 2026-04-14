package ex6;

import java.util.Scanner;

public class lab04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int month = 0;
        int year = -1;

        while (true) {
            System.out.print("Input month: ");
            String input = scanner.nextLine().trim().toLowerCase();

            month = convertMonth(input);

            if (month != -1)
                break;
            System.out.println("Invalid month");
        }
        while (true) {
            System.out.print("Input year: ");
            String inputYear = scanner.nextLine();
            if (!inputYear.matches("\\d+")) {
                System.out.println("Invalid year!");
                continue;
            }

            year = Integer.parseInt(inputYear);

            if (year < 0) {
                System.out.println("Year must be >= 0!");
            } else {
                break;
            }
        }

        boolean isLeap = isLeapYear(year);

        int days = getDaysInMonth(month, isLeap);

        System.out.println("Month " + month + " year " + year + " has " + days + " days.");

        scanner.close();
    }

    public static int convertMonth(String m) {
        switch (m) {
            case "1":
            case "jan":
            case "jan.":
            case "january":
                return 1;
            case "2":
            case "feb":
            case "feb.":
            case "february":
                return 2;
            case "3":
            case "mar":
            case "mar.":
            case "march":
                return 3;
            case "4":
            case "apr":
            case "apr.":
            case "april":
                return 4;
            case "5":
            case "may":
                return 5;
            case "6":
            case "jun":
            case "june":
                return 6;
            case "7":
            case "jul":
            case "july":
                return 7;
            case "8":
            case "aug":
            case "aug.":
            case "august":
                return 8;
            case "9":
            case "sep":
            case "sept":
            case "sept.":
            case "september":
                return 9;
            case "10":
            case "oct":
            case "oct.":
            case "october":
                return 10;
            case "11":
            case "nov":
            case "nov.":
            case "november":
                return 11;
            case "12":
            case "dec":
            case "dec.":
            case "december":
                return 12;
            default:
                return -1;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, boolean isLeap) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeap ? 29 : 28;
            default:
                return 0;
        }
    }
}
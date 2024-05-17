package org.example;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    DayOfWeek day = DayOfWeek.MONDAY;

    DayOfWeek weekend = DayOfWeek.SATURDAY;
    DayOfWeek weekend2 = DayOfWeek.SUNDAY;

    System.out.println(day);
    System.out.println("Name of DayOfWeek.MONDAY is: " + day.name());

    if (day instanceof DayOfWeek) {
        System.out.println("day variable is of type DayOfWeek");
      }
      if (day.name() instanceof String) {
        System.out.println("day.name() is of type String");
      }

    DayOfWeek friday = DayOfWeek.valueOf("FRIDAY");
    System.out.println("friday variable value: " + friday + " of type " + friday.getClass().getSimpleName());
    System.out.println("friday variable's name value: " + friday.name() + " of type " + friday.name().getClass().getSimpleName());
    // DayOfWeek.FRIDAY != "FRIDAY"

    DayOfWeek tuesday = DayOfWeek.TUESDAY;
    System.out.println("Is " + tuesday + " a weekend day? " + tuesday.isWeekend());
    System.out.println("Is " + weekend + " a weekend day? " + weekend.isWeekend());

    System.out.println(tuesday.isWeekend());

    System.out.println("Please enter day in the week and you will get it's length: ");
    try (Scanner scanner = new Scanner(System.in)) {
      String providedDayString = scanner.next();
      scanner.nextLine();

      DayOfWeek providedDay = DayOfWeek.valueOf(providedDayString.trim().toUpperCase());

      // switch example - old syntax (switch statement)
      int numberOfLetters;
      switch (providedDay) {
        case MONDAY, FRIDAY, SUNDAY:
          numberOfLetters = 6;
          break;
        case TUESDAY:
          numberOfLetters = 7;
          break;
        case WEDNESDAY:
          numberOfLetters = 9;
          break;
        case THURSDAY, SATURDAY:
          numberOfLetters = 8;
          break;
        default:
          numberOfLetters = -1;
      }

      System.out.println("Length of " + providedDay + "'s name is: " + numberOfLetters);

      // switch example - new syntax (switch expression)
      // new switch is now expression and not a statement (we can assign it to some variable)
      // syntax is shorter
      // no need to use breaks
      // no need for default
      int numberOfLetters2 = switch (providedDay) {
        case MONDAY, FRIDAY, SUNDAY -> getLegth(); // recommended practice, call method in case of more code
        case TUESDAY -> 7;
        case WEDNESDAY -> 9;
        case THURSDAY, SATURDAY -> { // possible to use code block, in that case use `yield` keyword to return result
          int length = 0;
          length = 8;
          yield length;
        }
      };

      System.out.println("Length of " + providedDay + "'s name is: " + numberOfLetters2);

      // no need for default branch if we have covered all possible options
      // if not we have to include default
      int numberOfLetters3 = switch (providedDay) {
        case MONDAY, FRIDAY, SUNDAY -> 6;
        case WEDNESDAY -> 9;
        case THURSDAY, SATURDAY -> 8;
        default -> 7;
      };

      System.out.println("Length of " + providedDay + "'s name is: " + numberOfLetters3);
    }

  }

  public static int getLegth() {
    int length = 0;
    length = 6;
    return length;
  }
}
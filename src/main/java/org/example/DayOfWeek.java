package org.example;

public enum DayOfWeek {
  MONDAY(false),
  TUESDAY(false),
  WEDNESDAY(false),
  THURSDAY(false),
  FRIDAY(false),
  SATURDAY(true),
  SUNDAY(true);

//  private String name; name property is available by default
  private boolean isWeekend;

  DayOfWeek(boolean isWeekend) {
    this.isWeekend = isWeekend;
  }

  public boolean isWeekend() {
    return isWeekend;
  }
}

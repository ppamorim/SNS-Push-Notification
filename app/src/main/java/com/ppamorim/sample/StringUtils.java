package com.ppamorim.sample;

public class StringUtils {

  public static boolean isEmpty(String s) {
    return s == null || s.length() < 1;
  }

  public static boolean isBlank(String s) {
    return isEmpty(s.trim());
  }

}

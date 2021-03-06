package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArray implements TheHistory {

  /**
   * This implementation should use a String array so don't change that!
   */
  private String[] wordsArray = new String[0];

  @Override
  public void add(String text) {
    //TODO: check the TheHistory interface for more information
    wordsArray = text.split("\\s");
  }

  @Override
  public void removeWord(String wordToBeRemoved) {
    //TODO: check the TheHistory interface for more information
    String [] newWordArray = new String [size()];
    int index = 0;
    for (int i = 0; i < wordsArray.length; i++) {
      if (wordsArray[i] != wordToBeRemoved) {
        newWordArray[index] = wordsArray[i];
        index++;
      }
    }
    wordsArray = newWordArray;
  }

  @Override
  public int size() {
    //TODO: check the TheHistory interface for more information
    return wordsArray.length;
  }

  @Override
  public void clear() {
    //TODO: check the TheHistory interface for more information
    wordsArray = new String[0];
  }

  @Override
  public void replaceOneWord(String from, String to) {
    int count = 0;
    for (int i=0; i < wordsArray.length; i++) {
      if (wordsArray[i].equals(from)) {
        wordsArray[i] = to;
        count++;
      }
    }
  }

  @Override
  public void replaceMoreWords(String[] fromWords, String[] toWords) {
    //TODO: check the TheHistory interface for more information
    int countFromFirst = 0;
    for (int i = 0; i < wordsArray.length - fromWords.length; i++) {
      if (wordsArray[i].equals(fromWords[0]) && wordsArray[i + fromWords.length -1 ].equals(fromWords[fromWords.length-1])) {
        countFromFirst++;

      }
    }
    //System.out.println(countFromFirst);

  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (String word : wordsArray) {
      sb.append(word).append(" ");
    }
    if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
    return sb.toString();
  }
}
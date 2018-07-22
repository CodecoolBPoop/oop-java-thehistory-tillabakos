package com.codecool.thehistory;

import java.util.*;


public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        /*String [] wordArray = text.split("\\s");
        Collections.addAll(wordsLinkedList, wordArray);*/
        wordsLinkedList.addAll(Arrays.asList(text.split("\\s")));
        }


    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        //wordsLinkedList.removeIf(s -> s.equals(wordToBeRemoved));
        wordsLinkedList.removeIf(wordToBeRemoved::equals);
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
      wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        Collections.replaceAll(wordsLinkedList, from, to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        List<String> tempWordsList = new LinkedList<>();
        for (ListIterator<String> iter = wordsLinkedList.listIterator(); iter.hasNext();) {
            String currentItem = iter.next();
            int lastIndex = wordsLinkedList.size() - 1;
            int lastIndexToCheck = iter.previousIndex() + fromWords.length-1;

            boolean notOutOfRange = currentItem.equals(fromWords[0]) && lastIndexToCheck <= lastIndex;
            boolean nextMatches = true;

            if (notOutOfRange) {
                for (int i = 1; i < fromWords.length; i++) {
                    String fromWord = iter.next();
                    if (!(fromWord.equals(fromWords[i]))) {
                        nextMatches = false;
                        for (int j = 0; j < i; j++) {
                            iter.previous();
                        }
                        break;
                    }
                }
                if (nextMatches) {
                    tempWordsList.addAll(Arrays.asList(toWords));
                } else {
                    tempWordsList.add(currentItem);
                }
            } else {
                tempWordsList.add(currentItem);
            }
        }
        wordsLinkedList = tempWordsList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}

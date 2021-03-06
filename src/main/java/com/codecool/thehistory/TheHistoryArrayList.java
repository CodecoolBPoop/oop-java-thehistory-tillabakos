package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String [] wordArray = text.split("\\s");
        Collections.addAll(wordsArrayList, wordArray );
        //wordsArrayList.addAll(Arrays.asList(text.split("\\s")));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.removeIf(s -> s == wordToBeRemoved);
        //wordsArrayList.removeIf(wordToBeRemoved::equals);
        /*for (int i = 0; i < size(); i++) {
            if (wordsArrayList.get(i).equals(wordToBeRemoved)) {
                wordsArrayList.remove(wordToBeRemoved);
            }
        }*/
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        Collections.replaceAll(wordsArrayList, from, to);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        int matchedItemsCount;
        List<String> tempArray = new ArrayList<>();
        for (int i=0; i < wordsArrayList.size(); i++) {
            if (wordsArrayList.size() - i < fromWords.length) {
                for (int j=i; j < wordsArrayList.size(); j++) {
                    tempArray.add(wordsArrayList.get(j));
                }
                break;
            }
            matchedItemsCount = 0;
            for (int j=0; j < fromWords.length; j++) {
                if (wordsArrayList.get(i+j).equals(fromWords[j])) {
                    matchedItemsCount++;
                } else {
                    break;
                }
            }
            if (matchedItemsCount != fromWords.length) {
                tempArray.add(wordsArrayList.get(i));
            } else {
                    Collections.addAll(tempArray, toWords);
                    i = i + fromWords.length -1;
            }
        }
        wordsArrayList = tempArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}

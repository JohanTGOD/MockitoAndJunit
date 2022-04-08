package com.johan.tesistingwithjava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        String word = "You_have_chosen_to_translate_this_kata_For_your_convenience_we_have_provided_the_existing_test_cases_used_for_the_language_that_you_have_already_completed_as_well_as_all_of_the_other_related_fields";
        String letter = "abcd";
        String findShorVariable = "bitcoin take over the world maybe who knows perhaps";
        System.out.println(toCamelCase(word));
        System.out.println(accum(letter));
        System.out.println(findShort(findShorVariable));
    }

    static String toCamelCase(String word) {
        List<String> strings = Arrays.asList(word.split("[-|_]"));
        return strings.get(0) + strings.stream().skip(1)
                .map(currenValue -> currenValue.substring(0, 1).toUpperCase() + currenValue.substring(1).toLowerCase()).collect(Collectors.joining());
    }

    public static String accum(String s) {
        String[] words = s.split("");
        return IntStream.range(0, words.length).mapToObj(i -> {
            String wordConverted = words[i].repeat(i + 1);
            return wordConverted.substring(0, 1).toUpperCase() + wordConverted.substring(1).toLowerCase();
        }).collect(Collectors.joining("-"));
    }

    public static int findShort(String s) {
        String[] words = s.split(" ");
        return Arrays.stream(words).min(Comparator.comparingInt(String::length)).get().length();
    }


//    String result = "";
//    boolean state = false;
//    List<String> chars = Arrays.asList(word.split(""));
//        for (int i = 0; i < chars.size(); i++) {
//        String currentValue = chars.get(i);
//        if (currentValue.matches("[a-zA-Z]")) {
//            result += convertToUpperCaseOrLowerCase(state, currentValue);
//            state = false;
//
//        } else {
//            result += " ";
//            state = true;
//        }
//    }
//
//    return result.replace(" ","");
//}
//
//    private static String convertToUpperCaseOrLowerCase(Boolean convertToUpperCase, String value) {
//        return convertToUpperCase ? value.toUpperCase() : value;
//    }
}

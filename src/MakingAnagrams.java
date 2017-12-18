/*
 * Created by Jeprox on 12/18/17.
Alice is taking a cryptography class and finding anagrams to be very useful. We consider two
strings to be anagrams of each other if the first string's letters can be rearranged to form the
second string. In other words, both strings must contain the same exact letters in the same exact
frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

Alice decides on an encryption scheme involving two large strings where encryption is dependent on
the minimum number of character deletions required to make the two strings anagrams. Can you help
her find this number?

Given two strings, a and b, that may or may not be of the same length, determine the minimum number
of character deletions required to make a and b anagrams. Any characters can be deleted from either
of the strings.

Input Format
The first line contains a single string, a.
The second line contains a single string, b.
i.e.) cde
      abc
Output: 4
*/

import java.util.*;

public class MakingAnagrams {

    public static int numberNeeded(String first, String second) {

        String small;
        StringBuilder big;

        //choose which string is smaller
        if(first.length() <= second.length()){
            small = first;
            big = new StringBuilder(second);
        } else {
            small = second;
            big = new StringBuilder(first);
        }

        int match = 0;
        //check if each letter in small string exist in big string
        for(int i = 0; i < small.length(); i++){
            for(int j = 0; j < big.length(); j++){ //iterate through big string
                if(small.charAt(i) == big.charAt(j)){ //when match is found delete
                    big.deleteCharAt(j); //delete the match so it will not be doubled
                    match++; //increment no. matches to be used later
                    j = big.length(); // cancel the big for loop
                }
            }
        }

      /* big should only have letters to be deleted
      * no. of chars in small should be the difference of it's length and no. matches.
      */
        return (small.length() - match) + big.length();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}



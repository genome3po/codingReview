/*
 * Created by Jeprox on 12/12/17.
 *
A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a
magazine and wants to know if he can cut out whole words from it and use them to create an
untraceable replica of his ransom note. The words in his note are case-sensitive and he
must use whole words available in the magazine, meaning he cannot use substrings or
concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can
replicate his ransom note exactly using whole words from the magazine; otherwise, print No.

Input Format
The first line contains two space-separated integers describing the respective values of
(the number of words in the magazine) and  (the number of words in the ransom note).

The second line contains  space-separated strings denoting the words present in the magazine.

The third line contains  space-separated strings denoting the words present in the ransom
note.

Constraints
* 1 <= m, n <= 30000
* 1 <= length of any word <= 5
Each word consists of English alphabetic letters (i.e., a to z and A to Z).
The words in the note and magazine are case-sensitive.

Output Format
Print Yes if he can use the magazine to create an untraceable replica of his ransom note;
otherwise, print No.

Sample Input 0
6 4
give me one grand today night
give one grand today

Sample Output 0
Yes

Sample Input 1
6 5
two times three is not four
two times two is four

Sample Output 1
No

Explanation 1
two should occur 2 times in magazine.

 */

import java.util.*;

public class RansomNote {

    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNote(String magazine, String note) {

        String[] magWords = magazine.split("[ .,;:!?()]");
        String[] noteWords = note.split("[ .,;:!?()]");

        this.magazineMap = storeInHM(magWords);
        this.noteMap = storeInHM(noteWords);
    }

    public static Map<String, Integer> storeInHM(String[] toBeStored) {

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < toBeStored.length; i++) {
            String key = toBeStored[i];
            if(!map.containsKey(key)) map.put(key, 1);
            else {
                int value = map.get(key);
                value++;
                map.put(key, value);
            }
        }
        return map;
    }

    public boolean solve() {

        Set<Map.Entry<String, Integer>> noteSet = noteMap.entrySet();

        for(Map.Entry<String, Integer> x: noteSet) {
            String key = x.getKey();
            if(!magazineMap.containsKey(key)) {
                return false;
            }
            else if(x.getValue() > magazineMap.get(key)) {
                    return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}

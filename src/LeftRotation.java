/*
 * Created by Jeprox on 12/19/17.
A left rotation operation on an array of size 'n' shifts each of the array's elements 1 unit to the
left. For example, if 2 left rotations are performed on array [1,2,3,4,5], then the array would
become [3,4,5,1,2].

Given an array of 'n' integers and a number, d, perform d left rotations on the array. Then print
the updated array as a single line of space-separated integers.

Input Format
The first line contains two space-separated integers denoting the respective values of 'n' (the
number of integers) and 'd' (the number of left rotations you must perform).
The second line contains 'n' space-separated integers describing the respective elements of the
array's initial state.

Constraints
* 1 <= n <= 10^5
* 1 <= d <= n
* 1 <= a sub i <= 10^6

Output Format
Print a single line of 'n' space-separated integers denoting the final state of the array after
performing 'd' left rotations.

Sample Input
5 4
1 2 3 4 5

Sample Output
5 1 2 3 4

When we perform d = 4 left rotations, the array undergoes the following sequence of changes:
[1,2,3,4,5] -> [2,3,4,5,1] -> [3,4,5,1,2] -> [4,5,1,2,3] -> [5,1,2,3,4]
Thus, we print the array's final state as a single line of space-separated values, which is
5 1 2 3 4.
 */

import java.util.*;

public class LeftRotation {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        int temp;
        if(k % n == 0) { //number of swaps is mult. of size, just return the same array
            return a;
        } else {
            for(int i = 0; i < k; i++){
                temp = a[0]; //store the 1st elem. to temp
                for(int j = 1; j < n; j++){ //from after the 1st elem. to last, shift 1 down
                    a[j-1] = a[j];
                }
                a[n-1] = temp; //put the temp in last index
            }
            return a;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}


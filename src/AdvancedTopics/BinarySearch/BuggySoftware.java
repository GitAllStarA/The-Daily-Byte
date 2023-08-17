package AdvancedTopics.BinarySearch;

import java.util.Arrays;

/*
This question is asked by Facebook. Releasing software can be tricky and sometimes we release
new versions of our software with bugs. When we release a version with a bug it’s referred to
as a bad release. Your product manager has just informed you that a bug you created was released
in one of the past versions and has caused all versions that have been released since to also be bad.
Given that your past releases are numbered from zero to N and you have a helper function
isBadRelease(int releaseNumber) that takes a version number and returns a boolean as to whether or
not the given release number is bad, return the release number that your bug was initially shipped in.
Note: You should minimize your number of calls made to isBadRelease().

Ex: Given the following value N…

N = 5 and release number four is the release your bug was shipped in...

isBadRelease(3) // returns false.
isBadRelease(5) // returns true.
isBadRelease(4) // returns true.
*/
public class BuggySoftware {
    public static void main(String[] args) {
        System.out.println(isBadVersion(4));

    }

    static boolean isBadVersion(int versionNumber) {
        boolean n[] = {true, true, true, true, false, false, false};
        return n[findBadVersion(versionNumber)];
    }

    //working https://www.youtube.com/watch?v=E15djRphPj0&ab_channel=FisherCoder
    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;

        int result = n;

        while(low<high) {
            int mid = low + (high - low)/2;
            if(isBadVersion(mid)){
                result = mid;
                high = mid;
            }
            else {
                low = mid+ 1;
            }
        }
        return low;
    }


    static int findBadVersion(int n) {
        return bs(6, 4);
    }

    static int bs(int n, int target) {
        int v[] = new int[n];
        for (int i = 0; i < v.length; i++) {
            v[i] = i;
        }

        int low = 0;
        int high = v.length - 1;


        while (low < high) {
            int mid = (high + low) / 2;
            if (v[mid] == target) {

                return mid;
            }
            if (n < v[mid]) {
                high = mid;
                high--;

            } else if (n > v[mid]) {
                low = mid;
                low++;

            }
        }
        return -1;
    }
}

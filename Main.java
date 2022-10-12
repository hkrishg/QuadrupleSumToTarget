import java.util.*;

class Main {

  // Given an array of unsorted numbers and a target number, find all unique
  // quadruplets in it, whose sum is equal to the target number.

  // Example 1:

  // Input: [4, 1, 2, -1, 1, -3], target=1
  // Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
  // Explanation: Both the quadruplets add up to the target.
  // Example 2:

  // Input: [2, 0, -1, 1, -2, 2], target=2
  // Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
  // Explanation: Both the quadruplets add up to the target.

  private static List<List<Integer>> QuadrupleSumToTarget(int[] arr, int target) {
    Arrays.sort(arr);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < arr.length - 3; i++) {
      if (i > 0 && arr[i] == arr[i - 1])
      continue;
      for (int j = i + 1; j < arr.length - 2; j++) {
        if (j > i + 1 && arr[j] == arr[j - 1])
        continue;
        int left = j + 1, right = arr.length - 1;
        while (left < right) {
          int sum = (arr[i] + arr[j] + arr[left] + arr[right]);

          if (sum == target) {
            result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
            left++;
            right--;
            while (left < right && arr[left] == arr[left - 1])
            left++;
            while (left < right && arr[right] == arr[right + 1])
            right--;
          } else if (sum < target)
            left++;
          else
            right--;
        }
      }
    }
    return result;

  }

  public static void main(String[] args) {
    System.out.println(Main.QuadrupleSumToTarget(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
    System.out.println(Main.QuadrupleSumToTarget(new int[] { 2, 0, -1, 1, -2, 2 }, 2));

  }
}
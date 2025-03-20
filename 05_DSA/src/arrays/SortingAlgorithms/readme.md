# **Bubble sort**

Bubble sort is a sorting algorithm that compares two adjacent elements and swaps them until they are in the intended order.

# Working of Bubble Sort

![](https://miro.medium.com/v2/resize:fit:776/1*7QsZkfrRGhAu5yxxeDdzsA.png)

# Optimized Bubble Sort Algorithm

In the above algorithm, all the comparisons are made even if the array is already sorted.

This increases the execution time.

To solve this, we can introduce an extra variable swapped. The value of swapped is set _**true**_ if there occurs swapping of elements. Otherwise, it is set false.

After an iteration, if there is no swapping, the value of swapped will be false. This means elements are already sorted and there is no need to perform further iterations.

This will reduce the execution time and helps to optimize the bubble sort.

# Bubble Sort Complexity

### 1. Time Complexities

* ####    Worst Case Complexity: O(n2)

   If we want to sort in ascending order and the array is in descending order then the worst case occurs.

* ####    Best Case Complexity: O(n)

   If the array is already sorted, then there is no need for sorting.

* ####    Average Case Complexity: O(n2)

   It occurs when the elements of the array are in jumbled order (neither ascending nor descending).

### 2. Space Complexity

**_Space complexity is O(1)_** because an extra variable is used for swapping.
   In the optimized bubble sort algorithm, two extra variables are used. Hence, the space complexity will be O(2).

# **Insertion sort**


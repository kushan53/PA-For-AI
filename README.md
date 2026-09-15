# 🚀 Java Data Structures and Algorithms (DSA) Repository

A comprehensive, topic-wise collection of **Java Data Structures, Algorithms, Core OOP Concepts, and LeetCode Solutions** with detailed explanations, time/space complexity analysis, and runnable `main` test cases.

---

## 📂 Repository Structure & Syllabus Mapping

```
PA/
├── 01_Core_Java_and_OOP/
│   ├── OOPDemonstration.java
│   ├── ExceptionHandlingDemo.java
│   └── ArrayListOperations.java
├── 02_Arrays_and_Searching/
│   ├── TwoPointerTargetSum.java
│   ├── SpiralMatrixTraversal.java
│   ├── IndexNegationTechnique.java
│   ├── LinearAndBinarySearch.java
│   ├── FirstAndLastOccurrenceFrequency.java
│   ├── LC118_PascalsTriangle.java
│   ├── LC989_AddToArrayFormOfInteger.java
│   ├── LC33_SearchInRotatedSortedArray.java
│   └── LC34_FindFirstAndLastPosition.java
├── 03_Sliding_Window/
│   ├── FixedSizeSlidingWindowMaxSum.java
│   ├── FixedSizeSlidingWindowMaxVowels.java
│   ├── VariableSizeSlidingWindowConstraints.java
│   ├── LongestSubstringWithoutRepeatingChars.java
│   ├── MinimumSizeSubarraySum.java
│   └── CountSubarraysWithinSumLimit.java
├── 04_Sorting_Algorithms/
│   ├── BubbleSort.java
│   ├── SelectionSort.java
│   ├── MergeSort.java
│   ├── QuickSort.java
│   ├── LC912_SortAnArray.java
│   ├── LC75_SortColors.java
│   ├── LC88_MergeSortedArray.java
│   └── LC2418_SortThePeople.java
├── 05_Recursion_and_Backtracking/
│   ├── RecursionPatterns.java
│   ├── LC78_Subsets.java
│   ├── LC17_LetterCombinationsOfPhone.java
│   ├── LC198_HouseRobber.java
│   └── LC401_BinaryWatch.java
├── 06_Singly_Linked_List/
│   ├── SinglyLinkedListOperations.java
│   ├── NthNodeFromEndOfList.java
│   ├── RemoveDuplicatesSortedList.java
│   ├── DeleteMiddleNode.java
│   ├── PalindromeLinkedList.java
│   ├── ReverseNodesInKGroup.java
│   ├── LC707_DesignLinkedList.java
│   ├── LC19_RemoveNthNodeFromEnd.java
│   ├── LC24_SwapNodesInPairs.java
│   ├── LC61_RotateList.java
│   ├── LC141_LinkedListCycle.java
│   ├── LC142_LinkedListCycleII.java
│   ├── LC143_ReorderList.java
│   └── LC1721_SwappingNodesInLinkedList.java
├── 07_Doubly_Linked_List/
│   ├── DoublyLinkedListOperations.java
│   ├── InsertAfterKeyDLL.java
│   ├── DeleteAllOccurrencesDLL.java
│   ├── InPlaceReversalDLL.java
│   ├── SecondLargestInDLL.java
│   └── PalindromeDLLTwoPointers.java
└── 08_Circular_Linked_List/
    ├── CircularLinkedListOperations.java
    ├── CountNodesCLL.java
    ├── SearchElementCLL.java
    ├── InsertAtBeginningCLL.java
    ├── DeleteSpecificNodeCLL.java
    └── MaxElementInCLL.java
```

---

## 📑 Detailed Topic & Problem Catalog

### 1. Core Java & Object-Oriented Programming (OOP)
| File | Problem Description | Key Concepts |
| :--- | :--- | :--- |
| `01_Core_Java_and_OOP/OOPDemonstration.java` | Practical integration of all 4 core OOP principles | Abstraction, Encapsulation, Inheritance, Polymorphism |
| `01_Core_Java_and_OOP/ExceptionHandlingDemo.java` | Robust exception handling with try, catch, finally, custom & multi-catch | ArithmeticException, ArrayIndexOutOfBounds, Custom Exception |
| `01_Core_Java_and_OOP/ArrayListOperations.java` | Core ArrayList operations: CRUD, verification, sorting, iteration | Java Collections Framework, ArrayList |

---

### 2. Arrays, Matrix & Searching Algorithms
| File | Problem / LeetCode | Time Complexity | Space Complexity |
| :--- | :--- | :---: | :---: |
| `02_Arrays_and_Searching/TwoPointerTargetSum.java` | Two-pointer approach for target pair sum in sorted array | $O(N)$ | $O(1)$ |
| `02_Arrays_and_Searching/SpiralMatrixTraversal.java` | Spiral matrix boundary traversal | $O(M \times N)$ | $O(1)$ |
| `02_Arrays_and_Searching/IndexNegationTechnique.java` | Find duplicate & disappeared numbers in $[1, n]$ | $O(N)$ | $O(1)$ |
| `02_Arrays_and_Searching/LinearAndBinarySearch.java` | Linear search and Binary search (Iterative & Recursive) | $O(\log N)$ | $O(1)$ |
| `02_Arrays_and_Searching/FirstAndLastOccurrenceFrequency.java` | First and last position + total frequency count | $O(\log N)$ | $O(1)$ |
| `02_Arrays_and_Searching/LC118_PascalsTriangle.java` | **LeetCode 118**: Pascal's Triangle generation | $O(N^2)$ | $O(1)$ |
| `02_Arrays_and_Searching/LC989_AddToArrayFormOfInteger.java` | **LeetCode 989**: Add to Array-Form of Integer | $O(\max(N, \log K))$ | $O(1)$ |
| `02_Arrays_and_Searching/LC33_SearchInRotatedSortedArray.java` | **LeetCode 33**: Search in Rotated Sorted Array | $O(\log N)$ | $O(1)$ |
| `02_Arrays_and_Searching/LC34_FindFirstAndLastPosition.java` | **LeetCode 34**: Find First and Last Position of Element | $O(\log N)$ | $O(1)$ |

---

### 3. Sliding Window Techniques
| File | Problem / LeetCode | Type | Time | Space |
| :--- | :--- | :---: | :---: | :---: |
| `03_Sliding_Window/FixedSizeSlidingWindowMaxSum.java` | Maximum sum of fixed-size ($k$) subarray | Fixed | $O(N)$ | $O(1)$ |
| `03_Sliding_Window/FixedSizeSlidingWindowMaxVowels.java` | Maximum vowels in substring of size $k$ (LC 1456) | Fixed | $O(N)$ | $O(1)$ |
| `03_Sliding_Window/VariableSizeSlidingWindowConstraints.java` | Longest subarray with sum $\le K$ and at most $K$ distinct | Variable | $O(N)$ | $O(K)$ |
| `03_Sliding_Window/LongestSubstringWithoutRepeatingChars.java` | **LeetCode 3**: Longest Substring Without Repeating Characters | HashSet | $O(N)$ | $O(\min(N, M))$ |
| `03_Sliding_Window/MinimumSizeSubarraySum.java` | **LeetCode 209**: Minimum Size Subarray Sum | Variable | $O(N)$ | $O(1)$ |
| `03_Sliding_Window/CountSubarraysWithinSumLimit.java` | Count valid contiguous subarrays with sum $\le K$ | Variable | $O(N)$ | $O(1)$ |

---

### 4. Sorting Algorithms
| File | Algorithm / Problem | Best Time | Worst Time | Space | Stability |
| :--- | :--- | :---: | :---: | :---: | :---: |
| `04_Sorting_Algorithms/BubbleSort.java` | Bubble Sort with early exit flag | $O(N)$ | $O(N^2)$ | $O(1)$ | Stable |
| `04_Sorting_Algorithms/SelectionSort.java` | Selection Sort | $O(N^2)$ | $O(N^2)$ | $O(1)$ | Unstable |
| `04_Sorting_Algorithms/MergeSort.java` | Merge Sort (Divide and Conquer) | $O(N \log N)$ | $O(N \log N)$ | $O(N)$ | Stable |
| `04_Sorting_Algorithms/QuickSort.java` | Quick Sort (Lomuto Partition) | $O(N \log N)$ | $O(N^2)$ | $O(\log N)$ | Unstable |
| `04_Sorting_Algorithms/LC912_SortAnArray.java` | **LeetCode 912**: Sort an Array (Heap Sort) | $O(N \log N)$ | $O(N \log N)$ | $O(1)$ | Unstable |
| `04_Sorting_Algorithms/LC75_SortColors.java` | **LeetCode 75**: Sort Colors (Dutch National Flag) | $O(N)$ | $O(N)$ | $O(1)$ | In-place |
| `04_Sorting_Algorithms/LC88_MergeSortedArray.java` | **LeetCode 88**: Merge Sorted Array | $O(M+N)$ | $O(M+N)$ | $O(1)$ | In-place |
| `04_Sorting_Algorithms/LC2418_SortThePeople.java` | **LeetCode 2418**: Sort the People (Custom Comparator) | $O(N \log N)$ | $O(N \log N)$ | $O(N)$ | - |

---

### 5. Recursion & Backtracking
| File | Problem / LeetCode | Technique | Time Complexity |
| :--- | :--- | :--- | :---: |
| `05_Recursion_and_Backtracking/RecursionPatterns.java` | Fibonacci, Substrings vs Subsequences, Head vs Tail Recursion | Recursion Patterns | $O(N)$ to $O(2^N)$ |
| `05_Recursion_and_Backtracking/LC78_Subsets.java` | **LeetCode 78**: Subsets (Power Set) | Backtracking / DFS | $O(N \cdot 2^N)$ |
| `05_Recursion_and_Backtracking/LC17_LetterCombinationsOfPhone.java` | **LeetCode 17**: Letter Combinations of a Phone Number | Backtracking | $O(4^N \cdot N)$ |
| `05_Recursion_and_Backtracking/LC198_HouseRobber.java` | **LeetCode 198**: House Robber | Memoization & DP | $O(N)$ |
| `05_Recursion_and_Backtracking/LC401_BinaryWatch.java` | **LeetCode 401**: Binary Watch | Bit Manipulation / Backtracking | $O(1)$ |

---

### 6. Singly Linked List
| File | Problem / LeetCode | Approach | Time | Space |
| :--- | :--- | :--- | :---: | :---: |
| `06_Singly_Linked_List/SinglyLinkedListOperations.java` | Basic Operations: print, count, search, fast-slow mid, reverse | Iterative | $O(N)$ | $O(1)$ |
| `06_Singly_Linked_List/NthNodeFromEndOfList.java` | Find $N$-th node from end | Two-Pointer single pass | $O(N)$ | $O(1)$ |
| `06_Singly_Linked_List/RemoveDuplicatesSortedList.java` | Remove duplicates from sorted linked list | Single Pointer | $O(N)$ | $O(1)$ |
| `06_Singly_Linked_List/DeleteMiddleNode.java` | Delete middle node | Fast & Slow Pointer | $O(N)$ | $O(1)$ |
| `06_Singly_Linked_List/PalindromeLinkedList.java` | Check if linked list is a palindrome | Mid-Reverse & Compare | $O(N)$ | $O(1)$ |
| `06_Singly_Linked_List/ReverseNodesInKGroup.java` | Reverse nodes in groups of $K$ | Dummy node & Pointer reverse | $O(N)$ | $O(1)$ |
| `06_Singly_Linked_List/LC707_DesignLinkedList.java` | **LeetCode 707**: Design Linked List | Node Implementation | $O(1) - O(N)$ | $O(N)$ |
| `06_Singly_Linked_List/LC19_RemoveNthNodeFromEnd.java` | **LeetCode 19**: Remove $N$-th Node From End of List | Two Pointers | $O(N)$ | $O(1)$ |
| `06_Singly_Linked_List/LC24_SwapNodesInPairs.java` | **LeetCode 24**: Swap Nodes in Pairs | Pointer Manipulation | $O(N)$ | $O(1)$ |
| `06_Singly_Linked_List/LC1721_SwappingNodesInLinkedList.java` | **LeetCode 1721**: Swapping Nodes in a Linked List | Single Pass Pointers | $O(N)$ | $O(1)$ |
| `06_Singly_Linked_List/LC61_RotateList.java` | **LeetCode 61**: Rotate List by $k$ places | Circular Ring Technique | $O(N)$ | $O(1)$ |
| `06_Singly_Linked_List/LC143_ReorderList.java` | **LeetCode 143**: Reorder List ($L_0 \to L_n \to L_1 \dots$) | Mid + Reverse + Merge | $O(N)$ | $O(1)$ |
| `06_Singly_Linked_List/LC141_LinkedListCycle.java` | **LeetCode 141**: Linked List Cycle Detection | Floyd's Tortoise & Hare | $O(N)$ | $O(1)$ |
| `06_Singly_Linked_List/LC142_LinkedListCycleII.java` | **LeetCode 142**: Find cycle entry node | Floyd's Cycle Detection II | $O(N)$ | $O(1)$ |

---

### 7. Doubly Linked List (DLL)
| File | Problem Description | Key Concepts | Time | Space |
| :--- | :--- | :--- | :---: | :---: |
| `07_Doubly_Linked_List/DoublyLinkedListOperations.java` | Construction, Forward & Backward Traversal, Insert, Delete | `prev` and `next` pointers | $O(N)$ | $O(1)$ |
| `07_Doubly_Linked_List/InsertAfterKeyDLL.java` | Insert new node after a given key | Node link rewiring | $O(N)$ | $O(1)$ |
| `07_Doubly_Linked_List/DeleteAllOccurrencesDLL.java` | Delete all occurrences of a value | In-place removal | $O(N)$ | $O(1)$ |
| `07_Doubly_Linked_List/InPlaceReversalDLL.java` | In-place reversal of Doubly Linked List | Pointer swapping | $O(N)$ | $O(1)$ |
| `07_Doubly_Linked_List/SecondLargestInDLL.java` | Find 2nd largest element without sorting | Single Pass Traversal | $O(N)$ | $O(1)$ |
| `07_Doubly_Linked_List/PalindromeDLLTwoPointers.java` | Palindrome check using two pointers | Head & Tail convergence | $O(N)$ | $O(1)$ |

---

### 8. Circular Linked List (CLL)
| File | Problem Description | Key Concepts | Time | Space |
| :--- | :--- | :--- | :---: | :---: |
| `08_Circular_Linked_List/CircularLinkedListOperations.java` | Insertion, Reverse print, Middle, Josephus Problem | Circular traversal, Elimination | $O(N)$ | $O(1)$ |
| `08_Circular_Linked_List/CountNodesCLL.java` | Count total nodes in CLL | Do-While Traversal | $O(N)$ | $O(1)$ |
| `08_Circular_Linked_List/SearchElementCLL.java` | Linear search in CLL | Circular Search | $O(N)$ | $O(1)$ |
| `08_Circular_Linked_List/InsertAtBeginningCLL.java` | Insert at the beginning of CLL | Tail and Head pointer update | $O(N)$ | $O(1)$ |
| `08_Circular_Linked_List/DeleteSpecificNodeCLL.java` | Delete a specific node from CLL | Head/Middle/Tail edge cases | $O(N)$ | $O(1)$ |
| `08_Circular_Linked_List/MaxElementInCLL.java` | Find maximum element in CLL | Traversal comparison | $O(N)$ | $O(1)$ |

---

## 🛠️ How to Compile and Run

### Run any individual file:
```bash
# Example 1: Core OOP Demonstration
javac 01_Core_Java_and_OOP/OOPDemonstration.java
java core_java_and_oop.OOPDemonstration

# Example 2: LeetCode 33 Rotated Sorted Array Search
javac 02_Arrays_and_Searching/LC33_SearchInRotatedSortedArray.java
java arrays_and_searching.LC33_SearchInRotatedSortedArray

# Example 3: Merge Sort
javac 04_Sorting_Algorithms/MergeSort.java
java sorting_algorithms.MergeSort
```

---

## 👨‍💻 Quick Git Push Commands

```bash
git init
git add .
git commit -m "feat: complete topic-wise Java DSA solutions, OOP, and LeetCode problems"
git branch -M main
git remote add origin <YOUR_GITHUB_REPO_URL>
git push -u origin main
```

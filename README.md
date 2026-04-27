# Assignment 3: Sorting and Searching Algorithm Analysis System
IT-2501 YERMEK DINMUKHAMBET
## Project Overview

This project analyzes and compares the performance of sorting and searching algorithms in Java.

Selected algorithms:

* Basic Sorting: Bubble Sort
* Advanced Sorting: Quick Sort
* Searching: Binary Search

The goal is to measure execution time and understand how algorithm efficiency changes depending on input size and data type.

---

## Algorithm Descriptions

### Bubble Sort

Bubble Sort repeatedly compares adjacent elements and swaps them if they are in the wrong order.

**Time Complexity:**

* Best: O(n)
* Average: O(n²)
* Worst: O(n²)

---

### Quick Sort

Quick Sort selects a pivot element and partitions the array into smaller and larger elements, then recursively sorts them.

**Time Complexity:**

* Best: O(n log n)
* Average: O(n log n)
* Worst: O(n²)

---

### Binary Search

Binary Search works only on sorted arrays by repeatedly dividing the search range in half.

**Time Complexity:**

* Best: O(1)
* Average/Worst: O(log n)

---


*(Replace "..." with your actual results from the program)*

---

## Analysis

### Which sorting algorithm performed faster? Why?

Quick Sort performed faster than Bubble Sort because it has a better time complexity (O(n log n) vs O(n²)).

### How does performance change with input size?

As the array size increases, Bubble Sort becomes significantly slower, while Quick Sort scales much better.

### How does sorted vs unsorted data affect performance?

Bubble Sort performs faster on sorted arrays because it can stop early. Quick Sort performance is less affected.

### Do the results match the expected Big-O complexity?

Yes, the results generally match theoretical expectations.

### Which searching algorithm is more efficient? Why?

Binary Search is more efficient because it reduces the search space by half each step.

### Why does Binary Search require a sorted array?

Because it relies on comparing the middle element to decide the search direction.

---

## Screenshots

Add screenshots of your program output here:

![Output](docs/screenshots/output1.png)

---

## Reflection

This project helped me understand how different algorithms perform in practice. Bubble Sort is easy to implement but inefficient for large datasets, while Quick Sort is much faster and more scalable.

I also learned how important sorted data is for Binary Search. One of the challenges was correctly measuring execution time and organizing the code into multiple classes.

---

## Conclusion

The experiment confirmed that algorithm efficiency depends heavily on input size and structure. Advanced algorithms like Quick Sort significantly outperform basic ones on larger datasets.

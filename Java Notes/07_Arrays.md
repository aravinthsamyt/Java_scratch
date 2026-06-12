# 7. Arrays in Java

An **array** is a collection of elements of the same data type stored in contiguous memory locations.

---

# 1. Declaration

### Syntax

```java
dataType[] arrayName;
```

Example:

```java
int[] arr;
```

---

# 2. Initialization

### Method 1

```java
int[] arr = new int[5];
```

Creates:

```text
[0, 0, 0, 0, 0]
```

---

### Method 2

```java
int[] arr = {10, 20, 30, 40, 50};
```

---

# 3. Access Elements

Index starts from **0**.

```java
int[] arr = {10,20,30};

System.out.println(arr[0]);
```

Output:

```text
10
```

---

# 4. Modify Elements

```java
arr[1] = 100;
```

Before:

```text
[10,20,30]
```

After:

```text
[10,100,30]
```

---

# 5. Array Length

```java
System.out.println(arr.length);
```

Output:

```text
3
```

⚠️ `length` is a property, not a method.

```java
arr.length     // Correct
arr.length()   // Wrong
```

---

# 6. Traversing Arrays

## Using for Loop

```java
for(int i = 0; i < arr.length; i++){
    System.out.println(arr[i]);
}
```

---

## Using for-each Loop

```java
for(int num : arr){
    System.out.println(num);
}
```

---

# 7. Default Values

```java
int[] arr = new int[3];
```

| Type    | Default Value |
| ------- | ------------- |
| int     | 0             |
| long    | 0             |
| float   | 0.0           |
| double  | 0.0           |
| boolean | false         |
| char    | '\u0000'      |
| String  | null          |

---

# 8. 2D Arrays

### Declaration

```java
int[][] matrix = new int[3][4];
```

3 rows, 4 columns.

---

### Initialization

```java
int[][] matrix = {
    {1,2,3},
    {4,5,6},
    {7,8,9}
};
```

---

### Dimensions

```java
matrix.length
```

Rows:

```text
3
```

```java
matrix[0].length
```

Columns:

```text
3
```

---

### Traversal

```java
for(int i=0;i<matrix.length;i++){
    for(int j=0;j<matrix[i].length;j++){
        System.out.print(matrix[i][j]+" ");
    }
    System.out.println();
}
```

---

# Arrays Utility Class

Import:

```java
import java.util.Arrays;
```

This class provides many useful methods.

---

# 1. Arrays.toString()

Converts array to readable string.

```java
int[] arr = {10,20,30};

System.out.println(Arrays.toString(arr));
```

Output:

```text
[10, 20, 30]
```

Without it:

```java
System.out.println(arr);
```

Output:

```text
[I@15db9742
```

---

# 2. Arrays.sort()

Sorts array in ascending order.

```java
int[] arr = {5,2,8,1};

Arrays.sort(arr);

System.out.println(Arrays.toString(arr));
```

Output:

```text
[1, 2, 5, 8]
```

---

# 3. Arrays.binarySearch()

Array must be sorted.

```java
int[] arr = {10,20,30,40};

int index =
    Arrays.binarySearch(arr,30);

System.out.println(index);
```

Output:

```text
2
```

Not found:

```java
Arrays.binarySearch(arr,25);
```

Output:

```text
-3
```

---

# 4. Arrays.fill()

Fill entire array with same value.

```java
int[] arr = new int[5];

Arrays.fill(arr,100);

System.out.println(Arrays.toString(arr));
```

Output:

```text
[100, 100, 100, 100, 100]
```

---

# 5. Arrays.copyOf()

Copy array.

```java
int[] arr = {1,2,3};

int[] copy =
    Arrays.copyOf(arr, arr.length);
```

---

### Copy with Different Size

```java
int[] copy =
    Arrays.copyOf(arr,5);
```

Output:

```text
[1,2,3,0,0]
```

---

# 6. Arrays.equals()

Compare arrays.

```java
int[] a = {1,2,3};
int[] b = {1,2,3};

System.out.println(
    Arrays.equals(a,b)
);
```

Output:

```text
true
```

---

# 7. Arrays.deepEquals()

Used for 2D arrays.

```java
int[][] a = {{1,2},{3,4}};
int[][] b = {{1,2},{3,4}};

System.out.println(
    Arrays.deepEquals(a,b)
);
```

Output:

```text
true
```

---

# 8. Arrays.deepToString()

Print 2D arrays.

```java
int[][] matrix = {
    {1,2},
    {3,4}
};

System.out.println(
    Arrays.deepToString(matrix)
);
```

Output:

```text
[[1, 2], [3, 4]]
```

---

# 9. Arrays.copyOfRange()

Copy specific range.

```java
int[] arr = {10,20,30,40,50};

int[] copy =
    Arrays.copyOfRange(arr,1,4);

System.out.println(
    Arrays.toString(copy)
);
```

Output:

```text
[20, 30, 40]
```

End index excluded.

---

# Character Arrays

```java
char[] arr = {'a','b','c'};
```

Convert String → char[]

```java
String s = "hello";

char[] arr = s.toCharArray();
```

---

# Array of Strings

```java
String[] names = {
    "Aravinth",
    "Rahul",
    "Kumar"
};
```

Traversal:

```java
for(String name : names){
    System.out.println(name);
}
```

---

# Passing Arrays to Methods

```java
public static void print(int[] arr){

    for(int num : arr){
        System.out.println(num);
    }
}
```

Call:

```java
print(arr);
```

---

# Common Interview Questions

## Maximum Element

```java
int max = Integer.MIN_VALUE;

for(int num : arr){
    max = Math.max(max,num);
}
```

---

## Minimum Element

```java
int min = Integer.MAX_VALUE;

for(int num : arr){
    min = Math.min(min,num);
}
```

---

## Sum of Array

```java
int sum = 0;

for(int num : arr){
    sum += num;
}
```

---

## Reverse Array

```java
int left = 0;
int right = arr.length - 1;

while(left < right){

    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;

    left++;
    right--;
}
```

---

# Time Complexities

| Operation     | Complexity |
| ------------- | ---------- |
| Access        | O(1)       |
| Update        | O(1)       |
| Search        | O(n)       |
| Binary Search | O(log n)   |
| Traversal     | O(n)       |
| Sorting       | O(n log n) |

---

# Quick Revision Notes

```java
arr.length

Arrays.toString(arr)

Arrays.sort(arr)

Arrays.binarySearch(arr,key)

Arrays.fill(arr,value)

Arrays.copyOf(arr,size)

Arrays.copyOfRange(arr,start,end)

Arrays.equals(arr1,arr2)

Arrays.deepEquals(matrix1,matrix2)

Arrays.deepToString(matrix)
```

### Most Used in LeetCode

```java
arr.length

Arrays.sort(arr)

Arrays.toString(arr)

Math.max(a,b)

Math.min(a,b)

String.toCharArray()
```

These are the array methods you'll use most frequently in coding interviews and DSA problems.



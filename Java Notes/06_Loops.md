# 6. Loops in Java

Loops are used to execute a block of code repeatedly.

Java provides:

1. `for` loop
2. `while` loop
3. `do-while` loop
4. Enhanced `for-each` loop
5. `break`
6. `continue`

---

## 1. for Loop

Used when the number of iterations is known.

### Syntax

```java
for(initialization; condition; update){
    // code
}
```

### Example

```java
for(int i = 1; i <= 5; i++){
    System.out.println(i);
}
```

Output:

```text
1
2
3
4
5
```

---

## Flow

```text
Initialization
      ↓
 Condition → false → Exit
      ↓ true
   Execute
      ↓
    Update
      ↓
 Condition
```

---

## Reverse Loop

```java
for(int i = 5; i >= 1; i--){
    System.out.println(i);
}
```

Output:

```text
5
4
3
2
1
```

---

## Multiple Variables

```java
for(int i = 0, j = 10; i < 5; i++, j--){
    System.out.println(i + " " + j);
}
```

---

## Infinite for Loop

```java
for(;;){
    System.out.println("Infinite");
}
```

---

# 2. while Loop

Used when the number of iterations is unknown.

### Syntax

```java
while(condition){
    // code
}
```

### Example

```java
int i = 1;

while(i <= 5){
    System.out.println(i);
    i++;
}
```

Output:

```text
1
2
3
4
5
```

---

## Example: Sum of Numbers

```java
int i = 1;
int sum = 0;

while(i <= 5){
    sum += i;
    i++;
}

System.out.println(sum);
```

Output:

```text
15
```

---

## Infinite while Loop

```java
while(true){
    System.out.println("Infinite");
}
```

---

# 3. do-while Loop

Executes at least once, even if the condition is false.

### Syntax

```java
do{
    // code
}
while(condition);
```

### Example

```java
int i = 1;

do{
    System.out.println(i);
    i++;
}
while(i <= 5);
```

Output:

```text
1
2
3
4
5
```

---

## Difference from while

```java
int i = 10;

while(i < 5){
    System.out.println("Hello");
}
```

Output:

```text
Nothing
```

---

```java
int i = 10;

do{
    System.out.println("Hello");
}
while(i < 5);
```

Output:

```text
Hello
```

Because `do-while` executes first, checks later.

---

# 4. Enhanced for Loop (for-each)

Used for arrays and collections.

### Syntax

```java
for(dataType variable : collection){
    // code
}
```

### Example

```java
int arr[] = {10,20,30,40};

for(int num : arr){
    System.out.println(num);
}
```

Output:

```text
10
20
30
40
```

---

## String Array Example

```java
String names[] = {
    "Aravinth",
    "Rahul",
    "Kumar"
};

for(String name : names){
    System.out.println(name);
}
```

---

## When Not to Use

Cannot directly access index.

❌

```java
for(int num : arr){
    System.out.println(arr[i]);
}
```

Use normal `for` loop when index is needed.

---

# break Statement

Terminates the loop immediately.

### Example

```java
for(int i = 1; i <= 10; i++){

    if(i == 5){
        break;
    }

    System.out.println(i);
}
```

Output:

```text
1
2
3
4
```

---

## break in while

```java
int i = 1;

while(true){

    if(i == 5)
        break;

    System.out.println(i);
    i++;
}
```

---

# continue Statement

Skips current iteration and moves to next iteration.

### Example

```java
for(int i = 1; i <= 5; i++){

    if(i == 3)
        continue;

    System.out.println(i);
}
```

Output:

```text
1
2
4
5
```

---

# Nested Loops

Loop inside another loop.

### Example

```java
for(int i = 1; i <= 3; i++){

    for(int j = 1; j <= 2; j++){

        System.out.println(i + " " + j);
    }
}
```

Output:

```text
1 1
1 2
2 1
2 2
3 1
3 2
```

---

# Pattern Example

```java
for(int i = 1; i <= 3; i++){

    for(int j = 1; j <= 3; j++){
        System.out.print("* ");
    }

    System.out.println();
}
```

Output:

```text
* * *
* * *
* * *
```

---

# Loop Comparison

| Loop     | Condition Checked |
| -------- | ----------------- |
| for      | Before execution  |
| while    | Before execution  |
| do-while | After execution   |

---

# Which Loop to Use?

### for Loop

When iterations are known.

```java
for(int i = 0; i < n; i++)
```

Examples:

* Arrays
* Strings
* Matrix traversal

---

### while Loop

When iterations are unknown.

```java
while(number > 0)
```

Examples:

* Digit extraction
* User input until exit
* Searching

---

### do-while Loop

When code must execute at least once.

Examples:

* Menus
* Repeated user choices

---

# Common Interview Examples

## Sum 1 to N

```java
int sum = 0;

for(int i = 1; i <= n; i++){
    sum += i;
}
```

---

## Reverse Digits

```java
while(n > 0){
    int digit = n % 10;
    System.out.print(digit);

    n /= 10;
}
```

---

## Count Digits

```java
int count = 0;

while(n > 0){
    count++;
    n /= 10;
}
```

---

## Traverse Array

```java
for(int i = 0; i < arr.length; i++){
    System.out.println(arr[i]);
}
```

---

# Quick Revision Notes

```text
for(initialization; condition; update)

while(condition)

do{
}
while(condition);

for(type var : array)

break     -> exits loop
continue  -> skips iteration
```

### Most Used in DSA / LeetCode

```java
for(int i = 0; i < n; i++)

for(int num : arr)

while(n > 0)

break
continue
```

These four (`for`, `for-each`, `while`, `break/continue`) cover almost all loop usage in coding interviews and LeetCode problems.


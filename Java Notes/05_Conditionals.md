# 5. Conditional Statements in Java

Conditional statements allow a program to make decisions based on conditions.

---

## 1. if Statement

Executes a block only if the condition is `true`.

### Syntax

```java
if(condition){
    // code
}
```

### Example

```java
int age = 20;

if(age >= 18){
    System.out.println("Eligible to vote");
}
```

Output:

```
Eligible to vote
```

---

# 2. if-else Statement

Executes one block if the condition is true, otherwise executes another block.

### Syntax

```java
if(condition){
    // true block
}
else{
    // false block
}
```

### Example

```java
int age = 15;

if(age >= 18){
    System.out.println("Adult");
}
else{
    System.out.println("Minor");
}
```

Output:

```text
Minor
```

---

# 3. else-if Ladder

Used when multiple conditions need to be checked.

### Syntax

```java
if(condition1){
    // code
}
else if(condition2){
    // code
}
else if(condition3){
    // code
}
else{
    // code
}
```

### Example

```java
int marks = 85;

if(marks >= 90){
    System.out.println("Grade A");
}
else if(marks >= 80){
    System.out.println("Grade B");
}
else if(marks >= 70){
    System.out.println("Grade C");
}
else{
    System.out.println("Fail");
}
```

Output:

```text
Grade B
```

### Important

Only the **first matching condition** executes.

```java
int x = 100;

if(x > 50)
    System.out.println("A");

else if(x > 80)
    System.out.println("B");
```

Output:

```text
A
```

Even though `x > 80` is true, the first condition matched.

---

# 4. Nested if

An `if` statement inside another `if`.

### Syntax

```java
if(condition1){
    if(condition2){
        // code
    }
}
```

### Example

```java
int age = 20;
boolean hasID = true;

if(age >= 18){
    if(hasID){
        System.out.println("Entry Allowed");
    }
}
```

Output:

```text
Entry Allowed
```

---

### Nested if-else Example

```java
int age = 20;
boolean hasID = false;

if(age >= 18){
    if(hasID){
        System.out.println("Allowed");
    }
    else{
        System.out.println("Bring ID");
    }
}
else{
    System.out.println("Underage");
}
```

Output:

```text
Bring ID
```

---

# 5. switch Statement

Used when comparing a variable against multiple fixed values.

---

## Traditional switch

### Syntax

```java
switch(variable){
    case value1:
        // code
        break;

    case value2:
        // code
        break;

    default:
        // code
}
```

### Example

```java
int day = 3;

switch(day){
    case 1:
        System.out.println("Monday");
        break;

    case 2:
        System.out.println("Tuesday");
        break;

    case 3:
        System.out.println("Wednesday");
        break;

    default:
        System.out.println("Invalid");
}
```

Output:

```text
Wednesday
```

---

# Why break is Important

Without `break`, execution continues into the next cases.

### Example

```java
int x = 2;

switch(x){
    case 1:
        System.out.println("One");

    case 2:
        System.out.println("Two");

    case 3:
        System.out.println("Three");
}
```

Output:

```text
Two
Three
```

This is called **fall-through**.

---

# switch with String

```java
String month = "Jan";

switch(month){
    case "Jan":
        System.out.println("January");
        break;

    case "Feb":
        System.out.println("February");
        break;
}
```

---

# Multiple Cases

```java
char grade = 'B';

switch(grade){
    case 'A':
    case 'B':
        System.out.println("Pass");
        break;

    case 'F':
        System.out.println("Fail");
}
```

Output:

```text
Pass
```

---

# Modern Switch (Java 14+)

### Example

```java
int day = 2;

switch(day){
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    case 3 -> System.out.println("Wednesday");
    default -> System.out.println("Invalid");
}
```

No `break` required.

---

# Common Interview Questions

## Can we use double in switch?

❌ No

```java
double x = 2.5;

switch(x){   // Error
}
```

Allowed types:

```java
byte
short
char
int
String
enum
```

---

## Difference Between if and switch

| if                      | switch                   |
| ----------------------- | ------------------------ |
| Handles ranges          | Handles fixed values     |
| Supports all conditions | Supports equality only   |
| More flexible           | Cleaner for many options |
| Slightly slower         | Often faster             |

### Example

Use `if`

```java
if(marks >= 90)
```

Use `switch`

```java
switch(day)
```

---

# Ternary Operator (Short if-else)

```java
int age = 20;

String result =
    (age >= 18) ? "Adult" : "Minor";

System.out.println(result);
```

Output:

```text
Adult
```

Equivalent:

```java
if(age >= 18)
    result = "Adult";
else
    result = "Minor";
```

---

# Quick Revision Notes

```java
if(condition){
}

if(condition){
}
else{
}

if(condition1){
}
else if(condition2){
}
else{
}

if(condition1){
    if(condition2){
    }
}

switch(variable){
    case value:
        break;

    default:
}
```

### When to Use

```text
Single condition      → if
Two choices           → if-else
Multiple conditions   → else-if ladder
Condition inside condition → nested if
Many fixed values     → switch
Short if-else         → ternary operator
```

For LeetCode and interviews, you'll mostly use:

* `if`
* `if-else`
* `else-if`
* Ternary operator `? :`

`switch` appears less often in algorithm problems but is common in application development.


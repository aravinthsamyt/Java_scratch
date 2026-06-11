# Java Operators

---

# 1. Arithmetic Operators

Used for mathematical calculations.

| Operator | Meaning             | Example |
| -------- | ------------------- | ------- |
| +        | Addition            | `a + b` |
| -        | Subtraction         | `a - b` |
| *        | Multiplication      | `a * b` |
| /        | Division            | `a / b` |
| %        | Modulus (Remainder) | `a % b` |
| ++       | Increment           | `a++`   |
| --       | Decrement           | `a--`   |

### Example

```java
int a = 10;
int b = 3;

System.out.println(a + b); // 13
System.out.println(a - b); // 7
System.out.println(a * b); // 30
System.out.println(a / b); // 3
System.out.println(a % b); // 1
```

### Increment & Decrement

```java
int x = 5;

System.out.println(x++); // 5 (post-increment)
System.out.println(x);   // 6

System.out.println(++x); // 7 (pre-increment)
```

---

# 2. Relational Operators

Used to compare two values.

| Operator | Meaning                  |
| -------- | ------------------------ |
| ==       | Equal to                 |
| !=       | Not Equal to             |
| >        | Greater than             |
| <        | Less than                |
| >=       | Greater than or Equal to |
| <=       | Less than or Equal to    |

### Example

```java
int a = 10;
int b = 20;

System.out.println(a == b); // false
System.out.println(a != b); // true
System.out.println(a > b);  // false
System.out.println(a < b);  // true
System.out.println(a >= b); // false
System.out.println(a <= b); // true
```

---

# 3. Logical Operators

Used with boolean expressions.

| Operator | Meaning     |
| -------- | ----------- |
| &&       | Logical AND |
| ||       | Logical OR  |
| !        | Logical NOT |

### Example

```java
int age = 20;
boolean hasID = true;

System.out.println(age >= 18 && hasID);
// true

System.out.println(age < 18 || hasID);
// true

System.out.println(!hasID);
// false
```

### Truth Table

| A | B | A && B | A || B |
| - | - | ------ | ------ |
| T | T | T      | T      |
| T | F | F      | T      |
| F | T | F      | T      |
| F | F | F      | F      |

---

# 4. Assignment Operators

Used to assign values.

| Operator | Example  | Equivalent  |
| -------- | -------- | ----------- |
| =        | `a = 5`  | Assign      |
| +=       | `a += 2` | `a = a + 2` |
| -=       | `a -= 2` | `a = a - 2` |
| *=       | `a *= 2` | `a = a * 2` |
| /=       | `a /= 2` | `a = a / 2` |
| %=       | `a %= 2` | `a = a % 2` |

### Example

```java
int a = 10;

a += 5;  // 15
a -= 3;  // 12
a *= 2;  // 24
a /= 4;  // 6
a %= 4;  // 2
```

---

# 5. Bitwise Operators

Operate on binary bits.

| Operator | Meaning              |
| -------- | -------------------- |
| &        | Bitwise AND          |
| |        | Bitwise OR           |
| ^        | Bitwise XOR          |
| ~        | Bitwise NOT          |
| <<       | Left Shift           |
| >>       | Right Shift          |
| >>>      | Unsigned Right Shift |

### Bitwise AND (&)

```java
int a = 5;  // 0101
int b = 3;  // 0011

System.out.println(a & b);
```

Output:

```text
1
```

Explanation:

```text
0101
0011
----
0001
```

---

### Bitwise OR (|)

```java
int a = 5;
int b = 3;

System.out.println(a | b);
```

Output:

```text
7
```

```text
0101
0011
----
0111
```

---

### Bitwise XOR (^)

```java
int a = 5;
int b = 3;

System.out.println(a ^ b);
```

Output:

```text
6
```

```text
0101
0011
----
0110
```

---

### Bitwise NOT (~)

```java
int a = 5;

System.out.println(~a);
```

Output:

```text
-6
```

Formula:

```text
~n = -(n+1)
```

---

### Left Shift (<<)

```java
int a = 5;

System.out.println(a << 1);
```

Output:

```text
10
```

```text
5 = 0101
Shift left by 1

1010 = 10
```

Formula:

```text
a << n = a × 2ⁿ
```

---

### Right Shift (>>)

```java
int a = 20;

System.out.println(a >> 2);
```

Output:

```text
5
```

Formula:

```text
a >> n = a / 2ⁿ
```

---

# 6. Ternary Operator

Short form of `if-else`.

### Syntax

```java
condition ? value1 : value2;
```

### Example

```java
int a = 10;
int b = 20;

int max = (a > b) ? a : b;

System.out.println(max);
```

Output:

```text
20
```

### Equivalent If-Else

```java
int max;

if(a > b){
    max = a;
}
else{
    max = b;
}
```

---

# Quick Revision Sheet

```text
Arithmetic
+  -  *  /  %  ++  --

Relational
==  !=  >  <  >=  <=

Logical
&&  ||  !

Assignment
=  +=  -=  *=  /=  %=

Bitwise
&  |  ^  ~  <<  >>  >>>

Ternary
condition ? trueValue : falseValue
```

For coding interviews and LeetCode, make sure you're especially comfortable with:

* Arithmetic (`+`, `-`, `%`)
* Relational (`==`, `<`, `>`)
* Logical (`&&`, `||`)
* Assignment (`+=`)
* Bitwise (`&`, `|`, `^`, `<<`, `>>`)
* Ternary (`? :`)

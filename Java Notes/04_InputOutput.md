# 4. Input and Output in Java

Input and Output (I/O) allows a program to receive data from the user and display results.

---

# 1. Scanner Class

The `Scanner` class is the most commonly used way to take input in Java.

### Import

```java
import java.util.Scanner;
```

### Create Scanner Object

```java
Scanner sc = new Scanner(System.in);
```

---

## Reading Different Data Types

### Integer Input

```java
Scanner sc = new Scanner(System.in);

int age = sc.nextInt();

System.out.println(age);
```

Input:

```text
21
```

Output:

```text
21
```

---

### Double Input

```java
double salary = sc.nextDouble();
```

---

### Float Input

```java
float marks = sc.nextFloat();
```

---

### Long Input

```java
long population = sc.nextLong();
```

---

### Boolean Input

```java
boolean status = sc.nextBoolean();
```

Input:

```text
true
```

---

### Character Input

Scanner does not have `nextChar()`.

```java
char ch = sc.next().charAt(0);
```

Input:

```text
A
```

Output:

```text
A
```

---

### String Input (Single Word)

```java
String name = sc.next();
```

Input:

```text
Aravinth
```

Output:

```text
Aravinth
```

---

### String Input (Full Line)

```java
String sentence = sc.nextLine();
```

Input:

```text
I love Java
```

Output:

```text
I love Java
```

---

## Common Scanner Issue

### Problem

```java
Scanner sc = new Scanner(System.in);

int age = sc.nextInt();
String name = sc.nextLine();

System.out.println(name);
```

Input:

```text
21
Aravinth
```

Output:

```text
```

(Name becomes empty)

### Solution

```java
int age = sc.nextInt();
sc.nextLine();   // consume newline

String name = sc.nextLine();
```

---

## Multiple Inputs

```java
Scanner sc = new Scanner(System.in);

int id = sc.nextInt();
String name = sc.next();
double cgpa = sc.nextDouble();

System.out.println(id + " " + name + " " + cgpa);
```

---

# 2. BufferedReader

Faster than Scanner.

Used in competitive programming and large inputs.

### Import

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
```

---

## Create Object

```java
BufferedReader br =
    new BufferedReader(
        new InputStreamReader(System.in)
    );
```

---

## Read String

```java
String name = br.readLine();
```

---

## Read Integer

```java
int n = Integer.parseInt(br.readLine());
```

Input:

```text
100
```

Output:

```text
100
```

---

## Read Double

```java
double d =
    Double.parseDouble(br.readLine());
```

---

## Read Long

```java
long l =
    Long.parseLong(br.readLine());
```

---

## Read Multiple Integers

Input:

```text
10 20 30
```

Code:

```java
String[] arr = br.readLine().split(" ");

int a = Integer.parseInt(arr[0]);
int b = Integer.parseInt(arr[1]);
int c = Integer.parseInt(arr[2]);
```

---

## Example

```java
import java.io.*;

public class Main {
    public static void main(String[] args)
    throws IOException {

        BufferedReader br =
            new BufferedReader(
                new InputStreamReader(System.in));

        int n =
            Integer.parseInt(br.readLine());

        System.out.println(n);
    }
}
```

---

# Scanner vs BufferedReader

| Feature                        | Scanner        | BufferedReader |
| ------------------------------ | -------------- | -------------- |
| Speed                          | Slow           | Fast           |
| Easy to Use                    | Yes            | Moderate       |
| Competitive Programming        | Less Preferred | Preferred      |
| Reads Primitive Types Directly | Yes            | No             |
| Parsing Needed                 | No             | Yes            |

---

# 3. Printing Methods

Used to display output on screen.

---

## print()

Prints on same line.

```java
System.out.print("Hello");
System.out.print("World");
```

Output:

```text
HelloWorld
```

---

## println()

Prints and moves cursor to next line.

```java
System.out.println("Hello");
System.out.println("World");
```

Output:

```text
Hello
World
```

---

## printf()

Formatted Output.

### Syntax

```java
System.out.printf(format, values);
```

---

### Integer

```java
int age = 21;

System.out.printf("%d", age);
```

Output:

```text
21
```

---

### String

```java
String name = "Aravinth";

System.out.printf("%s", name);
```

Output:

```text
Aravinth
```

---

### Float / Double

```java
double pi = 3.14159;

System.out.printf("%.2f", pi);
```

Output:

```text
3.14
```

---

### Multiple Values

```java
String name = "Aravinth";
int age = 21;

System.out.printf(
    "Name: %s Age: %d",
    name,
    age
);
```

Output:

```text
Name: Aravinth Age: 21
```

---

# Common Format Specifiers

| Specifier | Meaning      |
| --------- | ------------ |
| %d        | Integer      |
| %f        | Float/Double |
| %s        | String       |
| %c        | Character    |
| %b        | Boolean      |
| %n        | New Line     |

---

### Example

```java
char grade = 'A';
boolean pass = true;

System.out.printf(
    "Grade: %c Pass: %b",
    grade,
    pass
);
```

Output:

```text
Grade: A Pass: true
```

---

# Quick Revision Notes

```text
Scanner
-------
nextInt()
nextDouble()
nextFloat()
nextLong()
next()
nextLine()
next().charAt(0)

BufferedReader
--------------
readLine()

Integer.parseInt()
Double.parseDouble()
Long.parseLong()

Printing
--------
System.out.print()
System.out.println()
System.out.printf()

Format Specifiers
-----------------
%d -> int
%f -> double/float
%s -> String
%c -> char
%b -> boolean
%n -> new line
```

### Interview Question

**Which input method should I use?**

* Learning Java / interviews → **Scanner**
* Competitive Programming / large input → **BufferedReader**
* Modern CP templates often use **BufferedReader + StringTokenizer** for maximum speed.

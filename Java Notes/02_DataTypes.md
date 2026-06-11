# Data Types

Java has two main categories of data types: **Primitive** and **Non-Primitive**.

## Primitive Data Types
Primitive data types are predefined by the language and named by a reserved keyword. There are 8 primitive data types in Java:

*   `byte` (1 byte): Stores whole numbers from -128 to 127
*   `short` (2 bytes): Stores whole numbers from -32,768 to 32,767
*   `int` (4 bytes): Stores whole numbers from -2,147,483,648 to 2,147,483,647
*   `long` (8 bytes): Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
*   `float` (4 bytes): Stores fractional numbers (6 to 7 decimal digits)
*   `double` (8 bytes): Stores fractional numbers (15 decimal digits)
*   `char` (2 bytes): Stores a single character/letter or ASCII values
*   `boolean` (1 bit): Stores `true` or `false` values

## Non-Primitive Data Types
Non-primitive data types are created by the programmer and are not defined by Java (except for `String`). They are used to call methods to perform certain operations. Examples include:
*   Classes (e.g., custom classes, `String`)
*   Arrays
*   Interfaces

Here is a basic starting program (`Main.java`):

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

---

## Type Casting
Type casting is when you assign a value of one primitive data type to another type. In Java, there are two types of casting:

### 1. Widening Casting (Implicit Casting)
Converting a smaller data type into a larger data type automatically.

**Order of Widening:**
`byte` → `short` → `int` → `long` → `float` → `double`  
(Also: `char` → `int` → `long` → `float` → `double`)

#### Example:
```java
int num = 100;
double d = num;  // Automatic casting: int to double

System.out.println(num); // Output: 100
System.out.println(d);   // Output: 100.0
```

### 2. Narrowing Casting (Explicit Casting)
Converting a larger data type into a smaller data type manually by placing the target type in parentheses `()` in front of the value.

#### Example:
```java
double d = 9.78;
int num = (int) d; // Manual casting: double to int

System.out.println(d);   // Output: 9.78
System.out.println(num); // Output: 9
```

#### More Examples:
```java
long l = 1000;
int i = (int) l; // long to int

int x = 130;
byte b = (byte) x; // int to byte (overflow occurs)

System.out.println(b); // Output: -126
```

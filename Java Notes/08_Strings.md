# 8. Strings in Java

A **String** is a sequence of characters.

```java
String name = "Malar";
```

Strings are one of the most frequently used data types in Java and are **immutable**.

---

# 1. Creating Strings

### String Literal (Recommended)

```java
String s = "Hello";
```

Stored in the **String Pool**.

---

### Using new Keyword

```java
String s = new String("Hello");
```

Creates a new object in heap memory.

---

# 2. String Length

```java
String s = "Hello";

System.out.println(s.length());
```

Output:

```text
5
```

---

# 3. Access Characters

```java
String s = "Hello";

System.out.println(s.charAt(0));
```

Output:

```text
H
```

---

# 4. Traverse String

```java
String s = "Hello";

for(int i=0;i<s.length();i++){
    System.out.println(s.charAt(i));
}
```

---

# 5. String to Character Array

```java
String s = "Hello";

char[] arr = s.toCharArray();
```

Output:

```text
['H','e','l','l','o']
```

---

# 6. Character Array to String

```java
char[] arr = {'H','e','l','l','o'};

String s = new String(arr);
```

---

# Important String Methods

---

# 1. length()

Returns string length.

```java
String s = "Java";

System.out.println(s.length());
```

Output:

```text
4
```

---

# 2. charAt()

Returns character at index.

```java
String s = "Java";

System.out.println(s.charAt(2));
```

Output:

```text
v
```

---

# 3. substring()

Extract part of string.

```java
String s = "Programming";

System.out.println(s.substring(3));
```

Output:

```text
gramming
```

---

```java
System.out.println(s.substring(3,7));
```

Output:

```text
gram
```

End index excluded.

---

# 4. equals()

Compare contents.

```java
String a = "Java";
String b = "Java";

System.out.println(a.equals(b));
```

Output:

```text
true
```

---

# 5. equalsIgnoreCase()

```java
String a = "JAVA";
String b = "java";

System.out.println(
    a.equalsIgnoreCase(b)
);
```

Output:

```text
true
```

---

# 6. compareTo()

Lexicographical comparison.

```java
System.out.println(
    "apple".compareTo("banana")
);
```

Output:

```text
negative value
```

---

```java
"banana".compareTo("apple")
```

Output:

```text
positive value
```

---

```java
"apple".compareTo("apple")
```

Output:

```text
0
```

---

# 7. contains()

```java
String s = "Hello Java";

System.out.println(
    s.contains("Java")
);
```

Output:

```text
true
```

---

# 8. startsWith()

```java
String s = "Programming";

System.out.println(
    s.startsWith("Pro")
);
```

Output:

```text
true
```

---

# 9. endsWith()

```java
System.out.println(
    s.endsWith("ing")
);
```

Output:

```text
true
```

---

# 10. indexOf()

Returns first occurrence.

```java
String s = "banana";

System.out.println(
    s.indexOf('a')
);
```

Output:

```text
1
```

---

# 11. lastIndexOf()

```java
System.out.println(
    s.lastIndexOf('a')
);
```

Output:

```text
5
```

---

# 12. toUpperCase()

```java
String s = "java";

System.out.println(
    s.toUpperCase()
);
```

Output:

```text
JAVA
```

---

# 13. toLowerCase()

```java
String s = "JAVA";

System.out.println(
    s.toLowerCase()
);
```

Output:

```text
java
```

---

# 14. trim()

Removes leading and trailing spaces.

```java
String s = "   Java   ";

System.out.println(
    s.trim()
);
```

Output:

```text
Java
```

---

# 15. replace()

```java
String s = "banana";

System.out.println(
    s.replace('a','x')
);
```

Output:

```text
bxnxnx
```

---

# 16. split()

```java
String s = "Java Python C++";

String[] arr =
    s.split(" ");
```

Output:

```text
["Java","Python","C++"]
```

---

# 17. isEmpty()

```java
String s = "";

System.out.println(
    s.isEmpty()
);
```

Output:

```text
true
```

---

# String Comparison

## Wrong

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a == b);
```

Output:

```text
false
```

`==` compares references.

---

## Correct

```java
System.out.println(
    a.equals(b)
);
```

Output:

```text
true
```

`equals()` compares content.

---

# Immutable Strings

A String cannot be modified after creation.

```java
String s = "Hello";

s.concat(" World");

System.out.println(s);
```

Output:

```text
Hello
```

Nothing changed.

---

### Correct

```java
String s = "Hello";

s = s.concat(" World");

System.out.println(s);
```

Output:

```text
Hello World
```

---

# Why Strings Are Immutable

Benefits:

```text
Security
Thread Safety
String Pool Optimization
HashMap Efficiency
```

---

# Mutable vs Immutable

## Immutable

Cannot change after creation.

Examples:

```java
String
Integer
Double
Character
```

---

## Mutable

Can change after creation.

Examples:

```java
StringBuilder
StringBuffer
ArrayList
HashMap
```

---

# StringBuilder (Mutable)

Used when frequent modifications are needed.

```java
StringBuilder sb =
    new StringBuilder("Hello");

sb.append(" World");

System.out.println(sb);
```

Output:

```text
Hello World
```

---

# StringBuilder Methods

---

## append()

```java
sb.append("Java");
```

---

## insert()

```java
sb.insert(5," ");
```

---

## delete()

```java
sb.delete(0,2);
```

---

## reverse()

```java
sb.reverse();
```

---

## replace()

```java
sb.replace(0,5,"Hi");
```

---

## charAt()

```java
sb.charAt(0);
```

---

## setCharAt()

```java
sb.setCharAt(0,'A');
```

---

## length()

```java
sb.length();
```

---

## toString()

```java
String s = sb.toString();
```

---

# StringBuffer

Same as StringBuilder but thread-safe.

```java
StringBuffer sb =
    new StringBuffer("Java");
```

---

# StringBuilder vs StringBuffer

| Feature     | StringBuilder | StringBuffer |
| ----------- | ------------- | ------------ |
| Thread Safe | No            | Yes          |
| Faster      | Yes           | No           |
| Most Common | Yes           | Less Common  |

---

# String Pool

```java
String a = "Java";
String b = "Java";
```

Both point to same object.

```java
System.out.println(a == b);
```

Output:

```text
true
```

---

```java
String a = new String("Java");
String b = new String("Java");
```

Output:

```java
a == b
```

```text
false
```

Different objects.

---

# Common Interview Questions

## Reverse String

### Using StringBuilder

```java
String s = "hello";

String rev =
    new StringBuilder(s)
    .reverse()
    .toString();
```

---

## Count Characters

```java
for(int i=0;i<s.length();i++){
    char ch = s.charAt(i);
}
```

---

## Check Palindrome

```java
String rev =
    new StringBuilder(s)
    .reverse()
    .toString();

System.out.println(
    s.equals(rev)
);
```

---

# Time Complexity

| Operation | String | StringBuilder |
| --------- | ------ | ------------- |
| Append    | O(n)   | O(1)          |
| Modify    | O(n)   | O(1)          |
| charAt    | O(1)   | O(1)          |
| Length    | O(1)   | O(1)          |

---

# Quick Revision Notes

```java
length()

charAt(i)

substring(start,end)

equals()

equalsIgnoreCase()

compareTo()

contains()

startsWith()

endsWith()

indexOf()

lastIndexOf()

toUpperCase()

toLowerCase()

trim()

replace()

split()

isEmpty()

toCharArray()
```

### Mutable Classes

```java
StringBuilder
StringBuffer
ArrayList
HashMap
```

### Immutable Classes

```java
String
Integer
Double
Character
```

### Most Used in LeetCode

```java
s.length()

s.charAt(i)

s.toCharArray()

s.substring()

s.indexOf()

s.equals()

s.split()

new StringBuilder(s).reverse()
```

If you're preparing for interviews and DSA, focus especially on:

* `charAt()`
* `length()`
* `substring()`
* `indexOf()`
* `equals()`
* `toCharArray()`
* `StringBuilder` (`append`, `reverse`, `toString`)

These appear in a large percentage of string-based coding problems.

# mutability and immutability

There are only **three** string-related classes you commonly need to know:

1. `String`
2. `StringBuilder`
3. `StringBuffer`

---

# Quick Comparison

| Feature          | String                   | StringBuilder | StringBuffer              |
| ---------------- | ------------------------ | ------------- | ------------------------- |
| Mutable          | ❌ No                     | ✅ Yes         | ✅ Yes                     |
| Thread Safe      | ✅ Yes (immutable)        | ❌ No          | ✅ Yes                     |
| Performance      | Slow for modifications   | Fastest       | Slower than StringBuilder |
| Memory Efficient | No (creates new objects) | Yes           | Yes                       |
| Common Usage     | General strings          | DSA, LeetCode | Multithreading            |

---

# 1. String (Immutable)

Once created, it cannot be changed.

```java
String s = "Hello";

s.concat(" World");

System.out.println(s);
```

Output:

```text
Hello
```

No change occurred.

---

### What Actually Happens?

```java
String s = "Hello";

s = s.concat(" World");
```

Java creates a **new String object**:

```text
"Hello"
   ↓
"Hello World"
```

Old object remains unchanged.

---

# 2. StringBuilder (Mutable)

Can modify the same object.

```java
StringBuilder sb =
    new StringBuilder("Hello");

sb.append(" World");

System.out.println(sb);
```

Output:

```text
Hello World
```

No new object created.

---

# Why Use StringBuilder?

Consider:

```java
String s = "";

for(int i=0;i<10000;i++){
    s += i;
}
```

Creates thousands of new String objects.

---

Better:

```java
StringBuilder sb =
    new StringBuilder();

for(int i=0;i<10000;i++){
    sb.append(i);
}
```

Uses the same object.

Much faster.

---

# 3. StringBuffer (Mutable + Thread Safe)

Same as `StringBuilder`.

Difference:

```text
StringBuilder → Not Thread Safe
StringBuffer  → Thread Safe
```

Example:

```java
StringBuffer sb =
    new StringBuffer("Hello");

sb.append(" World");

System.out.println(sb);
```

Output:

```text
Hello World
```

---

# Why is StringBuffer Slower?

Every method is synchronized.

```java
public synchronized StringBuffer append(...)
```

Synchronization adds overhead.

---

# Common Methods

These methods are available in **both StringBuilder and StringBuffer**.

---

## append()

Add text at end.

```java
StringBuilder sb =
    new StringBuilder("Java");

sb.append(" Programming");

System.out.println(sb);
```

Output:

```text
Java Programming
```

---

## insert()

Insert at position.

```java
StringBuilder sb =
    new StringBuilder("Jva");

sb.insert(1,"a");

System.out.println(sb);
```

Output:

```text
Java
```

---

## delete()

Delete range.

```java
StringBuilder sb =
    new StringBuilder("Hello");

sb.delete(1,4);

System.out.println(sb);
```

Output:

```text
Ho
```

(Removes `ell`)

---

## deleteCharAt()

```java
StringBuilder sb =
    new StringBuilder("Java");

sb.deleteCharAt(1);

System.out.println(sb);
```

Output:

```text
Jva
```

---

## replace()

```java
StringBuilder sb =
    new StringBuilder("Hello");

sb.replace(0,5,"Java");

System.out.println(sb);
```

Output:

```text
Java
```

---

## reverse()

Very important in LeetCode.

```java
StringBuilder sb =
    new StringBuilder("hello");

sb.reverse();

System.out.println(sb);
```

Output:

```text
olleh
```

---

## charAt()

```java
StringBuilder sb =
    new StringBuilder("Java");

System.out.println(
    sb.charAt(2)
);
```

Output:

```text
v
```

---

## setCharAt()

Modify character.

```java
StringBuilder sb =
    new StringBuilder("Java");

sb.setCharAt(0,'K');

System.out.println(sb);
```

Output:

```text
Kava
```

---

## length()

```java
StringBuilder sb =
    new StringBuilder("Hello");

System.out.println(
    sb.length()
);
```

Output:

```text
5
```

---

## capacity()

Returns current capacity.

```java
StringBuilder sb =
    new StringBuilder();

System.out.println(
    sb.capacity()
);
```

Output:

```text
16
```

Default capacity = 16.

---

## toString()

Convert Builder/Buffer to String.

```java
StringBuilder sb =
    new StringBuilder("Java");

String s = sb.toString();
```

---

# Example: Reverse String

```java
String s = "hello";

String rev =
    new StringBuilder(s)
        .reverse()
        .toString();

System.out.println(rev);
```

Output:

```text
olleh
```

---

# Example: Build String Efficiently

```java
StringBuilder sb =
    new StringBuilder();

for(int i=1;i<=5;i++){
    sb.append(i);
}

System.out.println(sb);
```

Output:

```text
12345
```

---

# Interview Question

### Which should I use?

#### Use String

```java
String name = "Aravinth";
```

When value rarely changes.

---

#### Use StringBuilder

```java
StringBuilder sb =
    new StringBuilder();
```

For:

* LeetCode
* DSA
* Frequent modifications
* String construction

Most common choice.

---

#### Use StringBuffer

```java
StringBuffer sb =
    new StringBuffer();
```

Only when multiple threads modify the same string.

Rare in interviews.

---

# Quick Revision

```java
String
------
Immutable

length()
charAt()
substring()
equals()

StringBuilder
-------------
Mutable
Fast

append()
insert()
delete()
deleteCharAt()
replace()
reverse()
charAt()
setCharAt()
length()
capacity()
toString()

StringBuffer
------------
Same methods as StringBuilder
Thread Safe
Slower
```

### What you'll use most in LeetCode

```java
StringBuilder sb =
    new StringBuilder();

sb.append()

sb.reverse()

sb.toString()

sb.charAt()

sb.setCharAt()
```

In practice:

* **90% of interview problems** → `String` + `StringBuilder`
* **Almost never needed in LeetCode** → `StringBuffer`


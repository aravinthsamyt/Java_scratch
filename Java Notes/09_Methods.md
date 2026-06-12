# 08.String Methods Overview

```java
String s = "Malar";
```

| Method                 | Purpose                   | Example                      |
| ---------------------- | ------------------------- | ---------------------------- |
| `length()`             | Length of string          | `s.length()`                 |
| `charAt(i)`            | Character at index        | `s.charAt(0)`                |
| `substring(start)`     | Extract from start to end | `s.substring(5)`             |
| `substring(start,end)` | Extract range             | `s.substring(0,4)`           |
| `equals()`             | Compare content           | `s.equals("Java")`           |
| `equalsIgnoreCase()`   | Ignore case comparison    | `s.equalsIgnoreCase("java")` |
| `compareTo()`          | Lexicographical compare   | `"a".compareTo("b")`         |
| `contains()`           | Check substring           | `s.contains("Java")`         |
| `startsWith()`         | Prefix check              | `s.startsWith("Java")`       |
| `endsWith()`           | Suffix check              | `s.endsWith("ing")`          |
| `indexOf()`            | First occurrence          | `s.indexOf('a')`             |
| `lastIndexOf()`        | Last occurrence           | `s.lastIndexOf('a')`         |
| `toUpperCase()`        | Uppercase                 | `s.toUpperCase()`            |
| `toLowerCase()`        | Lowercase                 | `s.toLowerCase()`            |
| `trim()`               | Remove edge spaces        | `s.trim()`                   |
| `replace()`            | Replace chars/string      | `s.replace('a','x')`         |
| `split()`              | Convert to array          | `s.split(" ")`               |
| `isEmpty()`            | Length == 0               | `s.isEmpty()`                |
| `toCharArray()`        | Convert to char[]         | `s.toCharArray()`            |

---

# StringBuilder / StringBuffer Methods Overview

```java
StringBuilder sb =
    new StringBuilder("Java");
```

(`StringBuffer` has the same methods.)

| Method           | Purpose              | Example                    |
| ---------------- | -------------------- | -------------------------- |
| `append()`       | Add at end           | `sb.append(" Dev")`        |
| `insert()`       | Insert at index      | `sb.insert(4," ")`         |
| `delete()`       | Delete range         | `sb.delete(1,3)`           |
| `deleteCharAt()` | Delete one character | `sb.deleteCharAt(0)`       |
| `replace()`      | Replace range        | `sb.replace(0,4,"Python")` |
| `reverse()`      | Reverse string       | `sb.reverse()`             |
| `charAt()`       | Get character        | `sb.charAt(0)`             |
| `setCharAt()`    | Modify character     | `sb.setCharAt(0,'K')`      |
| `length()`       | Current length       | `sb.length()`              |
| `capacity()`     | Internal capacity    | `sb.capacity()`            |
| `toString()`     | Convert to String    | `sb.toString()`            |

---

# Arrays Class Methods Overview

```java
import java.util.Arrays;
```

| Method                         | Purpose                |
| ------------------------------ | ---------------------- |
| `Arrays.sort(arr)`             | Sort array             |
| `Arrays.toString(arr)`         | Print array            |
| `Arrays.binarySearch(arr,key)` | Search in sorted array |
| `Arrays.fill(arr,val)`         | Fill array             |
| `Arrays.copyOf(arr,n)`         | Copy array             |
| `Arrays.copyOfRange(arr,s,e)`  | Copy range             |
| `Arrays.equals(a,b)`           | Compare arrays         |
| `Arrays.deepEquals(a,b)`       | Compare 2D arrays      |
| `Arrays.deepToString(arr)`     | Print 2D array         |

---

# Math Class Methods Overview

```java
Math.max(a,b)
Math.min(a,b)
Math.abs(x)
Math.sqrt(x)
Math.pow(a,b)
Math.ceil(x)
Math.floor(x)
Math.round(x)
Math.random()
```

Examples:

```java
Math.max(10,20);    // 20
Math.min(10,20);    // 10
Math.abs(-5);       // 5
Math.sqrt(25);      // 5.0
Math.pow(2,3);      // 8.0
```

---

# Character Class Methods Overview

Very important for String problems.

```java
Character.isDigit(ch)
Character.isLetter(ch)
Character.isUpperCase(ch)
Character.isLowerCase(ch)
Character.toUpperCase(ch)
Character.toLowerCase(ch)
```

Example:

```java
char ch = 'a';

Character.toUpperCase(ch);
```

Output:

```text
A
```

---

# Frequently Used in LeetCode

### Strings

```java
s.length()
s.charAt(i)
s.substring()
s.equals()
s.indexOf()
s.toCharArray()
```

### StringBuilder

```java
append()
reverse()
toString()
setCharAt()
```

### Arrays

```java
Arrays.sort()
Arrays.toString()
```

### Math

```java
Math.max()
Math.min()
Math.abs()
```

### Character

```java
Character.isDigit()
Character.isLetter()
Character.toLowerCase()
Character.toUpperCase()
```

# If you're preparing for placements, memorize these 15 methods first:

```java
length()
charAt()
substring()
equals()
split()
toCharArray()

append()
reverse()
toString()

Arrays.sort()
Arrays.toString()

Math.max()
Math.min()

Character.isDigit()
Character.isLetter()
```

These alone cover a very large portion of beginner-to-intermediate Java interview and LeetCode questions.



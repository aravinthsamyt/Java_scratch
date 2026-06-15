# 17.Exception Handling in Java (Complete Interview + Placement Notes)

---

# Why Exception Handling?

Without exception handling:

```java
System.out.println("Start");

int result = 10 / 0;

System.out.println("End");
```

Output:

```text
Start
Exception in thread "main"
ArithmeticException
```

Program crashes.

---

With exception handling:

```java
System.out.println("Start");

try{
    int result = 10 / 0;
}
catch(Exception e){
    System.out.println("Error");
}

System.out.println("End");
```

Output:

```text
Start
Error
End
```

Program continues.

---

# Exception Hierarchy

```text
Object
   |
Throwable
   |
-------------------
|                 |
Error         Exception
                  |
      ---------------------
      |                   |
Checked          Unchecked
Exceptions       Exceptions
```

---

# Error vs Exception

## Error

Serious problems.

Examples:

```text
OutOfMemoryError
StackOverflowError
```

Normally you don't handle them.

---

## Exception

Problems that can be handled.

Examples:

```text
ArithmeticException
IOException
NullPointerException
```

---

# Checked vs Unchecked Exceptions

This is a very common interview question.

---

## Checked Exceptions

Checked by compiler.

Must be handled.

Examples:

```text
IOException
FileNotFoundException
SQLException
ClassNotFoundException
```

Example:

```java
FileReader fr =
    new FileReader("test.txt");
```

Compiler forces handling.

---

## Unchecked Exceptions

Occur at runtime.

Examples:

```text
ArithmeticException
NullPointerException
ArrayIndexOutOfBoundsException
NumberFormatException
```

Example:

```java
int x = 10 / 0;
```

Compiles successfully.

Fails at runtime.

---

# Common Runtime Exceptions

---

## ArithmeticException

```java
int x = 10 / 0;
```

Output:

```text
ArithmeticException
```

---

## NullPointerException

```java
String s = null;

System.out.println(s.length());
```

Output:

```text
NullPointerException
```

---

## ArrayIndexOutOfBoundsException

```java
int arr[] = {1,2,3};

System.out.println(arr[10]);
```

Output:

```text
ArrayIndexOutOfBoundsException
```

---

## NumberFormatException

```java
int n =
Integer.parseInt("abc");
```

Output:

```text
NumberFormatException
```

---

## StringIndexOutOfBoundsException

```java
String s = "Java";

System.out.println(
    s.charAt(10)
);
```

Output:

```text
StringIndexOutOfBoundsException
```

---

# try Block

Code that may throw exception.

```java
try{

    int result = 10 / 0;

}
```

---

# catch Block

Handles exception.

```java
try{

    int result = 10 / 0;

}
catch(Exception e){

    System.out.println(
        "Exception Occurred"
    );
}
```

---

# Exception Object

```java
catch(Exception e)
```

`e` stores exception details.

---

## getMessage()

```java
catch(Exception e){

    System.out.println(
        e.getMessage()
    );
}
```

Output:

```text
/ by zero
```

---

## printStackTrace()

```java
catch(Exception e){

    e.printStackTrace();
}
```

Output:

```text
java.lang.ArithmeticException
at Main.main(...)
```

Used for debugging.

---

# Multiple Catch Blocks

```java
try{

    String s = null;

    System.out.println(
        s.length()
    );

}
catch(NullPointerException e){

    System.out.println("Null");

}
catch(Exception e){

    System.out.println("General");
}
```

Output:

```text
Null
```

Specific exception should come first.

---

# Wrong Order

```java
catch(Exception e){

}
catch(NullPointerException e){

}
```

Compilation error.

Because Exception catches everything.

---

# finally Block

Runs whether exception occurs or not.

```java
try{

    int x = 10 / 0;

}
catch(Exception e){

    System.out.println("Error");

}
finally{

    System.out.println("Always Runs");
}
```

Output:

```text
Error
Always Runs
```

---

# Why finally?

Used for cleanup.

Examples:

```text
Close File
Close Database Connection
Close Socket
Release Resources
```

---

# Example

```java
FileReader file = null;

try{

    file = new FileReader("a.txt");

}
catch(Exception e){

}
finally{

    System.out.println(
        "Closing File"
    );
}
```

---

# try-catch-finally Flow

No Exception:

```text
try
finally
```

Exception Occurs:

```text
try
catch
finally
```

---

# throw Keyword

Used to manually create an exception.

Example:

```java
throw new ArithmeticException(
    "Invalid Operation"
);
```

---

# Example

```java
int age = -5;

if(age < 0){

    throw new IllegalArgumentException(
        "Age cannot be negative"
    );
}
```

Output:

```text
IllegalArgumentException
```

---

# Real-Time Example: ATM

```java
double balance = 500;

double withdraw = 1000;

if(withdraw > balance){

    throw new RuntimeException(
        "Insufficient Balance"
    );
}
```

Output:

```text
Insufficient Balance
```

---

# throws Keyword

Used to declare exceptions.

```java
public void readFile()
throws IOException{

}
```

Meaning:

```text
This method may throw IOException.
Caller must handle it.
```

---

# Example

```java
import java.io.*;

class Test{

    static void readFile()
    throws IOException{

        FileReader fr =
            new FileReader(
                "test.txt"
            );
    }

    public static void main(
        String[] args){

        try{

            readFile();

        }catch(IOException e){

            System.out.println(
                "File Error"
            );
        }
    }
}
```

---

# throw vs throws

| throw             | throws              |
| ----------------- | ------------------- |
| Creates exception | Declares exception  |
| Inside method     | Method signature    |
| Single object     | Multiple exceptions |

Example:

```java
throw new Exception();
```

```java
void test()
throws IOException
```

---

# Custom Exception

Create your own exception.

---

## Step 1

```java
class InvalidAgeException
extends Exception{

    InvalidAgeException(
            String msg){

        super(msg);
    }
}
```

---

## Step 2

```java
if(age < 18){

    throw new InvalidAgeException(
        "Not Eligible"
    );
}
```

---

## Full Example

```java
class InvalidAgeException
extends Exception{

    InvalidAgeException(
            String msg){

        super(msg);
    }
}

public class Main{

    static void vote(int age)
    throws InvalidAgeException{

        if(age < 18){

            throw new InvalidAgeException(
                "Not Eligible"
            );
        }

        System.out.println(
            "Eligible"
        );
    }

    public static void main(
        String[] args){

        try{

            vote(15);

        }
        catch(
        InvalidAgeException e){

            System.out.println(
                e.getMessage()
            );
        }
    }
}
```

Output:

```text
Not Eligible
```

---

# Real-Time Applications

## 1. Login System

```java
if(password == null){

    throw new RuntimeException(
        "Password Missing"
    );
}
```

---

## 2. Banking System

```java
if(amount > balance){

    throw new RuntimeException(
        "Insufficient Balance"
    );
}
```

---

## 3. E-Commerce

```java
if(stock == 0){

    throw new RuntimeException(
        "Out of Stock"
    );
}
```

---

## 4. Student Portal

```java
if(marks > 100){

    throw new IllegalArgumentException(
        "Invalid Marks"
    );
}
```

---

## 5. Embedded Systems (ECE)

Sensor reading:

```java
if(sensorDisconnected){

    throw new RuntimeException(
        "Sensor Failure"
    );
}
```

Instead of crashing, firmware can:

```text
Log Error
Retry Reading
Use Backup Sensor
```

---

# Interview Questions

## Difference Between Error and Exception?

```text
Error     → Serious problem
Exception → Can be handled
```

---

## Difference Between Checked and Unchecked Exception?

```text
Checked   → Compile Time
Unchecked → Runtime
```

Examples:

```text
IOException
FileNotFoundException
```

Checked.

```text
NullPointerException
ArithmeticException
```

Unchecked.

---

## Difference Between throw and throws?

```text
throw  → Create exception
throws → Declare exception
```

---

## Can try exist without catch?

Yes.

```java
try{

}
finally{

}
```

Valid.

---

## Can catch exist without try?

No.

---

## Can finally exist without catch?

Yes.

```java
try{

}
finally{

}
```

Valid.

---

# Most Important Exceptions for Placements

```java
ArithmeticException
NullPointerException
ArrayIndexOutOfBoundsException
StringIndexOutOfBoundsException
NumberFormatException
IOException
FileNotFoundException
IllegalArgumentException
```

---

# What Interviewers Expect

You should be comfortable writing:

```java
try{
}
catch(Exception e){
}
finally{
}
```

Know:

```java
throw
throws
Custom Exception
Checked vs Unchecked
```

These are the exception-handling topics most commonly asked in Java interviews, Spring Boot interviews, and placement coding rounds.



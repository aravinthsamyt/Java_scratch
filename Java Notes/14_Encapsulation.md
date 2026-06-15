# 14.Encapsulation in Java

**Encapsulation** means:

> **Wrapping data (variables) and methods together into a single unit (class) and restricting direct access to the data.**

It is one of the four pillars of OOP.

---

# Real-Life Example

Think of a **Bank Account**.

```text
Bank Account
-----------------
balance = 10000
deposit()
withdraw()
checkBalance()
```

You cannot directly modify:

```java
account.balance = -100000;
```

Instead, you use:

```java
account.deposit(500);
account.withdraw(200);
```

The data is protected.

This is encapsulation.

---

# Without Encapsulation

```java
class Student{
    String name;
    int age;
}
```

Usage:

```java
Student s = new Student();

s.name = "Aravinth";
s.age = -10;    // Invalid
```

Problem:

```text
Anyone can modify data.
No control over values.
```

---

# With Encapsulation

Use:

1. `private` variables
2. Public getter/setter methods

```java
class Student{

    private String name;
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}
```

Usage:

```java
Student s = new Student();

s.setName("Aravinth");
s.setAge(20);

System.out.println(s.getName());
System.out.println(s.getAge());
```

Output:

```text
Aravinth
20
```

---

# Why `private`?

```java
private String name;
```

Now:

```java
Student s = new Student();

s.name = "Aravinth";
```

❌ Compilation Error

Because only methods inside the class can access it.

---

# Getters and Setters

## Setter

Used to update data.

```java
public void setName(String name){
    this.name = name;
}
```

Usage:

```java
s.setName("Aravinth");
```

---

## Getter

Used to read data.

```java
public String getName(){
    return name;
}
```

Usage:

```java
System.out.println(s.getName());
```

---

# Why Not Make Variables Public?

```java
class Employee{
    public double salary;
}
```

Anyone can do:

```java
emp.salary = -5000;
```

Invalid value.

---

# Validation Using Encapsulation

```java
class Employee{

    private double salary;

    public void setSalary(double salary){

        if(salary > 0){
            this.salary = salary;
        }
    }

    public double getSalary(){
        return salary;
    }
}
```

Usage:

```java
Employee e = new Employee();

e.setSalary(-1000);

System.out.println(
    e.getSalary()
);
```

Output:

```text
0.0
```

Negative salary rejected.

---

# Bank Account Example

```java
class BankAccount{

    private double balance;

    public void deposit(double amount){

        if(amount > 0){
            balance += amount;
        }
    }

    public void withdraw(double amount){

        if(amount <= balance){
            balance -= amount;
        }
    }

    public double getBalance(){
        return balance;
    }
}
```

Usage:

```java
BankAccount acc =
    new BankAccount();

acc.deposit(1000);

acc.withdraw(200);

System.out.println(
    acc.getBalance()
);
```

Output:

```text
800.0
```

---

# How Encapsulation Protects Data

Without encapsulation:

```java
acc.balance = -100000;
```

Possible.

---

With encapsulation:

```java
private double balance;
```

Not possible.

Only controlled methods can change it.

---

# Constructor + Encapsulation

```java
class Student{

    private String name;
    private int age;

    Student(String name,int age){

        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
}
```

Usage:

```java
Student s =
    new Student("Aravinth",20);

System.out.println(
    s.getName()
);
```

---

# Read-Only Class

Only getter.

```java
class Student{

    private String name =
        "Aravinth";

    public String getName(){
        return name;
    }
}
```

Usage:

```java
System.out.println(
    s.getName()
);
```

Can read.

Cannot modify.

---

# Write-Only Class

Only setter.

```java
class Student{

    private String password;

    public void setPassword(
            String password){

        this.password = password;
    }
}
```

Can write.

Cannot read.

---

# JavaBean Example

A class following encapsulation rules:

```java
class Student{

    private String name;
    private int age;

    public String getName(){
        return name;
    }

    public void setName(
            String name){

        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(
            int age){

        this.age = age;
    }
}
```

This style is heavily used in Spring Boot.

---

# Advantages of Encapsulation

### 1. Data Hiding

```java
private int age;
```

Outside code cannot access directly.

---

### 2. Security

Only approved methods modify data.

---

### 3. Validation

```java
if(age > 0)
```

Reject invalid data.

---

### 4. Flexibility

Internal implementation can change without affecting users.

---

### 5. Better Maintainability

Large projects become easier to manage.

---

# Encapsulation vs Abstraction

Many students confuse these.

| Encapsulation       | Abstraction                   |
| ------------------- | ----------------------------- |
| Hides data          | Hides implementation          |
| Uses private fields | Uses abstract class/interface |
| Focus on security   | Focus on simplicity           |

---

### Encapsulation Example

```java
private int balance;
```

Protecting data.

---

### Abstraction Example

```java
interface Vehicle{
    void start();
}
```

Hiding implementation details.

---

# Interview Questions

### What is encapsulation?

Binding data and methods together and restricting direct access to data.

---

### How is encapsulation achieved?

Using:

```java
private variables
getter methods
setter methods
```

---

### Why use getters and setters?

To control access and validate data.

---

### Is encapsulation only about private variables?

No.

It's about controlled access to data through methods.

---

### Can encapsulation exist without getters/setters?

Yes.

You can expose only the methods you want.

Example:

```java
class BankAccount{

    private double balance;

    public void deposit(double amt){
        balance += amt;
    }
}
```

Still encapsulated.

---

# Complete Example

```java
class Student{

    private String name;
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){

        if(age > 0){
            this.age = age;
        }
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}

public class Main{

    public static void main(String[] args){

        Student s = new Student();

        s.setName("Aravinth");

        s.setAge(20);

        System.out.println(
            s.getName()
        );

        System.out.println(
            s.getAge()
        );
    }
}
```

Output:

```text
Aravinth
20
```

---

# Quick Revision

```text
Encapsulation =
Data + Methods in one class
+
Restrict direct access

Achieved using:
private variables
getter methods
setter methods

Benefits:
✓ Data Hiding
✓ Security
✓ Validation
✓ Maintainability
```

### Most Important Interview Pattern

```java
class Student{

    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
```

If you understand **why `private` is used** and **how getters/setters provide controlled access**, then you understand the core idea of encapsulation.



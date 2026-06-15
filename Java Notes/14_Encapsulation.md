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



# Real-World Applications of Encapsulation

Encapsulation is everywhere in software development. The main idea is:

```text
User cannot directly change important data.
Only approved methods can modify it.
```

---

# 1. Bank Account System 🏦

### Without Encapsulation

```java
class BankAccount{
    public double balance;
}
```

Anyone can do:

```java
account.balance = -50000;
```

Invalid state.

---

### With Encapsulation

```java
class BankAccount{

    private double balance;

    public void deposit(double amount){
        if(amount > 0)
            balance += amount;
    }

    public void withdraw(double amount){
        if(amount <= balance)
            balance -= amount;
    }

    public double getBalance(){
        return balance;
    }
}
```

Usage:

```java
acc.deposit(1000);
acc.withdraw(200);
```

User cannot directly change `balance`.

---

# 2. ATM Machine 💳

When you withdraw money:

```text
Insert Card
Enter PIN
Withdraw Amount
```

You never access the bank database directly.

Internally:

```java
atm.verifyPin();
atm.withdraw();
atm.checkBalance();
```

The account details are hidden.

This is encapsulation.

---

# 3. Student Management System 🎓

Suppose you build a college portal.

```java
class Student{

    private int marks;

    public void setMarks(int marks){

        if(marks >= 0 && marks <= 100)
            this.marks = marks;
    }
}
```

Without validation:

```java
student.marks = 500;
```

Wrong.

Encapsulation ensures only valid marks are stored.

---

# 4. E-Commerce Website 🛒

Example: Amazon/Flipkart style application.

```java
class Product{

    private double price;

    public void setPrice(double price){

        if(price > 0)
            this.price = price;
    }
}
```

Prevent:

```java
product.price = -1000;
```

Only approved updates are allowed.

---

# 5. Employee Payroll System 💼

```java
class Employee{

    private double salary;

    public void setSalary(double salary){

        if(salary > 0)
            this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }
}
```

HR software should not allow:

```java
salary = -50000;
```

Encapsulation protects payroll data.

---

# 6. Social Media Applications 📱

Think of Instagram.

```java
class User{

    private String password;

    public void changePassword(
            String oldPass,
            String newPass){
        // validation
    }
}
```

You cannot directly access:

```java
user.password
```

Passwords are hidden.

This is one of the most important uses of encapsulation.

---

# 7. Mobile Phone Example 📱

You press:

```text
Volume Up
Volume Down
```

Internally:

```java
phone.increaseVolume();
phone.decreaseVolume();
```

You don't directly manipulate hardware circuits.

The implementation is hidden.

---

# 8. Car Example 🚗

You drive using:

```text
Accelerator
Brake
Steering
```

Internally:

```text
Fuel Injection
Engine Timing
Transmission Control
```

You don't interact with engine internals.

The car exposes only necessary controls.

This is encapsulation in the real world.

---

# 9. Embedded Systems (Relevant to Your ECE Background)

Suppose you're writing firmware for a sensor.

```java
class TemperatureSensor{

    private double currentTemp;

    public double readTemperature(){
        return currentTemp;
    }
}
```

Application code:

```java
sensor.readTemperature();
```

Instead of:

```java
sensor.currentTemp = 5000;
```

Sensor data is protected.

---

# 10. Spring Boot / Enterprise Applications

A common Spring Boot model:

```java
public class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

Frameworks like Spring, Hibernate, and Jackson rely heavily on encapsulated classes.

---

# Why Companies Use Encapsulation

Imagine a banking app with millions of users.

If developers could freely modify:

```java
balance
salary
password
marks
price
```

bugs would be everywhere.

Encapsulation provides:

```text
Security
Validation
Data Integrity
Maintainability
Scalability
```

---

# Interview Answer

**Q: Give a real-world example of encapsulation.**

Answer:

> A bank account is a classic example of encapsulation. The account balance is kept private and cannot be modified directly. Users interact through methods such as `deposit()`, `withdraw()`, and `getBalance()`, which validate operations and protect the data from invalid changes.

This is the answer interviewers most often expect.

---

# One-Line Memory Trick

```text
Encapsulation =
Hide data using private variables
+
Provide controlled access using methods
```

### Real-world examples:

* Bank Account
* ATM
* Student Management System
* E-Commerce Products
* Employee Payroll
* Instagram Passwords
* Cars
* Mobile Phones
* Embedded Sensors
* Spring Boot Entity Classes

These examples make it easier to explain encapsulation in interviews instead of only giving the textbook definition.



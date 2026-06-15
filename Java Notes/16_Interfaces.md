# 16.Interface in Java

An **Interface** is a blueprint of a class that defines **what a class should do**, but not **how it should do it**.

Think of it as a **contract**.

---

# Real-Life Example: Remote Control 📺

A TV remote has buttons:

```text
Power ON
Power OFF
Volume Up
Volume Down
```

The remote knows:

```text
What actions are available
```

It doesn't know:

```text
How Samsung TV works internally
How LG TV works internally
How Sony TV works internally
```

Each TV implements the functionality differently.

This is exactly how interfaces work.

---

# Basic Syntax

```java
interface Vehicle{

    void start();
}
```

Implementing class:

```java
class Car implements Vehicle{

    public void start(){
        System.out.println("Car Started");
    }
}
```

Usage:

```java
Car c = new Car();

c.start();
```

Output:

```text
Car Started
```

---

# Why Interface?

Suppose every payment system supports:

```text
Pay Money
```

But implementation differs.

```text
UPI
Credit Card
PayPal
Net Banking
```

Interface defines:

```java
pay()
```

Each class provides its own implementation.

---

# Complete Example

Interface:

```java
interface Payment{

    void pay(double amount);
}
```

UPI:

```java
class UPI implements Payment{

    public void pay(double amount){

        System.out.println(
            "Paid via UPI: " + amount
        );
    }
}
```

Credit Card:

```java
class CreditCard implements Payment{

    public void pay(double amount){

        System.out.println(
            "Paid via Credit Card: " + amount
        );
    }
}
```

Usage:

```java
Payment p;

p = new UPI();
p.pay(1000);

p = new CreditCard();
p.pay(2000);
```

Output:

```text
Paid via UPI: 1000.0
Paid via Credit Card: 2000.0
```

---

# Interface + Polymorphism

```java
Payment p = new UPI();
```

Reference Type:

```text
Payment
```

Object Type:

```text
UPI
```

Runtime decides:

```java
UPI.pay()
```

This is runtime polymorphism.

---

# Rules of Interface

---

## Interface Cannot Be Instantiated

```java
interface Vehicle{
}
```

❌

```java
Vehicle v = new Vehicle();
```

Compilation error.

---

## Class Must Implement Methods

```java
interface Animal{

    void sound();
}
```

Implementation:

```java
class Dog implements Animal{

    public void sound(){

        System.out.println("Bark");
    }
}
```

---

## Interface Methods Are Public

Interface:

```java
interface Animal{

    void sound();
}
```

Actually Java treats it as:

```java
public abstract void sound();
```

Therefore implementation must be:

```java
public void sound()
```

Not:

```java
void sound()
```

❌ Error

---

# Multiple Interfaces

One of the biggest advantages.

---

## Example

```java
interface Camera{

    void clickPhoto();
}
```

```java
interface MusicPlayer{

    void playMusic();
}
```

```java
class Smartphone
        implements Camera,
                   MusicPlayer{

    public void clickPhoto(){

        System.out.println(
            "Photo Clicked"
        );
    }

    public void playMusic(){

        System.out.println(
            "Playing Music"
        );
    }
}
```

Usage:

```java
Smartphone s =
    new Smartphone();

s.clickPhoto();
s.playMusic();
```

Output:

```text
Photo Clicked
Playing Music
```

---

# Why Multiple Interfaces?

Java doesn't allow:

```java
class C extends A,B
```

❌ Multiple inheritance of classes.

But allows:

```java
class C implements A,B
```

✅ Multiple inheritance through interfaces.

---

# Interface Variables

All variables are:

```java
public static final
```

by default.

Example:

```java
interface Test{

    int MAX = 100;
}
```

Actually:

```java
public static final int MAX = 100;
```

Usage:

```java
System.out.println(Test.MAX);
```

---

# Default Methods (Java 8)

Interfaces can contain implemented methods.

```java
interface Vehicle{

    default void stop(){

        System.out.println(
            "Vehicle Stopped"
        );
    }
}
```

Implementation:

```java
class Car implements Vehicle{
}
```

Usage:

```java
Car c = new Car();

c.stop();
```

Output:

```text
Vehicle Stopped
```

---

# Static Methods in Interface

```java
interface Calculator{

    static int add(int a,int b){

        return a+b;
    }
}
```

Usage:

```java
System.out.println(
    Calculator.add(10,20)
);
```

Output:

```text
30
```

---

# Functional Interface

Contains exactly one abstract method.

```java
@FunctionalInterface
interface Greeting{

    void sayHello();
}
```

Used in:

```text
Lambda Expressions
Streams API
```

---

# Real-Time Application 1: Payment Gateway 💳

Interface:

```java
interface Payment{

    void pay(double amount);
}
```

Implementations:

```java
class UPI implements Payment
class CreditCard implements Payment
class PayPal implements Payment
```

Benefits:

```text
New payment method can be added
without changing existing code.
```

---

# Real-Time Application 2: Notification System 📩

Interface:

```java
interface Notification{

    void send(String msg);
}
```

Email:

```java
class EmailNotification
        implements Notification{

    public void send(String msg){

        System.out.println(
            "Email: " + msg
        );
    }
}
```

SMS:

```java
class SMSNotification
        implements Notification{

    public void send(String msg){

        System.out.println(
            "SMS: " + msg
        );
    }
}
```

Usage:

```java
Notification n;

n = new EmailNotification();
n.send("Hello");

n = new SMSNotification();
n.send("Hello");
```

---

# Real-Time Application 3: Embedded Systems (Important for ECE)

Suppose you're building firmware.

Interface:

```java
interface Sensor{

    double read();
}
```

Temperature Sensor:

```java
class TemperatureSensor
        implements Sensor{

    public double read(){

        return 35.5;
    }
}
```

Pressure Sensor:

```java
class PressureSensor
        implements Sensor{

    public double read(){

        return 101.3;
    }
}
```

Application code:

```java
Sensor s =
    new TemperatureSensor();

System.out.println(
    s.read()
);
```

Application doesn't care about hardware details.

This is abstraction through interfaces.

---

# Real-Time Application 4: Spring Boot

Repository example:

```java
public interface StudentRepository
       extends JpaRepository<
            Student, Integer>{
}
```

Spring automatically provides implementation.

You simply write:

```java
repository.save(student);
repository.findAll();
```

Framework handles:

```text
SQL Queries
Database Connections
Transactions
```

This is a major real-world use of interfaces.

---

# Interface vs Abstract Class

| Feature              | Interface      | Abstract Class   |
| -------------------- | -------------- | ---------------- |
| Multiple Inheritance | ✅ Yes          | ❌ No             |
| Constructor          | ❌ No           | ✅ Yes            |
| Variables            | Constants Only | Normal Variables |
| Object Creation      | ❌ No           | ❌ No             |
| Abstraction          | Yes            | Yes              |

---

# Interview Questions

### What is an interface?

A contract that specifies what methods a class must implement.

---

### Why use interfaces?

```text
Abstraction
Loose Coupling
Polymorphism
Multiple Inheritance
```

---

### Can we create an object of interface?

❌ No

---

### Can interface have methods with implementation?

✅ Yes (default/static methods)

---

### Can interface have constructors?

❌ No

---

### Can one class implement multiple interfaces?

✅ Yes

```java
class Phone
implements Camera,
           MusicPlayer{
}
```

---

# Complete Interview Example

```java
interface Vehicle{

    void start();
}

class Car implements Vehicle{

    public void start(){

        System.out.println(
            "Car Started"
        );
    }
}

public class Main{

    public static void main(String[] args){

        Vehicle v =
            new Car();

        v.start();
    }
}
```

Output:

```text
Car Started
```

Here:

```text
Interface      → Vehicle
Implementation → Car
Polymorphism   → Vehicle v = new Car()
Abstraction    → User only sees start()
```

---

# Quick Revision

```text
Interface =
Contract

Keywords:
interface
implements

Cannot create object

Supports:
✓ Abstraction
✓ Polymorphism
✓ Multiple Inheritance

Real Applications:
✓ Payment Gateway
✓ Notification System
✓ Spring Boot Repository
✓ Sensor Drivers
✓ Mobile Chargers
✓ Remote Controls
```

### Memory Trick

```text
Abstract Class =
"What classes have in common"

Interface =
"What classes can do"
```

Example:

```text
Animal → Abstract Class

Flyable, Runnable, Payable
→ Interfaces
```

This distinction is frequently asked in Java interviews and helps you decide when to use an abstract class versus an interface.



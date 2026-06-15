# 15.Abstraction in Java

**Abstraction** means:

> **Hiding implementation details and showing only the essential features to the user.**

The user knows **what to do**, but doesn't need to know **how it is done**.

---

# Real-Life Example: Car 🚗

When driving a car, you use:

```text
Accelerator
Brake
Steering
```

You don't need to know:

```text
Fuel Injection
Engine Timing
Gearbox Internals
Combustion Process
```

The complex implementation is hidden.

This is **abstraction**.

---

# Another Example: ATM 🏧

You do:

```text
Insert Card
Enter PIN
Withdraw Money
```

You don't know:

```text
Database Queries
Network Communication
Encryption
Transaction Processing
```

Only essential operations are visible.

---

# Why Abstraction?

Without abstraction:

```text
User must understand every internal detail.
```

With abstraction:

```text
User focuses only on what is needed.
```

Benefits:

✅ Simplicity

✅ Security

✅ Maintainability

✅ Reduced Complexity

---

# How Abstraction is Achieved in Java?

Java provides:

1. Abstract Classes
2. Interfaces

---

# 1. Abstract Class

An abstract class cannot be instantiated.

```java
abstract class Animal{
}
```

❌ Not allowed:

```java
Animal a = new Animal();
```

Compilation error.

---

# Abstract Method

A method without implementation.

```java
abstract class Animal{

    abstract void sound();
}
```

No method body.

---

# Complete Example

```java
abstract class Animal{

    abstract void sound();

    void eat(){
        System.out.println("Eating");
    }
}
```

Child class:

```java
class Dog extends Animal{

    @Override
    void sound(){
        System.out.println("Bark");
    }
}
```

Usage:

```java
Dog d = new Dog();

d.sound();
d.eat();
```

Output:

```text
Bark
Eating
```

---

# Why Abstract Class?

Suppose every animal has a sound.

But sound differs.

```text
Dog  → Bark
Cat  → Meow
Lion → Roar
```

Parent knows:

```text
Every animal makes a sound.
```

But doesn't know which sound.

Hence:

```java
abstract void sound();
```

---

# Real-Time Example: Payment System 💳

Abstract class:

```java
abstract class Payment{

    abstract void pay(double amount);
}
```

Credit Card:

```java
class CreditCardPayment
        extends Payment{

    @Override
    void pay(double amount){

        System.out.println(
            "Paid using Credit Card"
        );
    }
}
```

UPI:

```java
class UPIPayment
        extends Payment{

    @Override
    void pay(double amount){

        System.out.println(
            "Paid using UPI"
        );
    }
}
```

Usage:

```java
Payment p =
    new UPIPayment();

p.pay(1000);
```

Output:

```text
Paid using UPI
```

User only knows:

```java
pay()
```

Implementation is hidden.

---

# Rules of Abstract Classes

### Can Have Abstract Methods

```java
abstract void show();
```

---

### Can Have Normal Methods

```java
void display(){
}
```

---

### Can Have Constructors

```java
abstract class Animal{

    Animal(){
        System.out.println("Animal");
    }
}
```

---

### Can Have Variables

```java
int age;
```

---

# Interface

An interface provides **100% abstraction conceptually**.

---

## Interface Example

```java
interface Vehicle{

    void start();
}
```

Implementation:

```java
class Car implements Vehicle{

    public void start(){

        System.out.println(
            "Car Started"
        );
    }
}
```

Usage:

```java
Vehicle v =
    new Car();

v.start();
```

Output:

```text
Car Started
```

---

# Real-Time Example: Mobile Charger 🔌

Every charger:

```text
Can Charge Device
```

Interface:

```java
interface Charger{

    void charge();
}
```

Samsung Charger:

```java
class SamsungCharger
        implements Charger{

    public void charge(){

        System.out.println(
            "Samsung Charging"
        );
    }
}
```

Apple Charger:

```java
class AppleCharger
        implements Charger{

    public void charge(){

        System.out.println(
            "Apple Charging"
        );
    }
}
```

User only does:

```java
charge();
```

No need to know internal circuitry.

---

# Interface vs Abstract Class

| Feature              | Abstract Class | Interface   |
| -------------------- | -------------- | ----------- |
| Constructor          | ✅ Yes          | ❌ No        |
| Variables            | ✅ Yes          | Constants   |
| Multiple Inheritance | ❌ No           | ✅ Yes       |
| Abstract Methods     | ✅ Yes          | ✅ Yes       |
| Normal Methods       | ✅ Yes          | ✅ (Java 8+) |

---

# Abstraction + Polymorphism

Most powerful combination.

```java
abstract class Animal{

    abstract void sound();
}
```

Children:

```java
class Dog extends Animal{

    void sound(){
        System.out.println("Bark");
    }
}

class Cat extends Animal{

    void sound(){
        System.out.println("Meow");
    }
}
```

Usage:

```java
Animal a;

a = new Dog();
a.sound();

a = new Cat();
a.sound();
```

Output:

```text
Bark
Meow
```

---

# Real-World Applications

## 1. ATM Machine

User:

```text
Withdraw
Deposit
Balance Inquiry
```

Hidden:

```text
Database
Encryption
Server Calls
```

---

## 2. Online Payment

User:

```text
Pay ₹1000
```

Hidden:

```text
OTP Verification
Bank Processing
Transaction Routing
```

---

## 3. E-Commerce Website

User:

```text
Place Order
```

Hidden:

```text
Inventory Update
Payment Processing
Shipping Allocation
```

---

## 4. Spring Boot Framework

You write:

```java
repository.save(student);
```

You don't know:

```text
SQL Query Generation
Connection Handling
Transactions
```

Framework hides details.

This is abstraction.

---

## 5. Embedded Systems (Important for ECE)

Suppose you're controlling a temperature sensor.

Application:

```java
sensor.readTemperature();
```

Hidden:

```text
ADC Conversion
Register Access
SPI/I2C Communication
Calibration
```

Firmware hides hardware complexity.

This is abstraction.

---

# Encapsulation vs Abstraction

Students often confuse these.

| Encapsulation       | Abstraction                      |
| ------------------- | -------------------------------- |
| Hides data          | Hides implementation             |
| Uses private fields | Uses abstract classes/interfaces |
| Security-focused    | Simplicity-focused               |

---

### Encapsulation Example

```java
private double balance;
```

Protecting data.

---

### Abstraction Example

```java
interface Payment{
    void pay();
}
```

Hiding implementation.

---

# Interview Questions

### What is abstraction?

Hiding implementation details and exposing only essential functionality.

---

### How is abstraction achieved in Java?

```text
Abstract Classes
Interfaces
```

---

### Can abstract class have constructor?

✅ Yes

---

### Can we create object of abstract class?

❌ No

---

### Can abstract class have normal methods?

✅ Yes

---

### Does interface support multiple inheritance?

✅ Yes

---

# Complete Interview Example

```java
abstract class Vehicle{

    abstract void start();
}

class Car extends Vehicle{

    @Override
    void start(){

        System.out.println(
            "Car Started"
        );
    }
}

public class Main{

    public static void main(String[] args){

        Vehicle v = new Car();

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
Abstraction  → Vehicle defines what to do
Polymorphism → Car provides implementation
```

---

# Quick Revision

```text
Abstraction =
Hide implementation
Show functionality

Achieved Using:
1. Abstract Class
2. Interface

Real Examples:
✓ Car
✓ ATM
✓ Payment Gateway
✓ Mobile Charger
✓ E-Commerce
✓ Spring Boot
✓ Embedded Systems

Encapsulation = Hide Data
Abstraction = Hide Implementation
```

### One-Line Memory Trick

```text
Encapsulation → "How can I protect data?"
Abstraction   → "How can I hide complexity?"
```

That's the easiest way to remember the difference during interviews.



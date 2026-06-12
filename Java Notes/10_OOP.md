# 10. Object-Oriented Programming (OOP) in Java

OOP is a programming paradigm that organizes code using **objects and classes**.

Java is primarily an OOP language.

---

# Why OOP?

Without OOP:

```java
String studentName = "Malar";
int studentAge = 20;
```

Managing hundreds of students becomes difficult.

With OOP:

```java
Student s1 = new Student();
Student s2 = new Student();
```

Each object stores its own data and behavior.

---

# Four Pillars of OOP

1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction

---

# 1. Class and Object

## Class

A class is a blueprint.

```java
class Student{
    String name;
    int age;
}
```

---

## Object

An object is an instance of a class.

```java
Student s1 = new Student();
```

---

## Example

```java
class Student{

    String name;
    int age;

    void display(){
        System.out.println(name);
        System.out.println(age);
    }
}

public class Main{
    public static void main(String[] args){

        Student s1 = new Student();

        s1.name = "Aravinth";
        s1.age = 20;

        s1.display();
    }
}
```

Output:

```text
Aravinth
20
```

---

# Memory View

```text
Student s1 = new Student();
```

```text
Stack              Heap
-----              -----
s1  ----------->   Student Object
                    name = null
                    age = 0
```

---

# Constructor

Special method called automatically when object is created.

---

## Default Constructor

```java
class Student{

}
```

Java creates one automatically.

---

## User Defined Constructor

```java
class Student{

    String name;

    Student(){
        System.out.println("Constructor Called");
    }
}
```

---

## Parameterized Constructor

```java
class Student{

    String name;
    int age;

    Student(String n,int a){
        name = n;
        age = a;
    }
}
```

Usage:

```java
Student s =
    new Student("Aravinth",20);
```

---

# this Keyword

Refers to current object.

```java
class Student{

    String name;

    Student(String name){
        this.name = name;
    }
}
```

Without `this`:

```java
name = name;
```

Java gets confused between parameter and instance variable.

---

# Encapsulation

Binding data and methods together and hiding data.

---

## Bad Practice

```java
class Student{
    String name;
}
```

Anyone can modify it.

---

## Encapsulation Example

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

Usage:

```java
Student s = new Student();

s.setName("Aravinth");

System.out.println(
    s.getName()
);
```

---

# Access Modifiers

| Modifier  | Same Class | Same Package | Subclass | Other Package |
| --------- | ---------- | ------------ | -------- | ------------- |
| private   | ✔          | ✖            | ✖        | ✖             |
| default   | ✔          | ✔            | ✖        | ✖             |
| protected | ✔          | ✔            | ✔        | ✖             |
| public    | ✔          | ✔            | ✔        | ✔             |

---

# Inheritance

One class acquires properties of another class.

---

## Parent Class

```java
class Animal{

    void eat(){
        System.out.println("Eating");
    }
}
```

---

## Child Class

```java
class Dog extends Animal{

    void bark(){
        System.out.println("Barking");
    }
}
```

Usage:

```java
Dog d = new Dog();

d.eat();
d.bark();
```

Output:

```text
Eating
Barking
```

---

# Types of Inheritance

### Single

```text
Animal
   ↓
 Dog
```

---

### Multilevel

```text
Animal
   ↓
 Dog
   ↓
 Puppy
```

---

### Hierarchical

```text
      Animal
      /   \
    Dog   Cat
```

---

### Multiple

Not supported through classes.

Supported through interfaces.

---

# Method Overriding

Child provides its own implementation.

```java
class Animal{

    void sound(){
        System.out.println("Animal Sound");
    }
}

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
```

Output:

```text
Bark
```

---

# Polymorphism

Means "many forms".

---

# Compile Time Polymorphism

Method Overloading.

Same method name, different parameters.

```java
class MathOperation{

    int add(int a,int b){
        return a+b;
    }

    int add(int a,int b,int c){
        return a+b+c;
    }
}
```

Usage:

```java
obj.add(10,20);

obj.add(10,20,30);
```

---

# Runtime Polymorphism

Method Overriding.

```java
Animal a = new Dog();

a.sound();
```

Output:

```text
Bark
```

Decision made at runtime.

---

# Upcasting

```java
Animal a = new Dog();
```

Parent reference → Child object.

Commonly used.

---

# Downcasting

```java
Dog d = (Dog)a;
```

Convert parent reference back to child.

---

# Abstraction

Hide implementation details and show only essential features.

---

# Abstract Class

```java
abstract class Animal{

    abstract void sound();
}
```

---

## Child Class

```java
class Dog extends Animal{

    void sound(){
        System.out.println("Bark");
    }
}
```

Usage:

```java
Animal a = new Dog();

a.sound();
```

---

# Interface

100% abstraction (before Java 8).

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
        System.out.println("Car Started");
    }
}
```

Usage:

```java
Vehicle v = new Car();

v.start();
```

Output:

```text
Car Started
```

---

# Abstract Class vs Interface

| Feature              | Abstract Class           | Interface       |
| -------------------- | ------------------------ | --------------- |
| Constructor          | ✔                        | ✖               |
| Variables            | Normal variables allowed | Constants only  |
| Multiple Inheritance | ✖                        | ✔               |
| Methods              | Abstract + Concrete      | Mostly abstract |

---

# static Keyword

Belongs to class, not object.

```java
class Student{

    static String college =
        "KEC";
}
```

Usage:

```java
System.out.println(
    Student.college
);
```

---

# final Keyword

## Variable

```java
final int x = 10;
```

Cannot change.

---

## Method

```java
final void show(){}
```

Cannot override.

---

## Class

```java
final class A{}
```

Cannot inherit.

---

# Object Class Methods

Every class inherits from `Object`.

---

## toString()

```java
System.out.println(obj);
```

Calls:

```java
obj.toString();
```

---

## equals()

```java
obj1.equals(obj2);
```

---

## hashCode()

```java
obj.hashCode();
```

Used in HashMap, HashSet.

---

# Real Life Example

```java
class BankAccount{

    private double balance;

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
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

System.out.println(
    acc.getBalance()
);
```

This demonstrates:

```text
Class
Object
Encapsulation
Methods
Data Hiding
```

---

# OOP Interview Revision

```text
Class        → Blueprint
Object       → Instance of class

Constructor  → Initializes object

this         → Current object

Encapsulation→ Data hiding using private

Inheritance  → extends

Polymorphism → Overloading + Overriding

Abstraction  → Abstract class / Interface

static       → Belongs to class

final        → Cannot change

Upcasting    → Parent ref = Child object

Downcasting  → Child ref = (Child) Parent ref
```

# Most Important for Placements

Focus deeply on:

1. Class & Object
2. Constructor
3. `this`
4. Encapsulation
5. Inheritance
6. Method Overloading
7. Method Overriding
8. Abstract Class
9. Interface
10. `static`
11. `final`

These topics account for the majority of Java OOP interview questions and are also heavily used in Spring Boot and enterprise Java development.


# 12.Inheritance in Java

**Inheritance** is a mechanism where one class acquires the properties and methods of another class.

It promotes **code reusability**.

---

# Why Inheritance?

Without inheritance:

```java
class Dog{
    void eat(){
        System.out.println("Eating");
    }
}

class Cat{
    void eat(){
        System.out.println("Eating");
    }
}
```

Same code is repeated.

---

With inheritance:

```java
class Animal{

    void eat(){
        System.out.println("Eating");
    }
}

class Dog extends Animal{
}

class Cat extends Animal{
}
```

Both `Dog` and `Cat` can use `eat()`.

---

# Basic Syntax

```java
class Parent{
}

class Child extends Parent{
}
```

---

# Simple Example

```java
class Animal{

    void eat(){
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal{

    void bark(){
        System.out.println("Dog is barking");
    }
}

public class Main{

    public static void main(String[] args){

        Dog d = new Dog();

        d.eat();
        d.bark();
    }
}
```

Output:

```text
Animal is eating
Dog is barking
```

---

# Memory View

```java
Dog d = new Dog();
```

Dog object contains:

```text
Dog Object
-----------------
eat()   ← inherited
bark()  ← own method
```

---

# Terminology

```java
class Animal{
}
```

Parent Class:

* Superclass
* Base Class

---

```java
class Dog extends Animal{
}
```

Child Class:

* Subclass
* Derived Class

---

# Types of Inheritance

---

# 1. Single Inheritance

One parent → One child

```text
Animal
   ↓
 Dog
```

Example:

```java
class Animal{
    void eat(){
        System.out.println("Eating");
    }
}

class Dog extends Animal{
    void bark(){
        System.out.println("Bark");
    }
}
```

---

# 2. Multilevel Inheritance

Child becomes parent of another class.

```text
Animal
   ↓
 Dog
   ↓
 Puppy
```

Example:

```java
class Animal{

    void eat(){
        System.out.println("Eating");
    }
}

class Dog extends Animal{

    void bark(){
        System.out.println("Bark");
    }
}

class Puppy extends Dog{

    void weep(){
        System.out.println("Weeping");
    }
}
```

Usage:

```java
Puppy p = new Puppy();

p.eat();
p.bark();
p.weep();
```

Output:

```text
Eating
Bark
Weeping
```

---

# 3. Hierarchical Inheritance

One parent → Multiple children

```text
      Animal
      /    \
    Dog    Cat
```

Example:

```java
class Animal{

    void eat(){
        System.out.println("Eating");
    }
}

class Dog extends Animal{

    void bark(){
        System.out.println("Bark");
    }
}

class Cat extends Animal{

    void meow(){
        System.out.println("Meow");
    }
}
```

Usage:

```java
Dog d = new Dog();
d.eat();
d.bark();

Cat c = new Cat();
c.eat();
c.meow();
```

---

# 4. Multiple Inheritance

```text
Parent1
    \
     Child
    /
Parent2
```

❌ Not supported using classes.

```java
class A{
}

class B{
}

class C extends A,B{
}
```

Compilation error.

---

### Why Not Supported?

To avoid the **Diamond Problem**.

```text
      A
     / \
    B   C
     \ /
      D
```

If both `B` and `C` have same method, Java won't know which one to use.

---

# Multiple Inheritance Using Interfaces

```java
interface A{
    void show();
}

interface B{
    void print();
}

class C implements A,B{

    public void show(){
        System.out.println("Show");
    }

    public void print(){
        System.out.println("Print");
    }
}
```

---

# Constructor Execution in Inheritance

Parent constructor runs first.

```java
class Animal{

    Animal(){
        System.out.println("Animal Constructor");
    }
}

class Dog extends Animal{

    Dog(){
        System.out.println("Dog Constructor");
    }
}
```

Usage:

```java
new Dog();
```

Output:

```text
Animal Constructor
Dog Constructor
```

---

# super Keyword

Used to refer to parent class.

---

# 1. Access Parent Method

```java
class Animal{

    void eat(){
        System.out.println("Animal Eating");
    }
}

class Dog extends Animal{

    void eat(){

        super.eat();

        System.out.println("Dog Eating");
    }
}
```

Output:

```text
Animal Eating
Dog Eating
```

---

# 2. Access Parent Variable

```java
class Animal{

    String name = "Animal";
}

class Dog extends Animal{

    String name = "Dog";

    void display(){

        System.out.println(super.name);

        System.out.println(name);
    }
}
```

Output:

```text
Animal
Dog
```

---

# 3. Call Parent Constructor

```java
class Animal{

    Animal(String type){

        System.out.println(type);
    }
}

class Dog extends Animal{

    Dog(){

        super("Animal");

        System.out.println("Dog");
    }
}
```

Output:

```text
Animal
Dog
```

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

# Runtime Polymorphism

```java
Animal a = new Dog();

a.sound();
```

Output:

```text
Bark
```

Java decides at runtime.

---

# Upcasting

Parent reference → Child object

```java
Animal a = new Dog();
```

Allowed.

Used extensively in Java.

---

# Downcasting

```java
Dog d = (Dog)a;
```

Convert back to child reference.

---

# What is Inherited?

### Inherited

```java
public methods
protected methods
public variables
protected variables
```

---

### Not Inherited

```java
Constructors
private methods
private variables
```

---

# Access Modifier Behavior

| Modifier  | Child Can Access? |
| --------- | ----------------- |
| private   | ❌                 |
| default   | ✔ (same package)  |
| protected | ✔                 |
| public    | ✔                 |

---

# final and Inheritance

### final Class

```java
final class Animal{
}
```

Cannot inherit.

```java
class Dog extends Animal{
}
```

❌ Error

---

### final Method

```java
class Animal{

    final void eat(){
    }
}
```

Cannot override.

---

# Object Class

Every class inherits from `Object`.

```java
class Student{
}
```

Actually:

```java
class Student extends Object{
}
```

---

Methods inherited:

```java
toString()
equals()
hashCode()
getClass()
```

---

# Real-Life Example

```java
class Employee{

    String company = "ABC";

    void work(){
        System.out.println("Working");
    }
}

class SoftwareEngineer
        extends Employee{

    void code(){
        System.out.println("Coding");
    }
}

public class Main{

    public static void main(String[] args){

        SoftwareEngineer emp =
            new SoftwareEngineer();

        System.out.println(emp.company);

        emp.work();
        emp.code();
    }
}
```

Output:

```text
ABC
Working
Coding
```

---

# Interview Questions

### Can Java support multiple inheritance?

❌ Through classes

✅ Through interfaces

---

### Are constructors inherited?

❌ No

---

### Can private members be inherited?

❌ No

---

### Which constructor executes first?

✅ Parent constructor

---

### Can a child override a final method?

❌ No

---

### What is the purpose of `super`?

```text
Access parent variable
Access parent method
Call parent constructor
```

---

# Quick Revision

```text
Inheritance = Code Reusability

extends = inheritance keyword

Types:
1. Single
2. Multilevel
3. Hierarchical
4. Multiple (via interfaces)

super.variable
super.method()
super(...)

Method Overriding
Runtime Polymorphism

Upcasting:
Animal a = new Dog();

Downcasting:
Dog d = (Dog)a;
```

# Most Important for Interviews

Master these concepts:

1. `extends`
2. Constructor execution order
3. `super`
4. Method Overriding
5. Upcasting
6. Runtime Polymorphism
7. Multiple Inheritance via Interfaces
8. `final` with inheritance

These are the inheritance topics most frequently asked in Java interviews and placement rounds.



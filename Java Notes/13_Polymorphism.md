# 13.Polymorphism in Java

**Polymorphism** means **"many forms"**.

The same method or object can behave differently depending on the context.

---

# Real-Life Example

### Person

A person can have multiple roles:

```text
Aravinth
   ↓
Student
   ↓
Developer
   ↓
Son
```

Same person → Different forms.

This is the idea behind polymorphism.

---

# Types of Polymorphism

Java supports:

1. Compile-Time Polymorphism (Method Overloading)
2. Runtime Polymorphism (Method Overriding)

---

# 1. Compile-Time Polymorphism

Also called:

```text
Method Overloading
Static Binding
Early Binding
```

Compiler decides which method to call.

---

# Method Overloading

Same method name but different parameters.

---

## Example 1

```java
class Calculator{

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
Calculator c = new Calculator();

System.out.println(c.add(10,20));

System.out.println(c.add(10,20,30));
```

Output:

```text
30
60
```

---

# How Compiler Decides?

```java
c.add(10,20);
```

Compiler finds:

```java
add(int,int)
```

---

```java
c.add(10,20,30);
```

Compiler finds:

```java
add(int,int,int)
```

Decision happens at compile time.

---

# Valid Overloading

## Different Number of Parameters

```java
void show()
void show(int a)
void show(int a,int b)
```

---

## Different Data Types

```java
void show(int a)
void show(String s)
```

---

## Different Parameter Order

```java
void show(int a,String s)

void show(String s,int a)
```

---

# Invalid Overloading

Only return type changed.

❌

```java
int add(int a,int b)

double add(int a,int b)
```

Compilation error.

Because parameter list is same.

---

# Example

```java
class Printer{

    void print(int a){
        System.out.println(a);
    }

    void print(String s){
        System.out.println(s);
    }

    void print(double d){
        System.out.println(d);
    }
}
```

Usage:

```java
Printer p = new Printer();

p.print(10);

p.print("Java");

p.print(10.5);
```

Output:

```text
10
Java
10.5
```

---

# 2. Runtime Polymorphism

Also called:

```text
Method Overriding
Dynamic Binding
Late Binding
```

Decision happens at runtime.

---

# Method Overriding

Child class provides its own implementation.

---

## Example

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

# Another Example

```java
class Animal{

    void sound(){
        System.out.println("Animal Sound");
    }
}

class Cat extends Animal{

    @Override
    void sound(){
        System.out.println("Meow");
    }
}
```

Usage:

```java
Cat c = new Cat();

c.sound();
```

Output:

```text
Meow
```

---

# Runtime Polymorphism Magic

```java
Animal a = new Dog();

a.sound();
```

Output:

```text
Bark
```

---

Question:

```java
Animal a
```

Why not Animal's method?

Because:

```java
new Dog()
```

creates Dog object.

Java checks object type at runtime.

---

# Memory View

```java
Animal a = new Dog();
```

```text
Reference Type = Animal

Object Type = Dog
```

Runtime method selection uses:

```text
Object Type
```

Hence:

```java
Dog.sound()
```

is called.

---

# Multiple Runtime Examples

```java
class Animal{

    void sound(){
        System.out.println("Animal");
    }
}

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

Same reference.

Different behavior.

This is runtime polymorphism.

---

# Rules for Overriding

---

## Same Method Name

```java
void sound()
```

must match.

---

## Same Parameters

Parent:

```java
void sound()
```

Child:

```java
void sound()
```

---

## Return Type

Must be same (or covariant).

---

## Access Modifier

Cannot be more restrictive.

Parent:

```java
public void sound()
```

Child:

```java
public void sound()
```

✔

---

Child:

```java
private void sound()
```

❌ Error

---

# @Override Annotation

Recommended.

```java
@Override
void sound(){
}
```

Benefits:

* Improves readability
* Compiler checks mistakes

---

# Upcasting

Very important.

```java
Animal a = new Dog();
```

Parent reference.

Child object.

Called:

```text
Upcasting
```

---

# Why Upcasting?

Allows runtime polymorphism.

```java
Animal a = new Dog();
```

```java
Animal a = new Cat();
```

Same reference.

Different behavior.

---

# Downcasting

Convert parent reference back.

```java
Animal a = new Dog();

Dog d = (Dog)a;
```

---

# Example

```java
Dog d = new Dog();

Animal a = d;

Dog d2 = (Dog)a;
```

---

# Cannot Override

---

## Static Methods

```java
class A{

    static void show(){
    }
}

class B extends A{

    static void show(){
    }
}
```

Method hiding, not overriding.

---

## Final Methods

```java
final void show(){
}
```

Cannot override.

---

## Private Methods

```java
private void show(){
}
```

Not inherited.

Cannot override.

---

# Compile-Time vs Runtime Polymorphism

| Feature              | Overloading  | Overriding      |
| -------------------- | ------------ | --------------- |
| Binding              | Compile Time | Runtime         |
| Inheritance Required | No           | Yes             |
| Method Name          | Same         | Same            |
| Parameters           | Different    | Same            |
| Speed                | Faster       | Slightly slower |
| Polymorphism Type    | Compile-Time | Runtime         |

---

# Real Interview Example

```java
class Shape{

    void draw(){
        System.out.println("Drawing Shape");
    }
}

class Circle extends Shape{

    void draw(){
        System.out.println("Drawing Circle");
    }
}

class Rectangle extends Shape{

    void draw(){
        System.out.println("Drawing Rectangle");
    }
}
```

Usage:

```java
Shape s;

s = new Circle();
s.draw();

s = new Rectangle();
s.draw();
```

Output:

```text
Drawing Circle
Drawing Rectangle
```

---

# Why Polymorphism?

Benefits:

```text
Code Reusability
Flexibility
Loose Coupling
Extensibility
Cleaner Code
```

---

# Interview Questions

### What is polymorphism?

Ability of one entity to take many forms.

---

### Types?

```text
Compile-Time Polymorphism
Runtime Polymorphism
```

---

### Which is method overloading?

Compile-time polymorphism.

---

### Which is method overriding?

Runtime polymorphism.

---

### Does overloading require inheritance?

❌ No

---

### Does overriding require inheritance?

✅ Yes

---

### Which method is called?

```java
Animal a = new Dog();

a.sound();
```

Dog's method.

Because object type determines execution.

---

# Quick Revision

## Compile-Time

```java
class Calculator{

    int add(int a,int b)

    int add(int a,int b,int c)
}
```

Method Overloading.

---

## Runtime

```java
Animal a = new Dog();

a.sound();
```

Method Overriding.

---

## Upcasting

```java
Animal a = new Dog();
```

---

## Downcasting

```java
Dog d = (Dog)a;
```

---

# Most Important Placement Topics

Focus on:

1. Method Overloading
2. Method Overriding
3. `@Override`
4. Upcasting
5. Runtime Polymorphism
6. Difference between Overloading and Overriding

These are the polymorphism concepts most commonly asked in Java interviews and are heavily used in frameworks like Spring and Hibernate.



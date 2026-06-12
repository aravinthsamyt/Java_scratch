# 11.Constructors in Java

A **constructor** is a special method that is automatically called when an object is created.

Its main purpose is to **initialize object data**.

---

# Why Constructor?

Without constructor:

```java
class Student{
    String name;
    int age;
}

public class Main{
    public static void main(String[] args){

        Student s = new Student();

        System.out.println(s.name);
        System.out.println(s.age);
    }
}
```

Output:

```text
null
0
```

Default values are assigned.

---

Using constructor:

```java
class Student{
    String name;
    int age;

    Student(){
        name = "Malar";
        age = 20;
    }
}
```

Output:

```text
Aravinth
20
```

---

# Constructor Syntax

```java
class Student{

    Student(){
        // constructor body
    }
}
```

### Rules

✅ Constructor name must be same as class name

```java
class Student{

    Student(){
    }
}
```

---

❌ No return type

Wrong:

```java
class Student{

    void Student(){
    }
}
```

This is a method, not a constructor.

---

# When Constructor Executes?

```java
Student s = new Student();
```

Execution order:

```text
new Student()
       ↓
Memory allocated
       ↓
Constructor called
       ↓
Object returned
```

---

# Types of Constructors

## 1. Default Constructor

Created automatically by Java if you don't write any constructor.

```java
class Student{
}
```

Java internally creates:

```java
Student(){
}
```

---

Example:

```java
class Student{
}

public class Main{

    public static void main(String[] args){

        Student s =
            new Student();

        System.out.println("Object Created");
    }
}
```

---

# 2. No-Argument Constructor

Constructor written by programmer without parameters.

```java
class Student{

    Student(){
        System.out.println("Constructor Called");
    }
}
```

Usage:

```java
Student s =
    new Student();
```

Output:

```text
Constructor Called
```

---

# 3. Parameterized Constructor

Used to initialize values while creating object.

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
    new Student("Malar",20);
```

Memory:

```text
name = Aravinth
age  = 20
```

---

# Problem Without this Keyword

```java
class Student{

    String name;

    Student(String name){
        name = name;
    }
}
```

Both variables are called `name`.

Java gets confused.

---

Output:

```text
null
```

---

# Using this Keyword

```java
class Student{

    String name;

    Student(String name){
        this.name = name;
    }
}
```

Meaning:

```text
this.name
↑
instance variable

name
↑
parameter
```

---

# Complete Example

```java
class Student{

    String name;
    int age;

    Student(String name,int age){

        this.name = name;
        this.age = age;
    }

    void display(){

        System.out.println(name);
        System.out.println(age);
    }
}

public class Main{

    public static void main(String[] args){

        Student s =
            new Student("Malar",20);

        s.display();
    }
}
```

Output:

```text
Aravinth
20
```

---

# Constructor Overloading

Multiple constructors with different parameters.

```java
class Student{

    String name;
    int age;

    Student(){
        name = "Unknown";
        age = 0;
    }

    Student(String name){
        this.name = name;
    }

    Student(String name,int age){
        this.name = name;
        this.age = age;
    }
}
```

Usage:

```java
Student s1 =
    new Student();

Student s2 =
    new Student("Malar");

Student s3 =
    new Student("Malar",20);
```

---

Output:

```text
Unknown 0
Malar 0
Malar 20
```

---

# Constructor Chaining

Calling one constructor from another constructor.

Use:

```java
this(...)
```

---

Example

```java
class Student{

    String name;
    int age;

    Student(){

        this("Unknown",0);

        System.out.println(
            "Default Constructor"
        );
    }

    Student(String name,int age){

        this.name = name;
        this.age = age;
    }
}
```

Usage:

```java
Student s =
    new Student();
```

---

Execution:

```text
Default Constructor
```

Before printing, Java executes:

```java
this("Unknown",0);
```

---

# Important Rule

```java
this(...)
```

must be first statement.

❌ Wrong

```java
Student(){

    System.out.println("Hello");

    this("Aravinth",20);
}
```

Compilation error.

---

# Copy Constructor (User Defined)

Java doesn't provide a built-in copy constructor like C++.

We create it manually.

```java
class Student{

    String name;
    int age;

    Student(String name,int age){

        this.name = name;
        this.age = age;
    }

    Student(Student s){

        this.name = s.name;
        this.age = s.age;
    }
}
```

Usage:

```java
Student s1 =
    new Student("Aravinth",20);

Student s2 =
    new Student(s1);
```

---

# Constructor vs Method

| Constructor          | Method             |
| -------------------- | ------------------ |
| Same name as class   | Any name           |
| No return type       | Has return type    |
| Called automatically | Called manually    |
| Initializes object   | Performs operation |

Example:

```java
class Student{

    Student(){
        System.out.println("Constructor");
    }

    void display(){
        System.out.println("Method");
    }
}
```

Usage:

```java
Student s =
    new Student();

s.display();
```

Output:

```text
Constructor
Method
```

---

# Constructor and Inheritance

Parent constructor executes first.

```java
class Animal{

    Animal(){
        System.out.println("Animal");
    }
}

class Dog extends Animal{

    Dog(){
        System.out.println("Dog");
    }
}
```

Usage:

```java
Dog d = new Dog();
```

Output:

```text
Animal
Dog
```

---

# super() Constructor Call

Call parent constructor explicitly.

```java
class Animal{

    Animal(String name){
        System.out.println(name);
    }
}

class Dog extends Animal{

    Dog(){

        super("Animal Constructor");

        System.out.println("Dog");
    }
}
```

Output:

```text
Animal Constructor
Dog
```

---

# Private Constructor

Used to prevent object creation.

```java
class Test{

    private Test(){
    }
}
```

Now:

```java
Test t = new Test();
```

❌ Compilation Error

Used in:

* Singleton Design Pattern
* Utility Classes

---

# Constructor Execution Order

```java
class A{

    A(){
        System.out.println("A");
    }
}

class B extends A{

    B(){
        System.out.println("B");
    }
}

class C extends B{

    C(){
        System.out.println("C");
    }
}
```

Usage:

```java
new C();
```

Output:

```text
A
B
C
```

---

# Most Asked Interview Questions

### Can constructor be overloaded?

✅ Yes

```java
Student()
Student(String name)
Student(String name,int age)
```

---

### Can constructor be overridden?

❌ No

Constructors are not inherited.

---

### Can constructor be private?

✅ Yes

Used in Singleton pattern.

---

### Can constructor be static?

❌ No

```java
static Student(){
}
```

Compilation error.

---

### Can constructor return value?

❌ No

```java
Student(){
}
```

No return type allowed.

---

# Quick Revision

```java
Student(){
}

Student(String name){
    this.name = name;
}

Student(String name,int age){
    this.name = name;
    this.age = age;
}

this(...)   // constructor chaining

super(...)  // parent constructor
```

### Important Concepts

```text
Default Constructor
No-Argument Constructor
Parameterized Constructor
Constructor Overloading
Constructor Chaining
Copy Constructor
super()
this()
Private Constructor
```

### Interview Priority

1. Parameterized Constructor
2. `this` keyword
3. Constructor Overloading
4. Constructor Chaining (`this()`)
5. Inheritance + `super()`
6. Private Constructor

Master these six topics and you'll be able to answer most constructor-related interview questions confidently.



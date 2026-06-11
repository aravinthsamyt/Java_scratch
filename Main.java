// Primitive Data Types:
/*  
byte
short
int
long
float
double
char
boolean

Non-Primitive Data Types
Type Casting
*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}

                                        //Type casting:

/* 
1. Widening Casting (Implicit Casting)

Converting a smaller data type into a larger data type automatically.

Order of Widening
byte → short → int → long → float → double
          ↘
           char → int → long → float → double
           
Example
int num = 100;
double d = num;  // int to double

System.out.println(d);  // Output: 100.0

 */

/* 
2. Narrowing Casting (Explicit Casting):

Converting a larger data type into a smaller data type manually.

Example
double d = 9.78;
int num = (int)d;

System.out.println(num);

Output:

9
More Examples
long l = 1000;
int i = (int)l;

int x = 130;
byte b = (byte)x;

Output:

-126
*/
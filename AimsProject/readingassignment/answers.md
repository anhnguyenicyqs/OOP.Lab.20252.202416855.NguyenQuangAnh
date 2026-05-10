# Reading Assignment - Lab 03: Polymorphism

## 1. What are the advantages of Polymorphism?
- Code reusability: one method works for many types (e.g., `toString()` called on Media, DVD, Book, CD).
- Flexibility: new subclasses can be added without changing existing code.
- Simplifies code: use a single reference type (e.g., `Media`) to handle different objects.
- Enables the Open/Closed Principle: open for extension, closed for modification.

## 2. How is Inheritance useful to achieve Polymorphism in Java?
- Inheritance creates an IS-A relationship (e.g., DigitalVideoDisc IS-A Media).
- A parent class reference can point to a child class object.
- When a method is called on the parent reference, Java calls the overridden version in the child (runtime polymorphism / dynamic dispatch).
- Example: `Media m = new DigitalVideoDisc(...)` then `m.toString()` calls DVD's toString(), not Media's.

## 3. What are the differences between Polymorphism and Inheritance in Java?
| | Inheritance | Polymorphism |
|---|---|---|
| Definition | A class inherits fields/methods from a parent class | One interface/method behaves differently based on object type |
| Purpose | Code reuse, hierarchy | Flexibility, extensibility |
| Type | Compile-time relationship | Can be compile-time (overloading) or runtime (overriding) |
| Example | `Book extends Media` | `Media m = new Book(...)` then `m.toString()` |

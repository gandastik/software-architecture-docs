## Object Oriented Concepts (Recap)

### Procedural Programming
- the code of a program is typically divided into groups of smaller parts of code called **procedures**
  - procedure = function
- each procedures consists of a series of computational steps to perform a specific task
  - แต่ละ procedures จะประกอบไปด้วยคำสั่งต่างๆที่จะทำหน้าที่ที่แตกต่างกันออกไป
- procedure take input(s) and may return output(s)
- ทำให้การออกแบบ software จะเป็นการทำมาจากการ organizing groups of functions and/or passing data among them
- eg. Fortran, Cobol, Pascal, C
- **Warning**: the followings are mostly opinion-based
  - the imporatance is given to operations(procedures/functions) rather than data
    - ความสำคัญในการเขียนโค้ดจะไปเน้นในด้าน funciton มากกว่าข้อมูล
  - the data is often seperated from the procedures as the paradigm does not provided a common approach to bind the data and operation together
    - data ถูกแยกออกไปจาก procedure อย่างสิ้นเชิง
  - data access restrictions cannot be associated directly with the data
    - การจำกัดการเข้าถึง data ไม่สามารถทำได้โดยตรงกับ data แต่ต้องไป ทำภายใน operations อีกที
  - it is difficult to represent real world object

### Obejct Oriented Programming
- code of one program is divided into smaller part called **objects**
- object typically contains both its data(state) and operations(behavior)
- the ***access*** to members of one object can be controlled by the definition of an object itself
- software is designed by using objects that interact with one another
- eg. C++, Python, PHP, Java, C#

![](https://media.discordapp.net/attachments/1014398974649708624/1029589427254730802/unknown.png?width=1302&height=640)

### Class
- class is a data structure that can hold both variables and functions
- class provide clustering mechanism for related functions (methods) along with related variables (attributes)
- class -> blueprint or prototype for creating objects
- programmers can use the same class and therefore the same code over and over again to create different objects
- classes hide their data representation from all code except their own classes
- OOP -> we design construct a set of classes -> ต้องเขียน classes to accomplish what the program needs to do
- object ถูกสร้างมาเมื่อตอน runtime ของ program

### The bid idea of OOP
- "I'm sorry that I long ago coined the term **objects** for this topic because
 it gets many people to focus on the lesser idea. The big idea is **messaging**"

### Object and Messaging
- each object provides a service, or performs an action, that is used by other objects
- action is initiated in OOP by the transmission of a message to an object responsible for the action
  - มีการส่ง message ไปยัง object ที่รับผิดชอบหน้าที่นั้นๆ
- message encodes the request for an action and is accompanied by any additional information(argument)
- fundamental concept in OOP is to describe behavior in term of **responsibility**

### Encapsulation
- the mechanism that binds together code and the data it manipulates, and keeps both safe from outside interference and misuse
  - คือการทำ private -> setters, getters
### Inheritance
- the process by which one object acquires the properties of another class or another object
  - [subclass or child] vs [superclass or base class or parent]
- supports the concept of hierarchical classification
- make sure the 2 classes(parent and child) has a **"Is a"** relationship
### Abstraction
- data from a traditional process-oriented program can be transformed by abstraction into its component objects
- a sequence of process steps can become a collection of messages between these objects
- each of these objects describes its own unique behavior
### Polymorphism
- allow one interface to be used for a general class of actions.
the specific action is determined by the exact nature of the situation
- by inheriting its superclass features, an subclass is still a member of superclass. It
can execute all of it's methods as well as those of the superclass
- **ability to be both a member of subclass and a superclass is called Polymorphism**

## Software Design Principles

### Design Smells
- "Design smells are the odors of rotting software"
- **Rigidity**: inability to be changed or adapted
  - **the tendency for software to be difficult to change**
  - ถ้าการออกแบบจะมีความ rigid ก็ต่อเมื่อการเปลี่ยนแปลงส่วนหนึ่งจะส่งผลต่อการเปลี่ยนแปลงในส่วนอื่นๆไปด้วย
  - the more modules that must be changed, the more rigid the design
- **Fragility**: quality of being easily broken or damaged
  - **the tendency of a program to break in many places when a single change is made**
  - ส่วนมาก ปัญหาใหม่ๆจะอยู่ใน area that have no conceptual relationship กับ area that was changed
  - fixing those problems leads to even more problems -> "dog chasing its tail"
- **Immobility**: the state of not moving; motionless
  - **the inability to reuse software from other projects or from parts of the same project**
  - design จะมีความ immobile เมื่อมันประกอบไปด้วยส่วนที่สามารถเป็นประโยชน์ได้กับระบบอื่น แต่การที่จะไปทำให้
  ไปเกิดประโยชน์จริงนั้นทำได้ยากและมีความเสี่ยงสูง
  - immobile software components is simply rewritten instead of reused
- **Viscosity**: the state of being thick, sticky, and semifluid in consistency, due to internal friction
  - ในกรณีที่ software มี change แต่ dev สามารถมี more than one way to make that change. some of the ways preserve the design; others do not.
  **When the design-preserving methods are more difficult to use than the hacks** -> viscosity is high
- **Needless complexitity**
  - when **it contains elements that aren't currently useful**
- **Needless repetition**
  - when the **same code appears over and over again, in slightly different forms** -> missing an abstraction
- **Opacity**: the condition of lacking transparency or translucence; opaqueness
  - **the tendency of a module to be difficult to understand**
  - "When I wrote it, only god and I knew the meaning; Now god along knows."
- **Why Software Rots**
  - because requirements change in ways that the initial design did not anticipate
    - มีความต้องการที่เปลี่ยนแปลงไปทำให้ design แรกไม่ได้รองรับไว้
  - often, theses change made by developers who are not familiar with the original design philosophy
  - **"Change is inevitable; change is constant."**

### SOLID Principles
- solves the problems of [**Design Smells**](#design-smells)
- "On the one hand, if the bricks aren't well made, the architecture of the building doesn't matter much.
  On the other hand, you can make a substantial mess with well-made bricks"
- SOLID เป็นตัวย่อมาจาก 5 principles for object-oriented class design
- เป็นการให้แนวทางสำหรับการจัดเรียง functions และ data structures ให้มาเป็น classes, และ how those classes should be interconnected
- the goal of the principles is the creation of **mid-level** software structures that:
  - **tolerate change**
  - **are easy to understand**
  - **are the basis of components that can be used in many software systems**
  - mid-level = developers working at the modules level

### Single-Responsibility Principle (SRP)
- **"A module should be responsible to one, and only one, actor"**
- ควรจะมีเหตุผลเดียวๆ เท่านั้นที่ควรจะมาแก้โค้ดส่วนๆนั้น

#### Bad Example: SRP Violation
![](https://media.discordapp.net/attachments/1014398974649708624/1029617563157667950/unknown.png)
- three methods are responbile to three very different actors

#### Good Example: Fixing SRP Violation
![](https://media.discordapp.net/attachments/1014398974649708624/1029617771941732352/unknown.png)

### The Open-Closed Principle
- **"Software entities(classes, modules, functions, etc.) should be open for extension but closed for modification"**
- ง่ายๆคือ behavior ของ software entity ควรที่จะสามารถต่อยอดออกไปได้ โดยทีไม่ต้องไปเปลี่ยนแปลง entity นั้นๆ

### The Liskov Substitution Principle
- **"Subtype Requirement: Let o(x) be a property provable about objects x for type T.
Then o(y) should be true for objects y for type S where S is a subtype of T"**
- ง่ายๆคือ subclasses ควรที่จะสามารถ ใช้แทนกันได้ระหว่าง base classes ของมัน
- ***behavioral subtyping***
![](https://media.discordapp.net/attachments/1014398974649708624/1029619098092572752/unknown.png)

### The

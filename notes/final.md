## UML

### UML Diagram Types
- Graphical language for visualizing, ... the artifacts of software intensive-system
![](https://media.discordapp.net/attachments/1014398974649708624/1021980073491963974/unknown.png?width=717&height=284)

### 4+1 View Model of Software Architecture
![](https://media.discordapp.net/attachments/1014398974649708624/1021983523021783060/unknown.png?width=1440&height=602)
- **Logical View**
  - อธิบายส่วนของนามธรรมของคำอธิบายของชิ้นส่วนของระบบ (abstraction description of system's parts)
  - สร้างขึ้นมาเพื่อแสดงให้เป็น model ของระบบบอกว่าสร้างมาจากอะไรบ้าง และแต่ละส่วนติดต่อกันอย่างไร
  - ส่วนมากจะแบ่งเป็น object or object class
  - ref to UML -> **Class Diagram**
- **Process View**
  - ใช้ในการอธิบาย processes within your system
  - A process is a grouping of tasks that form an executable unit
  - ซอฟต์แวร์ประกอบไปด้วย task ที่ independent กัน -> task is a seperate thread of control
  - UML -> **Activity Diagram**
- **Development View**
  - อธิบายว่าจัดเรียงเป็นโมดูลอย่างไรและ component อย่างไร
  - this view focuses on the configuration management of a system; **what components depend on what**
  - UML -> **Component Diagram**
- **Physical View**
  - อธิบายทำงานว่า system's component ทำงานอย่างไรใน environment นั้นๆ
- **Scenario** (+1 view)
  - อธิบายถึง functionality of the system ซึ่งจะถูก model จากมุมมองของ user และ/หรือจากคนภายนอก
  - UML -> **Use-case Diagram**

  ## Object Oriented Programming
 -  code of one program is divided into smaller part called **objects**
 - object typically contains both its data(state) and operations(behavior)
 - the **access** to members of one object can be controlled by the definitions of an object itself

### Class
- class is a data structure that can hold both variables and functions
- class provide clustering mechanism for related functions (methods) along with related variables (attributes)
- class -> blueprints or prototype for creating objects
- programmers can use the same class and therefore the same code over and over again to create different objects
- classes hide their data representation from all code except their own classes
- OOP -> we design construct a set of classes -> ต้องเขียน classes to accomplish what the program needs to do
- object ถูกสร้างมาเมื่อตอน runtime ของ program

### Object and Messaging
- each object provides a service, or performs an action, that is used by other objects
- action is initiated in OOP by the transmission of a message to an object responsible for the action
	- มีการส่ง message ไปยัง object ที่รับผิดชอบหน้าที่นั้นๆ
- message encodes the request for an action and is accompanied by any additional information(argument)
- fundamental concept in OOP is to describe behavior in term of **responsibility**

### Encapsulation
- the mechanism that binds together code and the data it manipulates, and keeps both safe from outside interference and misuse

### Inheritance
- the process by which one object acquires the properties of another class or another object
- supports the concept of hierarchical classification
- make sure the 2 classes(parent and child) has a **"is a"** relationship

### Abstraction
- data from a traditional process-oriented program can be transformed by abstraction into its component objects
- a sequence of process steps can become a collection of messages between these objects
- each of these objects describes its own unique behavior

### Polymorphism
- allow one interface to be used for a general class of actions. the specific action is determined by the exact nature of the situation
- by inheriting its superclass features, a subclass is still a member of superclass. it can execute all of it's methods as well as those of the superclass
- **ability to be both a member of subclass and a superclass is called Polymorhpism**

## Software Design Principles

### Design Smells
- "Design smells are the odors of rotting software"
- **Rigidity**: inability to be changed or adapted
	- **the tendency for software to be difficult to change**
	- ถ้าการออกแบบจะมีความ rigid ก็ต่อเมื่อการเปลี่ยนแปลงส่วนหนึ่งจะส่งผลต่อการเปลี่ยนแปลงในส่วนอื่นๆไปด้วย
	- the more modules that must be changed, the more rigid the design
- **Fragility**: quality of being easily broken or damaged
	- **the tendency of  a program to break in many places when a single change is made**
	- ส่วนมาก ปัญหาใหม่ๆจะอยู่ใน are that have no conceptual relationship กับ area that was changed
	- fixing those problems leads to even more problems -> "dog chasing its tail"
- **Immobility**: the state of not moving; motionless
	- **the inability to reuse software from other projects or from parts of the same project**
	- design จะมีความ immobile เมื่อมันประกอบด้วยส่วนที่สามารถเป็นประโยชน์ได้กับระบบอื่น แต่การที่จะไปทำให้ไปเกิดประโยชน์จริงนั้น ทำได้ยากและมีความเสี่ยงสูง
- **Viscosity**: the state of being thick, sticky, and semifluid in consistency, due to internal friction
	- ในกรณี software มี change แต่ dev สามารถมี more than one way to make that change. some of the ways preserve the design; others do not.
	- **when the design-preserving methods are more diffcult to use than the hacks** -> vicosity is high
- **Needless complexity**: when it **contains elements that aren't currently useful**
- **Needless repetition**: when the **same code appears over and over again, in slightly different forms** -> missing an abstraction
- **Opacity**: the codition of lacking transparency or translucence; opaqueness
	- **the tendency of a module to be difficult to understand**
	- "When I wrote it, only god and I knew the meaning; Now only god knows."
- **Why software rots?**
	- because requirements change in ways that the initial design did not anticipate
		- เพราะว่าความต้องการเปลี่ยนแปลงไป จน design ไม่ได้คิดเผื่อไว้
	- often, these change made by developers who are not familiar with the original design philosophy
	- **"Change is inevitable; change is constant"**

## SOLID Principles
- แก้ปัญหาของ [Design Smells](#design-smells)
- แนวทางสำหรับการจัดเรียง functions และ data structures ให้มาเป็น classes, และ how those classes should be interconnected
- the goal of the principles is the creation of **mid-level** software structures that:
	- **tolerate change**
	- **are easy to understand**
	- **are the basis of components that can be used in many software systems**
	- mid-level = developers working at the modules level

### Single-Responsibilty Principle (SRP)
- **"A module should be responsible to one, and only one, actor"
- ควรจะมีเหตุผลเดียวๆ เท่านั้นที่ควรจะมาแก้โค้ดส่วนๆนั้น

#### Bad Example: SRP Violation
![](https://media.discordapp.net/attachments/1014398974649708624/1029617563157667950/unknown.png)
#### Good Example: Fixing SRP Violation
![](https://media.discordapp.net/attachments/1014398974649708624/1029617771941732352/unknown.png)

### The Open-Closed Principle
- "Software entities(classes, modules, functions, etc.) should be open for extension but closed for modification"
- ง่ายๆคือ behavior ของ software entity ควรที่จะสามารถต่อยอดออกไปได้ โดยที่ไม่ต้องไปเปลี่ยนแปลง entity นั้นๆ
- arguably the most important

### The Liskov Substitution Principle
- **"Subtype Requirement: Let o(x) be a property porvable about objects x for type T. Then o(y) should be true for objects y for type S where S is a subtype of T"
- ง่ายๆคือ subclasses ควรที่จะสามารถใช้แทนกันได้ระหว่าง base classes ของมัน

#### Bad Example: LSP Violation
![](https://media.discordapp.net/attachments/1014398974649708624/1029619098092572752/unknown.png)
![](https://media.discordapp.net/attachments/1014398974649708624/1046074601102377055/image.png?width=1440&height=577)

### The Interface Segregation Principle
- **"Many client specific interfaces are better than one general purpose interface."**
- ถ้ามีคลาสที่มีหลายๆ client ก็ควรที่จะสร้าง interface สำหรับแต่ละ client และ multiply inherit them into the class

#### Bad Example: ISP Violation
![](https://media.discordapp.net/attachments/1014398974649708624/1046075392206848101/image.png?width=1068&height=685)
#### Good Example: Fixing ISP Violation
![](https://media.discordapp.net/attachments/1014398974649708624/1046075497060253728/image.png?width=1065&height=685)

### The Dependency Inversion Principle
- **"High-level modules should not depend on low-level modules. Both should depend on abstractions"**
- **"Abstractions should not depend upon details. Details should depend on abstraction"**

#### Bad Example: DIP Violation
![](https://media.discordapp.net/attachments/1014398974649708624/1046076139434684447/image.png)

#### Good Example: Fixing DIP Violation
![](https://media.discordapp.net/attachments/1014398974649708624/1046076291604041728/image.png)

#### Dependence on Abstractions
- การตีความของ DIP สามารถพูดง่ายๆได้จะเป็น -> "Depend on abstractions"
	- no variable should hold a reference to a concrete class
	- no class should derive from a concrete class
	- no method should override an implemented method of any of its base classes


## Design Patterns

### Benefits & Limitations
- **Benefits**
	- Design reuse
	- Uniform design vocabulary 
	- Enhance understanding, restructuring, & team communication
	- Basic for automation: design patterns -> standards -> testability
- **Limitations**
	- Require significant tedious & error-prone human effort to handcraft patterns implementations design reuse
	- Can be decpetively simple uniform design vocabulary
	- May limit design options
	- Leaves important (implementations) details unsolved

## Creational Design Patterns
- เกี่ยวกับการ Instantiate object -> increase flexibility and reuse of existing code

### Factory Method
- **Problem**
	- How can an object be created so that subclasses can redefine which class to instantiate?
		- Object จะถูกสร้างอย่างไร เพื่อที่จะให้ subclasses สามารถ redefine ว่า class ไหนจะเป็นตัว instantiate
	- How can a class defer instantiation to subclass?
- **Aplicability**
	- When a class cannot anticipate the objects it must create or a class wants its subclasses to specify the object its created
- **Solution**
	- intent to provide an interface for creating an object, but leave choice of object's concrete type to a subclass
	- define a seperate operation (factory method) for creating an object
	- create an object by calling a factory method
![](https://media.discordapp.net/attachments/1014398974649708624/1032131550243979264/unknown.png?width=1202&height=685)
- **จากรูป** คือ จะมีคลาสที่ทำหน้าที่เป็น creator ของ Product A, B เพื่อเป็นจุดที่จะให้ client code มาใช้งานเพื่อที่จะทำการ instantiate concrete class จาก class creator อีกที
- **Consequences**
	- (+) ด้วยการที่หลีกเลี่ยงการระบุชื่อของ concrete class รวมไปถึงรายละเอียดในการสร้าง object นั้น มันจะทำให้โค้ดมีความ flexible และมี
	การ **isolates code สำหรับ construction และ representation**
	- (+) client จะ depend only to the interface (ในรูปข้างบนก็คือ IProduct)
	- (-) construction of objects requires one additional class in some cases
	- ลด coupling 𛱠
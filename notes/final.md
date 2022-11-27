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
	- (+) ด้วยการที่หลีกเลี่ยงการระบุชื่อของ concrete class รวมไปถึงรายละเอียดในการสร้าง object นั้น มันจะทำให้โค้ดมีความ flexible และมีการ **isolates code สำหรับ construction และ representation**
	- (+) client จะ depend only to the interface (ในรูปข้างบนก็คือ IProduct)
	- (-) construction of objects requires one additional class in some cases
	- ลด coupling 𛱠

### Abstract Factory
**Problem**
	- How can an application be independent of how its objects are created?
	- How can a class be independent of how the objects it requires are created?
	- How can families of related or dependent objects be created?
- **Applicability**
	- when clients cannot anticipate groups of classes to instantiate
- **Solution**
	- intent to create families of realted objects without specifying subclass names
	- encapsulate object creation in a seperate (factory) object. That is, define an interface (AbstractFactory) for creating objects, and implement the interface
	- a class delegates object creation to a factory object instead of creating objects directly
![](https://media.discordapp.net/attachments/1014398974649708624/1032141181120958494/unknown.png?width=1201&height=685)
- **Consequences**
	  - (+) flexibility -> removes types (i.e. subclass) dependencies from client
	  - (+) abstraction & sematic checking: hides product's composition
	  - (-) hard to extend factory interface to create new product

### Builder
- **Problem**
	- How can a class (the same construction process) create different representation of a complex object?
	- How can a class that includes creating a complex object be simplified?
- **Applicability**
	- need to isolate knowledge of the creation of a complex object from its parts
	- need to allow different implementations/interfaces of an object's parts
- **Solution**
	- intent to sepearate the construction of a complex object from its representation so that the same construction process can create different representation
	- encapsulate creating and assembling the parts of a complex object in a seperate Builder object
	- a class delegates object to a Builder object instead of creating the objects directly
![](https://media.discordapp.net/attachments/1014398974649708624/1046265556266917909/image.png?width=1312&height=685)  
- **Consequences**
	- (+) can vary a product's internal representation
	- (+) isolates code for construction & representation
	- (+) finer control over the construction process
	- (-) may involve a lot of classes

### Prototype
- **Problem**
	- How can a objects be created so that which objects to create can be specified at run-time?
	- How can dynamically loaded classes be instantiated?
- **Applicability**
	- when a system should be independent of how its products are created, composed, & represented
	- when the classes to instantiate are specified at run-time
- **Solution**
	- intent to specify the kinds of objects to create using a prototypical instance & create new objects by copying this prototype
	- define a ***Prototype*** object that returns a copy of itself
	- create new objects by copying a ***Prototype*** object
![](https://media.discordapp.net/attachments/1014398974649708624/1046267393170755645/image.png?width=1144&height=685)
- **Consequences**
	- (+) can add & remove classes at runtime by cloning them as needed
	- (+) reduced subclassing minimizes/eliminates need for lexical dependencies at run-time
	- (-) every class that used as a prototype must itself be instantiated
	- (-) classes that have circular references to other classes cannot really be cloned

### Singleton
- **Problem**
	- ensure that a class only has one instance
	- easily access the sole instance of a class
	- control its instantiation
	- restrict the number of instances
- **Applicability**
	- when there must be exactly one instance of a class & it must be accessible from a well-known access point
	- when the sole instance should be extensible by subclassing & clients should be able to use and extended instance without modifying their code
- **Solution**
	- intent to ensure a class only ever has one instance & provide a global point of access
	- hide the constructors of the class (make private the constructors)
	- define a public static operation (getInstance()) that returns the sole instance of the class
![](https://media.discordapp.net/attachments/1014398974649708624/1046268311064817684/image.png?width=1376&height=685)
- **Consequences**
	- (+) reduces namespace pollution
	- (+) makes it easy to change your mind & allow more than one instance
	- (+) allow extension by subclassing
	- (-) same drawbacks of a global if misused
	- (-) implementation may be less efficient than a global
	- (-) concurrency/cache pitfalls & communication overhead

### Dependency Injection
- **Problem**
	- How can a class be independent of how the objects on which it depends are created?
	- How can the way objects are created be specified in seperate configuration files?
	- How can an application support different configurations?
- **Solution**
	- intent to sepearte the creation of a client's dependencies from the client's behavior, which promotes loosely coupled programs and the dependency inversion and single responsbility principles
![](https://media.discordapp.net/attachments/752199659270963250/1032161892212408330/unknown.png?width=1357&height=685)
- **Consequences**
	- (+) help in unit testing
	- (+) boiler plate code is reduced, as initializing of dependencies is done by the injector component
	- (+) helps to enable loose coupling, which is important in application programming
	- (-) it's a bit complext to learn (????), and if overused can lead to management issues and other problems
	- (-) many complie time errors are pushed to run-time

## Structural Design Patterns

### Facade
- "ฉากหน้า"
- **Problems**:
	- How to make a complex subsystem easier to use?
	- How can the dependencies on a subsystem be minimized?
- **Applicability**:
	- simple interface is required to access a complex system
		- บรรดาพวก public methods ที่ไว้ให้ผู้อื่นใช้ or public APIs
	- a system is very copmlex or difficult to understand
	- an entry point is needed to each level of layered software
	- the abstraction and implementation of a subsystem are tightly coupled
- **Solution**: 
	- *intent* to provide unified interface to a set of interfaces in a subsytem 
	
![](https://media.discordapp.net/attachments/1014398974649708624/1034658575282356224/unknown.png?width=1301&height=685)

- **Consequences**: 
	- (+) client code can be isolated from the complexity of a subsystem
	- (-) Facade can become ***god object*** coupled to all classes of an app

### Composite
- aka. "Object Tree"
- **Problem**:
	- how to represent a part-whole hierarchy so that clients can treat part and whole objects uniformly?
	- how to represent a part-whole hierarchy with tree structures?
- **Applicability**:
	- Objects must be composed recursively
	- No distinction between individual & composed elements
	- Objects in structure can be treated uniformly (เรียกตัวเดียวๆ หรือจะเรียกเป็นตัว collection ของ object ก็จะไม่ต่างกัน eg. list of person or one person are treated the same)
- **Solution**:
	- ***intent*** to treat individual objects & multiple, recursively-composed objects uniformly
	- define a unified component interface for both part (Leaf) objects and whole (Composite) objects
	- individual leaf object implement the composite interface directly, and Composite objects forward request to their child components
![](https://media.discordapp.net/attachments/1014398974649708624/1034664912309461002/unknown.png?width=1306&height=685)

- **Consequences**:
	- (+) Uniformly: treat components the same regardless of complexity
	- (+) Extensibility: new component subclasses work wherever old ones do
	- (-) Overhead: might need prohibitive numbers of objects
	- (-) Awkward designs: may need to treat leaves as lobotomized(ฝืน) composites in some cases

### Decorator
- "Wrapper" คือจะคล้ายๆกับ  russian dolls มีการเรียกตามๆตัวที่ถูก wrapped ลงไปเรื่อยๆ
- **Problems**:
	- how to add responsibilities to (and removed from) an object dynamically at run-time?
	- how to provide a flexible alternative to subclassing for extending functionality?
- **Applicability**:
	- when responbilities are needed to add to individual objects dynamically and transparently
	- when such responsibilities can be withdrawn from objects
	- when extension by subclassing is impractical
- **Solution**:
	- ***intent*** to attach additional responsibilties to an object dynamically
	- define decorator objects that implement the interface of the extended (decorated) object (component) transparently by forwarding all request to it
	- such decorator objects may perform additional functionality before/after forwarding a request
	
![](https://media.discordapp.net/attachments/1014398974649708624/1034680044569759774/unknown.png?width=1051&height=685)
- **Consequences**:
	- (+) Add or remove responsibilities from an object at runtime
	- (+) SRP: many variants of behavior can be implemented with several smaller class
	- (-) hard to remove specific wrapper from the wrapper stack
	- (-) certaint variants of behavior may depend on the order of the decorators stack

### Proxy
- "fences" คล้ายเป็นยามเฝ้าประตูว่าให้ client ตัวไหนสามารถเรียกใช้ service ตัวนั้นๆได้
- **Problems**:
	- how to control the access to an object?
	- how to provide additional functionality when accessing an object?
- **Applicability**:
	- There are dozen ways to use this patterns -> see https://refactoring.guru/design-patterns/proxy
- **Solution**:
	- ***intent*** to provide a surrogate or placeholder for another object to control access to it
	- define a seperate proxy object that can be used as subtitute for another object
	- such a proxy object implements additional functionality to control the access to this subject
	
![](https://media.discordapp.net/attachments/1014398974649708624/1034687932386254898/unknown.png?width=1306&height=685)

- **Consequences**:
	- (+) Service object can be controlled without clients' awareness
	- (+) OCP: introduction new proxies without change service to clients
	- (-) Overhead: the response from the service might get delayed

### Flyweight
- ligth like a feather -> performance (reduce memory consumption)
- **Problem**:
	- how to minimizes memory usage by sharing some of object data with other similar object?
- **Applicability**:
	- an application needs to spawn a huge number of similar object
	- the objects contain duplicate states which can be extracted and shared between multiple objects
- **Solution**:
	- ***intent*** to use sharing to support large numbers of fine-grained objects efficiently
	- define a flyweight object to store shared *intrinsic state*, constant data of objects
	- *extrinsic state*, the rest of the object's state that can be altered, should be stored in another object with a reference to a flyweight object
![](https://media.discordapp.net/attachments/1014398974649708624/1046277036018245692/image.png?width=1331&height=685)
- **Consequences**:
	- (+) saves lots of RAM
	- (-) trading RAM over CPU cycles in some cases
	- (-) code become more complicated

## Behavioral Design Patterns

### Strategy
- "กลยุทธ์/ยุทธศาสตร์" -> ลำดับขั้นของ operation
- **Problems**:
	- how to independently very algorithm from clients that use it?
	- how to defer the decision about which algorithm to use until runtime?
- **Applicability**:
	- when an object should be configurable with one of many algorithms
	- and all algorithms can be encapsulated
	- and one interface covers all encapsulations
- **Soluiton**:
	- intent to define a family of algorithms, encapsulates each one & make them interchangable to let clients & algorithms vary independently
		- เป็นการนิยามให้มีหลากหลายอัลกอ โดยที่จะ encap แต่ละตัวแล้วทำให้มันใช้เปลี่ยนแปลงกันได้
		
![](https://media.discordapp.net/attachments/1014398974649708624/1037192709850533928/unknown.png?width=1268&height=685)

- **Consequences**:
	- (+) greater flexibility, reuse.
	- (+) can change algorithms dynamically
	- (-) strategy creation & communication overhead
	- (-) inflexible strategy interface
	- (-) semantic incompatibility of multiple strategies used together
		- คำที่ใช้มีความหมายใช้เข้ากันไม่ค่อยได้
		
### Observer
- "รอฟัง" aka **Event-Subscriber, Listener**
- **Problems**:
	- A one-to-many dependency between objects should be defined without making the objects tightly coupled
		- การที่ dependency มีความเชื่อมโยงกันเป็นแบบ 1-to-many แต่ต้องการที่จะทำให้ไม่เกิด tightly coupled
	- It should be ensured that when one object changes state, an open-ended number of dependent objects are updated automatically
		- same with "Publish-subscribe"
	- It should be possible that one objecct can notify an open-ended number of other objects
- **Applicability**:
	- an abstraction has two aspects, one depends on the other
	- a change to one object required chaning untold others
	- an object should notify unknown other objects
- **Solution**:
	- intent to define one-to-many dependency between objects so that when one object change state, all dependent are notified & updated
	- define Subject and Observer objects
	- So that when a subject changes state, all registerd observers are notified and updated automatically (prob asynchronously)

![](https://media.discordapp.net/attachments/1014398974649708624/1037199955321954344/unknown.png?width=1296&height=685)

- **Consequences**:
	- (+) modularity: subject & observers may vary independently
	- (+) extensibility: can define & add any number of observers
	- (+) customizability: different observers offer different views of subject
	- (-) unexpected updates: observers don't know about each other
	- (-) update overhead: might need hints or filtering

### Command
- aka. "Action", "Transaction"
- **Problems**:
	- coupling the invoker of a request to a particular request should be avoided. "hard-wired request should be avoided"
	- it should be possible to configure an object (that invoke a request) with a request
- **Applicability**:
	- to parameterize objects with an action to perform
	- to specify, queue & execute requests at different times
	- for multilevel undo
- **Solution**:
	- intent to encapsulate the request for a service
	- define seperate (command) objects that encapsulate a request
	- a class delegates a request to a command object instead of implementing a particular request directly
	
![](https://media.discordapp.net/attachments/1014398974649708624/1037213738039779348/unknown.png?width=1383&height=684)

- **Consequences**:
	- (+) Abstracts executor of a service
	- (+) Supports arbitrary-level undo-redo
	- (+) Composition yields macro-commands
	- (-) Might result in lots of trivial command subclasses
	- (-) Excessive memory may be needed to support undo/redo operations

### Template Methods
- **Problems**:
	- How to define the overall structure of the operation in base class, but allow subclasses to refine, or redefine, certain steps?
- **Applicability**:
	- Implement invariant aspects of an algorithm once & let sublcasses define variant parts
		- implement ส่วนที่เหมือนๆกันไว้รอบเดียว แล้วให้ subclass ไปประยุกต์ส่วนที่แตกต่างกันออกไปเอง
	- localize common behavior in a class to increase code resuse
	- control subclass extensions
- **Solution**:
	- intent to provide a skeleton of an alogrithm in a method, deferring some steps to subclasses
	- 2 parts
	- the "template method" is implemented as a method in a base class (usually an abstract class). This method contains code for the parts of the overall algorithm that are invariant. ทำให้ template สามารมั่นใจได้ว่า overarching algorithm จะเป็นไปตามที่กำหนดไว้
	- subclasses of the base class "fill in" the empty or "variant" part of the "template"

![](https://media.discordapp.net/attachments/1014398974649708624/1037221413620289556/unknown.png?width=1019&height=685)

- **Consequences**:
	- (+) Leads to inversion of control ("don't call us - we'll call you")
	- (+) Promotes code reuse
	- (+) Lets you enforce overriding rules
	- (-) Must subclass to specialize behavior

### Iterator
- **Problems**:
	- the elements of an aggregate object should be accessed and traversed without exposing its representation (data structure)
		- คืออยาก traverse "colletion of something" โดยที่ไม่จำเป็นต้องรู้ว่า data structure นั้นมันเก็บอะไรอยู่
	- new traversal operations should be defined for an aggregate object without changing its interface
- **Applicability**:
	- require multiple traversal algorithms over an aggregate
	- require a uniform traversal interface over different aggregate
	- when aggregate classes & traversal algorithm must vary independently
- **Solution**:
	- intent to access elements of an aggregate (container) without exposing its representaion
	- define a seperate (iterator) object that encapsulates accessing and traversing an aggregate object
	- clients use an iterator to access and traverse an aggregate without knowing its representation

![](https://media.discordapp.net/attachments/1014398974649708624/1037225210526568508/unknown.png?width=1051&height=685)

- **Consequences**:
	- (+) Flexibility: aggregate & traversal are independent
	- (+) Support multiple iterators & multiple traversal algorithms
	- (-) Incur additional communication overhead between iterator & aggregate 
	- (-) problematics in distributed systems

### Null Object
- **Problems**:
	- in most object-oriented languages, references may be null
	- these references need to be checked to ensure they are not null before invoking any methods, because methods typically cannot be invoked on null references
	- how can the absence of an object - the presence of a null reference - be treated transparently
- **Applicability**:
	- an object requires a collaborator
		- obj มีคนมาเรียกใช้
	- some collaborator instances should do nothing
	- you want to abstract the handling of null away from the client
		- ไม่อยากให้ client มา handle null exception
- **Solution**:
	- intent to provide an object as a surrogate for the lack of an object of a given type
		- สร้าง obj ขึ้นมาแทนที่ โดยที่ใน obj นั้นไม่ได้ทำอะไรเลย
	- the use of a Null Object, an object with no referenced value or with defined neutral ("null") behavior
	- the behavior (or lack thereof) of such objects
	
![](https://media.discordapp.net/attachments/1014398974649708624/1037232576928165928/unknown.png?width=1328&height=685)

- **Consequences**:
	- (+) Simplifies client code, because it avoids having to write testing code which handles the null collaborator specially
	- (-) Can be difficult to implement if various clients do not agree on how the null object should do nothings as when your AbstractObject interface is not well defined
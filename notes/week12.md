## Software Design Patterns

### Off topics
- สหกิจสอบเขียนโค้ด
- ใช้ C, python ก็ไม่ต่างกันมาก
- editor -> vscode, codeblock, devC .. ไว้ให้
- อาจารย์สหกิจเพิ่มขึ้น อาจจะรองรับได้ถึง 40-45 คน 😃
- ข้อสอบใช้ความรู้จากที่เรียนมาสองปีแรก
- แนะนำให้ใช้ python มี tools ให้ภายในคอมมี vscode ให้ใช้ได้
- สอบช่วงเย็นประมาณ 17:00 ของวันอังคาร หรือวันพุธ
- เล่าประสบการณ์ต่างๆ บลาๆๆ ~~~
- ไม่จำเป็นต้องสหกิจก็ได้ ถ้าเกิดว่าฝีกงานแล้วบริษัทชอบ -> job opportunity
- แนะนำบริษัท
  - Agoda
  - Refinitiv (Thompson's Reutuer)

##  Design Patterns
### What ?
- a general, resuable solution to a commonly occurring problem in the context of modular software design.
- ตามเดิมแล้วมาจาก **ด้านสถาปัตยกรรม**
- in 94s, concept of software design patterns for object-oriented software was published by "the Gang of Four"
- GoF -> Erich Gamma, John Vlissides, Ralph Johnson and Richard Helm
- their book is often called "the GoF book". originally covers 23 classics design patterns
- more and more design patterns are introduced

### Relationship with Other Design Concepts
![](https://media.discordapp.net/attachments/1014398974649708624/1032124057375756318/unknown.png)
- Architecture Styles ส่งผลต่อ QAs
- Reference Architectures / Domain Specific Architectures
  - ซึ่งจะติดมากับ framework -> อาจจะมีการใช้อะไรที่มากับ framework
- Design Patterns
  - แก้ปัญหาที่เขียนโค้ดเป็น modules และพบเจอปัญหาที่ซ้ำๆ ทำให้มีการออกแบบขึ้นมากเพื่อที่จะแก้ปัญหานั้นๆ
  - ยกตัวอย่างเช่น SOLID Principles, Clean Architectures
  - ส่วนมากออกแบบมาเพื่อให้สนับสนุน Modifiability -> สนับสนุน SOLID
- Design/Coding Idioms
  - เป็นเฉพาะต่อภาษาที่ใช้ในการพัฒนานั้นๆ เป็นเทคนนิคเฉพาะภาษาเลย

### Benefits & Limitations
- **Benefits**
  - Design reuse
  - Uniform design vocabulary -> เป็นภาษาที่ใช้กันอย่างแพร่หลายในหมู่ของ good devs
  - Enhance understanding, restructuring, & team communication
  - Basic for automation: เพราะ design patterns -> มาตรฐาน -> teastability

- **Limitations**
  - Require significant tedious & error-prone human effort to handcraft patterns
  implementations design reuse
  - Can be deceptively simple uniform design vocabulary
  - May limit design options
  - Leaves important (implementations) details unsolved

- **WARNING!!**
  - **Overuse of design patterns can lead to code that is downright over-engineered**
  - adhere to **YAGNI** and **KISS**

### Four Basic Parts of a Pattern
1. Name
2. Problem (including "applicability")
3. Solution
4. Consequences

### Classification of Design Patterns
- **Creational Patterns**: เกี่ยวกับการ Instantiate object -> increase flexibility and reuse of exisiting code
- **Structural Patterns**: เกี่ยวกับ Object + Class มาประกอบกันให้เป็นโครงสร้างที่ใหญ่ขึ้น โดยจะให้มีความ flexibility and efficient
- **Behavioral Patterns**: ประสิทธิภาพกันในการสื่อสารระหว่าง object และหน้าที่รับผิดชอบของแต่ละ object

## Creational Design Patterns
- Factory Method
- Prototype
- Abstract Factory
- Singleton
- Builder
- Dependency Injection

### Factory Method
- **Problem**
  - How can an object be created so that subclasses can redefine which class to instantiate?
    - Object จะถูกสร้างอย่างไร เพื่อที่จะให้ subclasses สามารถ redefine ว่า class ไหนจะเป็นตัว instantiate
  - How can a class defer instantiation to subclass?
- **Aplicability**
  - When a class cannot anticipate the objects it must creat or a class wants its subclasses to specify the object its created
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

### Abstract Factory
- **Problem**
  - How can an application be independent of how its objects are created?
  - How can a class be independent of how the objects it requires are created?
  - How can families of related or dependent objects be created?
- **Applicability**
  - when clients cannot anticipate groups of classes to instantiate
- **Solution**
  - intent to create families of realted objects without specifying subclass names
  - encapsulate object creation in a seperate (factory) object. That is, define an interface (AbstractFactory)
    for creating objects, and implement the interface
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
  - intent to sepearate the construction of a complex object from its representation so that the same construction
  process can create different representation
  - encapsulate creating and assembling the parts of a complex object in a seperate Builder object
  - a class delegates object to a Builder object instead of creating the objects directly
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
  - intent to sepearte the creation of a client's dependencies from the client's behavior, which promotes
  loosely coupled programs and the dependency inversion and single responsbility principles
![](https://media.discordapp.net/attachments/752199659270963250/1032161892212408330/unknown.png?width=1357&height=685)
- **Consequences**
  - (+) help in unit testing
  - (+) boiler plate code is reduced, as initializing of dependencies is done by the injector component
  - (+) helps to enable loose coupling, which is important in application programming
  - (-) it's a bit complext to learn (????), and if overused can lead to management issues and other problems
  - (-) many complie time errors are pushed to run-time

## Behavioral Design Patterns
- "พฤติกรรม"

### Behavioral Design Patterns
- Strategy
- Observer
- Command
- Template Method
- Iterator
- Null Object

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
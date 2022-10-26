# Structural Design Patterns

#### Warning!
- **Overuse of design patterns can lead to code that is downright over-engineered**

### Structural Design Patterns
- Facade
- Composite
- Proxy
- Flyweight
- Decorator

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
- "fences" คล้ายเป็นยามเฝ้าประตูว่าให้ client ตัวไหนสามารถเรียกใช้ service ตัวนั้นๆได้jkjjjkj
- **Problems**:
	-  how to control the access to an object?
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
	- ***intent*** to use sharing to support large numbers of find-grained objects efficiently
	- define a flyweight object to store shared *intrinsic state*, constant data of objects
	- *extrinsic state*, the rest of the object's state that can be altered, should be stored in another object with a reference to a flyweight object
- **Consequences**:
	- (+) saves lots of RAM
	- (-) trading RAM over CPU cycles in some cases
	- (-) code become more complicated
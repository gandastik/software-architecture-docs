## Software Architecture and Architectural Patterns/Styles

### Components
- we may call phycial packaging of modules **components**
- ***components from the fundamental modular building block in architecture***
- เอาไว้ใช้ในการ group สิ่งต่างๆเข้าด้วยกัน

![Components](https://media.discordapp.net/attachments/1014398974649708624/1016897951123116082/unknown.png?width=901&height=640)

### Architecture Partitioning
- **FIRST LAW** of SA states that everything in software is a ***trade-off***
- ต้องมีสิ่งที่แลกมาเสมอในสถาปัตยกรรมซอฟต์แวร์
- several common styles exist, with different sets of trade-offs

### Software Architecture
![software architecture](https://media.discordapp.net/attachments/1014398974649708624/1016899086068219944/unknown.png?width=828&height=640)

### Conway's Law
"Any organization that designs a system (defined boardly) will produce a design whose structure is a copy of the organization's communication structure"
- องค์กรใดก็ตามที่ออกแบบระบบ จะมีแนวโน้มที่ออกแบบโครงสร้างที่สะท้อนถึงโครงสร้างการสื่อสารกันภายในองค์กร

### Partitioning
![image showing old and new way of partitioning](https://media.discordapp.net/attachments/1014398974649708624/1016900356489363527/unknown.png?width=1318&height=640)

### Catalog of Architectural Patterns/Styles
- **Monolithic** : ไม่ได้มีการแบ่ง service ย่อยๆ
  - Layers
  - Plug-ing (Microkernel)
  - Model-View-Controller (MVC)
- **Distributed**
  - Client-Server & N-Tier
  - Publish-Subscribe
  - Service-Oriented Architecture (SOA)
  - Representationi State Transfer (REST)

## Monolithic
### Layers
- การแบ่งตัวระบบในรูปแบบที่ modules สามารถพัฒนาปรับปรุงเปลี่ยนแปลงได้ อย่างแยกๆกันได้โดยมีการ
with little interaction ซึ่งจะ supports portability, modifiability, and reuse
- layers pattern divides the software into units called **layers** แบ่ง sw เป็น ชั้นๆ (layer)
- each layer is a grouping of modules that offers a cohesive set of services
  - modules ที่ทำงานเป็นชุดเดียวๆกัน ก็จะอยู่รวมที่ layer เดียวกัน
- key constraint: the relationship must be **unidirectional**
  - top layer called bottom layer
- **Relaxed Layers** : less restrcitive relationship among layers
  - some layer maybe marked as **open layers**
- **Benefits**
  - layer is constrainted to use only lower layer, ทำให้ software in lower layers can be changed
    (as long as the interface doesn't change) without affecting the upper layers
  - lower-level layers maybe reused acorss different application
  - the number of interfaces that any team must understand is reduced becuase of the allowed-to-use relations contraints
     - จำนวนของ interfaces ที่ทีมจำเป็นต้องเข้าใจมีน้อยลง เพราะว่า contraints ของ top -> lower
- **Tradeoffs**
  - if layering is not designed correctly, problems -> by not providing the lower-level abstractions that programmers at the higher levels need
    - **integratibility** decreased
  - layering often adds a **performance** penalty to a system
    - ประสิทธิภาพของระบบอาจจะลดลง เนื่องจากถ้าเกิด function ถูกเรียกบน top layer แล้วอาจจะต้องผ่านหลาย lower layer ก่อนที่จะเข้าสู่ hardware
  - if many instances of layer bridging occur, the system may not meet its **portability** and **modifiability** goals
    - ถ้าเกิดมีการเรียกข้าม layer มากเกินไป จะทำให้ portability และ modifiability น้อยลง
    - ***strict layering*** -> helps improves portability and modifiability
- **Layerd Architecture in DDD**
  - there are four layers common to a DDD application

![layerd arch in DDD](https://media.discordapp.net/attachments/1014398974649708624/1016911263168733194/unknown.png)

  - User Interface Layer : contains only code that addresses user view and request concerns
    - จัดการว่ามี api อะไรบ้าง ไม่ได้บอกว่าแต่ละ api ทำอะไร
    - **must not** contain domain/business logic
    - user maybe either human or other system, provide the means to remotely invoke the servies of an API in the form of an Open Host Service
    - Components in the User Interfaces are direct client from the application layer
  - Application Layer : devoid from domain logic (no business logic)
    - ทำการจัดเรียง service ต่างๆ มารวมๆกันเป็น application
    - control presistence transactions and security, in charge of sending Event-based noti
    - if the application services become much more complex than this, it is probably an indication that domain logic is leaking into the Application layer
    - may also use a Domain Service to fulfill some domain-specific task designed as a stateless operation
  - Infrastructure Layer : persistence and messaging mechanism
    - middleware systems or more basic e-mails
    - all the technical components and frameworks that provide low-level services for the application

### Plug-in (Microkernel)
- provide a core set of functionality and specialized variants
- example:
  - plug-ins provide the actual OS functionality. such as device drivers, task management, I/O request management
  - plug-ins provice portability, such as OS compatibility or supporting library compatibility
    provide additional functionality not included in the core product. acts as adapter to enable integration with external systems
- **Benefits** : controlled mechanism to extend a core product and make it useful in a variety of contexts
  - plugins สามารถถูกพัฒนาได้จากทีมอื่นๆหรือองค์กรอื่นๆ
  - plugins evolve independently from the microkernel. since they interact through fixed interfaces
  - ทำให้ทั้งสองตัวระหว่าง plugins และ core product ไม่ได้ขึ้นอยู่กันแต่อย่างใดเลย ถ้าหาก interface ไม่ได้เปลี่ยน
- **Tradeoffs**
  - security vulnerability, privary threats
- Interaction between the core product and plugins : **Conformist**

### Model-View-Controller (MVC)
- the most widely known pattern for **usability**
- in the original MVC model, the model would send updates to a view, which a user would see and interact with
- user interactions are transmitted to **the controller** which interprets them as operations on **the model**

![MVC](https://media.discordapp.net/attachments/1014398974649708624/1016929688054157332/unknown.png?width=1338&height=640)

- **Benefits**
  - MVC promotes clear seperation of concerns, ให้ UI ปรับเปลี่ยนง่าย โดยไม่ส่งผลกระทบต่อ model or controller
  - developers can be working on all aspects of the pattern (model, view, controller) **relatively independently** and in pararllel
  - ***can be tested in pararllel***
  - model can be used in system with different views or a view might be used in systems with different models
- **Tradeoffs**
  - MVC can become burdensome for complex UIs, if theres are multiple views of the same model, a change to the model may require change to several
  - simple UIs, MVC adds up-front complexity that my not pay off in downstream savings
    - อาจจะไม่คุ้มกับการ implement กับ simple UIs

## Distributed
### Client-Server & N-Tier
- a server providing services to multiple distributed clients
- the interactions between a server and its clients follows this sequence
  - **Discovery**
    - client initiate the communication, which uses a discovery service to determine the location of the server
      - ตัว client จะเป็นตัวเริ่มในการหาตำแหน่งของ server
    - server reponds to the client using an agreed-upon protocol
  - **Interaction**
    - the client sends request to the server
    - the server process request and responds
- **load balancing** : server may have multiple instances if the number of clients > the capcity of the single instance
  - มีเซิฟเวอร์หลายตัว เพื่อรองรับจำนวน client ที่มาก
- if the server is **stateless** -> each request from a client is treated independently
- if the server is **stateful**
   - each request must id the client in some fashion
   - client should sent "end of sessions"
   - server may "time out" if client idles for too long
![Client-Server](https://media.discordapp.net/attachments/1014398974649708624/1016936443995754566/unknown.png?width=1064&height=640)

### N-Tier
![N-Tier](https://media.discordapp.net/attachments/1014398974649708624/1016936692755742760/unknown.png?width=846&height=640)

- **Benefits**
  - connection b/w client and server is established dynamically
  - server has no prio knowledge of its clients -> low coupling b/w the client and server
  - no coupling among the clients
  - number of clients can easily scale
  - clients and servers can ***evolve independently***
  - common services can be shared among clients
- **Tradeoffs**
  - message maybe delayed by network congestion, leading to degradation of performance
  - must implement security and maintain integrity

### Publish-Subscribe
- components commnunicate primarily through asynchronous messages, -> "events" or "topics"
- publishers have no knowledge of the subscribers
- systems using the pub-sub pattern rely on **implicit invocation**
- components publish messages on one or more events or topics
- at runtime, when a message is published, the pub-sub bus notifies all of the elements that registered an interest in the event or topic
  in this way, the message publication causes an implicit invocation of (method in) other components
- **Elements**:
  - Publisher : send message
  - Subscribers : subscribes to and then receive message
  - Event bus : manage subscriptions and message dispatch as a part of runtime infrastructure

![Publish-Subscribe](https://media.discordapp.net/attachments/1014398974649708624/1016940870030868582/unknown.png)

- **Benefits**
  - publishers and subscribers are independent and hence loosely coupled
    - การเพิ่ม subscribers ทำแค่ register event และจะไม่ส่งผลต่อ publisher
  - events can be logged easily to allow for record and playback
    - ทำให้การสร้าง error เพื่อ check เกิดขึ้นได้อย่างง่าย
- **Tradeoffs**
  - impact performance (latency)
  - a components cannot be sure how long it will take to receive a published message
  - negatively impact the determinisim produced by synchronous systems
  - negatively impact testability
  - limit the mechanism available to flexibly implement security (integrity)

### Service-Oriented Architecture (SOA)
- describes a collection of distributed components that provide and/or consume services
- SOA, **service provider** components and **service consumer** components can use different implementation languages and platoforms
  - ไม่จำเป็นต้องอยู่ภายใต้องค์กรเดียวกัน
- Services are largely standalone entities: Service providers and service consumers are usually deployed independently
  and often belong to different systems or even different organization
  - จะมีความเป็น independent สูงมาก
- **Components have interfaces that describe the services they request from other components and the services they provide**
  - components จะต้องมีคำอธิบายไปด้วยว่าจะใช้ service อะไร แล้วตัว service provider ก็จะต้องมีเอกสารประกอบว่าให้บริการอะไรบ้าง
- SOAs provide reusable components that are assumed to be **heterogeneous** and managed by distinct organization

## Understand this picture
![before SOA and after](https://media.discordapp.net/attachments/1014398974649708624/1016964950821978142/unknown.png?width=907&height=640)

- **Benefits**
  - services used by a variety of clients -> more generic
  - services are independent. the only method for accessing services is through the interfaces
  - services can be implemented heterogeneously. whatever languages and technologies
- **Tradeoffs**
  - because of their heterogeneity and distinct ownership, such as WSDL, SOAP <- add complexity and overhead
  - **WSDL** <- describe what components wants a service, what service provider provides

### Representational State Transfer (REST)
- describes a uniform interface between physically seperate components <- often in Client-Server Architecture
- in web development REST allows content to be rendered when it's requested <- "Dynamic Content"
- RESTful Dynamic context use server-side rendering (SSR) to generate a web site and send the content to the requesting web browser
- web API that obey the REST contraints -> **RESTful**
- **REST Architectural contraints**
  - Client-server architectural
  - Statelessness
  - Cacheability
  - Uniform interface
  - Layered system
  - Code on demand (optional)

# Sum-up of what I found intriguing

## Quality Attributes
- สิ่งที่เอาไว้บอกได้ว่า software นั้นมีคุณภาพหรือป่าว. "Quality **describe how well** the system does its function"

### Quality Attributes Scenario
- เป็นเหตุการณ์จำลองไว้สำหรับอธิบาย QAs นั้นๆ โดยแบ่งออกเป็น 6 ส่วน
- **การทำ software จริงๆไม่สามารถทำให้มี QAs ทุกๆด้านได้ทั้งหมด** -> **trade-off**
- **Artifact**: คือสิ่งที่สนใจ
- **Environment**: คือสวล.ที่ artifact นั้นๆอยู่
- **Stimulus**: สิ่งที่ไปกระตุ้น artifact
- **Source of Stimulus**: ตามชื่อ
- **Response**: "output" ที่ได้มาจาก input จากการกระตุ้น artifact
- **Response Measure**: วัดผลออกมาได้อย่างไร

### Availability
- คือคุณสมบัติที่ว่าถึง ความพร้อมของ software ในการทำงานที่ถูกออกแบบมาให้ทำงาน
  - ***that it is there and ready to carry out its task when you need it to be***
- **Availability refers to the ability of a system to mask or repair faults such that
 the cumulative service outage period does not exceed a required value over a specified time interval (SLA: Service Level Agreement)**
  - availability คือความสามารถของระบบที่จะสามารถปิดบังหรือซ่อมข้อผิดพลาดได้ เพื่อที่จะไม่ให้ระยะเวลาการ outage รวมกันแล้วเกิดเวลาที่กำหนดไว้ใน SLA
- **availability calculation**
  - **MTBF / (MTBF + MTTR)**
  - MTBF: Mean Time Between Failure
  - MTTR: Mean Time To Repair
- **QA Scenario**: Heartbeat Monitor -> [Server Unresponse] -> Process(Normal Operation) -> [Inform Operator] -> 2hrs of downtime
- **Tactics** (as I said above, this is not all that covered in the class but just the ones that I found interesting)
  - ***Detect Faults***
    - Monitor: โดยรวมๆแล้วเป็นการใช้ tactics อื่นๆมา โดยตัวมันเองทำหน้าที่เป็นตัว "orchestrates" เพื่อตรวจจับการทำงานที่ผิดพลาด
    - Ping/Echo: ตัว component ที่เป็นตัว monitor จะเป็นคนส่ง ping ถามอยู่เรื่อยๆ
    - Heartbeat: ตัว component ที่ถูก monitor จะเป็นคนค่อยส่ง msg ที่บอกว่าตัวเองโอเคอยู่เรื่อยๆ
    - Voting: เป็นการใช้วิธีการเปรียบเทียบจากคนรอบๆข้างดูว่าตัวไหนใช้ได้
      - Replication: เอาตัวเดิมๆมาเพิ่มเพื่อดูหา random failure
      - Functional Redundancy: เป็นการนำตัวอื่นที่สามารถสร้างผลลัพธ์ออกมาได้เหมือนกันกับตัวเดิมมาเพิ่มเป็น sources เพื่อแก้ปัญหา implementation error
        - eg. คิดเลข -> 1.เครื่องคิดเลข 2.คอมพิวเตอร์คิด 3.ใช้ลูกคิด
      - Analytic Redundancy: ใช้แก้ปัญหา specification error
        - eg. วัดความสูง -> 1.barometer 2.radar altimeter 3.geometric calculation
  - ***Recover Faults***
    - **Preparation and Repair**: การเตรียมพร้อมรับมือข้อผิดพลาด
      - Redundancy: การมีของสำรองง
        - active: ***protection group*** หรือกลุ่มตัวสำรอง จะทำหน้าที่รับข้อมูลและประมวลผลเหมือนกับตัวที่ active ตลอดแบบ synchronous
        - passive: only one active member ประมวลผลข้อมูล และใช้ periodic update เพื่ออัพเดทให้ตัวสำรองที่เหลือเป็นปัจจุบัน
        - (cold) spare: ตัวสำรองทุกๆตัวไม่ได้มีหน้าที่อะไรทั้งนั้น จนกว่าจะเกิด failure แล้วก็จะมี power-on-reset ก่อนที่จะทำให้ตัว spare เข้าสู่ service ได้
    - **Reintroduction**
      - State Resynchronization: เอาง่ายๆคือตัวเดียวกันกับ active redundancy, passive redundancy
      - Escalating Restart: มีการ restart เป็นระดับๆ
  - ***Preven Faults***
    - Removal from Service: นำเอา component ที่มีข้อผิดพลาดออกจาก service ก่อนที่จะทำให้ระบบล่ม
    - Transactions: ต้องมีการ ensure ACID property (Atomicity, Consistent, Isolated, Durable) แต่ละ transaction เพื่อป้องกัน race condition

### Intregrability
- คือคุณสมบัติของความสามารถในการ integrate software ได้ (คำอธิบายดีๆอยู่ในสไลด์ อยากอ่านลองหาเอา)
- **QA Scenario**: Component Marketplace -> [New component become available] -> System(Development) -> [the new component is integrated and deployed] -> 1month, with no more than 1person-month effort
- **Tactics**
  - ***Limit Dependencies*** (ส่วนมากพูดแบบผ่านๆไป)
    - Encapsulate
  - ***Adapt***
    - Discover: ใช้ใน microservice
  - ***Coordinate***
    - Orchestrates
    - Manage Resources

### Modifiability
- ความสามารถในการ **รับมือการเปลี่ยนแปลง**
- **Cost of Changes**: (example on week3 note)
  1. cost of introducing the mechanism
  2. cost of making the modification using the mechanism
- **QA Scenario**: Developer -> [wants to change UIs] -> UI(Design time) -> [change is made] -> less than 3hrs to make & test change
- **Tactics**
  - ***Increase Cohesion***: เป็นการเพิ่มความเกี่ยวเนื่องกันของ module
    - ***Cohesion*** คือระดับความรับผิดชอบที่เกี่ยวเนื่องกันของใน module หนึ่ง
    - ถ้าเกิดมีการเปลี่ยนแปลง responsibilty หนึ่งก็จะกระทบกับ responsibilty อื่นๆใน module นั้นด้วย -> ทำให้เปลี่ยนทีเดียวได้เลย
    - higher cohesion -> easier to modify
    - Split Module: ถ้าเกิดในกรณีที่ module มี cost ในการเปลี่ยนแปลงสูงเกินไป บางทีการแยกเป็น module เล็กๆก็อาจจะช่วยได้
    - Redistribute Responsibilty: ในกรณีที่มี A, A', A'' หน้าที่คล้ายๆกันกระจัดกระจายอยู่เป็น module อื่นๆ ดังนั้นควรที่จะรวมเอามาเป็น module เดียวกัน
  - ***Reduce Coupling***: ลดการขึ้นต่อกันและกันของแต่ละ component
    - ***Copuling*** คือค่าควานน่าจะเป็นที่การเปลี่ยนแปลงของ module หนึ่งจะไปกระทบกับ module อื่นๆด้วย
    - Encapsulate
    - Use an Intermediately
    - Abstract common service
    - Restrict Dependencies
  - ***Defer Binding***: ย้ายเวลา binding ออกไปไกลๆ เพื่อความ flexibility

### Cohesion vs Coupling
![](https://media.discordapp.net/attachments/1014398974649708624/1024978753983627304/unknown.png?width=1330&height=702)

### Performance
- เป็นการวัดจากประสิทธิภาพการทำงานของ software system โดยวัดจาก time constraint, allocation of resources
- **QA Scenario**: 500users -> [2000req in 30s] -> System(Normal Ops) -> [Process all request] -> ~ < 2s latency
- **Tactics**
  - ***Control Resources Demand***
    - Manage Work Request: เป็นการตั้งข้อกำหนด SLA ให้กับ external system ว่า "the system will process X events arriving per unit time with a response time of Y"
    - Limit Event Response: ใช้ Queue เป็นตัวการรองรับ reqs เยอะๆ แต่จะสามารถเลือกได้ว่าจะตั้งค่า max rate ของการ process ไว้ที่เท่าไหร่ก็ได้
    - Prioritize Events: จัดลำดับความสำคัญของ events
    - Reduce Computational Overhead: ลดการทำอะไรที่มันยุ่งยาก
      - Reduce Indirection: ลดการใช้ตัวกลาง (modifiability/performance tradeoff)
      - Co-locate Communication Resources
      - Periodic Cleaning
      - Bound Execution Time: จำกัดเวลาการประมวลผลเพื่อให้ได้ respond
      - Increase Efficiency of Resources Usage: improve efficiency of algorithms
  - ***Manage Resources***
    - Increase Resources: might be considering a cheapest way to get immediate improvement
    - Introduce Concurrency: ใช้ concurrency มาช่วยจัดการการทำงานแบบ parallel สร้าง thread และแบ่งงานให้ทำพร้อมๆกัน
    - Maintain Multiple Copies of Computations: คือการสร้าง service ตัวเดิมซ้ำเพิ่มขึ้นมา ซึ่งใช้ load balancer ในการช่วยการแจกจ่ายงาน
    - Maintain Multiple Copies of Data: มี db ซ้ำๆเพิ่มมากขึ้น -> ต้องทำให้ sync ตลอด เพื่อลด contention
      - Cache: 1. Shared Cache, 2. Local Cache
    - Schedule Resoureces: มีหลายเทคนิคในการทำ scheduling คือการแจกจ่าย prio ให้แต่ละ req

### Security
- **QA Scenario**: Employee -> [Attemps to modify salary] -> Data with in System(Normal Ops) -> [System maintain audit trails] -> Correct Data is restored, id'd source

### Testability
- **QA Scenario**: Developer -> [Complete a code unit] -> Code unit(Development) -> [Perform a test sequence] -> 85% path coverage in 30mins

### Usability
- เป็นการที่คำนึงถึงความง่ายสำหรับ user ในการทำงานที่ต้องการให้สำเร็จ และประเภทของระบบช่วยเหลือผู้ใช้งานที่ระบบมีให้
- **QA Scenario**: User -> [Launches a navigation app] -> System(Runtime) -> [A map is displayed] -> accomplished ~ 10mins
- **Tactics**
  - ***Support User Initiative***
    - Cancel
    - Undo
    - Pause/Resume
    - Aggregate: จับ low-level obj มาเป็นกลุ่มเดียวกัน สำหรับงานที่ทำแล้วส่งผลกระทบหลายๆตัวในทางๆเดียวกัน
  - ***Support System Initiative***

## Domain-Driven Design
- software design ที่มุ่งเน้นไปที่การออกแบบ software ให้ตรงกับ domain โดยอ้างจากความคิดเห็นหรือความรู้ของ domain's experts

### Models
- "A system of abstractions that describes selected asepects of a domain and can be used to solve problems related to that domain"
  - "เป็นระบบที่เป็นนามธรรมที่ใช้อธิบายบางมุมมองของโดเมนและสามารถใช้ในการแก้ปัญหาของโดเมนนั้นๆได้ด้วย"

### Domain
- **"an area of knowledge or activity"**
- "A sphere of knowledge, influence, or activity. The subject area to which the user applies a program is the domain of the software"

### Why DDD?
- เหตุผลมาจากวัตถุประสงค์ของ software คือการที่จะ enhance domain นั้นๆ เพราะฉะนั้น **the software has to fit harmonoiusly with the domain it has been created for***
- also **software needs to incorporate the core concepts and elements of the domain** -> to realize the relationship between them

### Domain Model
- "**A domain model** is not a particular diagram; it is the idea that the diagram is intended to convey. It not is not
 just the knowledge in a domain expert's head; **it is regerously organized and selective abstraction of that knowledge.**"
- แปล: domain model ไม่ใช่แค่ diagram ใดๆนึง แต่มันคือ **ไอเดีย** ที่ diagram นั้นต้องการที่จะโน้มน้าว มันไม่ใช่เพียงแค่ความรู้ที่อยู่ในหัวของ domain expert
 แต่เป็น **การคัดสรร และการจัดระเบียบมาแล้วอย่างดี ของนามธรรมของไอเดียนั้นๆ**

### Utility of a Model
1. model and the heart of the design shape each other
2. model is the backbone of a language used by all team members
3. model is distilled knowledge

### The Ubiquitous Langauge
- เกิดมาเนื่องจากที่ DDD นั้นแนะนำว่า software specialist ต้องทำงานร่วมกันกับ domain experts ในการพัฒนา model ขึ้นมา
- จึงเกิดภาษาที่จะพบเจอได้ทุกทีได้ทุกเวลาที่เรียกว่า **Ubiquitous Langauge**
- "A language structured around the domain model and used by all team members within a **bounded context**
 to connect all the activities of the team with the software"

### Context
- บริบท :)
- "The setting in which a word or statement appearts that determines its meaning ***Statement about a model can only be understand in a context***"
  - แปล: ที่ๆ เจอคำๆนึงหรือประโยคๆนึงแล้วสามารถบอกความหมายของคำได้. ประโยคที่เกี่ยวกับ model จะสามารถเข้าใจได้ภายในบริบทเท่านั้น!

## Strategic Design
- เป็นกลยุทย์ในการวางแผนการออกแบบ ยกตัวอย่างการออกแบบ project ใหญ่ๆก็ประกอบไปด้วย subdomain และ context ต่างๆกันออกไป
- **Domains -> Subdomains** ในองค์กรๆนึง domain ขององค์กรก็จะประกอบไปด้วย subdomains ต่างๆ
  - It's advantageous to think about each of those business function seperately

### Model in Large Software System
- when the design of the model evolves partially independently, we should consciously divide it into serveral models
- each model should have a clearly delimited border, adn the relationships between models should be defined with precision

### What is Bounded Context?
- "A description of a boundary (typically a subsystem, or the work of a particular team) within which a particular model is defined and applicable."
- Bounded Context != Modules (modules อยู่ข้างใน bounded context)

### Core Domain, Supporting Subdomain & Generic Subdomain
- Core Domain: คือโดเมนที่สำคัญที่สุดต่อการประสบความสำเร็จขององค์กร
- Supporting Subdomain: some aspect of business that is essential, yet not Core
- Generic Subdomain: nothing special to business, yet is required

### Context Map
- use context as the basis for team organization
- context map คือเอกสารที่ชี้ถึง bounded context ที่แตกต่างกันและความสัมพันธ์ระหว่างกัน

### The Interaction Between Different Contexts
- **Partnerships**: เกิดขึ้นเมื่อ **teams in two contexts will succeed or fail together**
  - development failure ในสักทีม ก็จะเฟลทั้งคู่
  - team จะต้องร่วมมือกันในการพัฒนา interfaces เพื่อที่จะอำนวยความสะดวกของการพัฒนาของทั้งสองทีม
  - ***Interpendent*** features ควรจะนัดเวลากันในการปล่อย release
  - ไม่จำเป็นต้องเข้าใจถึงรายละเอียดของ model ของอีกทีม ขอเพียงแค่ทำงานร่วมกันและวางแผนร่วมกันก็พอ
- **Shared Kernel**: **sharing a part of the model and associated code** มีความเสี่ยงในการที่จะยกระดับงานการออกแบบแต่ก็มีโอกาสแปกได้
  - ต้องตกลงกันว่าขอบเขตที่เป็นส่วนที่ share กันมันอยู่ตรงไหน แล้วก็จำเป็นต้องจำกัดให้ส่วนนี้มีขนาดเล็ก
  - ถ้าเกิดจะมีการเปลี่ยนแปลงในส่วนที่ share กันก็ **จำเป็นต้องคุยกันทั้งสองฝ่ายก่อน**
- **Customer-Supplier**: two team are in an ***upstream-downstream relationship**, แล้วความสำเร็จของ upstream team จะไม่ขึ้นอยู่กับ downstream team เลย
  - supplier is the upstream team
  - ควรที่จะมี customer/supplier relationship ที่ชัดเจน คือ priorities ของ downstream team factor into upstream planning
  - eg. plug-ins, mods
- **Conformist**: the upstream has no motivation to provide the downstream team's needs
  - จำกัดความซับซ้อนระหว่างการโยงระหว่าง bounded context โดยทำตัว **เกาะ** model of upstream team
  - Altruism(ความเห็นแก่ประโยชน์ส่วนรวม) maybe sufficient to get them to share information with you
- **Anticorruption Layer**: เป็นปัญหาที่เกิดจากการควบคุมหรือการสื่อสารกันระหว่าง bounded context ไม่เพียงพอที่จะเป็น shared kernel, partner, customer/supplier ได้
  - ยังสามารถมองได้เป็น upstream-downstream อยู่แต่ ไอ้ทีม upstream เราไม่สามารถทำอะไรกับมันได้เลย จึงต้องสร้าง layer กลางขึ้นมาเอง
  - mostly found in the legacy system
  - as a downstream client, creating an isolationg layer to provide your system with functionalitly of the upstream in terms of your own domain model
- **Open-host Service**: เมื่อมีการถูกใช้งานจาก external system มากจนไม่สามารถสร้าง translation layer เยอะๆได้
  - ***define a protocol that gives access to your subsystem as a set of services*** -> เปิด RESTful APIs
  - สร้าง APIs เป็น set ให้คนอื่นมาเรียกใช้งานเอง
  - เดียวจะเจอใน SOA อีก
- **Published Language**: คือภาษาที่ทำให้คนอื่นสามารถเข้าใจตรงกันกับเราได้
  - well-documented shared language that can express the necessary domain information as a common medium of communication
  - ทำเอกสาร APIs ออกมาให้ผู้อ่านสามารถเข้าใจได้และนำไปใช้งานได้
- **Seperate Ways**: have no significant relationship
- **Big Ball of Mud**: no well-defined bounded context -> everything mix together :0 (eg. in legacy system)

## Software Architecture and Architectural Patterns/Styles

### Components
- components เป็นชิ้นส่วนพื้นฐานในการสร้าง architecture

### Catalog of Architectural Patterns/Styles
- **Monolithic**: ใช้แบ่งเป็น layersๆ เอา ไม่ได้แบ่งออกเป็น service แยกออกมา
  - Layers
  - Plug-ins (Microkernel)
  - Model-View-Controlelr (MVC)
- **Distributed**
  - Client-Server & N-Tier
  - Publish-Subscribe
  - Service-Oriented Architecture (SOA)
  - Representational State Transfer (REST)

### Layers
- ทำให้ modules สามารพัฒนาปรับปรุงเปลี่ยนแปลงได้อย่างแยกๆกันได้ with little interaction
  - supports modifiability, portability, reuse
- แต่ละ layer จะเป็นการรวมกลุ่มกันของ cohesive set of services
- relationship -> **unidirectional** ความสัมพันธ์แบบทิศทางเดียว คือ **บน ลง ล่าง** no other around
- **relaxed layer** คือการเปิด layer ให้ผ่านไปได้ (layer บนสุด calls function ของ layer ถัดไปสองชั้น)
- **benefits**
  - software in lower layer can change without affecting the upper layer
  - ทำให้จำนวน interface ที่แต่ละ team จำเป็นต้องเข้าใจมีจำนวนน้อยลงจาก allowed-to-use relation (top -> lower)
- **tradeoffs**
  - ถ้าการออกแบบแต่ละ layer ไม่ดีพอก็จะทำให้การใช้งานร่วมกันของ top layer เป็นไปได้ยากขึ้น
  - performace penalty จากการที่ top layer calls the lowest layer (too many path)
  - ถ้าเกิดมี layer มากเกินไปป ก็จะไม่ได้ก่อให้เกิดผลดีในด้าน **portability** and **modifiability** เลย
- Layered Architecture in DDD ref:[Layers](https://github.com/gandastik/software-architecture-docs/blob/master/notes/week6.md#layers)

### Plug-in (Microkernel)
- อย่างที่บอกไปว่าเป็นค.สัมพันธ์แบบประเภท [Customer-Supplier](#The-Interaction-Between-Different-Contexts)
- typically bound together at build time or later (plug-ins and core set of functionalitly)
- example in [Plug-in](https://github.com/gandastik/software-architecture-docs/blob/master/notes/week6.md#plug-in-microkernel)
- **benefits**
  - plug-ins สามารถถูกพัฒนาได้จากทีมอื่นๆหรือองค์กรอื่นๆได้
  - plug-ins can evolve independently from the microkernel, as long as the interface does not change
- **tradeoffs**
  - security, privacy threats

### Model-View-Controlelr (MVC)
- **+usability**
- **benefits**
  - จากที่ MVC นั้นมีความชัดเจนในด้านการแยกแนวการคิดกัน ก็จะทำให้การเปลี่ยน one aspect of the system often have no consequences
  - devs สามารถพัฒนาทั้งสามด้านได้แบบ parallel และ ***relatively independently***
  - model can be used in system with different views, or a view might be used in systems with different models
- **tradeoffs**
  - ลำบากต่อการพัฒนา complex UI
  - ไม่คุ้มกับการ implement กับ simple UIs

### Client-Server & N-Tier
- server ทำหน้าทีจัดการให้บริการ services แก่ client ทั้งหลาย example is web server
- คำอธิบายชัดๆอยู่[ในนี้จ้า](https://github.com/gandastik/software-architecture-docs/blob/master/notes/week6.md#client-server--n-tier)
- **benefits**
  - low coupling between server and its clients (เพราะว่า server ไม่ได้มี knowledge เกี่ยวกับ client แต่ละตัวมาก่อน)
  - no coupling between clients
  - number of clients can easily scale, server can also scale
  - client and server can ***evolve independently***
- **tradeoffs**
  - messages can be delayed because of network congestion and shit -> degradation of performance
  - ต้องการการดูแลเพื่อเพิ่ม security และรักษา integrity

### Publish-Subscribe
- more [here](https://github.com/gandastik/software-architecture-docs/blob/master/notes/week6.md#publish-subscribe)
- components สื่อสารผ่านกันช่องทางเดียวคือ asynchronous messages called **event** or **topics**
- ตัวที่มา subscribe ก็จะถูก **implicit invocation** จากทาง publisher เมื่อมีการ publish message
- elements-> Publisher: คนส่งสาร, Subscribers: คนรับสาร, Events bus: ตัวจัดการการแจกจ่ายอยู่ภายใน infra ของ runtime
- **benefits**
  - loosly coupled (จากที่ publisher และ subscriber นั้น independent ต่อกันและกัน) -> more modifiability
  - system behavior can be easily changed
  - ง่ายต่อการ reproduce error เพราะว่ามีการเก็บ log ตลอด
- **tradeoffs**
  - impact performance (แก้ได้โดยการประยุกต์ใช้ distributed coordination)
  - impact testability (small change in event bus impact widly on system behavior and quality of service)
  - no integrity เพราะว่า publisher ไม่รู้ว่า subscriber เป็นใครบ้างก็เลยยืนยันตัวตนได้ยาก end-to-end encryption is limited

### Service-Oriented Architecture (SOA)
- more [here](https://github.com/gandastik/software-architecture-docs/blob/master/notes/week6.md#service-oriented-architecture-soa)
- คือ collection ของ distributed system ที่เป็นการ "ให้บริการ(provide)" and/or "รับบริการ(consume)"
- **service provider** component and **service consumer** component ใช้ภาษาต่างกันและการประยุกต์ต่างกันได้
- Component จะมี interface ที่ระบุไว้สำหรับการ**ขอ** request จาก component อื่น หรือการ**ให้**บริการ service กับ component อื่น
- SOAs provide resuable components -> assumed to be heterogeneous
- **benefits**
  - ทำให้ component มีความ generic มากขึ้น เพื่อหวังว่าจะถูก adopt ไปใช้จากองค์กรใหญ่ๆ
  - service are independent
  - service มีความ heterogeneously สามารถ implment ด้วยภาษาอะไรก็ได้ กับองค์กรอะไรก็ได้
- **tradeoffs**
  - because of their heterogeneity -> come with WSDL, SOAP adds complexity overhead

### Representational State Transfer (REST)
- เป็นแนวทาง architectural style ที่อธิบายถึง uniform interface ระหว่าง component ที่อยู่แยกกันส่วนมากคือแยกกันบนอินเทอร์เน็ต
- REST allows content to be rendered when it's requested, refer as Dynamic Content
- web API ที่ obey REST constraints -> RESTful
- **REST Contraints**
  - Client-Server Architecture
  - Statelessness
  - Cacheability
  - Uniform interface
  - Layered System
  - Code on demand (optional)


## Model-Driven Design
- รู้จักกันในอีกชื่อคือ Tactical Design
- เป็นการออกแบบ model ที่คำนึงถึงด้าน software และ design principle ต่างๆไว้ด้วย
- ใช้ OOP

### How to go about Model to Code!?
- ใช้สิ่งที่เรียกว่า Analysis model
- **Analysis Model** sucks ass
- better approach is **Model-Driven Design**

### Entity
- คือรูปแบบในการแสดงถึง object ผ่านสิ่งที่เรียกว่า **continuity and identity**
- ควรจะแยก object ให้ได้แม้ว่าจะมี attribute ที่เหมือนกันก็ตาม
- **Therefore**:
  - ใช้การที่ object ถูกแยกแยะออกด้วย identity มาเป็นหลักในการนิยาม object ในโมเดล

### Value Object
- เป็น object ที่อธิบายหรือคำนวณลักษณะบางอย่างของสิ่งอื่น
- ไม่มี conceptual identity
- **Therefore**:
  - ไม่จำเป็นต้องแยกแยะ identity ออกเพียงแค่ต้องการรู้ attribute, logicl ของ element of model -> Value Object
  - immutable (คือ ไม่มี setters())
  - สร้าง operations โดยที่เป็น ***side-effects-free*** ที่ไม่ได้เปลี่ยนแปลง internal state ของ object
- ตัวอย่าง address ถ้าเกิดว่า same address ก็ไม่สนใจว่ามันคือ object ตัวเดียวกันหรือป่าว เราแค่สนใจ value ของมัน

### Domain Events
- สิ่งบางอย่างที่เกิดขึ้นแล้ว **domain experts care about**
- ไว้สำหรับถ้าต้องการรับรู้เหตุผลหรือความหมายของการเปลี่ยนแปลงของ state ของ entity
- change happens -> generate events
- **Therefore**:
  - represent each event as a domain object -> แยก event ออกมาเป็น class
  - domain event คือตัวที่เแทนถึงเหตุการณ์ทุกๆอย่างหรือการเปลี่ยนแปลงที่เกิดขึ้นใน domain
  - สามารถดู state ของ entity ได้จาก domain event

### Services
- ไม่สามารถโยงไปให้ entity ตัวใดตัวนึงรับผิดชอบได้ -> somtime it just better ถ้าแยกออกมาเป็น class ตัวเอง
- **Therefore**
  - ในกรณีที่เกิด significant process or transformation in the domain โดยที่ไม่ได้มาจาก entity or value object จะให้เพิ่ม operation to the model as **Standalone interface** เรียกว่า **service**
  - define **service contract** เป็นข้ออ้างสิทธิ์สำหรับการใช้งาน service

### Modules
- แยกโค้ดออกมาเป็นหมวดหมู่ -> modules
- coupling and cohesion (low copuling + high cohesion)
- **Therefore**:
  - **refine the model until it partitions according to high-level domain concepts and the corresponding code is decoupled as well**

### Aggregate
- basically a pile of dogshit
- more [here](https://github.com/gandastik/software-architecture-docs/blob/master/notes/week7.md#aggregates)

### Repositories
- ตัวจัดการความซับซ้อนของการ access
- more [here](https://github.com/gandastik/software-architecture-docs/blob/master/notes/week7.md#repositories)

### Factories
- ถ้าเกิดว่ามันมีอะไรหลายๆอย่างรวมกันอยู่เยอะๆแล้วอย่างเช่น aggregate, large value object มันซับซ้อนมากๆและมันมีรายละเอียดมากเกินไป
การสร้าง class factories ขึ้นมาครอบ (encapsulate) เพื่อเป็นการย้ายหน้าที่ในการสร้าง instance ที่หลายๆที่มาอยู่แค่ที่เดียว
- more [here](https://github.com/gandastik/software-architecture-docs/blob/master/notes/week7.md#factories)

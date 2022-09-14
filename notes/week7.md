## Model-Driven Design
> also known as "Tatical Design"

### Model to Code
- **domain** จะสามารถเขียนออกมาได้  many **models** และ **model** จะสามารถถูกอธิบายได้ด้วย **code** ในรูปแบบที่หลากหลาย
- for each problem there can be more than one solution -> which one do we choose ?
- choose a **model** which **can be easily** and accurately put into **code**

### Analysis Model
- สร้างขึ้นมาสำหรับ business domain analysis โดยไม่คำนึงถึงด้านการประยุกต์ใช้ใน software เลย
- เมื่อมาถึงมือ dev ก็จะทำให้ dev ต้องมีการตัดสินใจเอง เพราะว่าใน model ไม่ได้คำนึงถึง design principle เลยทำให้เกิดการเปลี่ยนแปลงของ design ออกไป
- resulting in the **knowledge about the domain and the model is lost** และก็จะไม่มีความสัมพันธ์ระหว่าง model กับ code อีกต่อไป

### Model-Driven Design
- better approach is to be closely relate to domain modeling and design. ควรที่จะสร้าง model ที่คำนึงถึงด้าน software และ design principle ด้วย
- **Developers** ควรเป็นส่วนหนึ่งในกระบวนการ modeling
- choose a **model which can be appropriately expressed in software** เพื่อที่ให้ design process มีความตรงไปตรงมาและมีพื้นฐานที่อยู่กับ model
- we use -> **object-oriented programming** to tightly tie the implementation to a model

![Model-Driven Design](https://media.discordapp.net/attachments/1014398974649708624/1019442125387079710/unknown.png)
> Smart UI -> UI with business logic

### Entities
- objects represent a thread of **continuity and identity**, thought their attributes may change
- **an object must be distinguished from other objects**
- Therefore:
  - when an object **distinguished by its identity** -> make this primary to its definition in the model
  - keep class definition simple
  - define a mean of distinguishing each objects
  - define an operations that is guaranteed a unique result for each object
  - the model must define what it means to be the same thing

### Value Object
- **some objects describe or compute some characteristic of a thing** : เป็น Object ที่เอาไว้อธิบายสิ่งอื่นๆ
- **Objects ที่ไม่มี conceptual identity**
- Therefore:
  - เมื่อแค่ต้องการที่จะรู้เฉพาะ attributes and logic ของ element of model -> value object
  - value object -> **immutable** (เปลี่ยนแปลงไม่ได้) [no setters]
  - **make all operations Side-Effect-Free** ที่ไม่ได้ไปเปลี่ยนแปลง internal state ของ object
  - don't give a value object identity and avoide the design complexities
- eg. addresses -> same address -> doesnt care if it is the same object

### Domain Events
- **something happened that domain experts care about** -> **generate event**
- ถ้าต้องการรับรู้เหตุผลหรือความหมายของการเปลี่ยนแปลงของ state ของ entity
- changes happens -> generate events
- Therefore:
  - **model information about activity in the domain as a series of discrete events**
  - **represent each event as a domain object** -> แยก event ออกมาให้เป็น class
  - domain event is a full-fledged part of the domain model -> domain event เป็นตัวที่แทนถึงเหตุการณ์หรือการเปลี่ยนแปลงที่เกิดขึ้นใน domain
  - state of entity can be inferred from the domain events -> สามารถดู state of entity ได้จาก domain event
  - **domain events are ordinarily immutable** -> เพราะเป็น record of something in the past
  - events ประกอบไปด้วย
    - timestamp -> อาจจะแบ่งเป็นสองแบบ 1.เวลาที่เกิดเหตุการณ์  2.เวลาที่เหตุการณ์ถูกบันทึก
    - id of entities involved

### Services
- **sometimes, it just isn't a thing**
- some concepts from the domain aren't natural to model as objects
- ไม่สามารถโยงไปให้ entity ตัวใดรับผิดชอบได้ -> sometime it just better to แยกออกมาเป็น class ของตัวมันเอง
- Therefore:
  - เมื่อเกิด significant process or transformation in the domain โดยที่ไม่ได้เกิดจากความรับผิดชอบของ entity or value objects
  เราจะเพิ่ม oeprtion to the model as **standalone interface** declared as a **service**
  - define a **service contract** -> a set of assertions about interactions with the services
  - give the service a name -> become a part of ubiquitous langauge

### Modules
- มีการแยกส่วนโค้ดออกมาเป็นหมวดหมู่ -> กลายเป็น modules
- **coupling** and **cohesion**
- **low coupling + high cohesion**
- Therefore:
  - เลือก module ที่อธิบาย story ของระบบที่ประกอบไปด้วย cohesive set of concepts
  - give modules names -> become part of the ubiquitous langauge so ชื่อควรที่จะสะท้อนถึง insight into the domain
  - ควรจะทำให้  modules มี low coupling ต่อกันและกัน ในมุมมองของ concepts ที่สามารถเข้าใจได้โดยที่ไม่พึงพา module ตัวอื่น
  - **refine the model until it partitions according to high-level domain concepts and the corresponding code is decoupled as well**

### Aggregates**
- ที่มาคือ มันยากที่จะ guarantee the consistencey of changes to objects in the model with complex associations
- objects are supposed to maintain their own internal consistent state
- eg. ถ้าเกิดในกรณีที่ต้องการเปลี่ยนแปลง อะไรที่มีจำนวนเยอะๆ ก็จำเป็นที่จะต้อง lock database เพื่อไม่ให้มีคนเข้ามา access ได้ เพราะว่าอาจจะเกิดความ consistency ได้
- similar issues arise when designing asynchronous transactions
- สรุป: aggregate อยู่ภายใต้ bounded context และถูกสร้างขึ้นมาเพื่อรักษา consistency ภายใน aggregate
- Therefore:
  - cluster entites and value objects into aggregates
  - เลือก entity มาหนึ่งอันให้เป็น root aggregate <- เพื่อเป็นตัวติดต่อกับ external object เท่านั้น (เป็นทางผ่าน เข้า-ออก)
  - within aggregate boundary -> apply consistency rules synchronously. Accross boundaries -> updates asynchronously
  - keep an aggregate together on one server

### Repositories
- query access to aggregates expressed in the ubiquitous langauge
- Proliferation (การเจริญเติบโตสูง) เส้นความเชื่อมโยงระหว่าง object/class มีเยอะขึ้นมาก ก็จะทำให้
การที่จะหาอะไรบ้างอย่างใน model นั้นยุ่งยาก ถึงแม้ว่า model ที่มีความ mature และส่วนมาก query จะสื่อผ่าน domain concepts still quries can cause problems
- เกิดความยุ่งเยิงในการเขียนโค้ดเพื่อ access database และจะทำให้เกิดการเขียนโค้ดที่ไม่มีความเกี่ยวข้องกับ domain layer -> model irrelevant
- query framework จะเป็นตัวที่ encapsulate ความซับซ้อนทางเทคนิค (interfaces) เป็นการทำ low coupling
- เป็นตัวที่จัดการความซับซ้อนของการ access
- Therefore:
  - สำหรับ aggregate ที่ต้องการ global access จะต้องสร้าง service that can provide illusion of an in-memory
  เพื่อให้บริการผู้อื่นสำหรับการเข้าถึง data ใน aggregate
  - set up access through a well-known **global interface**
  - provide methods to add and remove objects -> encapsulate actual insertion or removal of data
  - provide methods that select objects based on criteria meaningful to domain experts
  - provide repositories only for aggregate roots that actually need direct access

### Factories
- creation of an entire -> ประกอบไปด้วยหลายอย่าง consistent aggregate, large value object ->
- สร้าง factories(class) มาครอบเพื่อให้ภายนอกมองเห็นแค่ภาพรวม ไม่เห็นถึง internal components
- รับผิดชอบในการสร้าง object อื่นๆ ประกอบชิ้นส่วนต่างๆให้พร้อมใช้งาน
- **assembled object or aggregate** -> ทำให้คนที่มาเรียกใช้สามารถใช้ได้เลย
- Therefore:
  - ห่อหุ้มกระบวนการการสร้างที่มันซับซ้อน

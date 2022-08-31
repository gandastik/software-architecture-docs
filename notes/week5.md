## Strategic Design

### The Development of Large Software System
- projects that involves **many subdomains and/or require many models in different context**
- **The design of such project should still be based on a domain model**

### Domains and Subdomains
- The whole Domains of the organization is composed of Subdomains
  - โดเมนขององค์กรจะประกอบไปด้วย subdomains มารวมๆกัน
- **it's advantageous to think about each of those business funciton seperately**
  - มีหลายปัจจัยที่ส่งผลให้ธุรกิจประสบความสำเร็จ ดังนั้นการแยกย่อยๆเป็น subdomains จึงทำให้ง่ายต่อการคำนึงถึงแต่ละปัจจัยหรือ functions ต่างๆ

### Models in Large Software System
- **good model == consistent**
- **When the design of the model evolves partially independently, we should consciouly divide it into serveral models**
  - ถ้าเกิดว่า design ของ model มีการพัฒนาบางส่วนออกไปแบบไม่ไปยุ่งกับส่วนอื่น ดังนั้นเราควรที่จะแยกออกมาเป็นหลายๆ model
  - several models can evolves independently as long as they obey the contract they are bound to
- **Each model should have a clearly delimited border, and the relationships between models should be defined with precision**
  - แต่ละ model ควรมีขอบเขตที่จำกัดแน่ชัด และความสัมพันธ์ระหว่าง model ควรจะถูกนิยามด้วยความแน่นอน
![DDD](https://media.discordapp.net/attachments/287239433517006848/1014368375184564264/unknown.png?width=1246&height=640)

### What is a "Bounded Context"?
- "A description of a boundary (typically a subsystem, or the work of a particular team) within which a particular model is defined and applicable."
- คำอธิบายถึงขอบเขตบริบท ที่อยู่ภายใต้ model นึงที่ถูกนิยามไว้แล้วสามารถนำไปใช้ได้
- **Bounded Context is not a Module**
  - ***it provides the logical frame inside of which the model evolves***
  -  เป็นกรอบทางตรรกะ ที่จะทำให้เกิด subdomain ขึ้นมาภายใต้ bounded context นี้

### Bounded Context in Large Software System
- แต่ละ model มี context ต่างกัน. จำเป็นต้องนิยาม context ในแต่ละ model ที่สร้างไว้
- **A model should be small enough to be assigned to one team**
- main idea is to define the scope of a mode, draw up the boundaries of its context,
- แม้ว่าบางครั้งเราก็ไม่สามารถทำ DDD เพื่อสร้าง Bounded Context อย่างเหมาะสมได้เสมอไป

### Example: E-commerce Application
![example of bounded context](https://media.discordapp.net/attachments/287239433517006848/1014372509082202112/unknown.png?width=885&height=640)

### Core Domain
- **A Core Domain is a part of the business Domain that is of primary importance to the success of the organization**
  - Domain ที่สำคัญที่สุดต่อการประสบความสำเร็จขององค์กร
- need the most focus, ***the business need to excel in the core domain to be successful***

### Subporting Subdomain & Generic Subdomain
- บางมุมมองของธุรกิจก็สำคัญ แต่ไม่สำคัญเท่ากับ core เราจะเรียกว่า **Supporting Subdomain**
- ถ้าเกิดว่า ไม่ได้ส่งผลอะไรพิเศษต่อธุรกิจ แต่ก็ยังจำเป็นต่อ business solution เราจะเรียกว่า **Generic Subdomain**

### Continuous Integration
- **A model is not fully defined from the beginning, It is created, the it evolves continuously**
- มีการเพิ่มโค้ด, เพ่ิม elements -> จำเป็นต้อง merge code (**Integration**)
- new code/new elements -> merge code -> build -> test == **Continuous Integration**
- CI applies to a Bounded Context, it is not used to deal with relationship between neighboring Contexts

### Context Map
- use context as the basis for team organization (แบ่งทีมตาม context)
- แต่ละ Bounded Context ควรจะมีชื่อที่เป็นส่วนหนึ่งของ **Ubiquitous Language**
- **A Context Map** is a docs whihc outlines the different Bounded Context and the relationship between them

![Example of Context Map](https://media.discordapp.net/attachments/287239433517006848/1014378486556803143/unknown.png?width=1240&height=640)

## The interaction between different contexts
### Partnerships
- **teams in two contexts will succeed or fail together**
- Therefore:
  - ถ้าเกิดว่า development fail ในสักทีมใดทีมนึง ก็จะทำให้ delivery fail ทั้งสองทีม
  - need to scheduled the independent features, so that they are completed for the same release

### Shared Kernel
- **Sharing a part of the model and associated code**
- Therefore:
  - ต้องตกลงกันว่าขอบเขตที่เป็นส่วนที่ share กันมันอยู่ตรงไหน แล้วก็จำเป็นต้องจำกัดให้ส่วนนี้มีขนาดเล็ก
  - ในส่วนที่ shared กันอยู่จะมีสถานะพิเศษคือ ถ้าเกิดจะมีการเปลี่ยนแปลง **จำเป็นต้องคุยกันทั้งสองฝ่ายก่อน**

### Customer-Supplier
- when two teams are in an **upstream-downstream relationship, where the upstream team may succeed independently of the fate of the downstream team**
  - ผลความสำเร็จจะขึ้นอยู่กับทีมที่อยู่ downstream เท่านั้น
- Therefore:
  - ต้องมี communication between the customer-supplier ที่ดี หมายความว่าลำดับความสำคัญของ downstream จะไปเป็นปัจจัยของ upstream team's planning
  - เจรจา และ budget tasks ของ downstream requirements เพื่อให้ทุกๆคนเข้าใจถึง commitment and schedule

### Conformist
- **the upstream has no motivation to provide for the downstream team's need**
- Therefore:
  - กำจัดความซับซ้อนออกไปจากช่วง translation ระหว่าง bounded context โดยไปเกาะ model ของ upstream team
  - share ubiquitou language with your upstream team. Altruism maybe sufficient to get them to share information with you

### Anticorruption Layer
![Anticorruption Layer](https://media.discordapp.net/attachments/287239433517006848/1014389014234677268/unknown.png?width=1000&height=640)

### Open-host Service
- where integration is one-off, this approach of inserting a translation layer for each external system avoids corruption of the modles with a minimum of cost
- Therefore:
  - when you find your subsystem in high demand, you may need **to define a protocol that gives access to your subsystem as a set of services** (define a clearly APIs)
  - Enhance and expand the protocol to handle new integration requirement, except when a single team has idiosyncratic needs
    - ปรับแก้ APIs เพื่อรองรับการ integrate กับ subsystem อื่นๆ
  - Then, use a one-off translator to augment the protocol for that special case so that the shread protocl can stay simple and coherent

### Published Language
- the translation between the models of two bounded contexts required a common language
- Therefore:
  - **Use a well-documented shared language that can express the necessary domain information as a common medium of communication**
    - ทำเอกสารประกอบ apis เพื่ออธิบายว่ามีการทำอะไร ใช้งานอย่างไร

### Seperate Ways
- **have no significant relationship**
- Therefore:
  - Declare a bounded context to have no connection to the others at all, allowing developers to find simple, specialized solutions within this small scope

### Big Ball of Mud
- **When well-defined context boundaries are absent, or disappear, multiple conceptual systems and mix together**
  - ไม่มีขอบเขต context ที่แบ่งชัดเจน ทำให้ context หลายๆอย่าง มายำรวมกันกลายเป็น ก้อนโคลนก้อนใหญ่ๆ ก้อนนึง
- Therefore:
  - Do not try to apply sophisticated modeling within this context. Be alert to the tendency for such system to sprawl into other contexts
    - อย่าพยายามไปนำ context มาใช้กับระบบที่ซับซ้อน แต่ก็ควรระวังไว้ว่ามันอาจจะไปส่งผลกระ context อื่นได้

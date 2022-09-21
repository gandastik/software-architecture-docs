## Unified Modeling Langauge
> ไม่ออกสอบกลางภาค กลางภาคออกสอบถึง model driven design -> บรรยายไม่เกิน 20 ข้อ

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

### Learning UML
- [https://www.omg.org/spec/UML/2.5/About-UML/] <- Standard
- [https://www.uml.diagrams.org/] <- How to write UML

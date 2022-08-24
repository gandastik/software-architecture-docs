## Introduction to Software Design with Domain-Driven Design

### Models
- **Software Design** is about modeling software ***systems***
- **Systems** is an organized or complex whole: an assemblage or combination of things or parts forming a complex, unitary whole
  - การรวมกันเป็นเหนึ่งเดียวของหลายๆสิ่ง
- **Modeling** a system means ***identifying its mains characteristics***, states and behavior using a ***notation***
- **Unified Modeling Language (UML)** is a commonly used for modeling software systems

- Reasons for modeling
  - To understand
  - To clarify
  - To analyze
  - To experiment
  - To evaluate
- How to model
  - Textual
  - Graphical
  - Mathematical

- **Model** : A system of abstractions that describes selected aspects of a domain and can be used to solve problems related to that domain
  - ระบบของนามธรรมที่ใช้ในการอธิบายด้านต่างๆของโดเมนและสามารถถูกใช้ในการแก้ปัญหาที่เกี่ยวข้องกับโดเมนนั้นได้

### Domain
- ***an area of knowledge or activity***
- Definition: "A sphere of knowledge, influence, or activity. The subject area to which
  the user applies a program is the domain of the software"

### Domain-Driven Design (DDD)
> A software design approach focusing on modeling software to match a domain according to input from that domain's experts
- **Software Domains**
  - the subject area to which the user applies the program is the domain of the software
  - some doamins involve the physical world: airline-booking program involves real people getting on real aircraft
  - some domains are **intangible**: an accounting program is money and finance
- **Why Domain-Driven ?**
  - software is made up of code
  - seeing the software as simply objects and methods, some devs might spend too much time solely on code.
  - the entire purpose of the software is to enhance a specific domain. ***the software has to fit harmoniously with the domain it has been created for.***
  - ***software needs to incorporate the core concepts and elements of the domain***, and to realize the relationship between them
- **Domain Knowledge** -> focusing on making a model
  - To create a good software system, one must understand the domain of that software!!
  - ***Models are tools for dealing with complexity of information required***
- "**A domain model** is not a particular diagram; it is the idea that the diagram is intended to convey. It is not just the knowledge in a domain expert's head;
***it is regorously organized and selective abstraction of that knowledge.***"
- **Communicate with Domain Experts**
  - Event storming : workshop-based to quickly find out what is happening in the domain of software program. expressed in sticky notes on a wide wall
  - Domain model diagram : UML diagram
- **Utility of a Model** in Domain-Driven Design
  1. model and the heart of the design shape each other
  2. model is the backbone of a language used by all team members
  3. model is distilled knowledge
- Scenario II (Airplane Flight Control System)
  - exchanging knowledge between domain experts and the developer or software architectures
  - made a better model
  - communication and understanding and learning between the domain experts and software architectures are important!
  - We, the ***software specialists (software architects and developers) and the domain experts***, ***are creating the model
  of the domain together***, and the model is the place where those two areas of expertise meet.

### The Ubiquitous Language
> ภาษาที่ไปที่ไหนก็เจอ -อาจารย์ปริญญา, 2022
- **The Need for a Common Language** : DDD suggests that software specialist must work with the domain experts to develop models.
  - such an approach usually has some difficultites due to a communication barrier
  - to over the communication difficulties, software specialists and domain experts ***need to speak in the same language***
  when they meet to talk about the model and to define it.
  - make sure this language appears consistenly in all the communication forms used by the teams; for this reason, the language is called the ***Ubiquitous Language***
- **Creating the Ubiquitous Language**
  - Languages do not appear overnight, it takes hard work and a lot of focus
  - ***Experimenting*** with alternative expressions which reflect alternative models
  - then refactor the code, renaming class, methods, and modules to conform to the new model
  - If domain experts cannot understand something in the model or the language, then it most likely something is wrong.
What is a **Ubiquitous Language**: "A language structured around the domain model and used by all team members within a ***bounded context*** to connect all the activities of the team with the software"
  - เป็นภาษาที่ถูกสร้างขึ้นมาจาก domain model และถูกใช้งานโดยสมาชิกของทีมภายใต้ขอบเขตของบริบท (context) ที่กำหนดไว้เพื่อที่จะเชื่อมโยงกันระหว่างกิจกรรมต่างๆภายในทีมและซอฟต์แวร์
- What is a **Context** ?
  - "The setting in which a word or statement appears that determines its meaning. ***Statement about a model can only be understand in a context***"
  - บริบท คือข้อความที่เกี่ยวกับ model จะสามารถเข้าใจได้ภายใน context นั้นๆเท่านั้น!

### Summary
Domain-Drive Design is an approach to the development of complex software in which we:
1. Focus on the core ***domain***
2. Explore ***models*** in a creative collaboration of domain practitioners and software practitioners
3. Speak a ***Ubiquitous language*** within an explicitly ***bounded context***
by katy

## Quality Attributes
- be able to run a software is not enough to be a **good** software
- ***BUT Good/Bad is SUBJECTIVE***
- **mesuarable or testable property**.Is used to indicate how well the system
satisfies the needs of its stakeholders
- Functionality descrbies what the system does. Quality **describes how well**
the system does its function

### Functionality
- the ability of the system to do the work for which it was intended
- **does not** determine achitecture
- is **Objective**

### Quality Attribute Scenario
**Source of Stimulus** -> [**Stimulus**] -> **Environment (Artifact)** -> [**Response**] -> **Response Measure**

***Software Product Quality Standard*** [ISO/IEC FCD 25010](https://iso25000.com/index.php/en/iso-25000-standards/iso-25010)

### Availability
- Availability is a property of software - that it is there and ready to carry out its task when you need it to be
- Failure is the **deviation of the system** from **its specification**, where the deviation is externally visible
- Availability refers to the **ability of a system** to **mask or reapir faults** such
that the cumulative service **outage period** does **not exceed a required value** over a specified time interval (SLA: Sevice Level Agreement)
- **Sample Availability Scenario**
    - **Heartbeat monitor** -> [**Server Unresponse**] -> **Normal Operation** -> [**Inform Operator**] -> **2 hour of downtime**

### Availability Calculation
- MTBF / (MTBF + MTTR)
- **MTBF** : Mean Time Between Failures
- **MTTR** : Mean Time To Repair
- **System Availability Requirements**
    - **99.999%** (GOAL? (GOLD) STANDARD) [five 9's]
        - Downtime per 90 days : 1 minutes 18 seconds
        - Downtime per 365 days : 5 minutes 15 seconds

### Tactics for Availability
- **Detect Faults**
    - Monitor
    - Ping/Echo
    - **Heartbeat** : periodic message exchange between a system monitor and a process being monitored
        - the process is the one that initiate the message
    - Timestamp : uses to detect incorrect sequence of events (also sequence number)
    - Condition Monitoring : eg. checksum
    - Sanity Checking : checks the specific operations or outputs of a component
    - **Voting** : *comparing* computational results from multiple sources
        - Typical multi-source schemes
            1. **Replication (Simplest)** : having multiple copies -> protect against random failures of hardware
            2. **Functional Redundancy** : address the issues of common-mode failures (every replicas have the same faulty)
***adding diversity to redundancy*** (adding same input produces same output)
            3. Analytic Redundancy : diversity among the components's inputs and outputs
***to tolerate specification errors by using seperate requirement specification***
- **Recover Faults**
    - ***Preparation and Repair***
        - Redundancy
            - Active : maintain synchronous state with the active nodes
            - Passive (warm spare) : periodic state updates
        - Spare (cold spare)
        - Rollback : reverts to a previous known good state
        - Exception Handling
        - Software Upgrade
        - Retry : try again just in-case :tf:
        - Ignore Faulty Behavior : ignore the message that we know that its a bogus message
        - Grateful Degradation : maintain the most critical system functions while drop less critical functions
        - Reconfiguration : reassigning responsibilities
    - ***Reintroduction***
        - Shadow : operating a previously failed or in-service upgraded component in a "shadow mode"
        - State Resynchronization : use with Redundancy tactics to keep updating the standby components
        - Escalating Restart : Leveling the restart
        - Non-stop forwarding (eg. router)
            - Control plane
            - Data plane
- **Prevent Faults**
    - Removal from Service
    - Transactions
    - Predictive Model
    - Exception Prevention
    - Increase Competence Set : designing a component to handle more cases-faults-etc.

### Integrability
- software archiect need to be concerned with the cost and the risk of an integration tasks
- **Sample Intetgrability Scenario**
    - **Component Marketplace** -> [**New data filtering component become available**] -> **System (Development)** -> [**The new component is integrated and deployed**] -> **time period**

### Tactics for Integrability
- **Limit Dependencies**
  - Encapsulate : make an explicit interface to an elemnt and ensures that all
  access to the element must pass through this interface (just like in OOP)
  - Use an intermediary :
  - Restrtict Communication Paths : restricting and element's visibility
  - Adhere to Standards : syntax
  - Abstract Common Services :
- **Adapt**
  - Discover :
  - Trailor Interface :
  - Configure Behavior : behavior of a component can be config during the build phase
- **Coordinate**
  - Orchestrate : centralizing those dependencies at the orchestration mechanism
  - Manage Resources : software component are not allowed to directly access some computing resources
  but instead request those resources from a resources manager

### LAB notes
- Supervisord : client/server system that allows its users to monitor and control a number of processes on UNIX-like system

1. จะสามารถคำนวณหาค่า availability ของระบบได้จาก (ค่า availability ของ WebServer) * (ค่า availability ของ AppServer) * (ค่า availability ของ DBServer) โดยเหตุผลที่นำมาคูณกันก็เพราะว่าถ้าขาดตัวใดตัวหนึ่งไปก็จะทำให้ระบบทำงานไม่ได้ ดังนั้นค่า availability จึงนำมาคูณกัน โดยจะมีการคำนวณได้ดังนี้
availability ของ WebServer : 99.0% (0.99)
availability ของ AppServer x 3 (ค่า availability จะคิดจากค.น่าจะเป็นทั้งหมด - ค.น่าจะเป็นที่ทั้งสามตัวพัง) : (1-(1-0.90)^3) = 0.999
availability ของ DBServer x 2 : (1-(1-0.95)^2) = 0.9975
เพราะฉะนั้น availability ของระบบ จะมีค่าคือ (0.99) * (0.999) * (0.9975) = 0.986537475
2. supervisord
3. Supervisord เป็น software ที่สามารถให้ user เข้ามาดูแลและควบคุมกระบวนการ(process) ต่างๆบนระบบปฎิบัติการที่เป็น unix  ได้ ซึ่งในที่นี้ก็อาจจะเป็น server ได้ โดยเราจะสามารถนำ Supervisord มาใช้เพื่อเพิ่ม quality attribute ในด้าน availability ได้จากการที่ Supervisord นั้นสามารถให้เราสร้าง config file เพื่อที่จะรับมือกับเหตุการณ์ที่ไม่คาดฝัน ซึ่งอาจจะทำให้ระบบเกิดความเสียหายได้ ยกตัวอย่างเช่น ถ้าเกิดการ crash ของ process นึงขึ้นมา ซึ่งจะส่งผลให้ระบบหลักๆพังตามลงไปด้วย ถ้าเกิดเราได้ config ให้ Supervisord ทำการ restart process นั้นขึ้นมาหลังจากที่มัน crash ได้ ก็จะเป็นการเพิ่ม availability ให้กับระบบได้นั้นเอง อีกทั้งตัว Supervisord ยังมี features อื่นๆที่ยังช่วยเพิ่ม availability ได้อีกด้วย ยกตัวอย่างเช่น การ set priority order ให้กับ process group ซึ่งก็จะไปตรงกับ tactics ของการทำ availability ในเรื่อง grateful degradation ได้อีกด้วย และการ monitor status ของ process และสามารถ log ออกมาได้ ซึ่งก็จะเป็นการ detect faults นั้นเอง
4. จากที่ได้อธิบายไปข้อก่อนหน้า tactics ที่ Supervisord ใช้ในการเพิ่ม availability ให้กับระบบจะมีดังนี้
  1. Retry เพราะว่า Supervisord นั้นสามารถทำการ restart process หลังจากที่มันเกิดการ detect ได้ว่า process นั้นได้เกิดการ crash หรือไม่ว่าจะเป็น status อื่นๆก็ตามที่ต้องการได้
  2. Monitor เพราะว่า Supervisord นั้นสามารถตรวจสอบและเช็คถึง status ของ process ที่มันได้สร้างขึ้นมาได้ตลอด เนื่องจาก process นั้นจะไปอยู่เป็น subprocess ของ Supervisord
  3. Condition Monitoring  เพราะว่า Supervisord ไม่ใช่เพียงแค่ดูได้แค่ crash process เท่านั้นแต่มันสามารถตรวจสอบสถานะของ process ได้ตามแต่ละ condition ของมันไป ไม่ว่าจะเป็น RUNNING, STARTING, EXITED, FATAL และอื่นๆ
  4. Grateful Degradation เพราะว่า Supervisord นั้นอนุญาติให้ user ตั้งค่า (config) process group ได้และยังสามารถตั้ง priority order ได้ ซึ่งก็จะเป็นการจัดเรียงลำดับ function ที่สำคัญให้มีการทำงานที่มีความสำคัญกว่าได้อีกด้วย
  5. Reconfiguration เพราะว่า Supervisord มี event listener และ event notification ทำให้สามารถตรวจจับสถานะต่างๆที่ต้องการของ process และสามารถ execute code ตามสถานะนั้นๆได้ ซึ่งการ execute code ก็อาจจะเป็นการเปลี่ยน responsibility ของ process ตามแต่สถานะที่ปรากฎอยู่ในขณะนั้นๆ
5. Primary/Replica Replication (asynchronous)
6. ช่วงเวลา Downtime สามารถเกิดได้ในช่วง Automatic failover ซึ่งก็จะเป็นช่วงที่ database ตัวสำรองจะกลายมาเป็น primary node เนื่องจาก primary node นั้นเกิดข้อผิดพลาด ซึ่งในช่วงเวลานี้ก็จะส่งผลให้เกิด downtime กับ application ได้ยกตัวอย่างเช่น ในกรณี (delayed retry) ที่ application ส่ง write queries เข้ามาหลังจากที่ primary node นั้น failed แล้ว ซึ่งก็จะส่งผลให้ database proxy นั้นส่ง error กลับมา และ application จะจำเป็นต้องรอก่อนสักเวลานึงและส่ง write queries เข้ามาอีกครั้ง หรือไม่ว่าจะเป็นการเกิด downtime ในกรณีที่มีการส่ง transactions แล้วแต่เกิด automatic failover กลางคันทำให้การทำ transactions กับ primary node นั้นยังเสร็จไม่สมบูรณ์ ซึ่งในกรณีนี้ database proxy ก็จะสามารถ config ให้มีการ transaction replay ได้ซึ่งก็จะเป็นการรอกระบวนการ automatic failover เสร็จก่อนแล้วจะย้าย transactions ที่ทำกับ primary node เก่าไปยัง master node ใหม่ให้
7. Redundancy (passive) ในการที่ทำ redundancy แบบ asynchronous โดยที่มี standby database ที่จะถูก update อยู่เป็นช่วงๆ คอยที่จะทำหน้าที่เป็น primary node หลังจากที่เกิดการ fail ของ primary node แต่ก็จะมีในกรณีที่ standby database คอยที่จะทำหน้าที่ ตอบกลับ read queries ตามที่ database proxy แบ่งหน้าที่มาให้
State Re-synchronization เกิดขึ้นในกรณีที่ทำการ primary/replicas replication เนื่องจากจะเป็นการ update ให้ replicas มีข้อมูลที่เป็นปัจจุบันมากที่สุดอยู่ ในกรณีนี้ก็จะเป็นการใช้ Global Transaction ID (GTID)
Removal from Service จะเป็นการเกิดขึ้นในตอนที่ primary node นั้นเกิดข้อผิดพลาด ทำให้จะมีการนำตัว primary node นั้นออกจากการให้บริการแล้วนำตัว standby database มาเป็น primary node แทน จะเรียกกระบวนการนี้ว่า automatic failover
8.
9. OSGi หรือ Open Services Gateway Initiative คือมาตรฐานสำหรับ computer software โดยจะมุ่งเน้นไปในด้านการทำ Module System ของภาษา Java โดยถ้าหากมีการนำมาตรฐาน OSGi มาประยุกต์ใช้ก็จะเป็นการส่งเสริม Quality Attribute ในด้าน Integrability เนื่องจากมาตรฐาน OSGi จะ
  1. ส่งเสริมให้แต่ละ dependency นั้นมีการบ่งบอกถึงความสามารถและความต้องการของตัวมันเองได้ ซึ่งจะเป็น tactics ของ Integrability ในด้าน Adapt ก็คือจะทำให้ Third Party ที่จะเข้ามาทำงานหรือจะ Integrate ต่างๆเข้าใจได้ง่ายขึ้น มีความง่ายต่อการเปลี่ยนแปลง เพราะเราจะสามารถรู้ว่าแต่ละ Dependency มีความสามารถอะไรบ้างและต้องการอะไรบ้าง หากเราจะต้องการหาตัวแทน Dependency นั้นๆก็จะสามารถทำได้ง่าย
  2. จะเป็นการส่งเสริม Integrability ในด้าน tactics ของการ Adhere to standards เพราะว่า OSGi เป็นมาตรฐานที่ต้องมีการบังคับให้ทำตาม ซี่งก็จะส่งผลดีต่อความ Integrability เนื่องจากจะทำให้ Dependency นั้นไปในทางเดียวกัน จะไม่มีความสับสน
10. DNS-Based Service Discovery คือการทำ Service Discovery โดยมองหลักการ DNS เป็นต้นแบบ โดยจะเป็นการแก้ปัญหาจากการทำ Microservice หรือก็คือการแยก Service ออกมาทำงานเป็นคนละส่วนกัน โดยจะมีปัญหาก็คือการติดต่อกันระหว่าง Service ว่าจะติดต่อกันอย่างไรดีให้มีประสิทธิภาพและไม่เกิดปัญหามากที่สุด โดยวิธีแก้ก็คือการทำ Service Discovery ซึ่งก็จะเป็นการทำให้แต่ละ service สามารถติดต่อหากันได้โดยจะต้องมีตัว Service Registry ซึ่งจะเป็นตัวกลางที่คอยเก็บข้อมูลและตำแหน่งของแต่ละ service ไว้ ซึ่งจำเป็นที่จะต้องอัพเดทให้เป็นปัจจุบันเสมอ ซึ่งตัว service registry จะทำหน้าที่จัดเก็บและบ่งบอก location ของ service ที่ถูกถามหาได้ โดยการทำ service discovery จะสามารถแบ่งได้ สองรูปแบบถ้าหากใช้เกณฑ์เป็นตำแหน่งที่เกิดการทำ service discovery 1. client side service discovery โดยตัว client จะทำหน้าที่เป็นตัวที่ติดต่อไปยัง service ที่ต้องการเองหลังจากที่ได้ location จากการที่ไปขอมาจาก service registry แล้ว 2. service side service discovery คือจะมีตัว proxy ทำหน้าที่ในการ redirect ให้ระหว่างตัว client กับ service ที่ต้องการ

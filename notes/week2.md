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
        - State Resynchronization
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


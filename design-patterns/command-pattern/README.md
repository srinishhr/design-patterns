# command-pattern #

- Avoiding if-else ladder
- Implementation of command-pattern
- based on source: Udit Agarwal(anamoly2104)


### BadImpl 
- here an if-else ladder is implemented to execute a command.
- balance and recharge are two commands, whose implementations are provided.
- introduction of a new command, will result in growing if-else ladder.
#### SOLID Principles
<pre>
    Single Responsibility: badImpl/CommandRunner.java consists of flows are kinds of command.
    Open/Close principle: badImpl/CommandRunner.java is not open for extension and also not closed for modification
(it needs to be modified when new command is added).
    Interface Aggregation : no interfaces.
    Dependency Inversion: dependencies are being injected in constructors.
</pre>

### GoodImpl
- command pattern is implemented using Abstract class CommandExecutor.
- specific commands are implemented as BalanceCommandExecutor and RechargeCommandExecutor.
#### SOLID Principles
<pre>
    Single Responsibility: 
        - classes have been implemented to bear single-responsibility.
        - goodImpl/CommandRunner.java only is responsible to trigger respective execution.
        - BalanceExecutor.java and RechargeExecutor.java hold specific implementations.
    Open/Close principle: 
        - classes are closed for modification.
        - addition/modifications of command is specific to its own implementation class.
        - open for extension for adding new command-execution.
    Interface Aggregation : no interfaces, but abstract classes are used.
    Dependency Inversion: dependencies are being injected in constructors.
</pre>

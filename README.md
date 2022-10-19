# Assignment 1 Distributed System
### github repo: https://github.com/filippocasari/ChatServer.git
@author: Filippo Casari

### example of the last exercise scenario
![alt text](images/distributedsystems.drawio.png)

## Exercise 1
To run the server, compile the java code and open the terminal and run the following command for the client:
```
$ telnet 127.0.0.1 8080
```
## Exercise 2
To run the server just follow the instruction as explained above in the previous ex. 
The client must be run by passing as arguments:
```
[ip][port]
```
## Exercise 3
I implemented a program the spawn 3 threads. Each one has his own id and after a fixed delay it terminates. 
Run the file by passing the following argument to the SpawningThreads executable:
```
 [num_threads]
```
 This value is set to 3 by default if the user does not provide any arguments.
## Exercise 4
The server handles multi clients by using multithreading style. It starts a new thread whether a new client would communicate with the running server. 
Every client has his own id created randomly. The program allows at most 1000 clients.  
You can run multiple clients in 3 ways:
- by manually launching many times' client.java program
- by launching multi clients java code
- by terminals with the command provided in the first exercise

*Is this the only way to handle multiple connections at the same time? Reflect on possible alternatives.*
- **Single-thread model**: One thread receives requests, executes them and replies to the clients
- **Finite-state machine model**: One thread executes requests and replies, if execution is quick. Multiple requests are handled simultaneously

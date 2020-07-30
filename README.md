##Sherpa-Module 2:Sanctions Screening
Objective: 
```
Upon reading a CSV of people, places or things, the user will
provide an input on the command prompt and it will
match it with the above list and return a “Hit” or “No hit” 
based on a 75% match.
Example being: Royal Carribean Cruise - if user inputs this with exact match
the screener will return a hit of 1.0 indicating an exact match.
```
## Installation

Below are the required installations to run the project

```
IntelliJ
Docker or Docker compose - 19.03.08 or higher 
(Make sure to have windows build 19.01.4 or later)
Otherwise WSL2 is needed to be installed manually)
Mvn 3.6.3 -Dependency Management
Spring Boot - Java-based framework for micro services
Postman 7.27.0+ / Insomnia - another API testing tool
Kafka
Zookeeper
```
## Usage
The project is built to run both local and Rest Based.
Docker handles both kafka and zoom, which frees up managing them while testing and running the program.

To run locally, please open a terminal in the IDE and run:

``docker-compose up`` to start Kafka and Zookeeper,

``docker-compose down``to terminate and end when finished testing.

Then build and run Sanctions Screening project which will open a window waiting for inputs.

Input will be sent through Postman.
Postman's configuration to send an input is listed below:

``http://localhost:8080/Send?input= user input here``

Rest API based:
Same process as above except instead of running sanctions screening project,
User will open a secondary terminal and 
Run spring boot on terminal two using: ``mvn spring-boot:run``

Terminal two is where the message will be published.
Input will be sent through Postman with the given configuration below.
``http://localhost:8080/Send?input= user input here``

##Unit Test

To run unit test type in terminal: ``mvn test``

Tests for:
````
1)No message received / empty
2)Invalid Input type
3)Correct Hit
4)Number mixed input
5)Special character mixed input
6)Number and special character input
7)Spaces Involved
8)Spaces and underscores involved
9)Upper Case and Lower Case involved
10)No Hit
11)All mix input

````
## Authors
Created by Jeremy S Bayangos,

Software Engineering Program intern 2020


# Shopping-Cart-Service

The Shopping Cart Service is a Backend service which is developed using Spring Boot, JPA, and MySQL database. It provides a comprehensive solution for managing online retail operations efficiently. 



## Installation and Run

Clone this repository in your local system

```bash
  git clone https://github.com/Nikhilraj081/shopping-cart-services.git
```
Go to shopping-cart-service/Database folder and import database in your local MYSQL database and change MYSQL username and password in application.properties file:
```bash
  spring.datasource.username=XXXX
  spring.datasource.password=XXXX
```
Then open terminal and go to project directory and run below command to start project:

```bash
  mvn clean spring-boot:run
```
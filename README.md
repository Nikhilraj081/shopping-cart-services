
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
Once server is started paste below swagger-ui link to your browser  
```bash
  http://localhost:8081/shopping-cart/swagger-ui/index.html
```
It will open swagger ui interface where you can test the all endpoints.

## Api test

### Step 1
First go to auth-controller and click on login api and then click on try it out option after that provide below body and generate jwt token
```bash
  {
    "email": "nikhil@gmail.com",
    "password":"12345678" 
  } 
```
### Step 2

Copy that jwt token and go to top right corner and click on Authorize option and put that token there and then click on authorize to get authorize.

### step 3 
Now we can test all the api's after providing required information.
For example: To Test get user by id api's go to user controller then click on GET /user/{id} after that click on try it out option then provide id 2 then click on excute option after that you will get user information below.

# Task Tracker API (Java Spring Boot)

![Java](https://img.shields.io/badge/Java-17-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-green.svg)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
- [API Documentation](#api-documentation)
- [Scaling API](#scaling-api)

## Introduction

Task Tracker API is a Java Spring Boot application that provides RESTful endpoints for managing tasks in projects. It follows best practices for Spring Boot development and includes features like API documentation with Swagger.

## Features

- Create, Read, Update, and Delete tasks
- RESTful API endpoints
- Unit and Integration tests
- Swagger API documentation

## Getting Started

### Prerequisites

Before you begin, ensure you have the following prerequisites:

- Java Development Kit (JDK) 17
- Maven installed
- MySQL database installed and running

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/s2emaduddin/task-tracking.git
2. Open the project in your IDE:
   Install all maven dependencies.
   ```bash
   cd task-tracker
   mvn install

### Configuration
Make sure you have MySQL Server running.
Launch MySQL Workbench.
If MySQL Server and Workbench are not configured, 
Please follow tutorial here: [MySQL Setup Tutorial](https://www.simplilearn.com/tutorials/mysql-tutorial/mysql-workbench-installation)
Create task_tracker schema in MySQL Workbench 

Configure the MySQL connection in 

    ```bash
    src/main/resources/application.properties
    spring.datasource.url=jdbc:mysql://localhost:3306/task_tracker
    spring.datasource.username=root
    spring.datasource.password=your-password

Run the TaskTrackerApplication class



### API Documentation
Access the API documentation using Swagger UI

- Swagger UI: http://localhost:8080/swagger-ui/index.html


### Scaling API
How would I build this API differently if it were to support a million customers?

1. I would do the time consuming tasks such as creating/updating/deleting tasks asynchronously. So that the client receives a quick response and actual creation/update/deletion process happens in the background
2. I would also have those customers call an API gateway which will be the entry gate to access /tasks
3. This API Gateway will authenticate each request on an Authentication Server
4. API Gateway will have routes configured in the properties file which will direct the incoming request to the correct API, be it /tasks or /users
5. To enable the traffic routes from API Gateway to other services, I will have Eureka Server and each of the services register with Eureka Server as Eureka Clients
6. There can be multiple instances running of each of these Eureka Clients and Eureka Server will distribute requests among available instances of the service
7. I will use Docker to containerize each of these services. Docker containers are lightweight and start quickly. This makes it easy to run multiple instances of the service
8. These multiple instances can be deployed on different servers (Horizontal Scaling) and the Eureka Server (Service Discovery) has info of all these Eureka Clients deployed on different servers and will route requests to available instances
9. I will also use Caching mechanism of Spring Boot to reduce database load
10. To service these million customers worldwide, the services can deployed in multiple geographic locations.

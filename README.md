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

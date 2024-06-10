# 🍿 SpringSerie 🎥

## Description

In this project, I use Spring Boot to develop the back end and HTML5, CSS3, and JavaScript for the front end. This project involves consuming the OMDb API, which provides us with series data. We will store this data in the PostgreSQL database management system. Then, we will connect the back end with the front end to display the data on the page.

## Installation and Usage:

1. Clone this repository to your local machine.
2. Install dependencies using `npm install`.
3. Configure your database connection in the `application.properties` file using the following code as an example:
    ```java
    spring.datasource.url=jdbc:postgresql://"Your host"/"The name of your database"
    spring.datasource.username="Your user"
    spring.datasource.password="Your password"
    spring.datasource.driver-class-name=org.postgresql.Driver
    hibernate.dialect=org.hibernate.dialect.HSQLDialect
    
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.format-sql=true
    })
4. register at `https://www.exchangerate-api.com/`
5. Write the password that arrived in your email in this code in the file `Principal` :
   ```Java
       private final String API_KEY = "YOUR_API_KEY";
7. Run the back end
    1. Move to the file `SpringSerieApplication` and run it:
8. Run the frond end
    1. download `live server` in `visual studio code extensions`
    2. Move to the file `index.html`
    3. Right click and click `open with live server`
   

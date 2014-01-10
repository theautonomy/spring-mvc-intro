Introduction
=================

This project quickly introduces some important features of the Spring MVC framework. The topics covered in this project include:
* Project setup and layout
  * Maven 
  
* Configuration
  * Spring XML and annotation hybrid
  * Use Spring profile to manage which configuration setting will be used at runtime
  
* View resolution 
  * Support different content types using content negotiation view resolver;
    * HTML
    * XML
    * JSON
    * PDF
    * EXCEL
  
  * Two rendering options for supporting HTML view are implemented:
    * Jsp
    * Thymeleaf
    
* Form bean validation with JSR 303 (via implementation by Hibernate Validator)
    
* Interceptor
  * Two functions are experimented 
    * You can time how long it takes for a page to load by simply appending ?timing=true to a url
    * You can switch the application to maintenance mode (showing flash page) by appending ?maintenance=true to a url
    * Of course, in real world we will use a configuration setting 

* Internationalization support

* Use Spring Security for user authentication and authorization

* Error/exception handling 

* How to run the application
  * Clone the project from github 
  * Run with Maven and Tomcat 7
    * From a command prompt, enter the command: mvn tomcat7:run
  * Run with Maven and Jetty 8
    * From a command prompt, enter the command: mvn jetty:run
  * Visit the following url from a browser: http://localhost:8080/spring-mvc-intro/
  * To edit a book, log in as normal user (id = user and password = user) 
  * To add a book, log in as admin user (id = admin and password = admin)
  * To show the time for loading each page, append ?timing=true to the url
    * For example, http://localhost:8080/spring-mvc-intro/book/list.html?timing=true
  * To switch the application to maintenance mode, append ?maintenance=true
    * http://localhost:8080/spring-mvc-intro/book/list.html??maintenance=true


 
 



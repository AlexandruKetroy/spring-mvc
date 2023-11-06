Spring MVC Web Application
=================================

H2 Database
------------
Connection details for datasource are configured by default by [EmbeddedDatabaseBuilder](src/main/java/com/example/config/AppConfiguration.java).
- jdbc-url: jdbc:h2:mem:testdb
- username: sa
- password: leave it empty

H2 web console is started during startup ([inMemH2Server](src/main/java/com/example/config/AppConfiguration.java)) and can be accessed on http://localhost:8082.

Requirements
------------
* Java
* Maven
* Servlet container for java web application e.g. [Apache Tomcat](https://tomcat.apache.org/download-90.cgil)
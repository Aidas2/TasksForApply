# TaskFromSEBGS

 Techstack:
  - backend: Java, Spingboot, Maven;
  - frontend: Angular, Bootstrap;
  - database: MySQL;
  
  
Prerequisites:
 - created database "etoolapp";
 - created user "etoolapp" with password "etoolapp" (and granted all privillegies);
 - created schema "etoolapp";
 
 
App configured to run only on localhost:
  - backend on port 8080;
  - frontend on port 4200;
  - database on port 3306;
  
  
Launching commands:
  - backend: 
		- open project in IntellijIdea and run "ProductRecommendationToolApplication" or
		- type in terminal "mvn spring-boot:run";
		
  - frontend:
		- type in terminal (command promt) "npm install" (only once);
		- type in terminal "ng serve";
  - database:
		- launch MySQL Workbench;
  - open browser and type "localhost:4200"
		

Tests:
  - frontend: type in terminal "ng test";
  - backend: run test folder src/test/java/com/sebgc/etool
		

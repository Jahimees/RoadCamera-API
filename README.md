RoadCamera API represents a service which registers cars and provides reports on registrations.

<b>Development process:</b>
<p>1-day: the technical task and subject area are considered;</p>
<p>2-day: Implemented big part of the functionality;</p>
<p>3-day: Completed the development of functional;</p>
<p>4-day: Written logs, tests. Assembled project;</p>
<p>5-day: Refactored code, assemled project, written readme file.</p>

<b>Technologies and tools:</b>
1) Spring boot;
2) Spring jpa;
3) Spring web;
4) Logger log4j2
5) Apache derby;
6) Maven.

Database works with in-memory mode.

<b>Requirements:</b>
<p>To use the application it is enough to have java installed on the machine. Cause server (Tomcat) and database (Derby) sewn into the project by Spring framework.</p>

<b>Deployment steps:</b>
1) Download project from repository
2) Build it in your IDE and make sure everything works
3) Run the command line
4) Move to the project directory by "cd" command
5) Execute command mvn package
6) You got executable jar-file which work independently

If you already have jar-file just execute it and application will be deployed to the local server.

<b>How to work with it?</b>
<p>1) Server will be deployed on address: http://localhost:8080/</p>
<p>2) If you want add new registered car use POST-request /registeredCars with body: </p>
<p>{ "carNumber": "carNumberExample" }</p>
<p>3) To get all registered cars use GET-request /registeredCars/all</p>
<p>4) To get total registered cars count use GET-request /registeredCars/count</p>
<p>5) To get filtered cars use GET-request with parameters "carNumber" and "date":</p>
<p>http://localhost:8080/registeredCars?carNumber=sas-f2&date=20191019</p>

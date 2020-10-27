# UniqueIdCounter-demo
Web Service to get count of distinct email addresses from the given list of email Id's


Question:
=========

https://fetch-hiring.s3.amazonaws.com/email.html

Please write a web service that accepts a list of email addresses and return an integer indicating the number of unique email addresses.

Unique email addresses means they will be delivered to the same account using Gmail account matching. Specifically: Gmail will ignore the placement of "." in the username. And it will ignore any portion of the username after a "+".

Examples
test.email@gmail.com, test.email+spam@gmail.com and testemail@gmail.com will all go to the same address, and thus the result should be 1.
test.email@gmail.com and test.email@fetchrewards.com are two different email addresses, and thus the result should be 2.



Solution:
=========

To Run the Web Service :
------------------------


Open the workspace folder in command prompt and run following commands

1. git clone https://github.com/patilrmanisha/UniqueIdCounter-demo.git
2. cd UniqueIdCounter-demo/
3. ./mvnw spring-boot:run

OR

Using Eclipse

1. Download the zip, Unzip the zip file
2. Open eclipse, File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip, Select the project.
3. Choose the Spring Boot Application file (UniqueIdCounterApplication.java). Right Click on the file and Run as Java Application


When you see '...Started UniqueIdCounterApplication..'. In terminal/console, follow following steps to test the web service.


To Test the Web Service :
-------------------------
1. Open Postman.
2. Enter URL in the URL text box - http://localhost:8080/api/v1/email/idCount
3. Select method GET from drop down.
4. Select Body (4th tab below url box), Select raw from the buttons below URL text box, Select JSON from the following dropdown.
5. In the area available below, pass JSON data (list of emails, see sample data below).
6. Click send on top left. 
7. In the Response area (select body tab), you will see count of unique email Id's from given list.

Sample JSON :
-------------

[  "testemail@gmail.com", "test+email@gmail.com", "test+spam@gmail.com" ] 

[  "testemail@gmail.com", "test.email@gmail.com", "testemail+spam@gmail.com" , "test.email+spam@gmail.com"] 

[  "test.email@gmail.com", "testemail@fetchrewards.com" ]


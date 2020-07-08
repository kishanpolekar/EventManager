# EventManager
Event Management in Spring Boot

The Event Manager application built in Spring Boot utilizes basic java tools and uses Gradle along with H2 database.

I would recommend downloading POSTMAN for the execution of this program. You can go to https://www.postman.com/downloads/ to download the app. Install it on your machine using all the recommended settings.

Begin by pulling the code from the Updates branch since that has the latest code. Master contains the first commit.

Unzip the file "EventManager-updates.zip" and open the project in your preferred IDE.

Navigate to "EventManager-updates/src/main/java/io/project/eventmanagement/EventManagement.java". This file contains the main class from where the application begins execution.

Run the file EventManagement.java through the IDE. It should begin compiling and start the local server at "localhost:8080".

Open the Postman application, begin without signing in (if it is your first time using postman), and you should see the launchpad opened. 

In the dropdown menu, select GET and enter the url "https://localhost:8080/allEvents" to get a list of all events present. There should be none initially.

To add an event, select POST in the dropdown menu, enter the url "https://localhost:8080/addEvent", and select the options raw, JSON in the BODY section below. Enter an entry in the JSON format like the following:

	{
		"name": "Event",
		"startDate": "07-07-2020",
		"endDate": "07-08-2020",
		"duration": 1
	}
	
Here, the date format is "MM-dd-yyyy". Hit the send button to see the entry added to our H2 database for this session.

To update an event, select PUT in the dropdown menu, enter the url "https://localhost:8080/updateEvent/1" (where 1 is the event ID), and select the options raw, JSON in the BODY section below. Update an entry in the JSON format like the following:

	{
		"name": "New Event",
		"startDate": "08-01-2020",
		"endDate": "08-08-2020",
		"duration": 7
	}
	
Hit the send button to see the entry updated in the database. If there is no matching event ID, a new event will be created with the information provided. 

The program also supports deleting an event using the event ID. To do so, select DELETE in the dropdown menu, enter the url "https://localhost:8080/deleteEvent/1" (where 1 is the event ID). If the event ID is found, it is deleted, if not, there are no changes to the database.

When you are done with all the executions, quit the postman app, stop the execution of the main java file from the IDE, and close the IDE.

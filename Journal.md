# Journal

Document project progress, the development process, accomplishments, snags, and time spent on this class. 

[Time Log](TimeLog.md)

### Week 7

02/29/2016 

Tasks Completed:

    * Created Bookworms repository.
    * Created project structure in IntelliJ.
    * Wrote the problem statement.
    * Began the project plan.
    * Completed Activity 3 - Create and Test Your second RESTful Web Service in IntelliJ
    * Journal Entry
 
We are off to a great start working well together as a team! 

### Week 8

03/07/2016 
    * Had a Bookworms Group meeting where we discussed application flow and defined project objectives and web service output
    * Assigned Alex the tasks of creating java beans for the web service and creating the send request for web service
    * Researched GOODREADS webservice
    * Assigned Savannah the task of converting the beans into JSON
    * Assigned Nancy the task of converting XML to beans,  creating application flow file
    * Nancy updated project plan and readme file

### Week 9
Spring Break

### Week 10

    * Had a Bookworms group meeting where we discussed pregress on assigned objectives from week 8
    * Alex created java beans and the send request for web service
    * Savannah converted beans into JSON
    * Nancy converted XML to beans using the JAXB unmarshaller
    * Nancy updated project plan and readme file
    * Nancy and Savannah created application flow file
 
Nancy struggled with converting the xsd/xml file. There were "errors" in the 
xml code being received. Nancy used the validate tool in IntelliJ to fix the 
errors in the xml data so the generator would create the POJOS.

### Week 11
    * Savannah and Nancy deployed the service to OpenShift.
    * Savannah and Alex "cleaned up the code"
    
Savannah found a bug in the service while running that would occasionally 
receive truncated xml. Alex then later had the same issue. Alex fixed it by
changing the code so that the file was read differently. The most important
take away was to have the file not be read line by line.

Nancy was able to deploy the service in OpenShift whereas Savannah was unable to.
Savannah discovered it was another issue with the configuration of her
OpenShift. Savannah re-instated the set up procedure and was able to fix the issue!
    
### Week 12
    * The group discussed and then created the first tests for the service.
    * Alex finished creating the other necessary tests for the program.
    * Savannah and Alex created JavaDoc comments for the service.
    * The group made a powerpoint presentation to coincide with the project code.
    * Nancy generated the JavaDoc files needed for the service.
    * Nancy completed the Journal and Project Plan.
    * The group practiced our presentation.
    * The group delivered our presentation on the service we created.

Nancy struggled the night before the presentation with IntelliJ. The group
project version she was working on became "corrupt". Nancy could not "break out"
the commits so in fear of corrupting the entire project with a "push" she
deleted her version of the project. This meant re-creating some of this 
journal. 

Since Maven was not introduced earlier, the group handled project dependencies
manually. This proved to be problematic in the end. Nancy could not correctly 
create the project even with a "clean" pull from the group GitHub repository.

Nancy received help via Slack from Vlad and even with his version of the
Jersey Jars, she was still unable to load the Jersey service.

Nancy then deleted the project and searched for all dependencies on her
local drive deleting these files too. This meant starting over yet again!

With this last attempt of a "clean" pull from the group repository (and
Vlad's notes) she was able to re-create the necessary dependencies for
the service to run!
 
  

# CSV Coding Challenge
 This project is a simple program which reads from a given CSV file and saves the data in 
a database. The project apply Spring Batch which reading data from CSV by chunk size, 
process data and write to memory database H2. 
We have two ways to trigger batch jobs, one is cron job and another one is Rest-API.
## Design
Attachment image
## Implementation
#### Step 1: Setup Spring Boot project from 'https://start.spring.io/' with Spring Batch, Spring JPA, Spring Web library
#### Step 2: Implement Batch Job with OrderReader, OrderProcessor, OrderWriter
#### Step 3: Implement GeneralLogs annotation to logs taken time and exceptions
#### Step 4: Implement Rest-API (OrderJobInvokerController) and Cron Job (ScheduledTasks)
#### Step 5: Implement unit test
## Deployment
#### Step 1: unzip assignment project
#### step 2: go to property file, modify file name and folder path for CSV file 'input.file', change port number, cron jobs
#### Step 4: go to the folder assignment, start maven build 'mvn clean install'
#### Step 5: start application: 'java -jar order-1.0-SNAPSHOT.jar'. On the other way, we can create docker file and deploy on cloud environment


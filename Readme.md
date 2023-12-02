#Prerequisites
1. Java 1.8 and above
2. maven

#How to run the code

1. `mvn clean install` This will create jar file with name address-book-1.0-SNAPSHOT.jar in target folder
2. `java -jar target/address-book-1.0-SNAPSHOT.jar sample-input/input1.txt` This will execute the commands defined in the sample input file 


#About the project
1. This project supports 3 types of command
   1. `ADD FirstName LastName Address PhoneNumber` This is used to add a new contact in the directory
   2. `GET-BY-NAME FirstName` This is used to get the contact based on the first name. For a given first name, I have assumed that we can get multiple contacts
   3. `GET-BY-PHONE-NUMBER PhoneNu` This is used to get the contact based on the phone number. For a given phone number, I have assumed that we can get a single contact as number will be unique
2. I have used trie for storing the contact details. This will reduce the time to retrieve the contacts, given that we have huge contacts directory. 
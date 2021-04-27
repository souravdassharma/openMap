There is a property file, setup.properties, which contains the url, browser type test data file and report file paths.
The program fetch values form these keys and works accordingly.

There is another property file called elements.properties. This file contains the webelements needed.

The 3rd user file is oneMapSG.xls. This file contains test data for validating routes. 

There are 6 test cases in this program.

1. Validate browser title
2. Validate the govt of Singapore logo
3. Validate overlay and close it
4. Validate menu names
5. Validate menu links are opening and validating the title of those menus
6. Validating number of routes between a given source and destination

For the first 5 test cases the test data is hard coded, but for the route validation test case the data is read from an excel file.
This excel file contains 4 columns: Source, Destination, Transport Type and Route Count. It only verifies the no of routes available for a given transport type between a source and a destination

The test report is written oneMap_Test_Reports.xls file, creating different sheets for different test cases. It creates a new test report file with the current timestamp if the test report file is already present.

There is another directory called screenshot, which captures and stores screenshots whenever a test case fails.

User need to execute execute_tc.java in order to execute the entire test cases.

A sample test report is attached herewith.
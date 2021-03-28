# REST App

# Description

Task is to develop our own relational database – this database can store anything we like. Then, to provide a web-service-based application that interacts with the database via JDBC.

# Database Details

Database is implemented in the Derby Database (Oracle Java DB) and have the following
properties:

    • At least one One-to-One relationship.
    • At least one One-to-Many relationship.
    • At least one Many-to-Many relationship.
    • Optimized to third normal form (3NF).
    • At least one column of the following types: INTEGER, VARCHAR, DATE, REAL.

# Web Service Details

All database interactions is provided as web services. The web services  implement all
interactions with the database by using JDBC. Web service component has the following
properties:

    • REST is used to provide web services.
      - A service that creates tables in Derby.
      - Query that involves a table with a One-to-One relationship.
      - Query that involves a table with a One-to-Many relationship.
      - Query that involves a table with a Many-to-Many relationship.
      - Adding an entry to a table with a One-to-One relationship.
      - Adding an entry to a table with a One-to-Many relationship.
      - Adding an entry to a table with a Many-to-Many relationship.

# Application Details

Application that interfaces to web services. This application  automatically
invoke each service at least once and display the outcome of each service: In case of queries display
the returned data, in case of statements indicate whether the statement was successful or not.

# Instructions on how to open the application in NetBeans 8.2

    1. Unzip the ZIP file.
    2. In NetBeans, Choose File > New Project (Ctrl-Shift-N on Windows/Cmd-Shift-N on OS X).
    3. Choose Java Web > Web Application with Existing Sources. Click Next.
    4. In the Name and Location page of the wizard, follow these steps:
        • In the Location field, enter the folder that contains the web application's source root folders and web page folders (The extracted ZIP file) 
    5. Click Next to advance to the Server and Settings page of the wizard.
    6. Click Next to advance to the Existing Sources and Libraries page of the wizard.
    7. Verify all of the fields on the page, such as the values for the Web Pages Folder and Source Package Folders. (In WEB-INF content, browse to /RESTApp/web/WEB-INF)
    8. Click Finish.
    9. Optional: Click on Resolve the Hamcrest binaries Missing (in RESTApp) problem.


More details can be found in Report.pdf.

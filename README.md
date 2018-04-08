This performs a simple salary calculation for the 2012 based Tax rates


Assumptions :

1. The salary is always paid monthly
2. The uniqueness of an employee is based on the first name and last name
3. For a given First name and Last Name it is possible to generate multiple pay slips, however, the salary can be paid only once for a given year and month
4. The Salary Table is maintained only to find if the salary is paid and it does not show the income tax or other details, which can be calculated based on the stored values

Reason for Using specific Technologies

1. Lombok  This will help in avoiding some boiler plate code
2. Angular JS is used, since I have used it in the past, and found it really convenient for usage
3. Springboot is used for a quick application development and JPA integration
4. The application uses the inbuild HSQL database for completeness and less installation efforts

Procedure to execute the project :

The executable jar is available in the below location 

https://www.dropbox.com/sh/i53qhs54l2bheni/AAAcwLUEoouiC9PPIZdyeCEKa?dl=0

The application will start with 

java -jar salarycalculator-0.0.1-SNAPSHOT.jar

you can access the index.html through localhost:8080/index.html. The employee list can be obtained by localhost:8080/salary/all.

The Generate Payslip will be enabled only with a valid data is given for all the four values

Testing

Provide a Salary of 60050, the payslip will be

Pay Date 8 April  2018
Pay Frequency Monthly
Annual Income 60050
Gross Income 5004
Income Tax 922
Net Income 4082
Super 450
Pay 3632

The source is available in https://github.com/swamitsk/salarycalculator





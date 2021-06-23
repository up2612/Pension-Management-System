# Pension-Management-System

Project Name: Pension-Management system.

Project Overview:
This project covers pensioner detail provision, calculate provision, initiate pension disbursement.

Total Microservices:

A.Authorization Microservice

B.Pension disbursement Microservice

C.Pensioner detail Microservice

D.Process Pension Microservice

E.Pension Management portal


Functionalities
---------------

A)Authorization Microservice:
-----------------------------


Main Functionality---> To Generate the token and Validate the token.

Step-1:Open Postman and follow the steps below:
 
Step-2:Go to Url section and paste---> http://localhost:8400/auth/api/v1/authenticate 

Method:POST

[Cloud Url---->pod5-june30-alb-283683330.us-east-2.elb.amazonaws.com/auth/api/v1/authenticate]

Step-3:  Body Section: 
    {
    "userName":"admin",
    "password":"admin"
    }

Step-4:  Click Send button,then a token will be generated.Copy the token.

Step-5:Open New tab in postman. 
 
Step-6:Paste the Url--> http://localhost:8400/auth/api/v1/authorize

Method:POST

[Cloud Url---->pod5-june30-alb-283683330.us-east-2.elb.amazonaws.com/auth/api/v1/authorize]

Step-7: Go to Authorization Section: Select token type as Bearer ,next paste the token there.

Step-8:Now check response section whether the token is valid or not.The boolean output 'true' indicates that the token is valid and 'false' indicates that the token is invalid.


B) Pension disbursement Microservice:
--------------------------------------

Main Functionality---> 

a)Gets the pension amount along with pensioner aadhaar details. This internally gets the bank detail from the Pensioner detail Microservice.
 Checks if the bank service charge is credited along with the pension amount or not. If the data is correct, then success code is returned, else appropriate error code is returned

b)This should be invoked from the ProcessPension microservice


Step-1:Open Postman and follow the steps below:
 
Step-2:Go to Url section and paste---> http://localhost:8300/disbursement/api/v1/disbursePension

Method:POST

[Cloud Url---->pod5-june30-alb-283683330.us-east-2.elb.amazonaws.com/disbursement/api/v1/disbursePension]

Step-3:  Body Section: 
    {
    "aadharNumber":420559429029,
    "pensionAmount":24400.0,
    "bankCharge":550
     }

Step-4:Go to Authorization Section: Select token type as Bearer ,next paste the token there.
 
Step-5:Now check response section,

i)If token is valid,bank type is Private and bank charge is 550 then a response of status code-10 will be returned otherwise 21 will be returned.

ii)If token is valid,bank type is Public and bank charge is 500 then a response of status code-10 will be returned otherwise 21 will be returned.

iii)If token is invalid then an exception will be thrown with a FORBIDDEN status.



C)Pensioner detail Microservice:
--------------------------------

Main Functionality-->

a)Used to find all the pensioner details.

b)Used to find details of a particular pensioner by Aadhar card number. 


a)To find all the pensioner details.
------------------------------------

Step-1:Open Postman and follow the steps below:
 
Step-2:Go to Url section and paste---> http://localhost:8200/pensioner/api/v1/getAllPensioner

Method:GET

[Cloud Url---->pod5-june30-alb-283683330.us-east-2.elb.amazonaws.com/pensioner/api/v1/getAllPensioner]

Step-3:Go to Authorization Section: Select token type as Bearer ,next paste the token there.

i)If token is valid,then all pensioner details will be returned.

ii)If token is invalid then it will throw an exception.


b)To find details of a particular pensioner by Aadhar card number.
-----------------------------------------------------------------

Step-1:Open Postman and follow the steps below:
 
Step-2:Go to Url section and paste---> http://localhost:8200/pensioner/api/v1/PensionerDetailByAadhaar/420559429029  {Here 420559429029 is the aadhar number}

Method:GET

[Cloud Url---->pod5-june30-alb-283683330.us-east-2.elb.amazonaws.com/pensioner/api/v1/PensionerDetailByAadhaar/420559429029]

Step-3:Go to Authorization Section: Select token type as Bearer ,next paste the token there.

i)If token is valid,and subsequently if Aadhar number is valid then it returns the pensioner details of that particular pensioner.  

ii)If token is valid and Aadhar number is invalid then it will throw Aadhar Not Found exception.

iii)If token is invalid then an exception will be thrown.


D)Process Pension Microservice:
-------------------------------

Main Functionality-->

a)Calculate Pension.

b)Returning the Status Code for pension process.


a)To Calculate Pension.

Step-1:Open Postman and follow the steps below:
 
Step-2:Go to Url section and paste---> http://localhost:8100/process/api/v1/PensionDetail

Method:POST

[Cloud Url---->pod5-june30-alb-283683330.us-east-2.elb.amazonaws.com/process/api/v1/PensionDetail]

Step-3:Go to Body Section and add the below Json object.
{
    "aadharNumber":420559429029,
    "name":"Parthik",
    "dateOfBirth":"1999-12-03",
    "pan":"BSDPS1495K",
    "pensionType":"self"
}

Step-4:Go to Authorization Section: Select token type as Bearer ,next paste the token there.

Step-5:

i)If token is valid and Pensioner details are also valid,then pension is calculated and 'PensionDetail' object will be returned.

ii)If token is invalid then an exception will be thrown.


b)For the Status Code Response.

Step-1:Open Postman and follow the steps below:
 
Step-2:Go to Url section and paste---> http://localhost:8100/process/api/v1/ProcessPension

Method:POST

[Cloud Url---->pod5-june30-alb-283683330.us-east-2.elb.amazonaws.com/process/api/v1/ProcessPension]

Step-3: Go to Body Section and add the below Json object.

{
    "aadharNumber":420559429029,
    "pensionAmount":24400.0,
    "bankCharge":500
}

Step-4:Go to Authorization Section: Select token type as Bearer ,next paste the token there.

Step-5:Now check response section,

i)If token is valid and entered details are also valid ,and for that user if bank type is Private and bank charge is 550 then a response of status code-10 will be returned otherwise 21 will be returned.

ii)If token is valid and entered details are also valid ,and for that user if bank type is Public and bank charge is 500 then a response of status code-10 will be returned otherwise 21 will be returned.

iii)If token is invalid then an exception will be thrown.



E.Pension Management portal:
---------------------------

Functionality:

Pension Management Portal must allow admin to Login. Once successfully logged in, then do the following operations:

a)Finds all Pensioner Details.

b)Invokes the Pensioner details microservice and displays pensioner Details by Aadhar Card Number.

c)Displays the Calculated pension amount.

d)Returns a Success/Failure message based on Bank type and Bank Charge.


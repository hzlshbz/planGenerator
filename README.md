 # plan-generator
  The goal of the application is calculating a repayment plan for an annuity plan.
  
  # Build, Run Setup

To build and load the project in your favourite IDE run the following commands from the root folder, prefferably before opening it in the IDE: 

```

#$ mvn clean install
#$ mvn eclipse:clean eclipse:eclipse
#$ mvn idea:idea
```



For runing simply run the jar in ../target/

```

java -jar /target/plan-generator-<CURRENT TAG>.jar
```


Then load the project in eclipse/idea and run the `PlanGeneratorApplication.java` class.


  # Basic Usage
  `PlanController.java` is Rest Controller class which includes endpoint method;

  - calculatePaymentDetails(@RequestBody LoanDetails loanDetails) 
    - This method takes loanDetails as a HTTP request and returns PaymentDetails list as a response

  `PlanCalculationService.java` is the service class that handles logic part of the project.

  -getPaymentDetails(LoanDetails loanDetails)
    - This method takes loan information and calculates the payment details.

  `PlanGeneratorApplication.java` is the main class for the running project

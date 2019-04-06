# budget_backend

This project uses Java Spring boot
You will need to install JDK 8 as well as the spring tool suite
https://spring.io/guides/gs/sts/

Clone the repository and open in Spring tool suite update the project by right clicking the top folder and wait for maven to build it.
run the project and it should come up on localhost:8080

MYSQL DB TEST SCRIPT

Spring is set-up to build the mySQL database, all you need to do is create the database. It initially builds anything new to the database, then updates even if you shut Spring down and start it back up.
## Budget Database Creation

```
CREATE Database moolah;
```

NOTES:

Ids are Long values autogenerated from within Spring.
Make sure Id's in message body null for POST requests and the correct userId for PUT requests.


Get all users:

  Get request to Url: localhost:8080/users

Get or Delete particular user:

  Get or Delete request to url: localhost:8080/users/{userId}

Post user: 
```
  Post request to url: localhost:8080/users
  Body
  {
    	"userId": null,
    	"userName": "bigone2",
    	"email": "BillyBob@monkey.com",
    	"password": "R%#$F^",
        "firstName": "Billy",
        "lastName": "Bob",
        "dateCreated": "2019-01-14"
    }    
```


Update particular user: 
```
  Put request here: localhost:8080/users/{userId}
  Body
   {
    	"userId": {userId},
    	"userName": "UpdatedYeah",
    	"email": "BillyBob@monkey.com",
    	"password": "R%#$F^",
        "firstName": "Billy",
        "lastName": "Bob",
        "dateCreated": "2019-01-14"
    }
```

Get all accounts of user:

  Get request to Url: localhost:8080/users/{userId}/accounts

Get or Delete particular account of user:

  Get or Delete request to url: localhost:8080/users/{userId}/accounts/{accountId}

Post account: 
```
  Post request to url: localhost:8080/users/{userId}/accounts
  Body
    {
    	"accountId": null,
    	"accountName": "bigone77",
    	"balance": 7777.77
    }  
```


Update particular account of user: 
```
  Put request here: localhost:8080/users/{userId}/accounts/{accountId}
  Body
    {
    	"accountId": {accountId},
    	"accountName": "updated77",
    	"balance": 777777.77
    }
```


Get all transactions of account:

  Get request to Url: localhost:8080/users/{userId}/accounts/{accountId}/transactions

Get or Delete particular transaction of account:

  Get or Delete request to url: localhost:8080/users/{userId}/accounts/{accountId}/transactions/{transactionId}

Post transaction: 
```
  Post request to url: localhost:8080/users/{userId}/accounts/{accountId}/transactions
  Body
    {
    	"transactionId": null,
        "date": "2019-01-14"
    	"category": "$Money",
    	"amount": 77.77
    }   
```


Update particular transaction of account: 
```
  Put request here: localhost:8080/users/{userId}/accounts/{accountId}/transactions/{transactionId}
  Body
    {
    	"transactionId": {transactionId},
        "date": "2019-01-14"
    	"category": "$Money",
    	"amount": 7.77
    }
```

Get all budgets of user:

  Get request to Url: localhost:8080/users/{userId}/budgets

Get or Delete particular budget of user:

  Get or Delete request to url: localhost:8080/users/{userId}/budgets/{budgetId}

Post budget: 
```
  Post request to url: localhost:8080/users/{userId}/budgets
  Body
    {
    	"budgetId": null,
    	"category": "Groceries",
    	"maxAmount": 777.77
    }   
```


Update particular budget of user: 
```
  Put request here: localhost:8080/users/{userId}/budgets/{budgetId}
  Body
    {
    	"budgetId": null,
    	"category": "Gas",
    	"maxAmount": 7777.77
    }
```

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

ERROR MESSAGES:
```
Format example
{
    "timestamp": "2019-04-20T05:28:22.921+0000",
    "message": "No transactions found.",
    "details": "uri=/users/1/accounts/6/transactions"
}
```
  There are three types of non-default errors:
    ResourceNotFoundException (custom) - message says user not found. 
    PasswordMismatchException - message say password incorrect.
    NullPointerException - messages says resource not found.
    
## Entrypoints

## Users
### Login
Will return Long = userId if submitted password == password stored in DB for that user, or Long = 0 if not. 

```
  Post request to url: localhost:8080/users/login
  Body
  {
    	"userName": "bigone2",
    	"password": "R%#$F^",
  } 
```

### Get All Users
```
GET request to URL: localhost:8080/users
```

### Get User
```
GET request to URL: localhost:8080/users/{userId}
```

### Delete User
```
DELETE request to URL: localhost:8080/users/{userId}
```

### Add User
```
POST request to URL: localhost:8080/users
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

### Update User 
```
PUT request to URL: localhost:8080/users/{userId}
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

## Accounts
### Get All Accounts of User
```
GET request to URL: localhost:8080/users/{userId}/accounts
```

### Get Account
```
GET request to URL: localhost:8080/users/{userId}/accounts/{accountId}
```

### Delete Account
```
DELETE request to URL: localhost:8080/users/{userId}/accounts/{accountId}
```

### Add Account 
```
POST request to URL: localhost:8080/users/{userId}/accounts
    {
        "accountId": null,
        "accountName": "bigone77",
        "balance": 7777.77
    }  
```

### Update Account
```
PUT request to URL: localhost:8080/users/{userId}/accounts/{accountId}
    {
    	"accountId": {accountId},
    	"accountName": "updated77",
    	"balance": 777777.77
    }
```

## Transactions
### Get All Transactions of Account
```
GET request to URL: localhost:8080/users/{userId}/accounts/{accountId}/transactions
```

### Get Transaction
```
GET request to URL: localhost:8080/users/{userId}/accounts/{accountId}/transactions/{transactionId}
```

### Delete Transaction
```
DELETE request to URL: localhost:8080/users/{userId}/accounts/{accountId}/transactions/{transactionId}
```

### Add Transaction 
```
POST request to URL: localhost:8080/users/{userId}/accounts/{accountId}/transactions
    {
        "transactionId": null,
        "date": "2019-01-14",
        "category": "$Money",
        "amount": 77.77
    }   
```

### Update Transaction 
```
PUT request to URL: localhost:8080/users/{userId}/accounts/{accountId}/transactions/{transactionId}
    {
    	"transactionId": {transactionId},
        "date": "2019-01-14",
    	"category": "$Money",
    	"amount": 7.77
    }
```

## Budgets
### Get All Budgets of User
```
GET request to URL: localhost:8080/users/{userId}/budgets
```

### Get Budget
```
GET request to URL: localhost:8080/users/{userId}/budgets/{budgetId}
```

### Delete Budget
```
DELETE request to URL: localhost:8080/users/{userId}/budgets/{budgetId}
```

### Add Budget 
```
POST request to URL: localhost:8080/users/{userId}/budgets
    {
    	"budgetId": null,
    	"category": "Groceries",
    	"maxAmount": 7777.77
    }
```

### Update Budget 
```
PUT request to URL: localhost:8080/users/{userId}/budgets/{budgetId}
    {
    	"budgetId": null,
    	"category": "Gas",
        "spentAmount": 3535.35
    	"maxAmount": 7777.77
    }
```

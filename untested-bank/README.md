# Untested Bank

Inspired by the [Bank Kata](https://www.codurance.com/katas/bank)

## Endpoints

### POST `/accounts`

Create an account

Response 
```json
{
    "id":"7f2afb67-5c65-49e6-a2a0-4eebcfc45aff"
}
```

### POST `/accounts/:id/deposit`

Create a deposit

Request Body 
```json
{
    "amount": 100
}
```

### GET `/accounts/:id/statement`

Get bank statement

```json
{
    "statementLines": [
        {
            "amount":100,
            "date":"Jul 18, 2024, 2:25:59 PM",
            "balance":300
        },
        {
            "amount":100,
            "date":"Jul 18, 2024, 2:25:51 PM",
            "balance":200
        },
        {
            "amount":100,
            "date":"Jul 18, 2024, 2:24:50 PM",
            "balance":100
        }
    ]
}
```

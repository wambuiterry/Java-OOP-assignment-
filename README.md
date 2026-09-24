# Payment Processing REST API Service

A lightweight, thread-safe RESTful API built in Java with Spring Boot to model core payment processing workflows, transaction ingestion, and account retrieval.

## Technical Highlights
- **Framework:** Java 17, Spring Boot 3
- **Architecture:** RESTful Web Services, Layered Architecture (Controller -> Service -> In-Memory Repository)
- **Data Validation:** Jakarta Bean Validation for transaction amounts and account formatting
- **Testing:** Unit tested with JUnit 5

## API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/v1/transactions` | Process a new payment transaction |
| `GET` | `/api/v1/transactions/{id}` | Retrieve transaction status by ID |
| `GET` | `/api/v1/transactions` | List all processed transactions |

### Sample Request (`POST /api/v1/transactions`)
```json
{
  "accountId": "ACC-8842",
  "amount": 2500.00,
  "currency": "KES"
}
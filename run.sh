#!/bin/sh

curl -X POST -d '{"credit_account_id": "8418f4ff-eabc-41e0-87d0-0f12853fc58b", "debit_account_id": "24324d01-ae69-452d-a969-b6bc93c1930e", "amount": "50.00", "currency": "USD"}' -H "Content-Type: application/json" http://localhost:4567/transfers

# Run Test

In order to run this project, please follow the next steps

```
./mvnw mvnw exec:java
```

Logs will display the following output:

```
Nov 11, 2019 1:58:18 AM org.example.account.AccountService createAccount
INFO: Account 111-1111 created with id c9614e82-ca26-4df4-9139-084be10db93b
Nov 11, 2019 1:58:18 AM org.example.account.AccountService createAccount
INFO: Account 222-2222 created with id 38717823-4a0e-4499-b28b-41ab975fc62f
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
```

Copy the id generated for each account and perform `./run.sh`

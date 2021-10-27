# mini-redis
```
ab -n 100 -c 10 -u data.json -T application/json http://localhost:8080/my-redis/increment/threadSafekey

```
 

# api expose are:
```
curl --location --request POST 'localhost:8080/my-redis' \
--header 'Content-Type: application/json' \
--data-raw '{
    "key":"threadSafeKey",
    "value":"1"
}'

curl --location --request GET 'localhost:8080/my-redis/threadSafeKey'```

curl --location --request PUT 'localhost:8080/my-redis/increment/threadSafeKey'
```

# test
we have created a Test.class which creates the number of thread needed and calls the update method.
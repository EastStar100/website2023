## Database tables
* Student: **student_id**, name, address
* Teacher: **teacher_id**, name, address
* Student_Teacher: **student_id**, **teacher_id**

## Database connection
```
server.port=8081

spring.datasource.url=jdbc:mysql://localhost:3306/{database}

spring.datasource.username = {name}

spring.datasource.password = {pwd}
```

## Test
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/22307051-3a9d03b6-e884-470b-b520-e5e9682c7a5e?action=collection%2Ffork&collection-url=entityId%3D22307051-3a9d03b6-e884-470b-b520-e5e9682c7a5e%26entityType%3Dcollection%26workspaceId%3D36a3e204-b96e-4813-a94d-86e7e3a9d7d9)

# delivery-manager

delivery manager API.

This api should be accessible for all clients that want to automate the creation, updates and views such information, thus a rest API was exposed for this purpose. This API that is a way to integrate systems with http protocol was developed in a springboot project.

We need to ensure that these end points are always avalible and even if a dependence on our application, fall and return, the api should return to air normally and without human intervention, thus, An asynchronous communication with JMS was adopted so  we ensure that all request will be avalible even with a database dependence down for example. We also ensure that no message will be discarded configuring the connection factory redelivery policity, thus each time a message throws any exception, it will return to the queue. For this functional test is been using embedded queue, but for a production scenario rabitMQ will be adopeted.

We need to have the control of our connections once we can’t wast time waiting for an connection response, thus the data source was configured with dbcp2. We chose to wait only for 1000 millis, but this time should be decided after some QA tests.

The API security (basic auth) was guaranteed with spring-securtity, which is a mature security framework. The user email and password are configured in the application properties, once we cannot depend on a database.

For the documentation, swagger was adopted once it  build process by keeping its design, documentation, and implementation synchronized and updated automatically.

# async-spring-boot

Simple demo using async support for REST controllers.

These approachs have been used:

- DeferredResult
- Callable
- WebAsyncTask

In order to get up and running just type mvn:spring-boot:run from your command line, this endpoints should be available for testing:

http://localhost:8080/deferred-approach
http://localhost:8080/callable-approach
http://localhost:8080/web-async-approach

Anyone of them works in the same way.

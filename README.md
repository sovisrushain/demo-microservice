# Microservice Demo Project

The sole purpose of this project is to demonstrate the configuration of several technologies as outlined below. The microservices project comprises three services. Service one communicates with both service two and three, both of which return integers. Subsequently, service one determines the largest integer from the outputs of these two services and exposes it through an API. This encapsulates the high-level overview of the project.

## Tech Stack
- Java 17 ✅
- Spring Boot 3 ✅
- Feign Client ✅
- Consul ✅
- Resilience4j ✅
- Zipkin ❌ 


## Getting start
- Clone the project
- checkout to a new branch
- Spin up both Consul & Zipkin services using docker (docker compose up -d)
- Spin up three services (Spring boot apps)
- fire a postman request
  http://localhost:8081/one
- Contribute 🤞

## Deal with Consul


**consul docker image:** 

`docker pull hashicorp/consul`

**consul ui:**

http://localhost:8500/ui/dc1/services


## Deal with Zipkin

**zipkin docker image:**

`docker pull openzipkin/zipkin`

**zipkin ui**

http://localhost:9411/zipkin/



## Why?

1. Feign Client

Feign is a declarative web service client developed by Netflix as part of the Spring Cloud ecosystem. It's commonly used in Spring Boot microservices for simplifying the process of making HTTP requests to other microservices or external APIs.

Feign allows you to define API interfaces using annotations, which makes the code more readable and self-explanatory. This declarative approach abstracts away the complexity of manually constructing HTTP requests and handling responses.

Feign reduces boilerplate code significantly. You define the API interface with annotations like @FeignClient, @RequestMapping, and others. Feign generates the necessary HTTP client code at runtime based on these annotations.

Feign can work in conjunction with service discovery tools like Netflix Eureka or other load balancing mechanisms. This allows it to automatically distribute requests across instances of the same service, enhancing reliability and fault tolerance.


2. Consul

Consul is a tool developed by HashiCorp that provides service discovery, health checking, key-value storage, and distributed configuration capabilities.

In a microservices environment, services need to find and communicate with each other. Consul offers a service discovery mechanism that allows services to register themselves and discover other services without hardcoding their locations. This dynamic discovery simplifies the process of locating and connecting to services as they come and go.

Consul can integrate with load balancers and help distribute incoming requests across instances of the same service. This leads to better utilization of resources and improved fault tolerance.

Consul enables services to regularly report their health status. This helps identify unhealthy or unavailable services, allowing the system to react and make decisions based on the health status of services. Spring Boot applications can easily integrate with Consul's health checking capabilities to provide accurate health information.

Consul provides a key-value store that can be used to store configuration data. Spring Boot applications can use Consul as a centralized configuration source, allowing you to update configurations dynamically without redeploying the applications.

Consul helps decouple services from each other by abstracting the location and health of services. This makes it possible to scale, update, or replace services without disrupting the overall system.

3. Resilience4

Resilience4j is a lightweight and flexible library for implementing resiliency patterns in Java applications, including those built with Spring Boot. It provides tools for dealing with common issues in distributed systems, such as failures, latency, and fault tolerance.

Resilience4j includes a robust implementation of the circuit breaker pattern. A circuit breaker helps prevent cascading failures by temporarily stopping requests to a failing service and allowing it to recover. This pattern enhances the stability and availability of microservices.

Resilience4j offers configurable retry mechanisms that automatically retry failed operations with customizable policies. This can be especially useful when dealing with transient failures, where a retry might succeed due to temporary issues.

When a service is unavailable or fails, Resilience4j allows you to define fallback strategies, providing a default response or alternative behavior. This ensures that even in the presence of failures, some level of service can still be provided.

4. Zipkin


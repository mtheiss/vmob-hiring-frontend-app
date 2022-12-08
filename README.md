# Valtech Mobility Frontend Application

This application simulates a frontend application.

It is based on Spring Boot 3.

The application exposes a REST service on default port 8080, which returns simple facts.
- [http://localhost:8082/](http://localhost:8082/)

For Kubernetes the application exposes a ready and a liveness probe on a management port.
- [http://localhost:8083/actuator/health/readiness](http://localhost:8081/actuator/health/readiness)
- [http://localhost:8083/actuator/health/liveness](http://localhost:8081/actuator/health/liveness)

The frontend calls the backend system. The base url can be controlled with the environment variable
`VMOB_HIRING_FRONTEND_BACKEND_URL`. It defaults to `http://localhost:8080/`.

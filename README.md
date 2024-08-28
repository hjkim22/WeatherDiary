#  ☁️️ WeatherDiary - 날씨 일기 프로젝트

> OpenWeatherMap API를 이용하여 날씨 데이터를 가져오고 사용자가 일기를 작성하고 관리할 수 있는 프로젝트

## 🛠️ Tech Stack

- **Java**: `17`
- **Spring Boot**: `3.3.2`
- **Gradle**: `8.8`
- **Spring Data JPA**: `3.3.3`
- **MySQL**: `8.3.0`
- **JSON Simple**: `1.1.1`
- **SpringDoc OpenAPI**: `2.0.2`
- **Library**: `Lombok`, `spring-web`, `swagger`, `logback`

> **Note:** 현재 Spring Boot 버전과 Springfox 라이브러리가 호환되지 않아서, SpringDoc OpenAPI Starter WebMVC UI 라이브러리 사용

## ⛓️ 프로젝트 기능

- **매일 새벽 01시에 OpenWeatherMap API에서 날씨 데이터를 받아와 DB에 저장**  
  매일 정해진 시간에 날씨 데이터를 자동으로 업데이트하여 최신 정보를 유지


- **일기 생성**  
  사용자가 새로운 일기를 작성하여 저장


- **일기 조회**  
  특정 날짜의 일기를 조회


- **일기 기간별 조회**  
  사용자가 지정한 기간(예: 2024-01-01 ~ 2025-01-01) 동안의 모든 일기 조회


- **일기 수정**  
  기존의 일기를 수정하여 업데이트


- **일기 삭제**  
  불필요한 일기를 삭제

## 📜 API Documentation

- **Swagger UI**를 통해 API 문서를 확인
  - [Swagger UI](http://localhost:8080/swagger-ui/index.html)
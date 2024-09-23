# **Monitor de Temperatura**

## **Descrição do Projeto**

O Monitor de Temperatura é uma aplicação Spring Boot que permite salvar localidades e monitorar periodicamente as condições meteorológicas dessas localidades. A aplicação consome a API do OpenWeatherMap para obter dados atualizados, armazena as informações em um banco de dados e atualiza automaticamente as informações em intervalos definidos. A documentação da API é disponibilizada através do Swagger (OpenAPI).

## **Tecnologias Utilizadas**

<p align="left">
  <a href="https://www.oracle.com/java/" target="_blank">
    <img src="https://img.shields.io/badge/Java-007396?logo=java&logoColor=white" alt="Java"/>
  </a>
  <a href="https://spring.io/projects/spring-boot" target="_blank">
    <img src="https://img.shields.io/badge/Spring%20Boot-brightgreen?logo=springboot&logoColor=white" alt="Spring Boot"/>
  </a>
  <a href="https://spring.io/projects/spring-data-jpa" target="_blank">
    <img src="https://img.shields.io/badge/Spring%20Data%20JPA-brightgreen?logo=spring&logoColor=white" alt="Spring Data JPA"/>
  </a>
  <a href="https://spring.io/projects/spring-framework" target="_blank">
    <img src="https://img.shields.io/badge/Spring%20Web-brightgreen?logo=spring&logoColor=white" alt="Spring Web"/>
  </a>
  <a href="https://spring.io/projects/spring-cloud-openfeign" target="_blank">
    <img src="https://img.shields.io/badge/Spring%20Cloud%20OpenFeign-brightgreen?logo=spring&logoColor=white" alt="Spring Cloud OpenFeign"/>
  </a>
  <a href="https://spring.io/guides/gs/scheduling-tasks/" target="_blank">
    <img src="https://img.shields.io/badge/Spring%20Scheduling-brightgreen?logo=spring&logoColor=white" alt="Spring Scheduling"/>
  </a>
  <a href="https://swagger.io/" target="_blank">
    <img src="https://img.shields.io/badge/Swagger-OpenAPI-brightgreen?logo=swagger&logoColor=white" alt="Swagger OpenAPI"/>
  </a>
  <a href="https://www.h2database.com/" target="_blank">
    <img src="https://img.shields.io/badge/H2%20Database-blue" alt="H2 Database"/>
  </a>
  <a href="https://projectlombok.org/" target="_blank">
    <img src="https://img.shields.io/badge/Lombok-red" alt="Lombok"/>
  </a>
  <a href="https://openweathermap.org/api" target="_blank">
    <img src="https://img.shields.io/badge/OpenWeatherMap%20API-orange" alt="OpenWeatherMap API"/>
  </a>
</p>

## **Pré-requisitos**

- **JDK 17** ou superior
- **Maven 3.6** ou superior
- **Chave de API** do OpenWeatherMap (obtenha em [OpenWeatherMap API Key](https://home.openweathermap.org/api_keys))

## **Configuração Inicial**

1. **Clonar o Repositório**

   ```bash
   git clone https://github.com/seu-usuario/monitor-de-temperatura.git
   cd monitor-de-temperatura


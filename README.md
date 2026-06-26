# Banco de Sangue — Backend

API REST em Spring Boot para processamento de dados de candidatos a doadores de sangue.

## Tecnologias

- Java 21
- Spring Boot 4.1.0
- Spring Security
- Spring Data JPA + Hibernate
- Flyway (migrations)
- MySQL
- MapStruct
- Lombok
- Springdoc OpenAPI (Swagger)

## Pré-requisitos

- Java 21+
- Maven 3.9+
- Docker e Docker Compose

## Rodando localmente

### 1. Suba o banco de dados

```bash
docker compose up -d
```

### 2. Configure as variáveis de ambiente

Defina as variáveis no sistema ou crie um arquivo `.env`:

```
BD=bancodesangue
DB_USERNAME=bdsangue
PWD=sua_senha
```

### 3. Inicie a aplicação

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## Documentação da API

Com a aplicação rodando, acesse o Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

## Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/api/carga` | Importa candidatos via arquivo JSON |
| GET | `/api/relatorios/candidatos-por-estado` | Quantidade de candidatos por estado |
| GET | `/api/relatorios/imc-por-faixa-etaria` | IMC médio por faixa etária |
| GET | `/api/relatorios/obesos-por-sexo` | Percentual de obesos por sexo |
| GET | `/api/relatorios/media-idade-por-tipo-sanguineo` | Média de idade por tipo sanguíneo |
| GET | `/api/relatorios/doadores-por-receptor` | Doadores elegíveis por tipo receptor |

## Subindo com Docker Compose completo

Para subir backend + frontend + banco juntos, utilize o `docker-compose.yml` na raiz do projeto (veja o README raiz).

## Migrations

As migrations Flyway ficam em `src/main/resources/db/migration/`:

- `V1__create_candidatos.sql` — tabela de candidatos
- `V2__create_compatibilidade_sanguinea.sql` — tabela de compatibilidade sanguínea com dados

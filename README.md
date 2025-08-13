# Projeto Java Web - Gerenciamento de Carros

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![MIT License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

## Descrição

Este projeto é um sistema web desenvolvido em **Java** com **Spring Boot** para gerenciamento de carros. Ele oferece funcionalidades completas de **CRUD** (Criar, Ler, Atualizar e Excluir) de carros, além de autenticação e controle de acesso para diferentes perfis de usuário.

O projeto inclui:
- Cadastro, edição, exclusão e listagem de carros.
- Interface web com validações de campos e mensagens de erro.
- Controle de acesso baseado em perfis (admin e usuário).
- Segurança com **Spring Security**.
- Testes de unidade e integração.
- Banco de dados **MySQL** para persistência.

## Funcionalidades

- **Carros**
  - Cadastrar novos carros
  - Listar todos os carros
  - Editar carros existentes
  - Excluir carros
- **Segurança**
  - Login com autenticação
  - Controle de acesso baseado em papéis
  - Página de acesso negado
- **Interface**
  - Navegação entre páginas com cabeçalho e rodapé reutilizáveis
  - Validação de formulários e exibição de mensagens de erro
- **Testes**
  - Testes unitários da camada web
  - Testes de integração com banco H2 (para testes)

## Configuração do Banco de Dados

Antes de rodar o projeto, é necessário criar o banco de dados **MySQL** e configurar o arquivo `application.properties`:

1. Crie o banco de dados no MySQL:
```sql
CREATE DATABASE carros;
```
2. Configure o arquivo  `src/main/resources/application.properties` com suas credenciais:
```properties
spring.application.name=carros
spring.datasource.url=jdbc:mysql://localhost:3306/carros?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
# spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
>⚠️ Ajuste `username` e `password` conforme seu usuário do MySQL.

## Como Rodar

1. Clone o repositório:
```bash
git clone https://github.com/natsalete/Projeto-em-Java-Web-Carros.git
```
2. Abra o projeto na sua IDE favorita (IntelliJ, Eclipse, VS Code).
3. Certifique-se de que o MySQL está rodando e o banco `carros` existe.
4. Execute a aplicação:
```bash
mvn spring-boot:run
```
ou, se estiver usando Gradle:
```bash
./gradlew bootRun
```
5. Acesse a aplicação em:
```bash
http://localhost:8080
```

## Estrutura do Projeto
- **model:**  Classes de entidades (Usuario, Carro)
- **repository:** Interfaces para persistência
- **service:** Lógica de negócio.
- **controller:** Endpoints e controle das páginas web.
- **security:** Configuração de segurança e roles.
- **tests:** Testes unitários e de integração.

## Licença
Este projeto está licenciado sob os termos da **Licença MIT**.  
Você pode utilizar, modificar e distribuir este código livremente, desde que mantenha os créditos originais.  
📄 [Clique aqui para ler a Licença MIT](https://opensource.org/licenses/MIT)  

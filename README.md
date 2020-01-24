# Biblioteca ágil

Gerado com [Spring Initializr](https://start.spring.io/).

## Como executar?
- Windows
  ```./mvnw.cmd spring-boot:run```
- Unix
  ```./mvnw.cmd spring-boot:run```
- Acessar http://localhost:8080/

## Fron-end

Este projeto possui um front-end embutido, porém os arquivos relacionados com o front-end estão minificados. Você pode acessar a versão de desenvolvimento em [desafio-agil-frontend](https://github.com/EdsonLuiz/desafio-agil-frontend)

## Endpoints
| Request            | Método | Auth | Desc                                         |
|--------------------|--------|------|----------------------------------------------|
| /usuarios          | POST   | Não  | Criar novo usuário                           |
| /login             | POST   | Não  | Efetua login e retorna token                 |
| /livros            | GET    | Não  | Retorna lista de livros                      |
| /livros            | POST   | Não  | Adiciona novo livro                          |
| /livros/disponivel | GET    | Não  | Lista todos os livros disponíveis            |
| /emprestimos       | GET    | Sim  | Lista todos os emprestimos do usuário logado |
| /emprestimos       | POST   | Sim  | Efetua um emprestimo                         |
| /emprestimos/id    | PUT    | SIm  | Termina um emprestimo                        |

## Banco de dados
Para este projeto foi utilizado o h2 database que pode ser acessado em:   
```
http://localhost:8080/h2-console/
JDBC URL: jdbc:h2:mem:testdb
User name: root
Password: biblioteca
```


## Decisões

1. Por que usar Spring?  
    Para acelerar o processo de desenvolvimento abstraindo configurações e consultas ao banco de dados.
    
2. Por que REST?  
    Para permitir que eu utilizasse alternativas mais modernas para o front-end além de thymeleaf e JSP, além do desacoplamento de back-end e front-end.

3. Por que autenticação com JWT?  
    Por ser um padrão em aplicações REST.

4. Por que Angular e não React ou Vue?  
    Simplesmente pela quantidade de bibliotecas que eu teria que adicionar ao projeto. Com Angular foram três e com React/Vue seriam pelo menos cinco. Menos bibliotecas representam menos atualizações de segurança no futuro.


## Dificuldades
Sem dúvida a maior dificuldade foi implementar a autenticação com JWT, mesmo não adicionando autorização por roles foi a parte que mais me tomou tempo. Para conseguir implementar tive que ler muitos artigos e pelo menos três tutorias, desatualizados e que não seguiam o [OAuth 2.0 Migration Guide](https://github.com/spring-projects/spring-security/wiki/OAuth-2.0-Migration-Guide), para criar algo que funcionasse. 

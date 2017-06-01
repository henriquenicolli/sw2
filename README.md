# Software para controle de estoque

## Recomendações

### Configure o banco de dados (postgres)
- Crie uma database com o nome de "sw2"
- Abra o arquivo "persistence.xml" (localizado em src/main/resources) 
  e **se necessário altere o usuario, senha e porta.**


Exemplo de configuração __(src/main/resources/persistence.xml)__
```
<property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:<PORTA>/sw2"/>
<property name="javax.persistence.jdbc.user" value="<USUARIO>"/>
<property name="javax.persistence.jdbc.password" value="<SENHA>"/>
```
**Evite de enviar essa alteração para o repositório.**

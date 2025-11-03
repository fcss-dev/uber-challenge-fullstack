# Email service - backend

[link do desafio](https://github.com/uber-archive/coding-challenge-tools/blob/master/coding_challenge.md)

## Como instalar e configurar
```bash
    # Clonar o repositório
    git clone https://github.com/fcss-dev/uber-challenge-fullstack.git
    cd uber-challenge-fullstack
```
```bash
    # Configurações AWS SES
    aws.accessKeyId=// sua chave de acesso
    aws.secretKey=// sua chave secreta
    aws.region=// região do serviço
```
```java
    // Configurar o remetente de e-mail
    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("remetentetest@gmail.com") // remetente autorizado no AWS SES
                .withDestination(new Destination().withToAddresses(to)) 
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );
        try {
            this.amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException e) {
            throw new EmailServiceException("Falha ao enviar e-mail", e);
        }
    }

```

```bash
    # Build e execução
    mvn clean install
    mvn spring-boot:run
```


```bash
    # Testar a aplicação
    http://localhost:8080/api/email
    # Requisição POST:
        {
            "to":"teste123@gmail.com",
            "subject":"test", 
            "body":"hello world, test"
        }
    # Resposta:
        200 ok
        ou
        500 Internal Server Error
```
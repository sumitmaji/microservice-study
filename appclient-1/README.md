# H2 Database details
1. Enable h2 console
```yaml
spring:
  jpa:
    show-sql: true
  h2:
    console:
      enabled: true
```

2. H2 Database url
```html
http://localhost:8080/h2-console
```

3. H2 Database url
```text
jdbc:h2:mem:testdb
```

4. No password required to connect.
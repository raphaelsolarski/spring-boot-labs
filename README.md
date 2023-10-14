# chapter_6
## Konfiguracja w Spring Boot

W Spring Boot konfiguracja aplikacji jest kluczowym elementem, umożliwiającym dostosowywanie zachowania aplikacji bez konieczności zmiany jej kodu. Poniżej znajdziesz szczegółowe omówienie elementów konfiguracji.

Pliki `application.yaml`/`application.properties`

Spring Boot obsługuje dwa główne formaty plików konfiguracyjnych: `.properties` i `.yaml`.

`application.properties`
Format bazujący na parze klucz-wartość.

Przykład:
```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
```

`application.yaml`
Format bazujący na YAML, bardziej przejrzysty dla złożonych konfiguracji.

Przykład:
```properties
server:
port: 8080
spring:
datasource:
url: jdbc:mysql://localhost:3306/mydb
```
Pliki te są automatycznie wczytywane przez Spring Boot podczas startu aplikacji.

`Profile`

Profile w Spring Boot umożliwiają definiowanie różnych konfiguracji dla różnych środowisk (np. deweloperskie, produkcyjne).

Możesz aktywować profile za pomocą parametru spring.profiles.active.
Przykład:
```properties
-Dspring.profiles.active=dev,hsqldb
```
Można też tworzyć dedykowane pliki konfiguracyjne dla poszczególnych profili, np. application-dev.properties.

`Konfiguracja przez parametry uruchomienia`

Parametry przekazane podczas uruchamiania aplikacji mogą nadpisać wartości z plików konfiguracyjnych.

Przykład:
```properties
java -jar myapp.jar --server.port=8090
```

`@Value`

Adnotacja @Value pozwala wstrzyknąć wartości z plików konfiguracyjnych bezpośrednio do pól w komponentach Springa.
Przykład:
```properties
@Value("${server.port}")
private int port;
```

Przykład:
```properties
java -jar myapp.jar --server.port=8090
```

`@ConfigurationProperties`

Jest to bardziej zaawansowana alternatywa dla @Value. Umożliwia grupowanie wielu właściwości konfiguracyjnych w jednym obiekcie Java i wymaga dodatkowej zależności spring-boot-configuration-processor.

Przykład klasy z właściwościami:
```properties
@Component
@ConfigurationProperties(prefix = "server")
public class ServerProperties {
private int port;
// getters and setters
}
```
# Podsumowanie
Spring Boot oferuje elastyczne narzędzia do konfiguracji aplikacji, które umożliwiają łatwe dostosowywanie jej do różnych środowisk i wymagań. Warto z nich korzystać, aby tworzyć aplikacje bardziej elastyczne i łatwiejsze w utrzymaniu.

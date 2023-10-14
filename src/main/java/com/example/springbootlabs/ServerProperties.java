package com.example.springbootlabs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * `@Value`
 * <p>
 * - Adnotacja `@Value` pozwala wstrzyknąć wartości z plików konfiguracyjnych bezpośrednio do pól w komponentach Springa.
 * <p>
 * Przykład:
 * @Value("${server.port}") private int port;
 * <p>
 * <p>
 * `@ConfigurationProperties`
 * <p>
 * - Jest to bardziej zaawansowana alternatywa dla `@Value`. Umożliwia grupowanie wielu właściwości konfiguracyjnych w jednym obiekcie Java.
 * <p>
 * - Wymaga dodatkowej zależności `spring-boot-configuration-processor`.
 * <p>
 * Przykład klasy z właściwościami:
 */
@Component
@ConfigurationProperties(prefix = "server")
public class ServerProperties {
    private int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

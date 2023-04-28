package org.acme;

import java.time.Duration;
import java.util.Optional;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;
import io.smallrye.config.WithParentName;

@StaticInitSafe
@ConfigMapping(prefix = "my")
public interface MyConfig {

    @WithParentName
    Optional<Property> property();

    interface Property {

        @WithName("jwt.refresh-interval")
        Duration jwtRefreshInterval();

        @WithName("jwt.refresh-window.expiry")
        Duration jwtRefreshWindowExpiry();

        @WithName("rest.url")
        String apiUrl();

        @WithName("rest.max-retries")
        Integer maxRetries();

        @WithName("rest.retry-delay")
        Integer retryDelay();

        @WithName("rest.connect-timeout")
        Integer connectTimeout();

        @WithName("rest.read-timeout")
        Integer readTimeout();

        @WithName("rest.connection-ttl")
        Integer connectionTTL();

        @WithName("rest.connection-pool-size")
        Integer connectionPoolSize();
    }

}

package com.zucchetti.blogz.api.gateway.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
@ApplicationScoped
public class SampleReadinessHealthCheck implements HealthCheck {

	@Override
	public HealthCheckResponse call() {
		return HealthCheckResponse
				.named("blogz-api-gateway readiness:")
				.withData("boolean", true)
				.withData("long:", 100)
				.withData("string:", "value")
				.up()
				.build();
	}

}

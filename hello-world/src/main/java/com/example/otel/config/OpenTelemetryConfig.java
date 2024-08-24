package com.example.otel.config;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.exporter.otlp.logs.OtlpGrpcLogRecordExporter;
import io.opentelemetry.instrumentation.logback.appender.v1_0.OpenTelemetryAppender;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.semconv.ResourceAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenTelemetryConfig
{
    @Bean
    SdkLoggerProvider sdkLoggerProvider() {
        return SdkLoggerProvider.builder()
                .setResource(
                        Resource.getDefault().toBuilder()
                                .put(ResourceAttributes.SERVICE_NAME, "hello-world")
                                .build())
                .addLogRecordProcessor(
                        BatchLogRecordProcessor.builder(
                                        OtlpGrpcLogRecordExporter.builder()
                                                .setEndpoint("http://localhost:4317")
                                                .build())
                                .build())
                .build();
    }

    @Bean
    OpenTelemetry openTelemetry(SdkLoggerProvider sdkLoggerProvider,
                                SdkTracerProvider sdkTracerProvider,
                                ContextPropagators contextPropagators) {
        OpenTelemetrySdk sdk =
                OpenTelemetrySdk.builder()
                        .setLoggerProvider(
                                sdkLoggerProvider)
                        .setTracerProvider(sdkTracerProvider)
                        .setPropagators(contextPropagators)
                        .build();
        OpenTelemetryAppender.install(sdk);
        return sdk;
    }
}

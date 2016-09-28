package de.stekoe.amcharts.examples.jersey.config;

import de.stekoe.amcharts.AmRadarChart;
import de.stekoe.amcharts.examples.jersey.rest.RestResource;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyInitialization extends ResourceConfig {
    public JerseyInitialization(){
        this.register(RestResource.class);
        this.register(JerseyObjectMapperProvider.class);
    }
}
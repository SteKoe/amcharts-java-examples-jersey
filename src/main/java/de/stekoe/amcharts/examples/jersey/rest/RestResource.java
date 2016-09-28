package de.stekoe.amcharts.examples.jersey.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.stekoe.amcharts.AmChart;
import de.stekoe.amcharts.AmGraph;
import de.stekoe.amcharts.AmSerialChart;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Path("/")
@Component
public class RestResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AmChart message() {
        List<Object> dataProvider = new ArrayList<>();
        dataProvider.add(new CountryVisits().setCountry("USA").setVisits(4252));
        dataProvider.add(new CountryVisits().setCountry("China").setVisits(1882));
        dataProvider.add(new CountryVisits().setCountry("Japan").setVisits(1809));
        dataProvider.add(new CountryVisits().setCountry("Germany").setVisits(1322));

        AmSerialChart chart = new AmSerialChart();
        chart.setType("serial");
        chart.setCategoryField("country");
        chart.setDataProvider(dataProvider);


        List<AmGraph> graphs = new ArrayList<>();
        graphs.add(new AmGraph().setValueField("visits").setType("column"));

        chart.setGridAboveGraphs(true);
        chart.setStartDuration(1);
        chart.setGraphs(graphs);
        chart.setCategoryField("choice");
        return chart;
    }

    class CountryVisits {
        private String country;
        private int visits;

        public String getCountry() {
            return country;
        }

        public CountryVisits setCountry(String country) {
            this.country = country;
            return this;
        }

        public int getVisits() {
            return visits;
        }

        public CountryVisits setVisits(int visits) {
            this.visits = visits;
            return this;
        }
    }
}

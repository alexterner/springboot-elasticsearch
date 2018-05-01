package com.mycompany.springboot.elasticsearch.springbootelasticsearch.configuration;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.mycompany.springboot.elasticsearch.springbootelasticsearch")
public class ElasticSearchConfiguration {

    @Value("elasticsearch.host")
    private String elasticSearchHost;

    @Value("elasticsearch.port")
    private String elasticSearchPort;

    @Value("elasticsearch.clustername")
    private String elasticSearchClusterName;


    @Bean
    public Client client() throws Exception {

        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", elasticSearchClusterName)
                .build();

        return TransportClient.builder()
                .settings(settings)
                .build()
                .addTransportAddress(
                        new InetSocketTransportAddress(InetAddress.getByName(elasticSearchHost), Integer.valueOf( elasticSearchPort ))
                );
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate( client() );
    }
}

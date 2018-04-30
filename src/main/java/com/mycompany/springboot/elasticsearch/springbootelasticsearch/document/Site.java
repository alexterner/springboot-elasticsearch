package com.mycompany.springboot.elasticsearch.springbootelasticsearch.document;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "active_site", type = "site")
public class Site {

    @Id
    private String id;
    private String name;
    private boolean isActive;



}

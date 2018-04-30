package com.mycompany.springboot.elasticsearch.springbootelasticsearch.service;

import com.mycompany.springboot.elasticsearch.springbootelasticsearch.document.Site;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface SiteService {

    Site save(Site site);

    void delete(Site site);

    Site findOne(String id);

    Iterable<Site> findAll();

    Page<Site> findByName(String name, PageRequest pageRequest);

    List<Site> findByIsActive(boolean isActive);

}

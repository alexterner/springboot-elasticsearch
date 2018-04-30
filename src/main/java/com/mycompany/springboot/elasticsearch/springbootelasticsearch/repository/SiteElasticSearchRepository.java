package com.mycompany.springboot.elasticsearch.springbootelasticsearch.repository;

import com.mycompany.springboot.elasticsearch.springbootelasticsearch.document.Site;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SiteElasticSearchRepository extends ElasticsearchRepository<Site, String> {

    Page<Site> findByName(String name, Pageable pageable);

    List<Site> findByIsActive(boolean isActive);

}

package com.mycompany.springboot.elasticsearch.springbootelasticsearch.service;

import com.mycompany.springboot.elasticsearch.springbootelasticsearch.document.Site;
import com.mycompany.springboot.elasticsearch.springbootelasticsearch.repository.SiteElasticSearchRepository;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteElasticSearchRepository siteElasticSearchRepository;

    @Override
    public Site save(Site site) {
        return siteElasticSearchRepository.save( site );
    }

    @Override
    public void delete(Site site) {
        siteElasticSearchRepository.delete( site );
    }

    @Override
    public Site findOne(String id) {
        return siteElasticSearchRepository.findOne( id );
    }

    @Override
    public Iterable<Site> findAll() {
        return siteElasticSearchRepository.findAll();
    }

    @Override
    public Page<Site> findByName(String name, PageRequest pageRequest) {
        return siteElasticSearchRepository.findByName(name, pageRequest);
    }

    @Override
    public List<Site> findByIsActive(boolean isActive) {
        return siteElasticSearchRepository.findByIsActive( isActive );
    }
}

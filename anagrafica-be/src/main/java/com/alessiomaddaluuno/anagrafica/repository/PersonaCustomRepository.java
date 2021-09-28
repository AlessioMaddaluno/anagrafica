package com.alessiomaddaluuno.anagrafica.repository;

import com.alessiomaddaluuno.anagrafica.dto.SearchPersonaDTO;
import com.alessiomaddaluuno.anagrafica.model.Persona;
import com.alessiomaddaluuno.anagrafica.resource.PersonaResource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Page<PersonaResource> search(SearchPersonaDTO dto){

        // Oggetto che gestisce la paginazione
        Pageable pageable = PageRequest.of(dto.getPage(),dto.getPageSize());

        // Le criteria query si creano attraverso un builder in quanto
        // sono oggetti piuttosto complessi. L'utilizzo del pattern builder
        // ne facilità la creazione
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // Creo una Criteria query a partire dalla classe su cui deve essere mappato
        // il risultato finale
        CriteriaQuery<Persona> criteriaQuery = criteriaBuilder.createQuery(Persona.class);

        // Identifico la root della query, ovvero la tabella "principale"
        Root<Persona> root = criteriaQuery.from(Persona.class);

        // Imposto i predicati della query nonché le where condition e le eventuali join
        Predicate[] predicates = this.createPredicate(criteriaBuilder,root,dto);

        // Imposto il sort
        List<Order> orders = this.createSort(criteriaBuilder,root,dto.getSortBy(),dto.getSortDirection());

        // Imposto i predicati e il sort
        CriteriaQuery<Persona> criteriaQuery_select = criteriaQuery.select(
                criteriaBuilder.construct(
                        Persona.class,
                        root.get("id"),root.get("nome"),root.get("cognome"),root.get("eta"),root.get("citta"))
        ).where(predicates).orderBy(orders);

        // Creo una typed query a pratire dalla blueprint definita dalla criteria query
        TypedQuery<Persona> typedQuery = entityManager.createQuery(criteriaQuery_select);

        // Imposto l'offset dei record (il numero della pagina) e il numero di elementi massimi che voglio (il pageSize)
        typedQuery.setFirstResult((int)pageable.getOffset());
        typedQuery.setMaxResults(pageable.getPageSize());

        // Fetcho i risultati
        List<Persona> result = typedQuery.getResultList();

        List<PersonaResource> resources = new ArrayList<>();
        for( Persona p : result){
            resources.add(this.assembler(p));
        }

        //Inserisco quello che ho ottenuto all'interno di un oggetto page
        Page<PersonaResource> page = new PageImpl<>(resources, pageable, resources.size());

        return page;

    }

    private Predicate[] createPredicate(CriteriaBuilder criteriaBuilder,Root<Persona> root,SearchPersonaDTO filter){

        List<Predicate> predicates = new ArrayList<>();

        if(StringUtils.isNotBlank(filter.getNome())){
            Predicate predicate_like = criteriaBuilder.like(root.get("nome"),filter.getNome());
            predicates.add(predicate_like);
        }

        if(StringUtils.isNotBlank(filter.getCognome())){
            Predicate predicate_like = criteriaBuilder.like(root.get("cognome"),filter.getCognome());
            predicates.add(predicate_like);
        }

        if(StringUtils.isNotBlank(filter.getCitta())){
            Predicate predicate_like = criteriaBuilder.like(root.get("citta"),filter.getCitta());
            predicates.add(predicate_like);
        }


        if(filter.getEtaMin() != null){
            Predicate predicate_min = criteriaBuilder.greaterThanOrEqualTo(root.get("eta"),filter.getEtaMin());
            predicates.add(predicate_min);
        }

        if(filter.getEtaMax() != null){
            Predicate predicate_max = criteriaBuilder.lessThanOrEqualTo(root.get("eta"),filter.getEtaMax());
            predicates.add(predicate_max);
        }

        Predicate[] predArray = new Predicate[predicates.size()];
        predicates.toArray(predArray);
        return predArray;
    }

    private List<Order> createSort(CriteriaBuilder criteriaBuilder, Root<Persona> root,String sortProperty, String sortDirection){

        List<Order> orders = new ArrayList<>();

        if(sortDirection.equals("ASC")){
            orders.add(criteriaBuilder.asc(root.get(sortProperty)));
        }
        else {
            orders.add(criteriaBuilder.desc(root.get(sortProperty)));
        }

        return orders;
    }

    // model -> resource
    private PersonaResource assembler(Persona model){
        return PersonaResource.builder()
                .id(model.getId())
                .nome(model.getNome())
                .cognome(model.getCognome())
                .eta(model.getEta())
                .citta(model.getCitta())
                .build();
    }

}

package it.alessiomaddaluno.anagrafica.repository;


import it.alessiomaddaluno.anagrafica.dto.SearchPersonaDTO;
import it.alessiomaddaluno.anagrafica.model.Persona;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import it.alessiomaddaluno.anagrafica.resource.PersonaResource;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonaCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Page<PersonaResource> search(SearchPersonaDTO filters){

        Pageable pageable = PageRequest.of(filters.getPage(),filters.getPageSize());

        Query countQuery = this.applyCriteria(this.getCountQuery(),filters);
        long totalRows = (Long) countQuery.getSingleResult();

        Query selectQuery = this.applyCriteria(this.getSelectQuery(),filters);
        selectQuery.setFirstResult(filters.getPageSize()*filters.getPage());
        selectQuery.setMaxResults(filters.getPageSize());

        List<Persona> models = selectQuery.getResultList();

        List<PersonaResource> resources = new ArrayList<>();
        if(!models.isEmpty()){
            for(Persona model : models){
                resources.add(this.assembler(model));
            }
        }
        //Inserisco quello che ho ottenuto all'interno di un oggetto page
        Page<PersonaResource> page = new PageImpl<>(resources, pageable, totalRows);

        return page;
    }

    private Query applyCriteria(String baseQuery,SearchPersonaDTO filter){

        Map<String,Object> params = new HashMap<>();

        String query = baseQuery;
        String whereAnd = " WHERE ";

        // filtro nome
        if(StringUtils.isNotEmpty(filter.getNome())){
            params.put("nome",filter.getNome());
            query += whereAnd + "lower(p.nome) LIKE lower(concat('%',:nome,'%'))";
            whereAnd = " AND ";
        }

        // filtro cognome
        if(StringUtils.isNotEmpty(filter.getCognome())){
            params.put("cognome",filter.getCognome());
            query += whereAnd + "lower(p.cognome) LIKE lower(concat('%',:cognome,'%'))";
            whereAnd = " AND ";
        }

        // filtro citta
        if(StringUtils.isNotEmpty(filter.getCitta())){
            params.put("citta",filter.getCitta());
            query += whereAnd + "lower(p.citta) LIKE lower(concat('%',:citta,'%'))";
            whereAnd = " AND ";
        }

        // filtro data di nascita
        if(filter.getDataNascitaMin() != null && filter.getDataNascitaMax() != null){
            params.put("dataNascitaMin",filter.getDataNascitaMin());
            params.put("dataNascitaMax", filter.getDataNascitaMax());
            query += whereAnd + "p.dataNascita >= :dataNascitaMin AND p.dataNascita <= :dataNascitaMax";
            whereAnd = " AND ";
        }

        else {
            if (filter.getDataNascitaMax() != null){
                params.put("dataNascitaMax", filter.getDataNascitaMax());
                query += whereAnd + "p.dataNascita <= :dataNascitaMax ";
                whereAnd = " AND ";
            }
            if(filter.getDataNascitaMin() != null){
                params.put("dataNascitaMin",filter.getDataNascitaMin());
                query += whereAnd + "p.dataNascita >= :dataNascitaMin";
                whereAnd = " AND ";
            }
        }

        Query q = this.entityManager.createQuery(query);

        for (Map.Entry<String, Object> param : params.entrySet()) {
           q.setParameter(param.getKey(),param.getValue());
        }

        return q;
    }

    private String getSelectQuery(){
        return "SELECT p FROM PERSONA p";
    }

    private String getCountQuery(){
        return "SELECT COUNT(p) FROM PERSONA p";
    }

    // it.alessiomaddaluno.anagrafica.model -> it.alessiomaddaluno.anagrafica.resource
    private PersonaResource assembler(Persona model){
        PersonaResource resource = new PersonaResource();
        resource.setId(model.getId());
        resource.setNome(model.getNome());
        resource.setCognome(model.getCognome());
        resource.setDataNascita(model.getDataNascita());
        resource.setCitta(model.getCitta());
        return resource;
    }

}

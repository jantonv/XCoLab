package org.xcolab.service.contest.service.ontology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xcolab.model.tables.pojos.FocusAreaOntologyTerm;
import org.xcolab.model.tables.pojos.OntologyTerm;
import org.xcolab.service.contest.domain.focusarea.FocusAreaDao;
import org.xcolab.service.contest.domain.focusareaontologyterm.FocusAreaOntologyTermDao;
import org.xcolab.service.contest.domain.ontologyspace.OntologySpaceDao;
import org.xcolab.service.contest.domain.ontologyterm.OntologyTermDao;
import org.xcolab.service.contest.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OntologyService {

    private final OntologyTermDao ontologyTermDao;

    private final OntologySpaceDao ontologySpaceDao;

    private final FocusAreaDao focusAreaDao;

    private final FocusAreaOntologyTermDao focusAreaOntologyTermDao;

    @Autowired
    public OntologyService(OntologySpaceDao ontologySpaceDao, OntologyTermDao ontologyTermDao, FocusAreaDao focusAreaDao, FocusAreaOntologyTermDao focusAreaOntologyTermDao){

        this.ontologySpaceDao = ontologySpaceDao;
        this.ontologyTermDao = ontologyTermDao;
        this.focusAreaDao = focusAreaDao;
        this.focusAreaOntologyTermDao = focusAreaOntologyTermDao;
    }


    public List<Long> getFocusAreaOntologyTermIdsByFocusAreaAndSpaceId(Long focusAreaId, Long ontologySpaceId){
        long ontologyTermId = getOntologyTermIdByFocusAreaAndSpaceId(focusAreaId, ontologySpaceId);
        List<Long> focusAreasIdsByOntologyTermId = new ArrayList<>();
        for(FocusAreaOntologyTerm faot: focusAreaOntologyTermDao.findByGiven(null, ontologyTermId)){
            focusAreasIdsByOntologyTermId.add(faot.getFocusAreaId());
        }

        return focusAreasIdsByOntologyTermId;
    }

    private Long getOntologyTermIdByFocusAreaAndSpaceId(Long focusAreaId, Long ontologySpaceId){
        List<FocusAreaOntologyTerm> ontologyTermsForFocusArea = focusAreaOntologyTermDao.findByGiven(focusAreaId, null);
        for(FocusAreaOntologyTerm focusAreaOntologyTerm : ontologyTermsForFocusArea){
            long focusAreaOntologyTermOntologyTermId = focusAreaOntologyTerm.getOntologyTermId();
            try {
                OntologyTerm ontologyTerm = ontologyTermDao.get(focusAreaOntologyTermOntologyTermId);
                if (ontologyTerm.getOntologySpaceId() == ontologySpaceId) {
                    return ontologyTerm.getId_();
                }
            }catch (NotFoundException ignored){

            }
        }
        return null;
    }

}
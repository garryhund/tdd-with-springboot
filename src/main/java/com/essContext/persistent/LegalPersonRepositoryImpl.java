package com.essContext.persistent;

import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.repository.LegalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LegalPersonRepositoryImpl implements LegalPersonRepository{
    private List<LegalPerson> legalPersonList = new ArrayList<>();

    @Override
    public LegalPerson save(LegalPerson legalPerson) {
        legalPerson.setId(UUID.randomUUID().toString());
        legalPersonList.add(legalPerson);
        return legalPerson;
    }
}

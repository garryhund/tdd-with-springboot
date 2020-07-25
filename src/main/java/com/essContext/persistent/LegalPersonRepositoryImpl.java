package com.essContext.persistent;

import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.repository.LegalPersonRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class LegalPersonRepositoryImpl implements LegalPersonRepository{
    private Map<String, LegalPerson> map = new ConcurrentHashMap<String, LegalPerson>();

    @Override
    public String save(LegalPerson legalPerson) {
        legalPerson.setId(UUID.randomUUID().toString());
        if (map.containsKey(legalPerson.getCompanyCode())) {
            throw new RuntimeException("用户已注册");
        }
        map.put(legalPerson.getCompanyCode(), legalPerson);
        return legalPerson.getId();
    }
}

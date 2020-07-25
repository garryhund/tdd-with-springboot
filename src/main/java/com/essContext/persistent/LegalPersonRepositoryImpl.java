package com.essContext.persistent;

import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.repository.LegalPersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class LegalPersonRepositoryImpl implements LegalPersonRepository{
    private Map<String, LegalPerson> map = new ConcurrentHashMap<String, LegalPerson>();

    @Override
    public String save(LegalPerson legalPerson) {
        legalPerson.setId(UUID.randomUUID().toString());
        if (map.containsKey(legalPerson.getCompanyCode())) {
            log.error("用户[{}]已注册", legalPerson.getCompanyCode());
            throw new RuntimeException("用户已注册");
        }
        map.put(legalPerson.getCompanyCode(), legalPerson);
        return legalPerson.getId();
    }
}

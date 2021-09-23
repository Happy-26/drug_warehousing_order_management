package org.example.service;

import org.example.domain.Details;

import java.util.List;

public interface DetailsService {
    int addDetails(Details details);
    int modifyDetails(Details details);
    int deleteDetails(String warehousingId);
    List<Details> queryDetailsByHeaderId(String warehousingId);

}

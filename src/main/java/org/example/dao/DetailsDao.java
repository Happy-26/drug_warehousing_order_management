package org.example.dao;

import org.example.domain.Details;

import java.util.List;

public interface DetailsDao {
    boolean insertDetails(Details details);
    List<Details> queryDetailsByHeaderId (Long warehousingId);
    boolean updateDetails(Details details);
    boolean deleteDetails(Long warehousingId);
}

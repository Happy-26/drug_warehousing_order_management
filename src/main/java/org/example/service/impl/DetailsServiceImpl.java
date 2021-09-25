package org.example.service.impl;

import org.example.dao.DetailsDao;
import org.example.entity.Details;
import org.example.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsServiceImpl implements DetailsService {
    @Autowired
    DetailsDao detailsDao;

    @Override
    public int addDetails(Details details) {
        if (detailsDao.insertDetails(details))
            return 1;
        else
            return 0;
    }

    @Override
    public int modifyDetails(Details details) {
        if (detailsDao.updateDetails(details))
            return 1;
        else
            return 0;
    }

    @Override
    public int deleteDetails(String warehousingId) {
        if (detailsDao.deleteDetails(warehousingId))
            return 1;
        else
            return 0;
    }

    @Override
    public List<Details> queryDetailsByHeaderId(String warehousingId) {
        return (detailsDao.queryDetailsByHeaderId(warehousingId));

    }
}

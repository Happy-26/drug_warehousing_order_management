package org.example.service.impl;

import org.example.dao.HeaderDao;
import org.example.domain.Header;
import org.example.service.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeaderServiceImpl implements HeaderService {
    @Autowired
    HeaderDao headerDao;

    @Override
    public int addHeader(Header header) {
        if (headerDao.insertHeader(header))
            return 1;
        else
            return 0;
    }

    @Override
    public int modifyHeader(Header header) {
        if (headerDao.updateHeader(header))
            return 1;
        else
            return 0;
    }

    @Override
    public int deleteHeader(Long warehousingId) {
        if (headerDao.deleteHeader(warehousingId))
            return 1;
        else
            return 0;
    }

    @Override
    public Header queryHeaderById(Long warehousingId) {
        return headerDao.selectHeader(warehousingId);

    }

    @Override
    public List<Header> queryAllHeader() {
       return headerDao.selectAllHeader();
    }

}

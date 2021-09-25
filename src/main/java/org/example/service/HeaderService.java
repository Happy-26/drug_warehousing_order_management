package org.example.service;

import org.example.entity.Header;

import java.util.List;

public interface HeaderService {
    int addHeader(Header header);

    int modifyHeader(Header header);

    int deleteHeader(String warehousingId);

    Header queryHeaderById(String warehousingId);

    List<Header> queryAllHeader();


}

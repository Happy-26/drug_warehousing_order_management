package org.example.service;

import org.example.domain.Header;

import java.util.List;

public interface HeaderService {
    int addHeader(Header header);
    int modifyHeader(Header header);
    int deleteHeader(Long warehousingId);
    Header queryHeaderById(Long warehousingId);
    List<Header> queryAllHeader();


}

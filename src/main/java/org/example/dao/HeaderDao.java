package org.example.dao;


import org.example.domain.Header;

import java.util.List;

public interface HeaderDao {
    boolean insertHeader(Header header);
    boolean deleteHeader(Long warehousingId);
    boolean updateHeader(Header header);
    Header selectHeader(Long warehousingId);
    List<Header> selectAllHeader();
}

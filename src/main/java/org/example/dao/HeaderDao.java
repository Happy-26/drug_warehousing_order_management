package org.example.dao;


import org.example.entity.Header;

import java.util.List;

public interface HeaderDao {
    boolean insertHeader(Header header);

    boolean deleteHeader(String warehousingId);

    boolean updateHeader(Header header);

    Header selectHeader(String warehousingId);

    List<Header> selectAllHeader();
}

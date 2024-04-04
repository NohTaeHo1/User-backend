package com.von.user.common.query;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface QueryService<T> {
    List<T> findAll() throws SQLException;
    Optional<T> findById(Long id);
    String count();
    Optional<T> getOne(String id);
    Boolean existsById(Long id);

}

package com.von.user.common.service;

import com.von.user.common.component.PageRequestVo;

import java.util.List;
import java.util.Optional;

public interface QueryService<T> {
    List<T> findAll() ;
    Optional<T> findById(Long id);
    long count();
    boolean existsById(Long id);

}

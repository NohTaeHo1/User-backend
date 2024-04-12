package com.von.user.common.service;

import com.von.user.common.component.MessengerVo;

public interface CommandService<T> {
    MessengerVo save(T t);
    MessengerVo deleteById(Long id);
    MessengerVo modify(T t);


}

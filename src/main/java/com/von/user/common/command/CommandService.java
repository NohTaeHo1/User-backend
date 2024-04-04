package com.von.user.common.command;

public interface CommandService<T> {
    String save(T t);
    String delete(T t);
    String insertMany();
}

package br.com.uninassau.lazulli.repositorio;

import java.util.List;

public interface ICrud<T> {
    void create(T object);
    T read(int x);
    List<T> read();
    void update(int x, T object);
    void delete(int x);
}

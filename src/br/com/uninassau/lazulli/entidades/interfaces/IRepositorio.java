package br.com.uninassau.lazulli.entidades.interfaces;

import java.util.List;

public interface IRepositorio<T> {
    void create(T object);
    T read(int x);
    List<T> readList();
    void update(int x, T object);
    void delete(int x);
}

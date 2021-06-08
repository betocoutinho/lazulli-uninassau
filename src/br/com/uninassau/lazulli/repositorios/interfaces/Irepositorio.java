package br.com.uninassau.lazulli.repositorios.interfaces;

import java.util.List;

public interface Irepositorio<T> {
    void create(T object);
    T read(int x);
    List<T> readList();
    void update(int x, T object);
    void delete(int x);
}

package com.bilgeadam.rentacarmonolitik.utility;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ServiceManager<T,ID> implements IService<T,ID>{
    private final JpaRepository<T,ID> jpaRepository;

    public ServiceManager(JpaRepository<T, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public T save(T t) {
        return jpaRepository.save(t);
    }

    @Override
    public T update(T t) {
        return jpaRepository.save(t);
    }

    @Override
    public Optional<T> findById(ID id) {
        return findById(id);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }
}

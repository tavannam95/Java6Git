package edu.poly.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.entities.Product;

public interface ProductService {

	List<Product> findAll();

	<S extends Product> List<S> findAll(Example<S> example, Sort sort);

	<S extends Product> List<S> findAll(Example<S> example);

	Product getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Product> entities);

	Product getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	<S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Product entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	<S extends Product> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Product> entities);

	<S extends Product> long count(Example<S> example);

	void deleteInBatch(Iterable<Product> entities);

	<S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Product> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends Product> S saveAndFlush(S entity);

	void flush();

	<S extends Product> List<S> saveAll(Iterable<S> entities);

	Optional<Product> findById(Integer id);

	List<Product> findAllById(Iterable<Integer> ids);

	List<Product> findAll(Sort sort);

	Page<Product> findAll(Pageable pageable);

	<S extends Product> Optional<S> findOne(Example<S> example);

	<S extends Product> S save(S entity);

	List<Product> findByCategoryId(String cid);


}

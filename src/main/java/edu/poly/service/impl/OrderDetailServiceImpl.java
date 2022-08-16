package edu.poly.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import edu.poly.dao.OrderDetailDAO;
import edu.poly.entities.OrderDetail;
import edu.poly.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	OrderDetailDAO orderDetailDAO;

	@Override
	public <S extends OrderDetail> S save(S entity) {
		return orderDetailDAO.save(entity);
	}

	@Override
	public <S extends OrderDetail> Optional<S> findOne(Example<S> example) {
		return orderDetailDAO.findOne(example);
	}

	@Override
	public List<OrderDetail> findAll() {
		return orderDetailDAO.findAll();
	}

	@Override
	public Page<OrderDetail> findAll(Pageable pageable) {
		return orderDetailDAO.findAll(pageable);
	}

	@Override
	public List<OrderDetail> findAll(Sort sort) {
		return orderDetailDAO.findAll(sort);
	}

	@Override
	public List<OrderDetail> findAllById(Iterable<Integer> ids) {
		return orderDetailDAO.findAllById(ids);
	}

	@Override
	public Optional<OrderDetail> findById(Integer id) {
		return orderDetailDAO.findById(id);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAll(Iterable<S> entities) {
		return orderDetailDAO.saveAll(entities);
	}

	@Override
	public void flush() {
		orderDetailDAO.flush();
	}

	@Override
	public <S extends OrderDetail> S saveAndFlush(S entity) {
		return orderDetailDAO.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Integer id) {
		return orderDetailDAO.existsById(id);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
		return orderDetailDAO.saveAllAndFlush(entities);
	}

	@Override
	public <S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
		return orderDetailDAO.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<OrderDetail> entities) {
		orderDetailDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends OrderDetail> long count(Example<S> example) {
		return orderDetailDAO.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<OrderDetail> entities) {
		orderDetailDAO.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return orderDetailDAO.count();
	}

	@Override
	public <S extends OrderDetail> boolean exists(Example<S> example) {
		return orderDetailDAO.exists(example);
	}

	@Override
	public void deleteById(Integer id) {
		orderDetailDAO.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		orderDetailDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(OrderDetail entity) {
		orderDetailDAO.delete(entity);
	}

	@Override
	public <S extends OrderDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return orderDetailDAO.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		orderDetailDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		orderDetailDAO.deleteAllInBatch();
	}

	@Override
	public OrderDetail getOne(Integer id) {
		return orderDetailDAO.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends OrderDetail> entities) {
		orderDetailDAO.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		orderDetailDAO.deleteAll();
	}

	@Override
	public OrderDetail getById(Integer id) {
		return orderDetailDAO.getById(id);
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example) {
		return orderDetailDAO.findAll(example);
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort) {
		return orderDetailDAO.findAll(example, sort);
	}
	
}

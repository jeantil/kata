package eu.byjean.hibernate.dao;

import org.springframework.stereotype.Repository;

import eu.byjean.hibernate.model.Dummy;

@Repository
public class DummyDao extends AbstractGenericDao {
	public Dummy getById(Long id) {
		return null;
	}
}

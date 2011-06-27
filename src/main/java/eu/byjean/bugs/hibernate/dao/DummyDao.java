package eu.byjean.bugs.hibernate.dao;

import org.springframework.stereotype.Repository;

import eu.byjean.bugs.hibernate.model.Dummy;

@Repository
public class DummyDao extends AbstractGenericDao {
	public Dummy getById(Long id) {
		return null;
	}
}

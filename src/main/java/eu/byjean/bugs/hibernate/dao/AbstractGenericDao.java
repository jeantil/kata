package eu.byjean.bugs.hibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractGenericDao extends HibernateDaoSupport {
	@Autowired
    public void init(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
    }
}

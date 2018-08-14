package com.denlex.superoptimum.repository.user.impl;

import com.denlex.superoptimum.domain.Credentials;
import com.denlex.superoptimum.repository.user.CustomizedDistributorRepository;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Shishkov A.V. on 14.08.18.
 */
@Repository
@Transactional(readOnly = true)
public class CustomizedDistributorRepositoryImpl implements CustomizedDistributorRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Credentials findCredentialsByUsername(String username) {
		Query query = entityManager.createNativeQuery(
				"select cr.* from super_optimum.distributor d " +
						"join super_optimum.credentials cr on d.credentials_id = cr.id " +
						"where cr.username = :username", Credentials.class);
		query.setParameter("username", username);
		List result = query.getResultList();

		if (result.isEmpty()) {
			throw new HibernateException("Невозможно загрузить поставщика с логином: " + username);
		}

		return (Credentials) result.get(0);
	}
}

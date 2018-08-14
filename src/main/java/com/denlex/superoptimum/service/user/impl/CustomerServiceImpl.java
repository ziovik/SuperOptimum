package com.denlex.superoptimum.service.user.impl;

import com.denlex.superoptimum.domain.Credentials;
import com.denlex.superoptimum.domain.user.Customer;
import com.denlex.superoptimum.repository.user.CustomerRepository;
import com.denlex.superoptimum.service.user.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.NotSupportedException;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Credentials findCredentialsByUsername(String username) {
		throw new NotSupportedException();
	}
}

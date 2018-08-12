package com.denlex.superoptimum.service.location.impl;

import com.denlex.superoptimum.domain.location.Address;
import com.denlex.superoptimum.repository.location.AddressRepository;
import com.denlex.superoptimum.service.location.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shishkov A.V. on 13.08.18.
 */
@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}
}

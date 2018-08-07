package com.denlex.superoptimum.service.user.impl;

import com.denlex.superoptimum.domain.user.Contact;
import com.denlex.superoptimum.repository.user.ContactRepository;
import com.denlex.superoptimum.service.user.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Shishkov A.V. on 09.08.18.
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}
}

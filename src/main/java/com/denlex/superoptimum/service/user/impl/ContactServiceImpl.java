package com.denlex.superoptimum.service.user.impl;

import com.denlex.superoptimum.domain.user.Contact;
import com.denlex.superoptimum.repository.user.ContactRepository;
import com.denlex.superoptimum.service.user.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shishkov A.V. on 13.08.18.
 */
@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}
}

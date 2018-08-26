package com.denlex.superoptimum.service.user.impl;

import com.denlex.superoptimum.domain.user.Role;
import com.denlex.superoptimum.repository.user.RoleRepository;
import com.denlex.superoptimum.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}
}

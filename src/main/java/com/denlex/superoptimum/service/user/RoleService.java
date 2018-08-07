package com.denlex.superoptimum.service.user;

import com.denlex.superoptimum.domain.Role;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
public interface RoleService {
	Role save(Role role);

	Role findByName(String user);
}

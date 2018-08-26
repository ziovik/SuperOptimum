package com.denlex.superoptimum.repository.user;

import com.denlex.superoptimum.domain.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 08.08.18.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}

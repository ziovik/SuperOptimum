package com.denlex.superoptimum.repository.user;

import com.denlex.superoptimum.domain.user.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Shishkov A.V. on 13.08.18.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	Contact save(Contact contact);
}

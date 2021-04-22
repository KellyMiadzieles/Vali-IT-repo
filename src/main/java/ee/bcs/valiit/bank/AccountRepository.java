package ee.bcs.valiit.bank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Hibernate, String> {
}

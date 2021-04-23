package ee.bcs.valiit.bank;

import org.springframework.data.jpa.repository.JpaRepository;
//Stringi asemel integer?
public interface AccountRepository extends JpaRepository<Hibernate, String> {
}

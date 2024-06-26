package shopstyle.mscustomer.framework.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopstyle.mscustomer.domain.entity.Address;


public interface AddressRepository extends JpaRepository<Address, Float> {
}

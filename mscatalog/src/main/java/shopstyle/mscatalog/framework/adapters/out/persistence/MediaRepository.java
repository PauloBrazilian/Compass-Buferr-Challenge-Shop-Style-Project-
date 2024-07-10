package shopstyle.mscatalog.framework.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import shopstyle.mscatalog.domain.model.Media;

public interface MediaRepository extends JpaRepository<Media, Long> {
}

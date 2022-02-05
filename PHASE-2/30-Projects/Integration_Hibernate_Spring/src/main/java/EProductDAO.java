import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerce.entity.EProductEntity;

@Repository
public class EProductDAO {

        @Autowired
    private SessionFactory sessionFactory;

        @SuppressWarnings("unchecked")
        public List<EProductEntity> getAllProducts() {
                return this.sessionFactory.getCurrentSession().createQuery("from EProducts").list();
        }
}

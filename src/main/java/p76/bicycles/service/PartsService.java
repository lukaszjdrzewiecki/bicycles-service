package p76.bicycles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.BicyclePart;
import p76.bicycles.db.entity.drivetrain.RearDerailleur;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class PartsService {

    @Autowired
    EntityManager em;

    public <T> T findByProductId(Class<T> type, String info) {
        String queryString = "select x from " + type.getSimpleName() + "  x where x.productId=:info";
        TypedQuery<T> q = em.createQuery(queryString, type);
        q.setParameter("info", info);
        List<T> result = q.getResultList();
        if(result.size() == 1) {
            return result.get(0);
        }
        return null;
    }

    public List<BicyclePart> findAll(String partType) {
        String queryString = "select x from " + partType + "  x";
        TypedQuery<BicyclePart> q = em.createQuery(queryString, BicyclePart.class);
        List<BicyclePart> result = q.getResultList();
        return result;
    }
}

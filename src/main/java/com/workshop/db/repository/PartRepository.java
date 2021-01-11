package com.workshop.db.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.workshop.db.entity.BicyclePart;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PartRepository {

    private final EntityManager em;
    private final ForkRepository forkRepository;
    private final FrameRepository frameRepository;

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

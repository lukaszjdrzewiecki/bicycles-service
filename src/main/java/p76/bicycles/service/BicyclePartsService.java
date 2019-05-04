package p76.bicycles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.drivetrain.RearDerailleur;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class BicyclePartsService {

    @Autowired
    EntityManager em;

    public RearDerailleur findByInfo(String info) {
        TypedQuery<RearDerailleur> q = em.createQuery("select x from RearDerailleur x where x.productId=:info", RearDerailleur.class);
        q.setParameter("info", info);
        List<RearDerailleur> result = q.getResultList();
        if(result.size() == 1) {
            return result.get(0);
        }
        return null;
    }
}

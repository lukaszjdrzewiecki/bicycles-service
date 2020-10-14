package workshop;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import workshop.config.security.entity.Role;
import workshop.config.security.repository.RoleRepository;
import workshop.db.entity.*;
import workshop.db.entity.drivetrain.*;
import workshop.db.repository.PedalsRepository;
import workshop.service.BicycleService;
import workshop.db.entity.Bicycle;
import workshop.db.entity.Pedals;
import workshop.db.entity.drivetrain.Crank;

import javax.persistence.EntityManager;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationListener {

    private final BicycleService service;
    private final EntityManager em;
    private final PedalsRepository pedalsRepository;
    private final RoleRepository roleRepository;

    @Transactional
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Optional<Role> admin = roleRepository.findByRoleName("ADMIN");
        if (admin.isEmpty()) {
            roleRepository.save(new Role("ADMIN"));
        }
        Optional<Role> customer = roleRepository.findByRoleName("CUSTOMER");
        if (admin.isEmpty()) {
            roleRepository.save(new Role("CUSTOMER"));
        }

//        insertPartsToDb(RearDerailleur.class);
//        insertPartsToDb(FrontDerailleur.class);
//        insertPartsToDb(Chainring.class);
//        insertPartsToDb(Hub.class);
//        insertPartsToDb(Rim.class);
//        insertPartsToDb(ShifterLeft.class);
//        insertPartsToDb(ShifterRight.class);
//        insertPartsToDb(Tyre.class);
//        insertPartsToDb(BottomBracket.class);
//        insertPartsToDb(Chain.class);
//        insertPartsToDb(Frame.class);
//        insertPartsToDb(Grips.class);
//        insertPartsToDb(Handlebar.class);
//        insertPartsToDb(HeadSet.class);
//        insertPartsToDb(Saddle.class);
//        insertPartsToDb(Seatpost.class);
//        insertPartsToDb(SeatpostClamp.class);
//        insertPartsToDb(Stem.class);
//        insertPartsToDb(Fork.class);
//        insertPartsToDb(Disc.class);
//        insertPartsToDb(Cassette.class);
//        insertPartsToDb(BrakeHydraulic.class);
//        insertPedalsToDb();
//        loadParts();
//        loadBicycles();

    }

    private Bicycle createBicycle(String name, String manufacturer) {
        Bicycle bicycle = new Bicycle();
        return bicycle;
    }


//    public void loadBicycles() {
//        List<Bicycle> list = loadObjectList(Bicycle.class);
//        for(Bicycle bicycle : list) {
//            service.addBicycle(bicycle);
//        }
//    }


//
//    public <T> void insertPartsToDb(Class<T> type) {
//        List<T> list = loadObjectList(type);
//        for(T entity : list) {
//            em.persist(entity);
//        }
//    }
//
//    public <T> void insertRearDerailleurToDb(Class<T> type) {
//        List<T> list = loadObjectList(type);
//        for(T entity : list) {
//            em.persist(entity);
//        }
//    }
//
//    public <T> List<T> loadObjectList(Class<T> type) {
//        String fileName = type.getSimpleName() + ".csv";
//        try {
//            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';');
//            CsvMapper mapper = new CsvMapper();
//
//            File file = new ClassPathResource(fileName).getFile();
//            MappingIterator<T> readValues =
//                    mapper.readerFor(type).with(bootstrapSchema).readValues(file);
//            return readValues.readAll();
//        } catch (Exception e) {
//            log.error("Error occurred while loading object list from file " + fileName, e);
//            return Collections.emptyList();
//        }
//    }
//
//
//    public void insertPedalsToDb() {
//        List<Pedals> pedals = loadObjectList(Pedals.class);
//        for(Pedals pedal : pedals ) {
//            if(!pedalsRepository.existsByProductId(pedal.getProductId())) {
//                em.persist(pedal);
//            }
//        }
//    }

}

package p76.bicycles;

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
import p76.bicycles.db.entity.*;
import p76.bicycles.db.entity.brakes.BrakeHydraulic;
import p76.bicycles.db.entity.cockpit.Handlebar;
import p76.bicycles.db.entity.cockpit.HeadSet;
import p76.bicycles.db.entity.cockpit.Stem;
import p76.bicycles.db.entity.drivetrain.*;
import p76.bicycles.db.entity.drivetrain.BottomBracket;
import p76.bicycles.db.entity.drivetrain.shifters.ShifterLeft;
import p76.bicycles.db.entity.drivetrain.shifters.ShifterRight;
import p76.bicycles.db.entity.cockpit.Grips;
import p76.bicycles.db.entity.seatpost.Saddle;
import p76.bicycles.db.entity.seatpost.Seatpost;
import p76.bicycles.db.entity.seatpost.SeatpostClamp;
import p76.bicycles.db.entity.suspension.Fork;
import p76.bicycles.db.entity.wheels.Disc;
import p76.bicycles.db.entity.wheels.Hub;
import p76.bicycles.db.entity.wheels.Rim;
import p76.bicycles.db.entity.wheels.Tyre;
import p76.bicycles.db.repository.PedalsRepository;
import p76.bicycles.service.BicycleService;

import javax.persistence.EntityManager;
import java.io.File;
import java.util.Collections;
import java.util.List;

//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class ApplicationListener {
//
//    private final BicycleService service;
//    private final EntityManager em;
//    private final PedalsRepository pedalsRepository;
//
//    @Transactional
//    @EventListener
//    public void onApplicationEvent(ContextRefreshedEvent event) {
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
//
//    }
//
//    private Bicycle createBicycle(String name, String manufacturer) {
//        Bicycle bicycle = new Bicycle();
//        return bicycle;
//    }
//
//
//    public void loadBicycles() {
//        List<Bicycle> list = loadObjectList(Bicycle.class);
//        for(Bicycle bicycle : list) {
//            service.addBicycle(bicycle);
//        }
//    }
//
//    public void loadParts() {
//        List<Crank> list = loadObjectList(Crank.class);
//        for(Crank part : list) {
//            service.addCrank(part);
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
//
//}

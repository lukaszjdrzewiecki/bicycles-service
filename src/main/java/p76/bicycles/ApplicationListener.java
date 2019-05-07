package p76.bicycles;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import p76.bicycles.db.entity.*;
import p76.bicycles.db.entity.cockpit.Handlebar;
import p76.bicycles.db.entity.cockpit.HeadSet;
import p76.bicycles.db.entity.cockpit.Stem;
import p76.bicycles.db.entity.drivetrain.*;
import p76.bicycles.db.entity.drivetrain.bottomBracket.BottomBracketIntegrated;
import p76.bicycles.db.entity.drivetrain.shifters.ShifterLeft;
import p76.bicycles.db.entity.drivetrain.shifters.ShifterRight;
import p76.bicycles.db.entity.seatpost.DropperSeatpost;
import p76.bicycles.db.entity.cockpit.Grips;
import p76.bicycles.db.entity.seatpost.Saddle;
import p76.bicycles.db.entity.seatpost.Seatpost;
import p76.bicycles.db.entity.seatpost.SeatpostClamp;
import p76.bicycles.db.entity.suspension.Fork;
import p76.bicycles.db.entity.wheels.Disc;
import p76.bicycles.db.entity.wheels.Hub;
import p76.bicycles.db.entity.wheels.Rim;
import p76.bicycles.db.entity.wheels.Tyre;
import p76.bicycles.service.BicycleService;
import p76.bicycles.service.compatibility.CompatibilityService;

import javax.persistence.EntityManager;
import java.io.File;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class ApplicationListener {

    @Autowired
    BicycleService service;

    @Autowired
    CompatibilityService compatibility;

    @Autowired
    EntityManager em;

    @Transactional
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        insertTestDataToDatabase(RearDerailleur.class);
        insertTestDataToDatabase(FrontDerailleur.class);
        insertTestDataToDatabase(Chainring.class);
        insertTestDataToDatabase(Hub.class);
        insertTestDataToDatabase(Rim.class);
        insertTestDataToDatabase(ShifterLeft.class);
        insertTestDataToDatabase(ShifterRight.class);
        insertTestDataToDatabase(Tyre.class);
        insertTestDataToDatabase(Crank.class);
        insertTestDataToDatabase(BottomBracketIntegrated.class);
        insertTestDataToDatabase(Chain.class);
        insertTestDataToDatabase(DropperSeatpost.class);
        insertTestDataToDatabase(Frame.class);
        insertTestDataToDatabase(Grips.class);
        insertTestDataToDatabase(Handlebar.class);
        insertTestDataToDatabase(HeadSet.class);
        insertTestDataToDatabase(Saddle.class);
        insertTestDataToDatabase(Seatpost.class);
        insertTestDataToDatabase(SeatpostClamp.class);
        insertTestDataToDatabase(Stem.class);
        insertTestDataToDatabase(Fork.class);
        insertTestDataToDatabase(Disc.class);
        insertTestDataToDatabase(Cassette.class);
        insertTestDataToDatabase(BottomBracketIntegrated.class);
        loadBicycles();
        loadParts();

        service.addBicycle("Tormenta Lady", "Accent");
        service.addBicycle("Scale Unique", "Scott");
        service.addBicycle("Trans Siberian 2015", "Kross");

        Bicycle bicycle = createBicycle("Sportster 2017", "Scott");

        service.addBicycle(bicycle);

    }

    private Bicycle createBicycle(String name, String manufacturer) {
        Bicycle bicycle = new Bicycle();
        return bicycle;
    }


    public void loadBicycles() {
        List<Bicycle> list = loadObjectList(Bicycle.class);
        for(Bicycle bicycle : list) {
            service.addBicycle(bicycle);
        }
    }

    public void loadParts() {
        List<Crank> list = loadObjectList(Crank.class);
        for(Crank part : list) {
            service.addCrank(part);
        }
    }

    public <T> void insertTestDataToDatabase(Class<T> type) {
        List<T> list = loadObjectList(type);
        for(T entity : list) {
            em.persist(entity);
        }
    }

    public <T> List<T> loadObjectList(Class<T> type) {
        String fileName = type.getSimpleName() + ".csv";
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader().withColumnSeparator(';');
            CsvMapper mapper = new CsvMapper();

            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues =
                    mapper.readerFor(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            log.error("Error occurred while loading object list from file " + fileName, e);
            return Collections.emptyList();
        }
    }
}

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
import p76.bicycles.db.entity.brakes.BrakeCaliper;
import p76.bicycles.db.entity.brakes.BrakeHandleLeft;
import p76.bicycles.db.entity.brakes.BrakeHandleRight;
import p76.bicycles.db.entity.drivetrain.*;
import p76.bicycles.db.entity.drivetrain.shifters.ShifterLeft;
import p76.bicycles.db.entity.drivetrain.shifters.ShifterRight;
import p76.bicycles.db.entity.seatpost.Saddle;
import p76.bicycles.db.entity.seatpost.SeatPostClamp;
import p76.bicycles.db.entity.seatpost.Seatpost;
import p76.bicycles.db.entity.steering.Grips;
import p76.bicycles.db.entity.steering.Handlebar;
import p76.bicycles.db.entity.steering.Stem;
import p76.bicycles.db.entity.suspension.Fork;
import p76.bicycles.db.entity.steering.HeadSet;
import p76.bicycles.db.entity.wheels.*;
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

        service.addBicycle("Tormenta Lady", "Accent");
        service.addBicycle("Scale Unique", "Scott");
        service.addBicycle("Trans Siberian 2015", "Kross");

        Bicycle bicycle = createBicycle("Sportster 2017", "Scott");



        bicycle.setCrank(new Crank("M610", "Shimano", 1.5, 104, 64, "4 symemtric", 175, 3, 11,
                new Chainring("M610", "Shimano", 0.15, "Big chainring", "4 symmetric", 104, 51, 10),
                new Chainring("M610", "Shimano", 0.11, "Medium chainring", "4 symmetric", 104, 36, 9),
                new Chainring("M610", "Shimano", 0.08, "Small chainring", "4 symmetric", 64, 22, 8)));
        bicycle.setRearDerailleur(new RearDerailleur("RD-M8000", "Shimano", 0.923, 46, 40, "3/2/1", 10, "Long", 47));
        bicycle.setCassette(new Cassette("M590", "Shimano", 0.746, 11, 36, 10));
        bicycle.setFrontDerailleur(new FrontDerailleur("M590", "Shimano", 0.430, 48, 44, 26, 3, 9));
        bicycle.setRearWheel(new RearWheel(
                new Rim("Shimano HB900", 20, 25, 28, true, true, 29),
                new Hub("HOPE HB4", 32, 135, true, 12),
                new Tyre("Continental Baron", 22, true, 26)));
        bicycle.setFrontWheel(new FrontWheel(
                new Rim("Shimano HB900", 20, 25, 28, true, true, 29),
                new Hub("HOPE HB4", 32, 100, true, 15),
                new Tyre("Continental Baron", 22, true, 26)));
        bicycle.setFrame(new Frame(
                "Scott", "Sportster 2017",
                2.10,
                "mountain",
                40.0, 48.7,
                68, 25, true, false, false,
                142, 9,
                31.8, 34.4,
                "Post Mount", "Disc",
                true));
        bicycle.setHeadSet(new HeadSet("FSA", "Headset Pro", 0.120, 28.7, 41.2, 49.3, 28.5, 38.2, true, "semi-integrated"));
        bicycle.setFork(new Fork("Reba", "Rock Shox", 1.58, "2017", 100, 50.0, 28.6, 38.1, false, "Air", "Oil/Coil", 100, 15, "Magnesium", "27,5''", "Disc"));

        bicycle.setShifterLeft(new ShifterLeft("M8000", "Shimano", 0.247, 3));
        bicycle.setShifterRight(new ShifterRight("M8000", "Shimano", 0.249, 11));

        bicycle.setStem(new Stem("Rapid", "FSA", 0.210, 70, 6, 28.6, 31.6));
        bicycle.setHandlebar(new Handlebar("Koryak", "PRO", 0.310, 31.5, 720, "Carbon"));
        bicycle.setGrips(new Grips("Chunky", "ESI Grips", 0.122, false));

        bicycle.setSeatpost(new Seatpost("Koryak", "PRO", 0.310, 320, 31.6, "Aluminium"));
        bicycle.setSeatPostClamp(new SeatPostClamp("Regular Clamp", "PRO", 0.080, 31.7, 34.9));
        bicycle.setSaddle(new Saddle("Volt", "WTB", 0.356, 210, 300, "Chromoly"));

        bicycle.setBrakeHandleLeft(new BrakeHandleLeft("M7000", "Shimano", 0.410, true, false, true, "Mineral", new BrakeCaliper("M7000", "Shimano", 0.203, true, false, false)));
        bicycle.setBrakeHandleRight(new BrakeHandleRight("M7000", "Shimano", 0.310, true, false, true, "Mineral", new BrakeCaliper("M7000", "Shimano", 0.203, true, false, false)));

        service.addBicycle(bicycle);

        System.out.println(service.findAllBicycles());

        System.out.println(compatibility.bicycleCheck(bicycle));

    }

    private Bicycle createBicycle(String name, String manufacturer) {
        Bicycle bicycle = new Bicycle();
        bicycle.setName(name);
        bicycle.setManufacturer(manufacturer);
        return bicycle;
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

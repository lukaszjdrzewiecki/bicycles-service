package p76.bicycles.service;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import p76.bicycles.db.entity.Bicycle;
import p76.bicycles.db.entity.Frame;
import p76.bicycles.db.entity.Pedals;
import p76.bicycles.db.entity.brakes.BrakeHydraulic;
import p76.bicycles.db.entity.cockpit.Grips;
import p76.bicycles.db.entity.cockpit.Handlebar;
import p76.bicycles.db.entity.cockpit.HeadSet;
import p76.bicycles.db.entity.cockpit.Stem;
import p76.bicycles.db.entity.drivetrain.*;
import p76.bicycles.db.entity.drivetrain.BottomBracket;
import p76.bicycles.db.entity.drivetrain.shifters.ShifterLeft;
import p76.bicycles.db.entity.drivetrain.shifters.ShifterRight;
import p76.bicycles.db.entity.seatpost.Saddle;
import p76.bicycles.db.entity.seatpost.Seatpost;
import p76.bicycles.db.entity.seatpost.SeatpostClamp;
import p76.bicycles.db.entity.suspension.Fork;
import p76.bicycles.db.entity.wheels.Disc;
import p76.bicycles.db.entity.wheels.Hub;
import p76.bicycles.db.entity.wheels.Rim;
import p76.bicycles.db.entity.wheels.Tyre;
import p76.bicycles.db.repository.BicycleRepository;
import p76.bicycles.db.repository.CrankRestRepository;

@Data
@Component
public class BicycleService {

    @Autowired
    BicycleRepository repository;

    @Autowired
    CrankRestRepository crankRepository;

    @Autowired
    PartsService partsService;


    public List<Bicycle> findBicycle(String name) {
        return repository.findByName(name);
    }

    public Bicycle addBicycle(Bicycle newBicycle) {
        newBicycle.setFork(
                partsService.findByProductId(Fork.class, newBicycle.getForkInfo())
        );
        newBicycle.setFrame(
                partsService.findByProductId(Frame.class, newBicycle.getFrameInfo())
        );
        //drivetrain
        newBicycle.setBottomBracket(
                partsService.findByProductId(BottomBracket.class, newBicycle.getBottomBracketIntegratedInfo())
        );
        newBicycle.setCrank(
                partsService.findByProductId(Crank.class, newBicycle.getCrankInfo())
        );
        newBicycle.setCassette(
                partsService.findByProductId(Cassette.class, newBicycle.getCassetteInfo())
        );
        newBicycle.setChain(
                partsService.findByProductId(Chain.class, newBicycle.getChainInfo())
        );
        newBicycle.setShifterRight(
                partsService.findByProductId(ShifterRight.class, newBicycle.getShifterRightInfo())
        );
        newBicycle.setShifterLeft(
                partsService.findByProductId(ShifterLeft.class, newBicycle.getShifterLeftInfo())
        );
        newBicycle.setRearDerailleur(
                partsService.findByProductId(RearDerailleur.class, newBicycle.getRearDerailleurInfo())
        );
        newBicycle.setFrontDerailleur(
                partsService.findByProductId(FrontDerailleur.class, newBicycle.getFrontDerailleurInfo())
        );
        // drivetrain
        // cockpit
        newBicycle.setStem(
                partsService.findByProductId(Stem.class, newBicycle.getStemInfo())
        );
        newBicycle.setHandlebar(
                partsService.findByProductId(Handlebar.class, newBicycle.getHandlebarInfo())
        );
        newBicycle.setHeadSet(
                partsService.findByProductId(HeadSet.class, newBicycle.getHeadSetInfo())
        );
        newBicycle.setGrips(
                partsService.findByProductId(Grips.class, newBicycle.getGripsInfo())
        );
        // cockpit
        // seatpost
        newBicycle.setSeatpost(
                partsService.findByProductId(Seatpost.class, newBicycle.getSeatpostInfo())
        );
        newBicycle.setSaddle(
                partsService.findByProductId(Saddle.class, newBicycle.getSaddleInfo())
        );
        newBicycle.setSeatPostClamp(
                partsService.findByProductId(SeatpostClamp.class, newBicycle.getSeatpostClampInfo())
        );
        // front wheel
        newBicycle.setHubFront(
                partsService.findByProductId(Hub.class, newBicycle.getHubFrontInfo())
        );
        newBicycle.setDiscFront(
                partsService.findByProductId(Disc.class, newBicycle.getDiscFrontInfo())
        );
        newBicycle.setTyreFront(
                partsService.findByProductId(Tyre.class, newBicycle.getTyreFrontInfo())
        );
        newBicycle.setRimFront(
                partsService.findByProductId(Rim.class, newBicycle.getRimFrontInfo())
        );
        // front wheel - rear wheel
        newBicycle.setHubRear(
                partsService.findByProductId(Hub.class, newBicycle.getHubRearInfo())
        );
        newBicycle.setDiscRear(
                partsService.findByProductId(Disc.class, newBicycle.getDiscRearInfo())
        );
        newBicycle.setTyreRear(
                partsService.findByProductId(Tyre.class, newBicycle.getTyreRearInfo())
        );
        newBicycle.setRimRear(
                partsService.findByProductId(Rim.class, newBicycle.getRimRearInfo())
        );
        // rear wheel
        // brakes
        newBicycle.setBrakeHydraulicFront(
                partsService.findByProductId(BrakeHydraulic.class, newBicycle.getBrakeFrontInfo())
        );
        newBicycle.setBrakeHydraulicRear(
                partsService.findByProductId(BrakeHydraulic.class, newBicycle.getBrakeRearInfo())
        );
        // brakes

        // pedals
        newBicycle.setPedals(
                partsService.findByProductId(Pedals.class, newBicycle.getPedalsInfo())
        );
        // pedals

        return repository.save(newBicycle);
    }

    public Crank addCrank(Crank newCrank) {
        newCrank.setBigGear(
                partsService.findByProductId(Chainring.class, newCrank.getBigGearInfo())
        );
        return crankRepository.save(newCrank);
    }

    public Bicycle addBicycle(String name, String brand) {
        Bicycle newBicycle = new Bicycle();
        return repository.save(newBicycle);
    }

    public List<Bicycle> findAllBicycles() {
        Iterable<Bicycle> iterable = repository.findAll();
        List<Bicycle> bicycles = new ArrayList();
        for(Bicycle bicycle : iterable) {
            bicycles.add(bicycle);
        }
        return bicycles;
    }

}



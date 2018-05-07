/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shipsProject;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author canderson
 */
public class Fleet {

    private ArrayList<Ship> shipsOfFleet;


    public Fleet()
    {
        //Create Cargo fleet
        CargoShip cargo1 = new CargoShip("Balinda", 1998, "USA", 1200);
        CargoShip cargo2 = new CargoShip("Sassy Boy", 2008,"UK", 2400);
        CargoShip cargo3 = new CargoShip("Gut Frau", 1976,"Germany", 3600);
        CargoShip cargo4 = new CargoShip("Atlas", 1983,"Porta Rico", 6600);

        shipsOfFleet = new ArrayList<Ship>();
        shipsOfFleet.add(cargo1);
        shipsOfFleet.add(cargo2);
        shipsOfFleet.add(cargo3);
        shipsOfFleet.add(cargo4);
        shipsOfFleet.add(new CargoShip("Big Hauler", 2000,"Russia", 16600));

   
        JOptionPane.showMessageDialog(null, "Fleet Roster:\n"+makeFleetRoster()+"\n"+countTheFleet());

        // count fleet

        

    }

    private String countTheFleet()
    {
        String fleetCount ="";
        int cargoShipCount = 0;
        int totalCargoCapacity =0;
        int cruiseShipCount = 0;
        int totalPassengerCapacity =0;

        int battleShipCount = 0;
        int totalWeaponsCapacity =0;
        int totalFighterCapacity =0;




        for(int dex = 0; dex < shipsOfFleet.size(); dex++)
        {
            Ship tempShip = shipsOfFleet.get(dex);

            if(tempShip instanceof CargoShip)
            {

                cargoShipCount++;
                totalCargoCapacity += ((CargoShip)tempShip).getTonnage();
            }
            else if(tempShip instanceof CruiseShip)
            {
                cruiseShipCount++;
                totalPassengerCapacity += ((CruiseShip)tempShip).getPassengers();
            }
            else
            {
                battleShipCount++;
                totalWeaponsCapacity += ((BattleShip)tempShip).getWeapons();
                totalFighterCapacity += ((BattleShip)tempShip).getFighters();
            }

        }

        fleetCount += "\nCargo Fleet:" +
                      "\nCargo ship count: "+cargoShipCount +
                      "\ntotal cargo capacity: "+totalCargoCapacity +
                      "\n\nCruise ship count: "+cruiseShipCount +
                      "\ntotal passenger capacity: "+totalPassengerCapacity +
                      "\n\nBattle ship count: "+battleShipCount +
                      "\ntotal weapons capacity: "+totalWeaponsCapacity +
                      "\ntotal fighter capacity: "+totalFighterCapacity ;



        return fleetCount;
    }


    private String makeFleetRoster()
    {
        String fleetRoster ="";
        for(int dex = 0; dex < shipsOfFleet.size(); dex++)
        {
            Ship tempShip = shipsOfFleet.get(dex);
            fleetRoster += "\n"+tempShip.toString();
        }
        return fleetRoster;
    }


    public static void main(String[] args)
    {
        Fleet myFleet = new Fleet();
    }


}

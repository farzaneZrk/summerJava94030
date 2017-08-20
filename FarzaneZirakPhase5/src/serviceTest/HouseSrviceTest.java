package serviceTest;
import java.io.*;
import java.util.ArrayList;

import entities.*;
import service.HouseService;

public class HouseSrviceTest {

    public void runTests() throws IOException{
        
        HouseService HSTest = new HouseService();
        
        House hagwarts = new House("Hagwarts");
        HSTest.setHouse(hagwarts);
        HSTest.getData("HouseDB.txt");
        HSTest.setData();

        System.out.println("Get House " + getHouseTest(HSTest, hagwarts));
        System.out.println("Set House " + setHouseTest(HSTest, new House("Gryffindor")));
        System.out.println("Get and Set data " + compareFile("HouseDB.txt", "myHouseDB.txt"));
    }

    public boolean getHouseTest(HouseService houseService, House expected){
        House actual = houseService.getHouse();
        if(actual.equals(expected))
            return true;
        return false;
    }

    public boolean setHouseTest(HouseService houseService, House House){
        houseService.setHouse(House);
        House actual = houseService.getHouse();
        if(actual.equals(House))
            return true;
        return false;
    }

    public boolean compareFile(String file1, String file2)throws IOException {

        BufferedReader reader1 = new BufferedReader(new FileReader(new File(file1)));
        BufferedReader reader2 = new BufferedReader(new FileReader(new File(file2)));
        String line1, line2;
        boolean result ;
        while (true){ 
            line1 = reader1.readLine();
            line2 = reader2.readLine();
            if (line1 == null){ 
                result = (line2 == null ? true : false);
                break;
            } 
            if (!line1.equalsIgnoreCase(line2)){ 
                result = false;
                break;
            }
        }  
        reader1.close();
        reader2.close();
        return result;
    }


}

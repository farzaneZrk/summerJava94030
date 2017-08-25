package serviceTest;

import java.io.*;

import entities.Professor;
import service.ProfessorService;

public class ProfessorSrviceTest {


    public void runTests() throws IOException{
        
        ProfessorService PSTest = new ProfessorService();
        
        Professor snape = new Professor("Severus Snape");
        PSTest.setProfessor(snape);
        PSTest.getData("ProfessorDB.txt");
        PSTest.setData();

        System.out.println("Get Professor " + getProfessorTest(PSTest, snape));
        System.out.println("Set Professor " + setProfessorTest(PSTest, new Professor("Madame Hooch")));
        System.out.println("Get and Set data " + compareFile("ProfessorDB.txt", "myProfessorDB.txt"));
    }

    public boolean getProfessorTest(ProfessorService professorService, Professor expected){
        Professor actual = professorService.getProfessor();
        if(actual.equals(expected))
            return true;
        return false;
    }

    public boolean setProfessorTest(ProfessorService professorService, Professor professor){
        professorService.setProfessor(professor);
        Professor actual = professorService.getProfessor();
        if(actual.equals(professor))
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

package application;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.SkeinDao;
import entity.Skein;

public class Menu {
  
  private SkeinDao skeinDao = new SkeinDao();
  private Scanner scanner = new Scanner(System.in); //creates a scanner
  
  private List<String> options = Arrays.asList(
      "Display skeins",
      "Display skein",
      "Create skein", 
      "Delete skein",
      "Update skein");

  
  public void start() {  // connects to the start menu in Application
    String selection = "";
    
    do {
      printMenu();
      selection = scanner.nextLine();
      
      try {
        if (selection.equals("1")) {
          displaySkeins();
      } else if (selection.equals("2")) {
          displaySkein();

      } else if (selection.equals("3")) {
          createSkein();
       
      } else if (selection.equals("4")) {
          deleteSkein();
          
      } else if (selection.equals("5")) {
          updateSkein();
      }  
      } catch (SQLException e) {
            e.printStackTrace();
      }
          
      
      System.out.println("Press enter to continue..."); //allows a pause
      scanner.nextLine();
    } while (!selection.equals("-1"));
  }
  
  private void displaySkeins() throws SQLException {
    List<Skein> skeins = skeinDao.getSkeins();
    for(Skein skein : skeins ) {
      System.out.println(skein.getId() + ": " + skein.getBrand() + " " + skein.getColor());
    }
  }  
  private void displaySkein() throws SQLException {
    System.out.print("Enter skein id: ");
    int id = Integer.parseInt(scanner.nextLine()); //allows us to hit enter to continue
    Skein skein = skeinDao.getSkeinById(id);
    System.out.println(skein.getId() + "; " + skein.getBrand() + skein.getColor());
    
  }
  private void createSkein() throws SQLException {
    System.out.print("Enter new skein brand: ");
    String skeinBrand = scanner.nextLine();
    System.out.print("Enter new skein color: ");
    String skeinColor = scanner.nextLine();
    skeinDao.createNewSkein(skeinBrand, skeinColor);
  }  
    
    
  private void deleteSkein() throws SQLException {
    System.out.print("Enter skein id to delete:");
    int id = Integer.parseInt(scanner.nextLine());
    skeinDao.deleteSkeinById(id);   
  }
  private void updateSkein() throws SQLException {
    System.out.print("Enter new skein brand: ");
    String skeinBrand = scanner.nextLine();
    System.out.print("Enter new skein color: ");
    String skeinColor = scanner.nextLine(); 
    System.out.print("Enter skein id to update: ");
    int id = (scanner.nextInt());
    System.out.println("Sucessfully updated to " + id +" " + skeinBrand + " " + skeinColor);
    skeinDao.updateSkeinByIdQuery(skeinBrand,skeinColor,id);   

  }

  private void printMenu() {
    System.out.println("Select an Option:\n--------------------");
    for (int i = 0; i < options.size(); i++) {
      System.out.println(i + 1 + ") " + options.get(i));
    }
  }    

}

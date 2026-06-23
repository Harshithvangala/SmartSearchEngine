
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine();
        engine.indexFiles("documents");

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("Enter keyword (or exit): ");
            String keyword = sc.nextLine();

            if(keyword.equalsIgnoreCase("exit"))
                break;

            engine.search(keyword);
        }
        sc.close();
    }
}

import java.util.regex.Pattern;

public class IdCheck {
    public static void idCheck(String id){
        boolean checked = Pattern.matches("[A-Z]{3}[0-9]{7}[A-Z]{1}", id);
        if (checked){
            System.out.println("Correct Id");
        }
        else
        {
            System.out.println("Please insert Id again");
        }
    }
}

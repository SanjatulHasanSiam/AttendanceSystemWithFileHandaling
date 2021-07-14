
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;


public class Attendance {
    public static void checkAttendance(String ID) throws IOException{
        String filePath=ID+".txt";
        //Checking Attendance
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");

            String strDate1 = formatter.format(date)+" Present";
            String strDate2 = formatter.format(date)+" Absent";
        FileReader fr=new FileReader(filePath);
        BufferedReader br=new BufferedReader(fr);
        String line= br.readLine();
        while (line != null){
            if (line.equals(strDate1)) {
                System.out.println("Present");
           break;
            }
            else if (line.equals(strDate2)) {
                //Absent-Wrong result-Have to modify it to present
                modifyAttendance(filePath,strDate2,strDate1);
                break;
            }
            else
            {
                line= br.readLine();
            }


        }
        br.close();


    }


    public static void modifyAttendance(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    //Method for making a file with intial absent value
    public static void month(String id,String month,int number) throws IOException{

        if(number==1 || number==3||number==5 || number==7 || number==8 || number==10 || number==12 )
        {String filePath=id+number+".txt";
            FileWriter fw = new FileWriter(filePath,true);
            PrintWriter pw=new PrintWriter(fw);
            String s;
            for(int i=1;i<=31;i++) {
                s=String.format("%02d",i)+" "+month+" 2021 Absent";
                pw.println(s);
            }
            pw.flush();
            pw.close();
        }
        else if(number==2)
        {
            String filePath=id+number+".txt";
            FileWriter fw = new FileWriter(filePath,true);
            PrintWriter pw=new PrintWriter(fw);
            String s;
            for(int i=1;i<=28;i++) {
                s=String.format("%02d",i)+" "+month+" 2021 Absent";
                pw.println(s);
            }
            pw.flush();
            pw.close();
        }
        else
        {
            String filePath=id+number+".txt";
            FileWriter fw = new FileWriter(filePath,true);
            PrintWriter pw=new PrintWriter(fw);
            String s;
            for(int i=1;i<=30;i++) {
                s=String.format("%02d",i)+" "+month+" 2021 Absent";
                pw.println(s);
            }
            pw.flush();
            pw.close();
        }

    }
    public static void absent(String id) throws IOException{

        for (int j=1;j<=12;j++){
            switch(j){
                case 1:
                    month(id,"January",1);
                    break;
                case 2:
                    month(id,"February",2);

                    break;
                case 3:
                    month(id,"March",3);
                    String March;
                    break;

                case 4:
                    month(id,"April",4);
                    break;
                case 5:
                    month(id,"May",5);
                    break;
                case 6:
                    month(id,"June",6);
                    String June;
                    break;
                case 7:
                    month(id,"July",7);
                    String July;
                    break;
                case 8:
                    month(id,"August",8);
                    String August;
                    break;
                case 9:
                    month(id,"September",9);
                    String September;
                    break;
                case 10:
                    month(id,"October",10);
                    String October;
                    break;
                case 11:
                    month(id,"November",11);
                    String November;
                    break;
                case 12:
                    month(id,"December",12);
                    break;
            }

        }

    }
    //Checking Id with regex
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

    public static void main(String[] args)throws IOException{

/* Suppose we got the voice match for ID="ASH1925023M"
Every txt file initally has to be of value Absent for each date- String strDate = formatter.format(date)+" Absent";
 */
       // checkAttendance("ASH1925023M");
        //absent("ASH1925023M");
        idCheck("ASH1925023M");


    }

}

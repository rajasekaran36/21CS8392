import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;

class Student {
    private String rollNo;
    private String regNo;
    private String name;
    private List<String> gmeetNames;

    public Student(String rollNo, String regNo, String name) {
        this.rollNo = rollNo;
        this.regNo = regNo;
        this.name = name;
        this.gmeetNames = new ArrayList<>();
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getName() {
        return name;
    }

    public List<String> getGmeetNames() {
        return gmeetNames;
    }
}

class MeetRecord{
    private String meetName;
    private String lastSeen;
    private String duration;

    public MeetRecord(String meetName,String lastSeen,String duration){
        this.meetName = meetName;
        this.lastSeen = lastSeen;
        this.duration = duration;
    }
    
    public String getMeetName() {
        return meetName;
    }
    public String getLastSeen() {
        return lastSeen;
    }
    public String getDuration() {
        return duration;
    }
}

class MeetUtils {
    public static String getSheetCSV(String sheetId, String sheetName) {
        String out = "";
        try {
            String sourceURL = "https://docs.google.com/spreadsheets/d/" + sheetId + "/gviz/tq?tqx=out:csv&sheet="
                    + sheetName;
            HttpURLConnection connection = (HttpURLConnection) new URL(sourceURL).openConnection();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            int c = 0;
            while ((c = buffer.read()) != -1) {
                builder.append((char) c);

            }
            out = builder.toString().replaceAll("\"", "");
        } catch (MalformedURLException e) {
            System.out.println("URL Issue");
        } catch (IOException e) {
            System.out.println("IO Issue");
        }
        return out;
    }
    public static List<MeetRecord> getMeetRecords(String meetData){
        List<MeetRecord> meetRecords = new ArrayList<>();
        String[] lines = meetData.split("\n");
        for(int i=1;i<lines.length;i++){
            String[] words = lines[i].split(",");
            MeetRecord mr = new MeetRecord(words[0], words[1], words[2]);
            meetRecords.add(mr);
        }
        return meetRecords;
    }

    public static List<Student> getStudents(String mapData){
        List<Student> students = new ArrayList<>();
        for (String x : mapData.split("\n")) {
            String[] words = x.split(",");
            Student student = new Student(words[0], words[1], words[2]);
            for (int i = 3; i < words.length; i++) {
                student.getGmeetNames().add(words[i]);
            }
            students.add(student);
        }
        return students;
    }
}

public class Main {
    public static void main(String[] args) throws MalformedURLException, IOException {

        String mapSheetId = "1Njnz3U8skMg8m1M5-k6HY6tCPp88Qj8mg-JEwnOBE-I";
        String mapSheetName = "II-IT";
        String mapData = MeetUtils.getSheetCSV(mapSheetId, mapSheetName);
        List<Student> students = MeetUtils.getStudents(mapData);
        List<String> studentMeetNames = new ArrayList<>();

        String meetSheetId = "1lcTnJM9OnhOzBxEP-8voTzXvQ1xzKKpPXnceTFKzntY";
        String meetSheetName = "26-08";
        String meetData = MeetUtils.getSheetCSV(meetSheetId, meetSheetName);
        List<MeetRecord> meetRecords = MeetUtils.getMeetRecords(meetData);
        List<String> meetNames = new ArrayList<>();
        
        StringBuilder outCSV = new StringBuilder();

        meetRecords.stream().forEach(s->{
            meetNames.add(s.getMeetName());
        });

        students.stream().forEach(s->{
            String line = s.getRollNo()+","+s.getRegNo()+","+s.getName();
            if(meetNames.contains(s.getGmeetNames().get(0))){
                line += ","+s.getGmeetNames().get(0)+","+"P";
            }
            else{
                line += ","+s.getGmeetNames().get(0)+","+"AB";
            }
            line += "\n";
            outCSV.append(line);
        });

        FileWriter fileWriter = new FileWriter(meetSheetName+".csv");
        fileWriter.write(outCSV.toString());
        fileWriter.close();
    }
}

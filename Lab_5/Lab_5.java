// Окрестин, 2 курс 5 группа
// Лаб 5
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
    static class Company {
        String name;
        String shortTitle;
        String dateUpdate;
        String address;
        String dateFoundation;
        int countEmployees;
        String auditor;
        String phone;
        String email;
        String branch;
        String activity;
        String internetAddress;

        public Company (String[] input){
            this.name = input[0];
            this.shortTitle = input[1];
            this.dateUpdate = input[2];
            this.address = input[3];
            this.dateFoundation = input[4];
            this.countEmployees = Integer.parseInt(input[5]);
            this.auditor = input[6];
            this.phone = input[7];
            this.email = input[8];
            this.branch = input[9];
            this.activity = input[10];
            this.internetAddress = input[11];
        }
    }

    List<Company> companiesArr = new ArrayList<>();

    public void csvRead(String csvFile) throws IOException{
        List<String> fileLines = Files.readAllLines(Paths.get(csvFile));
        for (String line : fileLines) {
            String[] fields = line.split(",");
            companiesArr.add(new Company(fields));
        }
    }

    private List<Company> requestCompaniesArr(java.util.function.Predicate<Company> pred) {
        List<Company> result = new ArrayList<>();
        for (Company company : companiesArr) {
            if (pred.test(company)) {
                result.add(company);
            }
        }
        return result;
    }

    public List<Company> searchByShortTitle(String shortTitle){
        return requestCompaniesArr(company -> company.shortTitle.equalsIgnoreCase(shortTitle));
    }
    public List<Company> searchByBranch(String branch){
        return requestCompaniesArr(company -> company.branch.equalsIgnoreCase(branch));
    }
    public List<Company> searchByActivity(String activity){
        return requestCompaniesArr(company -> company.activity.equalsIgnoreCase(activity));
    }
    public List<Company> searchByDate(String fromDate, String toDate){
        List<Company> result = new ArrayList<>();
        for (Company company : companiesArr) {
            if (fromDate.compareTo(company.dateFoundation) <= 0 && toDate.compareTo(company.dateFoundation) >= 0) {
                result.add(company);
            }
        }
        return result;
    }
    public List<Company> searchByEmployeesCount(int fromCount, int toCount){
        List<Company> result = new ArrayList<>();
        for (Company company : companiesArr) {
            if (fromCount <= company.countEmployees && toCount >= company.countEmployees) {
                result.add(company);
            }
        }
        return result;
    }

    public void writeToXml(String outputFile, List<Company> companies) {
        try {
            StringBuilder xmlBuilder = new StringBuilder();
            xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            xmlBuilder.append("<companies>\n");
            for (Company company : companies) {
                xmlBuilder.append("  <company>\n");
                xmlBuilder.append("    <name>").append(company.name).append("</name>\n");
                xmlBuilder.append("    <shortTitle>").append(company.shortTitle).append("</shortTitle>\n");
                xmlBuilder.append("    <dateUpdate>").append(company.dateUpdate).append("</dateUpdate>\n");
                xmlBuilder.append("    <address>").append(company.address).append("</address>\n");
                xmlBuilder.append("    <dateFoundation>").append(company.dateFoundation).append("</dateFoundation>\n");
                xmlBuilder.append("    <countEmployees>").append(company.countEmployees).append("</countEmployees>\n");
                xmlBuilder.append("    <auditor>").append(company.auditor).append("</auditor>\n");
                xmlBuilder.append("    <phone>").append(company.phone).append("</phone>\n");
                xmlBuilder.append("    <email>").append(company.email).append("</email>\n");
                xmlBuilder.append("    <branch>").append(company.branch).append("</branch>\n");
                xmlBuilder.append("    <activity>").append(company.activity).append("</activity>\n");
                xmlBuilder.append("    <internetAddress>").append(company.internetAddress).append("</internetAddress>\n");
                xmlBuilder.append("  </company>\n");
            }
            xmlBuilder.append("</companies>");

            Files.write(Paths.get(outputFile), xmlBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToJson(String outputFile, List<Company> companies) {
        try {
            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{\n  \"companies\": [\n");
            for (int i = 0; i < companies.size(); i++) {
                Company company = companies.get(i);
                jsonBuilder.append("    {\n");
                jsonBuilder.append("      \"name\": \"").append(company.name).append("\",\n");
                jsonBuilder.append("      \"shortTitle\": \"").append(company.shortTitle).append("\",\n");
                jsonBuilder.append("      \"dateUpdate\": \"").append(company.dateUpdate).append("\",\n");
                jsonBuilder.append("      \"address\": \"").append(company.address).append("\",\n");
                jsonBuilder.append("      \"dateFoundation\": \"").append(company.dateFoundation).append("\",\n");
                jsonBuilder.append("      \"countEmployees\": ").append(company.countEmployees).append(",\n");
                jsonBuilder.append("      \"auditor\": \"").append(company.auditor).append("\",\n");
                jsonBuilder.append("      \"phone\": \"").append(company.phone).append("\",\n");
                jsonBuilder.append("      \"email\": \"").append(company.email).append("\",\n");
                jsonBuilder.append("      \"branch\": \"").append(company.branch).append("\",\n");
                jsonBuilder.append("      \"activity\": \"").append(company.activity).append("\",\n");
                jsonBuilder.append("      \"internetAddress\": \"").append(company.internetAddress).append("\"\n");
                jsonBuilder.append("    }");
                if (i < companies.size() - 1) {
                    jsonBuilder.append(",\n");
                }
            }
            jsonBuilder.append("\n  ]\n}");

            Files.write(Paths.get(outputFile), jsonBuilder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        String csvFile = "input.csv";
        String jsonFile = "output.json";
        String xmlFile = "output.xml";

        List<Company> companies = new ArrayList<>();
        try {
            m.csvRead(csvFile);
            List<Company> resultArr1 = m.searchByShortTitle("Comp A");
            List<Company> resultArr2 = m.searchByEmployeesCount(400, 1100);
            List<Company> resultArr3 = m.searchByDate("1981-12-31", "1999-11-01");

            m.writeToXml(xmlFile, resultArr1);
            m.writeToJson(jsonFile, resultArr3);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.myindia.mygo;

import java.util.HashMap;

/**
 * Created by Fission Labs on 3/8/2018.
 */

public class CountryHelper {

    static  HashMap<String, String[]> citiesMap = new HashMap<>();
    static  HashMap<String, String[]> districtMap = new HashMap<>();

    static {
        String[] australiaCities = {"Select State", "Queensland", "Victoria"};
        String[] indiaCities = {"Select State", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "TamilNadu", "Telangana"};
        String[] newzelandCities = {"Select State", "Auckland"};
        String[] usaCities = {"Select State", "New Jersy", "Illinois"};
        String[] uaeCities = {"Select State", "Dubai"};
        String[] mauritiusCities = {"Select State", "Mauritius"};

        String[] queenslandDistricts = {"Select District", "Brisbane"};
        String[] victoriaDistricts= {"Select District", "Melbourne"};
        String[] aucklandDistricts = {"Select District", "Auckland"};
        String[] newJersyDistricts = {"Select District", "Edidon"};
        String[] illinoisDistricts = {"Select District", "Chicago"};
        String[] dubaiDistricts = {"Select District", "Dubai"};
        String[] mauritiusDistricts = {"Select District", "Mauritius"};
        String[] andhraDistricits = {"Select District","Anantpur","Chittoor","East Godavari","Guntur","(YSR) Kadapa","Krishna","Kurnool","Sri Potti Sriamulu Nellore","Prakasam","Srikakulam","Vishakapatnam","Vizianagaram","West Godavari"};
        String[] arunachalDistricts= {"Select District","Anjaw","Changlang","East Kameng","East Siang","Lohit","Lower Subansiri","Papum Pare","Tawang","Tirap","Dibang Valley","Upper Subansiri","West Kameng","West Siang" };
        String[] assamDistricts = {"Select District","Barpeta","Bongaigaon","Cachar","Darrang","Dhemaji","Dhubri","Dibrugarh","Goalpara","Golaghat","Hailakandi","Jorhat","Kamrup","Karbi Anglong","Karimganj","Kokrajhar","Lakhimpur","Morigaon","N.C.Hills","Nagaon","Nalbari","Dima Hasao","Sibsagar","Sonitpur","Tinsukia"};
        String[] biharDistricts = {"Select District","Araria","","Arwal","Aurangabad ","Banka ","Begusarai ","Bhabua ","Bhagalpur ","Bhojpur(Arah) ","Buxar ","Darbhanga ","East Champaran","Gaya","Gopalganj","Jamui","Jehanabad","Khagaria","Kishanganj"," Kaimur","Katihar","Lakhisarai","Madhubani","Munger","Madhepura","uzaffarpur","Nalanda","Nawada ","Patna","Purni","Rohtas(Sasaram)","Saharsa","Samastipur","Seohar","Sheikhpura ","Saran"," Sagar"," Supaul","Siwan","Vaishali(Hajipur)","West Champaran","Saran( Chapra )","Sitamarhi"};
        String[] chhattisgarhDistricts = {"Select District","Bastar","Bijapur","Bilaspur","Dantewada","Dhamtari","Durg","Jashpur","Janjgir Champa","Korba"," Koriya","Kanker","Kabirdham( Formerly Kawardha)","Mahasamund","Narayanpur","Raighar"," Rajnandgaon","Raipur","Surguja"};
        String[] goaDistricts = {"Select District","North Goa","South Goa"};
        String[] gujaratDistricts = {"Select District","Ahmedabad","","Amrelai","Anand","Banaskantha","Bharuch","Bhavnagar","Dahod","The Dangs","Gandhinagar","Jamnagar","Junagadh","Kheda","Kutch","Mehsana","Narmada","Navsari","Panchmahal","Patan","Porbander","Rajkot","Sabarkantha","Surat","Surendranagar","Vadodara","Valsad"};
        String[] haryanaDistricts = {"Select District","Ambala","","Bhiwani","Faridabad","Fatehabad","Gurgaon","Hissar","Jhajjar","Jind","Kaithal","Karnal ","Kurukshetra","Mahendragarh","Mewat","Panchkula","Panipat","Palwal","Rewari","Rohtak","Sirsa","Sonipat ","Yamunanagar"};
        String[] himachalDistricts= {"Select District","Bilaspur","Chamba","Hamirpur","Kangra","Kinnaur","Kullu","Lahaul-Spiti","Mandi","Shimla","Sirmour ","Solan","Una"};
        String[] jammuDistricts = {"Select District","Anantnag","Badgan","Bandipora","Baramula","Doda","GanderbalJammu","Kargil","Kathua ","Kishtwar","Kupwara","Kulgam","Leh","Poonch","Pulwama","Rajauri","Ramban","Reasi","Samba","Shopian"," Srinagar","Udhampur"};
        String[] jarkhandDistricts = {"Select District","Bokaro","Chatra","Deoghar","Dhanbad","Dumka","East Singhbhum","Garhwa","Giridih","Godda","Gumla ","Hazaribag","Jamtara","Khunti","Koderma","Latehar","Lohardaga","Pakur","Palamu","Ramgarh","Ranchi ","Sahibganj","Seraikela-Kharsawan","Simdega","West Singhbhum"};
        String[] karnatakaDistricts = {"Select District","Bangalore Rural","Bangalore Urban","Bagalkot","Belgaum","Bellar","Bidar","Bijapur ","Chamarajnagar"," Chickamagaluru","Chitradurga","Dakshina Kannada","Davanagare","Dharwad ","Gadag"," Gulbarga"," Hassan","Haveri","Kodagu","Karwar","Kolar","Koppal","Madikeri","Mandya ","Mysore"," Raichur"," Shimoga","Tumkur","Udupi","Uttara Kannada","Ramanagara","Chikkaballapur"," Yadgir"};
        String[] tamilnaiduDistricts= {"Select District","Ariyalur","Chennai","Coimbotore","Cuddalore","Dharmapuri","Dindigul","Erode","Kanchipuram","Kanyakumari","Karur","Madurai","Nagapattinam","Namakkal","Nilgiris","Perambalur","Pudukkottai","amanathapuram","Salem","Sivaganga","Tirupur","Tiruchiorappalli","Theni","Tirunelveli","Thanjavur","Thoothkudi","Tiruvallur","Tiruvannamalai","Tiruvarur","Vellore","Villupuram","Virudhunagar"};
        String[] telenganaDistricts = {	"Select District","Adilabad","Bhadradri-Kothagudem","Hyderabad","Jagtial","Jangaon","Jayashankar","Bhoopalpally","Jogulamba-Gadwal","Kamareddy","Karimnagar","Khammam","Komaram Bheem Asifabad","Mahabubabad","Mahabubnagar","Mancherial","Medchal","Medak","Nagarkurnool","Nalgonda","Nirmal","Nizamabad","Peddapalle","Rajanna Sircilla","Ranga Reddy","Sangareddy","Siddipet","Suryapet","Vikarabad","Wanaparthy","Warangal (Rural)","Warangal (Urban)","Yadadri-Bhuvanagiri"};

        citiesMap.put("australia", australiaCities);
        citiesMap.put("india", indiaCities);
        citiesMap.put("new zealand", newzelandCities);
        citiesMap.put("usa", usaCities);
        citiesMap.put("uae", uaeCities);
        citiesMap.put("mauritius", mauritiusCities);

        districtMap.put("Andhra Pradesh", andhraDistricits);
        districtMap.put("Arunachal Pradesh", arunachalDistricts);
        districtMap.put("Assam", assamDistricts);
        districtMap.put("Bihar", biharDistricts);
        districtMap.put("Chhattisgarh", chhattisgarhDistricts);
        districtMap.put("Goa", goaDistricts);
        districtMap.put("Gujarat", gujaratDistricts);
        districtMap.put("Haryana", haryanaDistricts);
        districtMap.put("Himachal Pradesh", himachalDistricts);
        districtMap.put("Jammu and Kashmir", jammuDistricts);
        districtMap.put("Jharkhand", jarkhandDistricts);
        districtMap.put("Karnataka", karnatakaDistricts);
        districtMap.put("TamilNadu", tamilnaiduDistricts);
        districtMap.put("Telengana", telenganaDistricts);
        districtMap.put("Queensland", queenslandDistricts);
        districtMap.put("Victoria", victoriaDistricts);
        districtMap.put("Auckland", aucklandDistricts);
        districtMap.put("New Jersy", newJersyDistricts);
        districtMap.put("Illinois", illinoisDistricts);
        districtMap.put("Dubai", dubaiDistricts);
        districtMap.put("Mauritius", mauritiusDistricts);

    }


    public static String[] getCityByName(String county) {
        return citiesMap.get(county.toLowerCase());
    }

    public static String[] getDistrictByName(String city) {
        return districtMap.get(city);
    }



}

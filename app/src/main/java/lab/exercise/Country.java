package lab.exercise;

import android.util.Log;
import android.widget.Toast;

public class Country {

    private String capitalCity;
    private String continent;
    private String currency;
    public String nationalNumberForPhone;
    protected String cityName;

    /**
     * @return the capitalCity
     */
    public String getCapitalCity() {
        return capitalCity;
    }
    /**
     * @param capitalCity the capitalCity to set
     */
    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }
    /**
     * @return the continent
     */
    public String getContinent() {
        return continent;
    }
    /**
     * @param continent the continent to set
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * @param nationalNumberForPhone the nationalNumberForPhone to set
     * Super weird visibility setting
     */
    private void setNationalNumberForPhone(String nationalNumberForPhone) {
        this.nationalNumberForPhone = nationalNumberForPhone;
    }
    /**
     * public method for private method
     */
    public void setNationalNumberForPhoneInOutside(String phoneNumber){
        setNationalNumberForPhone(phoneNumber);
    }

    /**
     * @return the nationalNumberForPhone
     * Super weird visibility setting
     */
    protected String getNationalNumberForPhone() {
        return nationalNumberForPhone;
    }

        /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void countryClassF(){Log.d("From Country class", "This method exist only in Country class");}

    public String countryClassF(boolean doYouWantString) {
        if (doYouWantString) {
            return "From Country class " + "This method exist only in Country class";
        } else
            return "";
    }

    public String runDemo(){
        String result = "";

        Country korea = new Country();
        Country finland = new Country();

        finland.setCapitalCity("Helsinki");
        finland.setContinent("Europe");
        korea.setCapitalCity("Seoul");
        korea.setContinent("Asia");

        result += "Capital city of Finland is " + finland.getCapitalCity() + " and Finland is located in " + finland.getContinent() ;
        result += "\nCapital city of Korea is " + korea.getCapitalCity() + " and Korea is located in " + korea.getContinent();
        Log.d("","Capital city of Finland is " + finland.getCapitalCity() + " and Finland is located in " + finland.getContinent());
        Log.d("","Capital city of Korea is " + korea.getCapitalCity() + " and Korea is located in " + korea.getContinent());

/**Demonstration of inheritage */

         City busan = new City();
         City tampere = new City();

         result += "\nEven without implementing any line of coding, with extends those are able to do";
         Log.d("","Even without implementing any line of coding, with extends those are able to do");

         busan.setContinent("Asia");
         tampere.setContinent("Europe");
         busan.setCityName("Busan");
         tampere.setCityName("Tampere");
         busan.setCurrency("Won");
         tampere.setCurrency("Euro");
         busan.setNationalNumberForPhoneInOutside("+82");
         tampere.setNationalNumberForPhoneInOutside("+358");

         result += "\n" + busan.getCityName() + " is City, " + busan.getCurrency() + " is used as currency and " + busan.getNationalNumberForPhone() + " is used as national phone code";
         result += "\n" + tampere.getCityName() + " is City, " + tampere.getCurrency() + " is used as currency and " + tampere.getNationalNumberForPhone() + " is used as national phone code";

         Log.d("",busan.getCityName() + " is City, " + busan.getCurrency() + " is used as currency and " + busan.getNationalNumberForPhone() + " is used as national phone code");
         Log.d("",tampere.getCityName() + " is City, " + tampere.getCurrency() + " is used as currency and " + tampere.getNationalNumberForPhone() + " is used as national phone code");

         /**
          * And here comes the demonstration of Polymorphism
          * */

         Country parentClassCountry = new Country();

         result += "\nFrom Country parent " + parentClassCountry.countryClassF(true);
         Log.d("From Country parent", "");
         parentClassCountry.countryClassF();


         City childClassCity = new City();
         result += "\nFrom City child class" + childClassCity.cityClassF(true) + childClassCity.countryClassF(true);
         Log.d("From City child class", "");
         childClassCity.cityClassF();
         childClassCity.countryClassF();

         Country countryClassButCity = new City();
         Log.d("From casted class", "");
         result += "\nFrom casted class " + countryClassButCity.countryClassF(true);
         countryClassButCity.countryClassF();
         /**Here Android Studio complains that even it is initiated with City class
          * beacuse it is declared with Country type*/
//         countryClassButCity.cityClassF();
         Log.d("after comment out", "then casted with City class");
         /**But with casting it is able to use 'cityClassF' since object has form of City class also*/
         ((City) countryClassButCity).cityClassF();

         result += "\nafter comment out" + "then casted with City class" + ((City) countryClassButCity).cityClassF(true);

         /**From here demonstration of override*/
         OverrideCity someCity = new OverrideCity();
         someCity.setCityName("Some City");
         someCity.setContinent("Somewhere");
         someCity.setCurrency("Gold");

         Log.d("From override Class", "some city's capital city is " + someCity.getCapitalCity() +
                 " and used currency is " + someCity.getCurrency() + " and it is located in " + someCity.getContinent() + " and lastly this city name is "
         + someCity.getCityName());

         result += "\nFrom override Class" + "some city's capital city is " + someCity.getCapitalCity() +
                 " and used currency is " + someCity.getCurrency() + " and it is located in " + someCity.getContinent() + " and lastly this city name is "
                 + someCity.getCityName() ;

         /**From here, demonstrating the abstract class*/
         Log.d("From abstract class", "");
         /*Abstract class can not be instantiated**/
//         InfoFrame infoFrame = new InfoFrame();
        PlaceInfo placeInfo = new PlaceInfo("Some place", "Somewhere", "Something");
        Log.d("",placeInfo.explain());

        result += "\nFrom abstract class" + placeInfo.explain();

        return result;
    }
}

 class City extends Country{

    public void cityClassF(){Log.d("From City Class", "This method exist only in City class!");}
    public String cityClassF(boolean doYouWantString){
        if(doYouWantString)
            return "From City Class " + "This method exist only in City class!";
        else
            return "";
    }
 }

 class OverrideCity extends Country{
     /**upper one that commend out is previous parent class's method that i can inheritage but modifiy for own usage*/

     @Override
     public String getCapitalCity() {
//         return super.getCapitalCity();
         return getCityName();
     }

     @Override
     public String getContinent() {
//         return super.getContinent();
         return "Somewhere in Earth";
     }

     @Override
     public String getCurrency() {
//         return super.getCurrency();
         return "For sure money will be used than goods";
     }

     @Override
     public String getCityName() {
//         return super.getCityName();
         return "I suppose that variable would represent it since class name is city so please declare variable with common sense!";
     }
 }

 interface NationInfomation{
    String printPopulationInfo(int population);
    String printLanguageInfo(String language);
    boolean checkContinent(String continent);
    String getNationalPhoneCode();
 }

 class CityInfo extends City implements NationInfomation{
     @Override
     public String printPopulationInfo(int population) {
         return null;
     }

     @Override
     public String printLanguageInfo(String language) {
         return null;
     }

     @Override
     public boolean checkContinent(String continent) {
         return false;
     }

     @Override
     public String getNationalPhoneCode() {
         return null;
     }
 }



 abstract class InfoFrame {
    private String name;
    private String location;
    protected String context;

     public InfoFrame(String name, String location, String context) {
         this.name = name;
         this.location = location;
         this.context = context;
     }

     public String getContext() {
         return context;
     }

     public void setContext(String context) {
         this.context = context;
     }

     public String getName() {
         return name;
     }
     /*
     * It is also possible set method accessibility/visibility as final with preventing override*/
     final void setName(String name) {
         this.name = name;
     }

     public String getLocation() {
         return location;
     }

     public void setLocation(String location) {
         this.location = location;
     }

     /**method can be also set as abstract*/
     abstract String explain();
 }

 /**when inherit the abstract class, abstract method must be included */
 class PlaceInfo extends InfoFrame{
     public PlaceInfo(String name, String location, String context) {
         super(name, location, context);
     }

     @Override
     String explain() {
         return getName() + " is name of this info, " + getLocation() + " is location of this info and " +
                 getContext() + " is context of this info";
     }
 }
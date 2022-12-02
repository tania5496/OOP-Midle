package info;

import api.APIBrandfetchStrategy;
import api.APIPDLStrategy;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import parser.*;
import search.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@ToString
public class Info {
    private String domain;
    @Getter
    private String name = null;
    @Getter
    private String twitter = null;
    @Getter
    private String facebook = null;
    @Getter
    private String logo = null;
    @Getter
    private String icon = null;
    @Getter
    private String employees = null;
    @Getter
    private String address = null;

    @SneakyThrows
    Info(String domain) {
        try{
        InetAddress inetAddress = InetAddress.getByName(domain);
        this.domain = domain;
        Parser parser = new Parser(domain);
        APIPDLStrategy apipdlStrategy = new APIPDLStrategy();
        apipdlStrategy.getInfo(domain);
        APIBrandfetchStrategy apiBrandfetchStrategy = new APIBrandfetchStrategy();
        apiBrandfetchStrategy.getInfo(domain);
        Document doc = parser.parse();
        setName(doc);
        setTwitter(doc, apiBrandfetchStrategy.getData(), apipdlStrategy.getData());
        setFacebook(doc, apiBrandfetchStrategy.getData(), apipdlStrategy.getData());
        setLogo(apiBrandfetchStrategy.getData());
        setIcon(doc, apiBrandfetchStrategy.getData());
        setEmployees(apipdlStrategy.getData());
        setAddress(domain);}
        catch (UnknownHostException e){
            this.domain = null;
        }
    }
    private void setName(Document doc){
        Name name = new Name(doc);
        name.findName();
        this.name = name.getName();}

    private void setTwitter(Document doc, JSONObject jsonObjectBF, JSONObject jsonObjectPDL){
        twitter =  new TwitterSearchStrategy().searchwithBrandfetch(jsonObjectBF);
        if (twitter.equals("Not found")){
            twitter = new TwitterSearchStrategy().searchwithPDL(jsonObjectPDL);}
        if (twitter.equals("Not found")){
            try{
            Twitter twitter = new Twitter(doc);
            twitter.findTwitter();
            this.twitter = twitter.getTwitter();}
            catch (IndexOutOfBoundsException e){
                this.twitter = "Not found";
            }
        }
    }

    private void setFacebook(Document doc, JSONObject jsonObjectBF, JSONObject jsonObjectPDL){
        facebook =  new FacebookSearchStrategy().searchwithBrandfetch(jsonObjectBF);
        if (facebook.equals("Not found")){
            facebook = new FacebookSearchStrategy().searchwithPDL(jsonObjectPDL);}
        if (facebook.equals("Not found")){
            try{
            Facebook facebook = new Facebook(doc);
            facebook.findFacebook();
            this.facebook = facebook.getFacebook();}
            catch (IndexOutOfBoundsException e){
                this.facebook = "Not found";
            }
        }
    }

    private void setLogo(JSONObject jsonObjectBF){
        logo = new LogoSearchStrategy().searchwithBrandfetch(jsonObjectBF);
    }

    private void setIcon(Document document, JSONObject jsonObject){
        icon = new IconSearchStrategy().searchwithBrandfetch(jsonObject);
        if (icon.equals("Not found")){
            try{
            Icon icon = new Icon(document);
            icon.findIcon();
            this.icon = icon.getIcon();}
            catch (IndexOutOfBoundsException e){
                this.icon = "Not found";
            }
        }
    }

    private void setEmployees(JSONObject jsonObject){
        employees = new Employees().getEmployees(jsonObject);
    }

    private void setAddress(String domain){
        try{
        address = GooglePlaces.searchaddress(domain);}
        catch(ArrayIndexOutOfBoundsException e){
            address = "Not found";
        }
    }
    public static void main(String[] args) {
        Info info = new Info("google");
        System.out.println(info);
    }

}

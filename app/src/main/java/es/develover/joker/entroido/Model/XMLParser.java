package es.develover.joker.entroido.Model;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.util.Log;
import es.develover.joker.entroido.R;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by snooze on 5/02/16.
 */
public class XMLParser {

    Context context = null;
    String LOG_TAG = "XML_TEST";
    int id;

    ArrayList<Event> cigarron = null;
    ArrayList<Event> party = null;
    ArrayList<Party> orquesta = null;
    ArrayList<Miscelaneus> miscellaneous = null;
    ArrayList<Colaborador> colaborador = null;
    ArrayList<Day> day = null;
    ArrayList<Event> history = null;

    public XMLParser(int id, Context context){
        this.id = id;
        this.context = context;
        try {
            doit();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doit() throws XmlPullParserException, IOException {
        XmlResourceParser xml = context.getResources().getXml(id);

        int event = xml.getEventType();

        while(event!= XmlPullParser.END_DOCUMENT){
            switch(event){
                case XmlPullParser.START_TAG:
//                    Log.d(LOG_TAG,"Start tag " + xml.getName());
                    if (xml.getName().equals("cigarron")){
                        xml.next();
                        this.cigarron = parseEvent(xml, "cigarron");
                    } else if (xml.getName().equals("partyzones")){
                        xml.next();
                        this.party = parseEvent(xml, "partyzones");
                    } else if (xml.getName().equals("orquestas")){
                        xml.next();
                        this.orquesta = parseParty(xml, "orquestas");
                    } else if (xml.getName().equals("miscelaneuses")){
                        xml.next();
                        this.miscellaneous = parseMiscellaneus(xml, "miscelaneuses");
                    } else if (xml.getName().equals("colaborators")){
                        xml.next();
                        this.colaborador = parseColaborator(xml, "colaborators");
                    } else if (xml.getName().equals("days")){
                        xml.next();
                        this.day = parseDay(xml, "days");
                    } else if (xml.getName().equals("history")){
                        xml.next();
                        this.history = parseEvent(xml, "history");
                    }
                    break;
                case XmlPullParser.END_TAG:
//                    Log.d(LOG_TAG,"End tag " + xml.getName());
                    break;
                case XmlPullParser.TEXT:
//                    Log.d(LOG_TAG,"Text " + xml.getText());
                    break;
                case XmlPullParser.START_DOCUMENT:
                    break;
            }
            event = xml.next();
        }

    }

    private ArrayList<Day> parseDay(XmlResourceParser xml, String end) throws XmlPullParserException, IOException {
        ArrayList<Day> arr = new ArrayList<Day>();
        int event = xml.getEventType();
        String date;
        int image = 0;
        String title;
        String description;
        ArrayList<Event> events = null;
        while(event!=XmlPullParser.END_DOCUMENT){
            switch(event){
                case XmlPullParser.START_TAG:
                    if (xml.getName().equals("date")){
                        xml.next();
                        date = xml.getText();
                        xml.next();
                        xml.next(); //Fin del título
                        xml.next(); //Inicio descripción
                        image = Integer.parseInt(String.valueOf(context.getResources().getIdentifier(xml.getText().replace("R.drawable.",""),"drawable",context.getPackageName())));
                        xml.next();
                        xml.next();
                        xml.next();
                        title = xml.getText();
                        xml.next();
                        xml.next();
                        xml.next();
                        description = xml.getText();
                        xml.next(); //Description
                        xml.next(); //Events
                        if (xml.getName().equals("events")){
                            xml.next();
                            events = parseEvent(xml, "events");
                        }
                        arr.add(new Day(date,image,title,description,events));
//                        arr.get(arr.size()-1).print();
                    }
                case XmlPullParser.END_TAG:
//                        Log.d(LOG_TAG,"End tag " + xml.getName());
                    if (xml.getName().equals(end)){
                        return arr;
                    }
                    break;
            }
            event = xml.next();
        }
        return arr;
    }

    private ArrayList<Miscelaneus> parseMiscellaneus(XmlResourceParser xml, String end) throws XmlPullParserException, IOException {
        ArrayList<Miscelaneus> arr = new ArrayList<Miscelaneus>();
        int event = xml.getEventType();
        String title;
        int id = -1;
        int image = 0;
        while(event!=XmlPullParser.END_DOCUMENT){
            switch(event){
                case XmlPullParser.START_TAG:
                    if (xml.getName().equals("title")){
                        xml.next();
                        title = xml.getText();
                        xml.next();
                        xml.next(); //Fin del título
                        xml.next(); //Inicio descripción
                        id = Integer.parseInt(xml.getText());
                        xml.next();
                        xml.next();
                        xml.next();
                        image = Integer.parseInt(String.valueOf(context.getResources().getIdentifier(xml.getText().replace("R.drawable.",""),"drawable",context.getPackageName())));
                        xml.next();
                        arr.add(new Miscelaneus(title, id, image));
//                        arr.get(arr.size()-1).print();
                    }
                case XmlPullParser.END_TAG:
//                        Log.d(LOG_TAG,"End tag " + xml.getName());
                    if (xml.getName().equals(end)){
                        return arr;
                    }
                    break;
            }
            event = xml.next();
        }
        return arr;
    }

    private ArrayList<Colaborador> parseColaborator(XmlResourceParser xml, String end) throws XmlPullParserException, IOException {
        ArrayList<Colaborador> arr = new ArrayList<Colaborador>();
        int event = xml.getEventType();
        String name;
        Uri url;
        int image = 0;
        String title;
        String description;
        while(event!=XmlPullParser.END_DOCUMENT){
            switch(event){
                case XmlPullParser.START_TAG:
                    if (xml.getName().equals("name")){
                        xml.next();
                        name = xml.getText();
                        xml.next();
                        xml.next(); //Fin del título
                        xml.next(); //Inicio descripción
                        image = Integer.parseInt(String.valueOf(context.getResources().getIdentifier(xml.getText().replace("R.drawable.",""),"drawable",context.getPackageName())));
                        xml.next();
                        xml.next();
                        xml.next();
                        url = Uri.parse(xml.getText());
                        xml.next();
                        xml.next();
                        xml.next();
                        title = xml.getText();
                        xml.next();
                        xml.next();
                        xml.next();
                        description = xml.getText();
                        xml.next();
                        arr.add(new Colaborador(name, image, url, title, description));
//                        arr.get(arr.size()-1).print();
                    }
                case XmlPullParser.END_TAG:
//                        Log.d(LOG_TAG,"End tag " + xml.getName());
                    if (xml.getName().equals(end)){
                        return arr;
                    }
                    break;
            }
            event = xml.next();
        }
        return arr;
    }

    private ArrayList<Party> parseParty(XmlResourceParser xml, String end) throws XmlPullParserException, IOException {
        ArrayList<Party> arr = new ArrayList<Party>();
        int event = xml.getEventType();
        String title;
        String url;
        int image = 0;
        String date;
        String video;
        while(event!=XmlPullParser.END_DOCUMENT){
            switch(event){
                case XmlPullParser.START_TAG:
                    if (xml.getName().equals("title")){
                        xml.next();
                        title = xml.getText();
                        xml.next();
                        xml.next(); //Fin del título
                        xml.next(); //Inicio descripción
                        image = Integer.parseInt(String.valueOf(context.getResources().getIdentifier(xml.getText().replace("R.drawable.",""),"drawable",context.getPackageName())));
                        xml.next();
                        xml.next();
                        xml.next();
                        date = xml.getText();
                        xml.next();
                        xml.next();
                        xml.next();
                        url = xml.getText();
                        xml.next();
                        xml.next();
                        xml.next();
                        video = xml.getText();
                        xml.next();
                        arr.add(new Party(title, image, date, url, video));
//                        arr.get(arr.size()-1).print();
                    }
                case XmlPullParser.END_TAG:
//                        Log.d(LOG_TAG,"End tag " + xml.getName());
                    if (xml.getName().equals(end)){
                        return arr;
                    }
                    break;
            }
            event = xml.next();
        }
        return arr;
    }

    private ArrayList<Event> parseEvent(XmlResourceParser xml, String end) throws XmlPullParserException, IOException {
        ArrayList<Event> arr = new ArrayList<Event>();
        int event = xml.getEventType();
        String title;
        String description;
        int image = 0;
        while(event!=XmlPullParser.END_DOCUMENT){
            switch(event){
                case XmlPullParser.START_TAG:
                    if (xml.getName().equals("title")){
                        xml.next();
                        title = xml.getText();
                        xml.next();
                        xml.next(); //Fin del título
                        xml.next(); //Inicio descripción
                        description = xml.getText();
                        xml.next();
                        xml.next();
                        xml.next();
                        image = Integer.parseInt(String.valueOf(context.getResources().getIdentifier(xml.getText().replace("R.drawable.",""),"drawable",context.getPackageName())));
                        xml.next();
                        arr.add(new Event(title, description, image));
//                        arr.get(arr.size()-1).print();
                    }
                case XmlPullParser.END_TAG:
//                        Log.d(LOG_TAG,"End tag " + xml.getName());
                    if (xml.getName().equals(end)){
                        return arr;
                    }
                    break;
            }
            event = xml.next();
        }
        return arr;
    }

    public ArrayList<Event> getCigarron() {
        return cigarron;
    }

    public ArrayList<Event> getParty() {
        return party;
    }

    public ArrayList<Party> getOrquesta() {
        return orquesta;
    }

    public ArrayList<Miscelaneus> getMiscellaneous() {
        return miscellaneous;
    }

    public ArrayList<Colaborador> getColaborador() {
        return colaborador;
    }

    public ArrayList<Day> getDay() {
        return day;
    }

    public ArrayList<Event> getHistory() {
        return history;
    }
}

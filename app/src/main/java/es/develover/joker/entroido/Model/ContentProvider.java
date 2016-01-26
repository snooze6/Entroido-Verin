package es.develover.joker.entroido.Model;

import java.util.ArrayList;

import es.develover.joker.entroido.R;

/**
 * Created by snooze on 26/01/16.
 */
public class ContentProvider {

    public static ArrayList<Day> days = doTheDay();
    public static ArrayList<Party> parties = doTheParty();

    public static ArrayList<Day> doTheDay(){

         //Event creation
        Event lunes1 = new Event("Evento 1","Lunes evento jejejejejejejejejejejejejeje, metele más cosas",R.drawable.icon);
        Event lunes2 = new Event("Evento 2","Lunes evento jejejejejejejejejejejejejeje, metele más cosas",R.drawable.domingo);
        Event martes1 = new Event("Evento 3","Martes evento jejejejejejejejejejejejejeje, metele más cosas",R.drawable.day04);
        Event martes2 = new Event("Evento 4","Martes evento jejejejejejejejejejejejejeje, metele más cosas",R.drawable.day05);
        Event miercoles1 = new Event("Evento 3","Miercoles evento jejejejejejejejejejejejejeje, metele más cosas",R.drawable.day06);
        Event miercoles2 = new Event("Evento 3","Miercoles evento jejejejejejejejejejejejejeje, metele más cosas",R.drawable.day07);

        //First arraylist of events with 2 first events
        ArrayList<Event> events= new ArrayList<Event>();
        events.add(lunes1);
        events.add(lunes2);

        //Second arraylist of events with 2  events
        ArrayList<Event> events2= new ArrayList<Event>();
        events2.add(martes1);
        events2.add(martes2);

        //Third arraylist of events with 2  events
        ArrayList<Event> events3= new ArrayList<Event>();
        events3.add(miercoles1);
        events3.add(miercoles2);

        //First day with 2 first events
        Day lunes = new Day("1 de Febrero", R.drawable.icon, "Lunes de carnaval", "Cabalgata espectacular en el pequeño gran pueblo de Verín", events);

        //Second dday with the events 2
        Day martes = new Day("2 de Febrero", R.drawable.icon, "Martes de carnaval", "Cabalgata espectacular en el pequeño gran pueblo de Verín", events2);

        //Third dday with the events 2
        Day miercoles = new Day("3 de Febrero", R.drawable.icon, "Maiercoles", "Cabalgata espectacular en el pequeño gran pueblo de Verín", events3);


        //ArrayList of days
        ArrayList<Day> dataDays = new ArrayList<Day>();
        dataDays.add(lunes);
        dataDays.add(martes);
        dataDays.add(miercoles);



        return dataDays;
    }

    public static ArrayList<Party> doTheParty(){
        ArrayList<Party> partyData = new ArrayList<Party>();

        partyData.add(new Party("Panadería Roscas", R.drawable.hermione, "www.panaderiaroscas.com"));
        partyData.add(new Party("Lusco Fusco", R.drawable.day07, "www.panaderiaroscas.com"));
        partyData.add(new Party("Panadería Roscas", R.drawable.hermione, "www.panaderiaroscas.com"));
        partyData.add(new Party("Lusco Fusco", R.drawable.day07, "www.panaderiaroscas.com"));
        partyData.add(new Party("Panadería Roscas", R.drawable.hermione, "www.panaderiaroscas.com"));
        partyData.add(new Party("Lusco Fusco", R.drawable.day07, "www.panaderiaroscas.com"));
        partyData.add(new Party("Panadería Roscas", R.drawable.hermione, "www.panaderiaroscas.com"));
        partyData.add(new Party("Lusco Fusco", R.drawable.day07, "www.panaderiaroscas.com"));
        partyData.add(new Party("Panadería Roscas", R.drawable.hermione, "www.panaderiaroscas.com"));
        partyData.add(new Party("Lusco Fusco", R.drawable.day07, "www.panaderiaroscas.com"));
        partyData.add(new Party("Panadería Roscas", R.drawable.hermione, "www.panaderiaroscas.com"));
        partyData.add(new Party("Lusco Fusco", R.drawable.day07, "www.panaderiaroscas.com"));

        return partyData;
    }

}

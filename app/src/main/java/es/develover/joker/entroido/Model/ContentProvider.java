package es.develover.joker.entroido.Model;

import java.util.ArrayList;

import es.develover.joker.entroido.R;

/**
 * Created by snooze on 26/01/16.
 */
public class ContentProvider {

    public static ArrayList<Day> days = doTheDay();
    public static ArrayList<Party> parties = doTheParty();

    /*public static ArrayList<Day> doTheDay() {

        //Event creation
        Event lunes1 = new Event("Evento 1", "Lunes evento jejejejejejejejejejejejejeje, metele más cosas", R.drawable.icon);
        Event lunes2 = new Event("Evento 2", "Lunes evento jejejejejejejejejejejejejeje, metele más cosas", R.drawable.domingo);
        Event martes1 = new Event("Evento 3", "Martes evento jejejejejejejejejejejejejeje, metele más cosas", R.drawable.day04);
        Event martes2 = new Event("Evento 4", "Martes evento jejejejejejejejejejejejejeje, metele más cosas", R.drawable.day05);
        Event miercoles1 = new Event("Evento 3", "Miercoles evento jejejejejejejejejejejejejeje, metele más cosas", R.drawable.day06);
        Event miercoles2 = new Event("Evento 3", "Miercoles evento jejejejejejejejejejejejejeje, metele más cosas", R.drawable.day07);

        //First arraylist of events with 2 first events
        ArrayList<Event> events = new ArrayList<Event>();
        events.add(lunes1);
        events.add(lunes2);

        //Second arraylist of events with 2  events
        ArrayList<Event> events2 = new ArrayList<Event>();
        events2.add(martes1);
        events2.add(martes2);

        //Third arraylist of events with 2  events
        ArrayList<Event> events3 = new ArrayList<Event>();
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
        dataDays.add(lunes);
        dataDays.add(martes);
        dataDays.add(miercoles);
        dataDays.add(lunes);
        dataDays.add(martes);
        dataDays.add(miercoles);
        dataDays.add(lunes);
        dataDays.add(martes);
        dataDays.add(miercoles);
        dataDays.add(lunes);
        dataDays.add(martes);
        dataDays.add(miercoles);


        return dataDays;
    }*/

    public static ArrayList<Party> doTheParty() {
        ArrayList<Party> partyData = new ArrayList<Party>();
        String uriVideo="qh-mwjF-OMo";
        partyData.add(new Party("Mapa", R.drawable.mapita,"02/02/15", "www.panaderiaroscas.com",uriVideo));
        partyData.add(new Party("Orquesta Panorama", R.drawable.panorama, "02/02/15", "www.panaderiaroscas.com",uriVideo));
        partyData.add(new Party("Orquesta Paris de Noia", R.drawable.parisdenoia, "02/02/15", "www.panaderiaroscas.com",uriVideo));
        partyData.add(new Party("Orquesta Marbella", R.drawable.marbella, "02/02/15", "www.panaderiaroscas.com","www.panaderiaroscas.com"));
        partyData.add(new Party("Orquesta Panorama", R.drawable.panorama, "02/02/15", "www.panaderiaroscas.com","www.panaderiaroscas.com"));
        partyData.add(new Party("Orquesta Paris de Noia", R.drawable.parisdenoia, "02/02/15", "www.panaderiaroscas.com","www.panaderiaroscas.com"));
        partyData.add(new Party("Mapa", R.drawable.mapita, "02/02/15", "www.panaderiaroscas.com","www.panaderiaroscas.com"));
        partyData.add(new Party("Orquesta Marbella", R.drawable.marbella, "02/02/15", "www.panaderiaroscas.com","www.panaderiaroscas.com"));

        return partyData;
    }

    public static ArrayList<Day> doTheDay() {
        ArrayList<Event> e28 = new ArrayList<Event>();
        e28.add(new Event("Jueves de Compadres", "Panorámica Jueves de Compadres\n" +
                "Es el primer día del Carnaval y la primera noche de mascarada colectiva.\n" +
                "Antiguamente la mujeres hacian los compadres o muñecos que imitan a la figura de un hombre, colgandolos en un lugar visible o intentar denigrarlos hasta quemarlos, siempre con la oposición de los hombres que trataban de evitarlo.\n" +
                "\n" +
                "Es noche de hombres, aunque con el paso de los años son más la mujeres que tambien se animan a esta noche, cambiando su rol y disfrazandose como si fuesen hombres.\n" +
                "\n" +
                "Después de una buena cena en cualquiera de los restaurantes de la villa, a medianoche todas las pandillas de hombres recorren las calles de la villa en compañía de las charangas y del “carro do Meco” para llegar a la Plaza Mayor y juzgar “o Maragato”.", R.drawable.day28));
        ArrayList<Event> e31 = new ArrayList<Event>();
        e31.add(new Event("Domingo de Corredoiro", "Se comienza propiamente a “correr-el Carnaval”, a las  primeras horas de la mañana hay una descarga de pirotecnia y las principales calles de la villa, se llenan de ruido y sonido con la música de las charangas.\n" +
                "Se celebra la primera concentración matinal de cigarrónes, que harán su aparición para saludar a todos los vecinos a la  salida de la misa.\n" +
                "A la tarde-noche se celebra en la Plaza Mayor de Verin el primer baile de máscaras vespertino al ritmo de las orquestras y tiene lugar la primera “fariñada”, ingrediente indiscutiblemente Carnavalero..", R.drawable.day31));
        ArrayList<Event> e04 = new ArrayList<Event>();
        e04.add(new Event("Desfile Infantil", "Desfile Infantil (Jueves de Comadres por la mañana)\n" +
                "\n" +
                "Desde las 11.45 horas tendrá lugar el Desfile Infantil del Carnaval, en lo que los/las menores del Punto de Atención a la Infancia del Ayuntamiento del Riós, Kero-Kolo del Ayuntamiento de Verín, Gardería Pinocho, CEIPs Amaro Refojo, Princesa de España, Castrelo do Val, Rodolfo Núñez de Vilardevós, Vendas da Barreira, Augusto Assia de A Mezquita, Medeiros, o Colexio Rural Agrupado Monterrei, Colegio María Inmaculada e o IES Taboada Chivite tomarán las calles de Verín.\n" +
                "\n" +
                "Dicho desfile estará amenizado por la Banda de Gaitas del Ayuntamiento de Verín y diversas charangas. Al mismo partirá, como todos los años, del cruze de la Canella Cega con la carretera de Cabreiroá, para recorrer las calles Deputación, Luis Espada y Lisa, y finalizar en las plazas García Barbón y Mayor.", R.drawable.day04b));
        e04.add(new Event("Jueves de Comadres", "¡¡LLEGÓ EL CARNAVAL!!!!  Miles de mujeres disfrazadas participan en el Jueves de Comadres en cenas colectivas, llenando todos los restaurantes de la villa, y pobre del hombre que esté fuera de casa antes de la medianoche….. A esta hora toda esa toda multitud se va juntando en las calles haciendo la procesión de la vela y de las sabanas blancas para recibir al Carnaval y a  la Reina del Carnaval.", R.drawable.day04));
        ArrayList<Event> e05 = new ArrayList<Event>();
        e05.add(new Event("Viernes de Compadreo", "Como en los últimos años, el Capuchón y la Mascarita son  los uniformes oficiales que llevarán a los asistentes a la fiesta durante esta jornada. A partir de las 19 horas tendrá lugar la salida de los Escuadrones de Capuchones y Mascaritas para recorrer diversas calles y plazas de la villa (desde el barrio de San Lázaro), con paradas estratégicas para mojar la garganta y  llenar el estomago. Irán acompañadas en todo momento de dos “Carros do Compadreo” y de las charangas, y finalizará el recorrido en la plaza de Edesio Fuentes, donde la música acompañará la tradicional degustación del cerdo al espeto.", R.drawable.day05));
        ArrayList<Event> e06 = new ArrayList<Event>();
        e06.add(new Event("Bautizo del Cigarrón", "A las 17 horas, saldrán desde la plaza del Ayuntamiento la confraría del Cigarrón para la plaza de la Mercé por la calle Laureano Peláez. en la propia plaza de la Mercé, se celebrará el emblemático “Bautizo do Cigarrón”, un acto solemne y donde serán investidos, por primera vez, varios cigarrónes.\n" +
                "A continuación, estos nuevos cigarrónes investidos presidirán una marcha par la plaza del Cigarrón, donde se le realizará un homenaje a los cigarrónes que por calquier motivo no pudieron salir y deleitarnos con sus chocas.", R.drawable.day06));
        ArrayList<Event> e07 = new ArrayList<Event>();
        e07.add(new Event("Domingo \"Gordo\" de Carnaval", "El día grande del Carnaval y de mayor intensidad. A primeras horas de la mañana vuelven a ser protagonistas las bombas y las charangas, pero ya no despertarán a tantos vecinos, puesto que serán muchos, chicos y chicas, y no tan chicos/as los que están esperando después de una larga noche de alegría y diversión la llegada del desfile de comparsas y carrozas, que se concentran en el  Barrio de San Roque hasta su salida.\n" +
                "\n" +
                "A las doce del mediodía comienza el Gran Desfile de Carrozas, Comparsas, Máscaras y Cigarrónes, amenizado por Banda de Gaitas del Ayuntamiento de Verín, y de las charangas, que recorrerán las calles de la villa, abarrotadas de gente, llenándolas de vida, de colores, de alegría, de música, de diversión y despreocupación, siendo numerosa la multitud de personas, entre máscaras participantes y espectadores que terminan por aglutinarse en la Plaza García Barbón al término de este desfile popular.\n" +
                "Desde la tarde hasta el anochecer, diversas orquestras y charangas amenizarán tanto a los vecinos como a los visitantes y a partir de media noche verbena popular.", R.drawable.day07));
        ArrayList<Event> e08 = new ArrayList<Event>();
        e08.add(new Event("Lunes de Carnaval", "Por la tarde tendrá lugar un Entroido infantil en el pabellón de deportes, con juegos y música. Así mismo una charanga amenizará el baile en la tercera edad.\n" +
                "\n" +
                "Hacia el atardecer habrá reparto de bica y empanada y todos tornamos al baile con el sonido de la música de la orquesta.", R.drawable.day08));
        ArrayList<Event> e09 = new ArrayList<Event>();
        e09.add(new Event("Martes de Carnaval", "Es el último día de la gran juerga popular.\n" +
                "Bombas y cohetes comienzan por la mañana con la misma intensidad como anunciaron la llegada del Carnaval.\n" +
                "Para después de comer las calles vuelven a llenarse de gente para revivir el domingo de Carnaval, una repetida concentración y Desfile de Carrozas, Comparsas, Máscaras y Cigarrónes, amenizado una vez más por Banda de Gaitas del Ayuntamiento de Verín, y de las charangas.\n" +
                "Concluyen este día los bailes y verbenas populares, y la juerga nocturna se da por finalizada para muchos/as al amencer del día siguiente.\n" +
                "\n" +
                "¡¡¡ HASTA EL AÑO QUE VIENE, CARNAVAL!!!", R.drawable.day09));
        ArrayList<Event> e14 = new ArrayList<Event>();
        e14.add(new Event("Domingo de Piñata", "Cierra este domingo la semana grande de fiesta con una comida colectiva.\n" +
                "Se hará entrega al término de esta comida del “Premio Pescadilla”, cedido por Comisión del Carnaval, y entregado a manos de su viuda, a aquella comparsa que más maravillados dejase a los vecinos durante el Desfile del Domingo de Carnaval.\n" +
                "Este premio es un recuerdo al “Pescadilla”, a su papel casi imprescindible en esta fiesta. Hablar de el y de su Señora, pareja inseparable en el trabajo y en la juerga es hablar también de Carnaval. Sus parodias, su chispa, su buen humor en su chimenea, siempre abierta a muchos en estas fiestas de Carnaval, se organizaron muchas de las más grandes juergas que se hicieron en Verín y que hicieron historia.\n" +
                "\n" +
                "Por la tarde hay baile popular amenizado por una orquesta.", R.drawable.day14));

        Day f28 = new Day("28 de Enero", R.drawable.day28, "Jueves de Compadres", "here", e28);
        Day f31 = new Day("31 de Enero", R.drawable.day31, "Domingo de Corredoiro", "here", e31);
        Day f04 = new Day("04 de Febrero", R.drawable.day04, "Jueves de Comadres", "here", e04);
        Day f05 = new Day("05 de Febrero", R.drawable.day05, "Viernes de Compadreo", "here", e05);
        Day f06 = new Day("06 de Febrero", R.drawable.day06, "Sábado de Carnaval", "here", e06);
        Day f07 = new Day("07 de Febrero", R.drawable.day07, "Domingo \"Gordo\" de Carnaval", "here", e07);
        Day f08 = new Day("08 de Febrero", R.drawable.day08, "Lunes de Carnaval", "here", e08);
        Day f09 = new Day("09 de Febrero", R.drawable.day09, "Martes de Carnaval", "here", e09);
        Day f14 = new Day("14 de Febrero", R.drawable.day14, "Domingo de Piñata", "here", e14);

        //ArrayList of days
        ArrayList<Day> dataDays = new ArrayList<Day>();
        dataDays.add(f28);
        dataDays.add(f31);
        dataDays.add(f04);
        dataDays.add(f05);
        dataDays.add(f06);
        dataDays.add(f07);
        dataDays.add(f08);
        dataDays.add(f09);
        dataDays.add(f14);

        return dataDays;
    }
}

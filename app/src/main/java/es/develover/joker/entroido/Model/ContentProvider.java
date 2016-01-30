package es.develover.joker.entroido.Model;

import android.net.Uri;

import java.util.ArrayList;

import es.develover.joker.entroido.R;

/**
 * Created by snooze on 26/01/16.
 */
public class ContentProvider {

    public static ArrayList<Day> days = doTheDay();
    public static ArrayList<Party> orquestas = doTheOrquestas();
    public static ArrayList<Miscelaneus> miscelaneuses = doTheMiscelaneus();
    public static ArrayList<Event> history = doTheHistory();
    public static ArrayList<Event> cigarron = doTheCigarron();
    public static ArrayList<Colaborador> colaboradores = doTheColaboradores();
    public static ArrayList<Event> parties = doTheParty();

    private static ArrayList<Event> doTheHistory() {

        ArrayList<Event> eventsHistory = new ArrayList<Event>();
        Event event1 = new Event("2016", "", R.drawable.entroido2016);
        Event event2 = new Event("2015", "", R.drawable.entroido2015);
        Event event3 = new Event("2014", "", R.drawable.entroido2014);
        Event event4 = new Event("2013", "", R.drawable.entroido2013);
        Event event5 = new Event("2012", "", R.drawable.entroido2012);

        eventsHistory.add(event1);
        eventsHistory.add(event2);
        eventsHistory.add(event3);
        eventsHistory.add(event4);
        eventsHistory.add(event5);
        return eventsHistory;
    }

    private static ArrayList<Event> doTheCigarron() {
        ArrayList<Event> eventsHistory = new ArrayList<Event>();
        Event event1 = new Event("Origen", "A principios del siglo XX, tan solo existían unos pocos trajes de cigarrón en la comarca y éstos eran alquilados a las casas que los poseían en castro. El traje en sí, se mantuvo igual hasta después de la guerra, tiempo en el que se descuidó un poco la estética. En los últimos tiempos se promovieron iniciativas para poder mejorar la presencia del cigarrón y a día de hoy tiene determinados unos elementos básicos que deben mantenerse intactos, como el pantalón, los zapatos, la camisa (permitidas algunas variantes pero dentro de la estética básica) y la estructura básica de la chaquetilla (los veremos en el apartado traje). Dentro de esa estética básica se permite un libre albedrío de colores tanto en medias, como pañoletas, fajas, ligas, pompones y elementos de las caretas como los motivos que aparecen en las mitras o las pieles empleadas en ellas. ", R.drawable.cigarron_1);
        Event event2 = new Event("Importancia", "Siempre ha sido la figura central del Entroido de Verín y debe ser venerada y respetada como tal, la tradición manda que se les debe dejar paso y que no se les puede tirar  la harina o ceniza tan típica del carnaval.\n" +
                "El cigarrón es un personaje que hace exaltación de su poderío y fuerza mediante las carreras y los saltos, los movimientos ágiles y certeros y la destreza al mover y emplear su zamarra, la cual tiene un uso exclusivamente limitado desde antaño en apartar a la gente que se interpone en el camino o perseguir y azotar a todo aquel que insulta al cigarrón o a la persona que lo porta.\n", R.drawable.cigarron_2);
        Event event3 = new Event("De padres a hijos", "Entendiendo tradición como la herencia de padres a hijos, en Verín se ha conservado desde antaño el vestir el traje de cigarrón. Para la gente de Verín el cigarrón es la figura idiosincrática del Entroido y vestirlo es un honor para todo aquel que puede hacerlo. Más que un traje, es un sentimiento que va más allá de lo que la razón puede entender. \n" +
                "Cigarróns son todas las personas que a lo largo de los siglos han conseguido mantener viva la tradición y vestirlo con el mayor orgullo, respeto y amor posible.  En Verín todo el mundo es cigarrón, desde el que lo viste, el que ayuda a vestirlo, el que lo admira, el que siente pasión por él aunque no lo vista y todas aquellas personas que lo llevan en el alma aunque jamás lo hayan vestido.\n", R.drawable.cigarron_3);
        eventsHistory.add(event1);
        eventsHistory.add(event2);
        eventsHistory.add(event3);


        return eventsHistory;
    }


    private static ArrayList<Event> doTheParty() {

        ArrayList<Event> eventsHistory = new ArrayList<Event>();
        Event event1 = new Event("Zona orquestas", "Descubre como llegar a la zona de orquestas", R.drawable.mapa_orquestas);
        Event event2 = new Event("Zona de bares Rua Monte Maior", "Descubre como llegar a la zona de bares de la calle Montemaior", R.drawable.mapa_zona_bares_1);
        Event event3 = new Event("Zona de bares Rua Irmáns Moreno", "Descubre como llegar a esta zona de bares de la calle Irmans Moreno", R.drawable.mapa_zona_bares2);
        Event event4 = new Event("Zona de pubs y discotecas cerca de la Plaza Alameda", "Descubre como llegar a la movida nocturna", R.drawable.mapa_discotes);

        eventsHistory.add(event1);
        eventsHistory.add(event2);
        eventsHistory.add(event3);
        eventsHistory.add(event4);
        return eventsHistory;
    }


    public static ArrayList<Party> doTheOrquestas() {
        ArrayList<Party> partyData = new ArrayList<Party>();
        String uriVideo = "qh-mwjF-OMo";
        //Mapa
        partyData.add(new Party("Localización Orquestas", R.drawable.mapita, "", "www.entroidoverin.com", uriVideo));
        //Jueves de compadres
        partyData.add(new Party("Charanga Tamega", R.drawable.charanga_tamega, "28/01 Jueves de Compadres", "www.orquestasyfiestas.com/charanga-tamega/", "KQv_w2HEPWI"));
        partyData.add(new Party("Banda de Gaitas de Verín", R.drawable.banda_de_gaitas_de_verin, "28/01 Jueves de Compadres", "http://www.verin.es/", "1697zUVEOwo"));
        partyData.add(new Party("Disco movil Jorge", R.drawable.disco_movil_jorge, "28/01 Jueves de Compadres", "www.discomoviljorge.com/", "87vZe4G2zoM"));

        //Domingo de corredoiro
        partyData.add(new Party("Grupo Aramio", R.drawable.grupo_aramio, "31/01 Domingo de corredoiro", "www.aramio.es/", "EvlTqavVv8Q"));

        //Jueves de compadres
        partyData.add(new Party("Orquesta Capitol", R.drawable.orquesta_capitol, "04/02 Jueves de Comadres 1:00", "www.orquestasdegalicia.es/formaciones/orquesta_capitol", "OYrLz_efk-Q"));

        //Viernes de compadreo
        partyData.add(new Party("Discomovil a Gramola", R.drawable.disco_movil_gramola, "05/02 Viernes de Compadreo - Noche ", "www.orquestasdegalicia.es/fiesta_02-08-2015_disco-movil_a-gramola_pazos-verin-ourense", "Hi5j3-kuiTo"));

        //Sabado de Carnaval
        partyData.add(new Party("Orquesta Trebol", R.drawable.orquesta_trebol, "06/02 Sabado de carnaval", "www.orquestatrebol.net", "UJwu2DIY37c"));
        partyData.add(new Party("Orquesta America", R.drawable.orquesta_america, "06/02 Sabado de carnaval", "www.orquestasdegalicia.es/formaciones/grupo_america-de-vigo", "Lwjzio2O6_M"));


        //Domingo de carnaval
        partyData.add(new Party("Orquesta Grupo de Moda", R.drawable.orquesta_de_moda, "07/02 Orquesta Grupo de Moda", "www.orquestasdegalicia.es/formaciones/grupo_d%C2%B4moda", "M_uUN9gV42Yc"));

        //Lunes de carnaval
        partyData.add(new Party("Orquesta Compostela", R.drawable.orquesta_compostela, "08/02 Orquesta Compostela", "www.orquestasdegalicia.es/formaciones/orquesta_compostela", "HWAFT21Zins"));

//Lunes de carnaval
        partyData.add(new Party("Orquesta Ciclón", R.drawable.orquesta_ciclon, "08/02 Orquesta Compostela", "www.es-la.facebook.com/ciclongrupo", "bKdrz7UXXpE"));


        return partyData;
    }

    private static ArrayList<Day> doTheDay() {
        ArrayList<Event> e28 = new ArrayList<Event>();
        e28.add(new Event("Jueves de Compadres",
                "Es el primer día del Carnaval y la primera noche de mascarada colectiva. " +
                "Antiguamente la mujeres hacian los compadres o muñecos que imitan a la figura de un hombre, colgandolos en un lugar visible o intentar denigrarlos hasta quemarlos, siempre con la oposición de los hombres que trataban de evitarlo.\n" +
                "\n" +
                "Es noche de hombres, aunque con el paso de los años son más la mujeres que tambien se animan a esta noche, cambiando su rol y disfrazandose como si fuesen hombres.\n" +
                "\n" +
                "Después de una buena cena en cualquiera de los restaurantes de la villa, a medianoche todas las pandillas de hombres recorren las calles de la villa en compañía de las charangas y del “carro do Meco” para llegar a la Plaza Mayor y juzgar “o Maragato”.", R.drawable.day28));
        ArrayList<Event> e31 = new ArrayList<Event>();
        e31.add(new Event("Domingo de Corredoiro", "Se comienza propiamente a “correr-el Carnaval”, a las  primeras horas de la mañana hay una descarga de pirotecnia y las principales calles de la villa, se llenan de ruido y sonido con la música de las charangas.\n" +
                "\nSe celebra la primera concentración matinal de cigarrónes, que harán su aparición para saludar a todos los vecinos a la  salida de la misa.\n" +
                "\nA la tarde-noche se celebra en la Plaza Mayor de Verin el primer baile de máscaras vespertino al ritmo de las orquestras y tiene lugar la primera “fariñada”, ingrediente indiscutiblemente Carnavalero..", R.drawable.day31));
        ArrayList<Event> e04 = new ArrayList<Event>();
        e04.add(new Event("Desfile Infantil", "Desfile Infantil (Jueves de Comadres por la mañana)\n" +
                "\n" +
                "Desde las 11.45 horas tendrá lugar el Desfile Infantil del Carnaval, en lo que los/las menores del Punto de Atención a la Infancia del Ayuntamiento del Riós, Kero-Kolo del Ayuntamiento de Verín, Gardería Pinocho, CEIPs Amaro Refojo, Princesa de España, Castrelo do Val, Rodolfo Núñez de Vilardevós, Vendas da Barreira, Augusto Assia de A Mezquita, Medeiros, o Colexio Rural Agrupado Monterrei, Colegio María Inmaculada e o IES Taboada Chivite tomarán las calles de Verín.\n" +
                "\n" +
                "Dicho desfile estará amenizado por la Banda de Gaitas del Ayuntamiento de Verín y diversas charangas. Al mismo partirá, como todos los años, del cruze de la Canella Cega con la carretera de Cabreiroá, para recorrer las calles Deputación, Luis Espada y Lisa, y finalizar en las plazas García Barbón y Mayor.", R.drawable.day04b));
        e04.add(new Event("Jueves de Comadres", "¡¡LLEGÓ EL CARNAVAL!!!!  Miles de mujeres disfrazadas participan en el Jueves de Comadres en cenas colectivas, llenando todos los restaurantes de la villa, y pobre del hombre que esté fuera de casa antes de la medianoche...\n\n A esta hora toda esa toda multitud se va juntando en las calles haciendo la procesión de la vela y de las sabanas blancas para recibir al Carnaval y a  la Reina del Carnaval.", R.drawable.day04));
        ArrayList<Event> e05 = new ArrayList<Event>();
        e05.add(new Event("Viernes de Compadreo", "Como en los últimos años, el Capuchón y la Mascarita son  los uniformes oficiales que llevarán a los asistentes a la fiesta durante esta jornada.\n\nA partir de las 19 horas tendrá lugar la salida de los Escuadrones de Capuchones y Mascaritas para recorrer diversas calles y plazas de la villa (desde el barrio de San Lázaro), con paradas estratégicas para mojar la garganta y  llenar el estomago.\n\nIrán acompañadas en todo momento de dos “Carros do Compadreo” y de las charangas, y finalizará el recorrido en la plaza de Edesio Fuentes, donde la música acompañará la tradicional degustación del cerdo al espeto.", R.drawable.day05));
        ArrayList<Event> e06 = new ArrayList<Event>();
        e06.add(new Event("Bautizo del Cigarrón", "A las 17 horas, saldrán desde la plaza del Ayuntamiento la confraría del Cigarrón para la plaza de la Mercé por la calle Laureano Peláez. en la propia plaza de la Mercé, se celebrará el emblemático “Bautizo do Cigarrón”, un acto solemne y donde serán investidos, por primera vez, varios cigarrónes.\n\n" +
                "A continuación, estos nuevos cigarrónes investidos presidirán una marcha par la plaza del Cigarrón, donde se le realizará un homenaje a los cigarrónes que por calquier motivo no pudieron salir y deleitarnos con sus chocas.", R.drawable.day06));
        ArrayList<Event> e07 = new ArrayList<Event>();
        e07.add(new Event("Domingo \"Gordo\" de Carnaval", "El día grande del Carnaval y de mayor intensidad. A primeras horas de la mañana vuelven a ser protagonistas las bombas y las charangas, pero ya no despertarán a tantos vecinos, puesto que serán muchos, chicos y chicas, y no tan chicos/as los que están esperando después de una larga noche de alegría y diversión la llegada del desfile de comparsas y carrozas, que se concentran en el  Barrio de San Roque hasta su salida.\n" +
                "\n" +
                "A las doce del mediodía comienza el Gran Desfile de Carrozas, Comparsas, Máscaras y Cigarrónes, amenizado por Banda de Gaitas del Ayuntamiento de Verín, y de las charangas, que recorrerán las calles de la villa, abarrotadas de gente, llenándolas de vida, de colores, de alegría, de música, de diversión y despreocupación, siendo numerosa la multitud de personas, entre máscaras participantes y espectadores que terminan por aglutinarse en la Plaza García Barbón al término de este desfile popular.\n\n" +
                "Desde la tarde hasta el anochecer, diversas orquestras y charangas amenizarán tanto a los vecinos como a los visitantes y a partir de media noche verbena popular.", R.drawable.day07));
        ArrayList<Event> e08 = new ArrayList<Event>();
        e08.add(new Event("Lunes de Carnaval", "Por la tarde tendrá lugar un Entroido infantil en el pabellón de deportes, con juegos y música. Así mismo una charanga amenizará el baile en la tercera edad.\n" +
                "\n" +
                "Hacia el atardecer habrá reparto de bica y empanada y todos tornamos al baile con el sonido de la música de la orquesta.", R.drawable.day08));
        ArrayList<Event> e09 = new ArrayList<Event>();
        e09.add(new Event("Martes de Carnaval", "Es el último día de la gran juerga popular.\n" +
                "Bombas y cohetes comienzan por la mañana con la misma intensidad como anunciaron la llegada del Carnaval.\n\n" +
                "Para después de comer las calles vuelven a llenarse de gente para revivir el domingo de Carnaval, una repetida concentración y Desfile de Carrozas, Comparsas, Máscaras y Cigarrónes, amenizado una vez más por Banda de Gaitas del Ayuntamiento de Verín, y de las charangas.\n\n" +
                "Concluyen este día los bailes y verbenas populares, y la juerga nocturna se da por finalizada para muchos/as al amencer del día siguiente.\n" +
                "\n" +
                "¡¡¡ HASTA EL AÑO QUE VIENE, CARNAVAL!!!", R.drawable.day09));
        ArrayList<Event> e14 = new ArrayList<Event>();
        e14.add(new Event("Domingo de Piñata", "Cierra este domingo la semana grande de fiesta con una comida colectiva.\n\n" +
                "Se hará entrega al término de esta comida del “Premio Pescadilla”, cedido por Comisión del Carnaval, y entregado a manos de su viuda, a aquella comparsa que más maravillados dejase a los vecinos durante el Desfile del Domingo de Carnaval.\n\n" +
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

    private static ArrayList<Miscelaneus> doTheMiscelaneus() {
        ArrayList<Miscelaneus> miscelaneusData = new ArrayList<Miscelaneus>();

        Miscelaneus miscelaneus1= new Miscelaneus("Eventos Musicales",Miscelaneus.ORQUESTA,R.drawable.orquestas);
        Miscelaneus miscelaneus2= new Miscelaneus("Carteles Del Carnaval",Miscelaneus.HISTORIA,R.drawable.carteles);
        Miscelaneus miscelaneus3= new Miscelaneus("Cigarrones y Tradición",Miscelaneus.CIGARRON,R.drawable.cigarron);
        Miscelaneus miscelaneus5= new Miscelaneus("Concurso de disfraces",Miscelaneus.CONCURSO,R.drawable.hermione);
        Miscelaneus miscelaneus4= new Miscelaneus("Fiesta",Miscelaneus.FIESTA,R.drawable.fiesta);

        miscelaneusData.add(miscelaneus1);
        miscelaneusData.add(miscelaneus2);
        miscelaneusData.add(miscelaneus3);
        miscelaneusData.add(miscelaneus4);
        miscelaneusData.add(miscelaneus5);
        return miscelaneusData;
    }

    private static ArrayList<Colaborador> doTheColaboradores() {
        ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();

        colaboradores.add(new Colaborador("Ayuntamiento de Verín", R.drawable.ayuntamiento_verin, Uri.parse("http://www.verin.es/"), "Difusión de la aplicación"));
        colaboradores.add(new Colaborador("La Región", R.drawable.la_region, Uri.parse("http://www.laregion.es/"), "Difusión de la aplicación"));

        return colaboradores;
    }


}

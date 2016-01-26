package es.develover.joker.entroido.Network;

import android.util.Base64;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import es.develover.joker.entroido.Model.Tweet;

public class Twitah {

    //SUBCLASE PARA XESTIONAR E DELEGAR ERRORES
    public class Oauth2Exception extends Exception{
        public Oauth2Exception(String message) {
            super(message);
        }
    }

    //<DEBUG>
    private final static String DEBUG_API="DEBUG_API";
    //</DEBUG>

    private final static String API_KEY ="VIJrM2ZUPIsG7Qs1qRidaYeD1";
    private final static String API_SECRET ="apAqSn4nMzGqi5yH6i4ThOiM6IWC2w7B1Lrr9RdBT2iXEPsTJq";
    private final static String TOKEN_URL = "https://api.twitter.com/oauth2/token";

    private static String bearerToken;

    public Twitah(){}

    //codifica a consumerkey e o consumer secret ao formato especificado pola api te twitter
    private String encodeKeys(String consumerKey, String consumerSecret) throws Oauth2Exception{
        String encodedConsumerKey ="";
        String encodedConsumerSecret ="";

        try {

            encodedConsumerKey = URLEncoder.encode(consumerKey, "UTF-8");
            encodedConsumerSecret = URLEncoder.encode(consumerSecret, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new Oauth2Exception("Erro ao codificar a API_KEY e/ou a API_SECRET_KEY");
        }

        String fullKey = encodedConsumerKey + ":" + encodedConsumerSecret;

        return Base64.encodeToString(fullKey.getBytes(), Base64.NO_WRAP);

    }

    //construe o token de autentificación
    private String requestBearerToken(String endPointUrl)
            throws IOException,Oauth2Exception {

        HttpsURLConnection connection = null;

        //codificanse as credenciales ao formato establecido por twitter
        String encodedCredentials = encodeKeys(API_KEY, API_SECRET);

        Log.d(DEBUG_API, "Credenciales codificadas: " + encodedCredentials);

        try {
            URL url = new URL(endPointUrl);
            connection = (HttpsURLConnection) url.openConnection();

            Log.d(DEBUG_API, "Conexion: " + connection);

            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Host", "api.twitter.com");
            connection.setRequestProperty("User-Agent", "anyApplication");
            connection.setRequestProperty("Authorization", "Basic "
                    + encodedCredentials);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            connection.setRequestProperty("Content-Length", "29");
            connection.setUseCaches(false);

            //solicitanse as credenciales
            writeRequest(connection, "grant_type=client_credentials");


            //Obtense como resppsta un string formateado como un json
            String jsonString = readResponse(connection);
            Log.d(DEBUG_API, "Respuesta: " + jsonString);

            //Parsease o string a un json e obtense o bearerToken recibido

            try {
                JSONObject obj = new JSONObject(jsonString);

                if (obj != null) {
                    String tokenType = (String) obj.get("token_type");
                    String token = (String) obj.get("access_token");

                    Log.d(DEBUG_API,"Token Type: "+tokenType);
                    Log.d(DEBUG_API,"Token: "+token);

                    return ((tokenType.equals("bearer")) && (token != null)) ? token
                            : "";
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            throw new Oauth2Exception("Erro ao parsear os datos do json recibido");

        } catch (MalformedURLException e) {
            throw new IOException("Endpoint inválido especificado n aurl", e);

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

    }

    // Writes a request to a connection
    private boolean writeRequest(HttpURLConnection connection,
                                 String textBody) throws Oauth2Exception{
        try {
            //obtense o fluxo de datos da conexion
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(
                    connection.getOutputStream()));

            //escribense os datos sobre o fluxo
            wr.write(textBody);

            //limpase e cerrase o fluxo
            wr.flush();
            wr.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lee a resposta obtida por unha conexion e a devolve como un string
    private String readResponse(HttpURLConnection connection) throws IOException{

        StringBuilder str = new StringBuilder();

        //obtense o lector do fluxo de datos
        BufferedReader br = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));

        //leese o fluxo de datos obtido liña a liña,engadindo cada linea a varaible line
        //ata que se consuma todo o fluxo

        String line = "";
        while ((line = br.readLine()) != null) {
            str.append(line + System.getProperty("line.separator"));
        }

        //cerrase o fluxo
        br.close();

        return str.toString();

    }

    //TAL VEZ SEXA NECESARIO REFACTORIZAR ESTA FUNCION
    public String autentificarOAUTH2() throws IOException,Oauth2Exception{
        bearerToken = requestBearerToken(TOKEN_URL); //autentificación
        return bearerToken;
    }

    public ArrayList<Tweet> tweetsPorHashtag(String hashtag) throws IOException,Oauth2Exception{
        HttpsURLConnection connection = null;

        //codificanse as credenciales ao formato establecido por twitter
        String encodedCredentials = encodeKeys(API_KEY, API_SECRET);

        Log.d(DEBUG_API, "Credenciales codificadas: " + encodedCredentials);

        try {

            //TODO: REFACTORIZAR
            URL url = new URL("https://api.twitter.com/1.1/search/tweets.json?q=%23"+hashtag+"&count=10");
            connection = (HttpsURLConnection) url.openConnection();

            Log.d(DEBUG_API, "Conexion: " + connection);

            connection.setDoOutput(false);//ao ser unha peticion de tipo GET non leva contido no corpo da mensaxe polo que este campo debe estar a false
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Host", "api.twitter.com");
            connection.setRequestProperty("User-Agent", "anyApplication");
            connection.setRequestProperty("Authorization", "Bearer "
                    + bearerToken);
            connection.setUseCaches(false);


            //Obtense como resppsta un string formateado como un json
            String jsonString = readResponse(connection);
            Log.d(DEBUG_API, "Respuesta: " + jsonString);

            //Parsease o string a un json e obtense o bearerToken recibido
            try {
                JSONObject json= new JSONObject(jsonString);
                JSONArray arrayJsonsTweets=json.getJSONArray("statuses");

                ArrayList<Tweet> tweets=new ArrayList<Tweet>(arrayJsonsTweets.length());
                for (int i = 0; i < arrayJsonsTweets.length(); i++) {

                    tweets.add(new Tweet(arrayJsonsTweets.getJSONObject(i)));

                }

                return tweets;

            } catch (JSONException e) {
                e.printStackTrace();
            }

            throw new Oauth2Exception("Erro ao parsear os datos do json recibido");

        } catch (MalformedURLException e) {
            throw new IOException("Endpoint inválido especificado n aurl", e);

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
package es.develover.joker.entroido.Network;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;

import es.develover.joker.entroido.BuildConfig;
import es.develover.joker.entroido.Model.Tweet;
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

public class Twitah {

    private static final String TYPE = "mixed";

    //SUBCLASE PARA XESTIONAR E DELEGAR ERRORES
    public class Oauth2Exception extends Exception{
        public Oauth2Exception(String message) {
            super(message);
        }
    }

    //<DEBUG>
    private final static String DEBUG_API="DEBUG_API";
    //</DEBUG>

    private final static String API_KEY = BuildConfig.API_KEY;
    private final static String API_SECRET = BuildConfig.API_SECRET;
    private final static String TOKEN_URL = "https://api.twitter.com/oauth2/token";

    private static String bearerToken;

    private Context c = null;

    public Twitah(){}

    public Twitah(Context c){ this.c = c;}

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

        //Log.d(DEBUG_API, "Credenciales codificadas: " + encodedCredentials);

        try {
            URL url = new URL(endPointUrl);
            connection = (HttpsURLConnection) url.openConnection();

            //Log.d(DEBUG_API, "Conexion: " + connection);

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
            //Log.d(DEBUG_API, "Respuesta: " + jsonString);

            //Parsease o string a un json e obtense o bearerToken recibido

            try {
                JSONObject obj = new JSONObject(jsonString);

                if (obj != null) {
                    String tokenType = (String) obj.get("token_type");
                    String token = (String) obj.get("access_token");

                    //Log.d(DEBUG_API,"Token Type: "+tokenType);
                    //Log.d(DEBUG_API,"Token: "+token);

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
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

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

    public ArrayList<Tweet> tweetsPorHashtag(int cantidad,String[] hashtags) throws IOException,Oauth2Exception{
        HttpsURLConnection connection = null;

        //codificanse as credenciales ao formato establecido por twitter
        String encodedCredentials = encodeKeys(API_KEY, API_SECRET);

        //Log.d(DEBUG_API, "Credenciales codificadas: " + encodedCredentials);

        try {

            //TODO: REFACTORIZAR

            String cadenaHashtags="%23"+hashtags[0];
            for (int i=1;i<hashtags.length;i++) {
                cadenaHashtags+="%2BOR%2B%23"+hashtags[i];
            }

            URL url = new URL("https://api.twitter.com/1.1/search/tweets.json?q="+cadenaHashtags+"-filter:retweets&count="+cantidad+"&result_type="+TYPE);
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
            //Log.d(DEBUG_API, "Respuesta: " + jsonString);

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
            throw new IOException("Endpoint inválido especificado na url", e);

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public ArrayList<Tweet> tweetsPorHashtag(int cantidad, long desde, String[] hashtags) throws IOException,Oauth2Exception {
        HttpsURLConnection connection = null;

        //codificanse as credenciales ao formato establecido por twitter
        String encodedCredentials = encodeKeys(API_KEY, API_SECRET);

        //Log.d(DEBUG_API, "Credenciales codificadas: " + encodedCredentials);

        try {

            String cadenaHashtags="%23"+hashtags[0];

            for (int i=1;i<hashtags.length;i++) {
                cadenaHashtags+="%2BOR%2B%23"+hashtags[i];
            }

            //TODO: REFACTORIZAR
            //URL url = new URL("https://api.twitter.com/1.1/search/tweets.json?q=%23" + hashtag + "&count=" + cantidad + "&since_id=" + desde +"&result_type=recent");
            URL url = new URL("https://api.twitter.com/1.1/search/tweets.json?q=" + cadenaHashtags + "-filter:retweets&count=" + cantidad + "&max_id=" + desde + "&result_type="+TYPE);
            connection = (HttpsURLConnection) url.openConnection();

            Log.d(DEBUG_API, "[Conexion: " + url.toString() + "]");

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
            //Log.d(DEBUG_API, "Respuesta: " + jsonString);

                if (c!=null) {
                    File file;
                    try {
                        String fileName = Uri.parse("/DEPURACION").getLastPathSegment();
                        file = File.createTempFile(fileName, null, c.getCacheDir());

                        Log.d("DEBUG_API", "DEBUG: File path --> " + file.getAbsolutePath());

                        FileOutputStream outputStream = c.openFileOutput(fileName, Context.MODE_PRIVATE);
                        outputStream.write(jsonString.getBytes());
                        outputStream.close();

                        //Log.d("DEBUG_API", "Aarchivo creado");

                    } catch (IOException e) {
                        // Error while creating file
                    }
                }

            //Parsease o string a un json e obtense o bearerToken recibido
            try {
                JSONObject json = new JSONObject(jsonString);
                JSONArray arrayJsonsTweets = json.getJSONArray("statuses");

                ArrayList<Tweet> tweets = new ArrayList<Tweet>(arrayJsonsTweets.length());
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

    public ArrayList<Tweet> update(int cantidad, long desde, String... hashtags) throws IOException,Oauth2Exception {
        HttpsURLConnection connection = null;

        //codificanse as credenciales ao formato establecido por twitter
        String encodedCredentials = encodeKeys(API_KEY, API_SECRET);

        //Log.d(DEBUG_API, "Credenciales codificadas: " + encodedCredentials);

        try {

            //TODO: REFACTORIZAR

            String cadenaHashtags="%23"+hashtags[0];

            for (int i=1;i<hashtags.length;i++) {
                cadenaHashtags+="%2BOR%2B%23"+hashtags[i];
            }
            //URL url = new URL("https://api.twitter.com/1.1/search/tweets.json?q=%23" + hashtag + "&count=" + cantidad + "&since_id=" + desde +"&result_type=recent");
            URL url = new URL("https://api.twitter.com/1.1/search/tweets.json?q=" + cadenaHashtags + "-filter:retweets&count=" + cantidad + "&since_id=" + desde + "&result_type="+TYPE);
            connection = (HttpsURLConnection) url.openConnection();

            Log.d(DEBUG_API, "[Conexion: " + url.toString() + "]");

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
            //Log.d(DEBUG_API, "Respuesta: " + jsonString);

            if (c!=null) {
                File file;
                try {
                    String fileName = Uri.parse("/DEPURACION").getLastPathSegment();
                    file = File.createTempFile(fileName, null, c.getCacheDir());

                    Log.d("DEBUG_API", "DEBUG: File path --> " + file.getAbsolutePath());

                    FileOutputStream outputStream = c.openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(jsonString.getBytes());
                    outputStream.close();

                    //Log.d("DEBUG_API", "Aarchivo creado");

                } catch (IOException e) {
                    // Error while creating file
                }
            }

            //Parsease o string a un json e obtense o bearerToken recibido
            try {
                JSONObject json = new JSONObject(jsonString);
                JSONArray arrayJsonsTweets = json.getJSONArray("statuses");

                ArrayList<Tweet> tweets = new ArrayList<Tweet>(arrayJsonsTweets.length());
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
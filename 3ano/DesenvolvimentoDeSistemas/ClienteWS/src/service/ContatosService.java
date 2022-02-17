/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author 2info2021
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import vo.Contato;

public class ContatosService {

    public void insere(Contato p) {
        try {
            URL url = new URL("http://localhost:8080/crud/contato");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Authorization", "Basic YWRtaW46cGluZGFtb25oYW5nYWJh");

            Gson gson = new Gson();
            String json = gson.toJson(p);
            System.out.println(json);
            OutputStream os = connection.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            System.out.println("codigo: " + connection.getResponseCode());
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + connection.getResponseCode());

            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salva(Contato p) {
        if (p.getId() == 0) {
            insere(p);
        } else {
            atualiza(p);
        }
    }

    public void atualiza(Contato p) {
        try {
            URL url = new URL("http://localhost:8080/crud/contato/" + p.getId());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Authorization", "Basic YWRtaW46cGluZGFtb25oYW5nYWJh");
            Gson gson = new Gson();
            String json = gson.toJson(p);
            System.out.println(json);
            OutputStream os = connection.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            System.out.println("codigo: " + connection.getResponseCode());
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + connection.getResponseCode());

            }
            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exclui(Contato p) {
        try {
            URL url = new URL("http://localhost:8080/crud/contato/" + p.getId());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Authorization", "Basic YWRtaW46cGluZGFtb25oYW5nYWJh");
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + connection.getResponseCode());

            }
            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Contato localiza(int id) {
        Contato p = new Contato();
        try {
            URL url = new URL("http://localhost:8080/crud/contato/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Authorization", "Basic YWRtaW46cGluZGFtb25oYW5nYWJh");
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + connection.getResponseCode());

            }
            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            Gson gson = new Gson();
            if ((output = br.readLine()) != null) {
                p = gson.fromJson(output, Contato.class);
            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    public List<Contato> pesquisa() {
        List<Contato> lista = new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8080/crud/contato/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Authorization", "Basic YWRtaW46cGluZGFtb25oYW5nYWJh");
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + connection.getResponseCode());

            }
            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String completa = "";
            String output;
            while ((output = br.readLine()) != null) {
                completa += output;
            }
            Gson gson = new Gson();
            lista = gson.fromJson(completa, new TypeToken<List<Contato>>() {
            }.getType());
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

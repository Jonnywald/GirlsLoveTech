package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Aula {

    private int idAula;
   private String nomeAula;
   private String url;
   private  int idCurso;


    public Aula(int idAula, String nomeAula, int idCurso, String url) {

        this.idAula = idAula;
        this.nomeAula = nomeAula;
        this.url = url;
        this.idCurso = idCurso;
    }

    public Aula (){

    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }


    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public static String parseJson(Aula aula) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("lesson", aula.getNomeAula());
            jsonObject.put("id", aula.getIdAula());
            jsonObject.put("videoUrl", aula.getUrl());
            return jsonObject.toString();
        } catch (Exception ex) {
            return "";
        }

    }

    public static ArrayList<Aula> parseObject1(String json, int idCurso) {
        ArrayList<Aula> aulas = new ArrayList<>();

        try {
            JSONObject objetoPrincipal = new JSONObject(json);
            JSONArray array = objetoPrincipal.getJSONArray("data");
            for (int i = 0; i < array.length(); i++) {
                Aula aula = new Aula();
                JSONObject obj = array.getJSONObject(i);
                aula.setNomeAula(obj.getString("name"));
                aula.setIdCurso(obj.getInt("courseId"));
                aula.setUrl(obj.getString("videoUrl"));
                if(aula.getIdCurso() == idCurso)
                    aulas.add(aula);
            }

            return aulas;

        } catch (Exception ex) {
            return aulas;
        }
    }
}


package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Aula extends Curso{

    private int idAula;
   private String nomeAula;


    public Aula(int idAula, String nomeAula, int idCurso) {

        this.idAula = idAula;
        this.nomeAula = nomeAula;
        this.setIdCurso(idCurso);
    }

    public Aula (){

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



    public static String parseJson(Aula aula) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("lesson", aula.getNomeAula());
            return jsonObject.toString();
        } catch (Exception ex) {
            return "";
        }

    }

    public static ArrayList<Aula> parseObject1(String json) {
        ArrayList<Aula> aulas = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Aula aula = new Aula();
                JSONObject obj = array.getJSONObject(i);
                aula.setNomeAula(obj.getString("lesson"));
                aula.setIdAula(obj.getInt("idLesson"));
                aulas.add(aula);
            }

            return aulas;

        } catch (Exception ex) {
            return aulas;
        }
    }
}


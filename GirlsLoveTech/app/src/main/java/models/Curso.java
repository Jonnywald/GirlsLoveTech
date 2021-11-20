package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Curso {

    private int idCurso;
    private String nomeCurso;

    public Curso(){

    }

    public Curso(int idCuso, String nomeCurso) {

        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;

    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }


    public static String parseJson(Curso curso) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("course", curso.getNomeCurso());
            return jsonObject.toString();
        } catch (Exception ex) {
            return "";
        }

    }

    public static ArrayList<Curso> parseObject(String json) {
        ArrayList<Curso> cursos = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Curso curso = new Curso();
                JSONObject obj = array.getJSONObject(i);
                curso.setNomeCurso(obj.getString("course"));
                curso.setIdCurso(obj.getInt("idCourse"));
                cursos.add(curso);
            }

            return cursos;

        } catch (Exception ex) {
            return cursos;
        }
    }
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author LENOVO
 */
public class ModelSave {
    private int save_id, soal_id, score;

    public int getSoal_id() {
        return soal_id;
    }

    public void setSoal_id(int soal_id) {
        this.soal_id = soal_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    private String user_id;

    public int getSave_id() {
        return save_id;
    }

    public void setSave_id(int save_id) {
        this.save_id = save_id;
    }
}

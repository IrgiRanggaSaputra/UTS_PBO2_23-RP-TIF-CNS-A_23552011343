package com.mycompany.project_uts;


public class Mahasiswa extends Civitas {
    private String nim;
    
    public Mahasiswa(int id, String nama, String nim){
        super(id, nama);
        this.nim = nim;
    }
    
    public String getNim(){
        return nim;
    }
    
    @Override
    public void Info(){
        System.out.println("Mahasiswa: " + nama + " - NIM " + nim);
    }
}

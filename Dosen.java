package com.mycompany.project_uts;


public class Dosen extends Civitas {
    private String NIDN;
    
    public Dosen(int id, String nama, String NIDN){
        super(id, nama);
        this.NIDN = NIDN;
    }
    @Override
    public void Info(){
        System.out.println("Dosen: " + nama + " - NIDN: " + NIDN);
    }
    
}

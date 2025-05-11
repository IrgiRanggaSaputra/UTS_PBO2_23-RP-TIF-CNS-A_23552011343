package com.mycompany.project_uts;


public abstract class Civitas {
    protected int id;
    protected String nama;
    
    public Civitas(int id, String nama){
        this.id = id;
        this.nama = nama;
    }
    
    public abstract void Info();
    
}

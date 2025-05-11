package com.mycompany.project_uts;


public class Tagihan {
    protected int id;
    protected int MahasiswaId;
    protected int semester;
    protected double total;
    
    public Tagihan(int id, int MahasiswaId, int semester, double total){
        this.id = id;
        this.MahasiswaId = MahasiswaId;
        this.semester = semester;
        this.total = total;
    }
    
    public double getTotal(){
        return total;
    }
}




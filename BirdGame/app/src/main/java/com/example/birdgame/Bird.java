package com.example.birdgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import java.util.ArrayList;

public class Bird extends BaseObject{
    private ArrayList<Bitmap> arrBms = new ArrayList<>();
    private int count, vFlap, idCurrentBitmap;
    private float drop;
    public Bird(){
        this.drop = 0;

    }
    public void draw(Canvas canvas){
        drop();
        canvas.drawBitmap(this.getBm(),this.x,this.y,null);

    }

    private void drop() {
        this.drop+=0.6;
        this.y+=this.drop;


    }

    public ArrayList<Bitmap> getArrBms() {
        return arrBms;
    }

    public void setArrBms(ArrayList<Bitmap> arrBms) {
        this.arrBms = arrBms;
        for (int i = 0; i < arrBms.size(); i++){
            this.arrBms.set(i, Bitmap.createScaledBitmap(this.arrBms.get(i),this.width,this.height,true));
        }
    }

    public float getDrop() {
        return drop;
    }

    public void setDrop(float drop) {
        this.drop = drop;
    }

    @Override
    public Bitmap getBm(){
        if(this.drop<0){
            Matrix matrix = new Matrix();
            matrix.postRotate(-25);
            return Bitmap.createBitmap(arrBms.get(0),0,0,arrBms.get(0).getWidth(),arrBms.get(0).getHeight(),matrix, true);
        }else if (drop>=0){
            Matrix matrix  = new Matrix();
            if (drop<70){
                matrix.postRotate(-25+(drop*2));
            }else{
                matrix.postRotate(45);

            }
            return Bitmap.createBitmap(arrBms.get(0),0,0,arrBms.get(0).getWidth(),arrBms.get(0).getHeight(),matrix,true);
        }
        return this.getArrBms().get(0);
    }
}

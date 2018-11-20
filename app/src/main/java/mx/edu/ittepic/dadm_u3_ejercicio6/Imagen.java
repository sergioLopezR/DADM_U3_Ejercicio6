package mx.edu.ittepic.dadm_u3_ejercicio6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Imagen {

    Bitmap icono;
    float x, y;
    private boolean visible;

    public  Imagen(int recurso, float _x, float _y, Lienzo l){
        icono = BitmapFactory.decodeResource(l.getResources(), recurso);
        x = _x;
        y = _y;
        visible = true;
    }

    public  Imagen(int recurso, float _x, float _y, LienzoKiwis l){
        icono = BitmapFactory.decodeResource(l.getResources(), recurso);
        x = _x;
        y = _y;
        visible = true;
    }

    public  Imagen(int recurso, float _x, float _y, LienzoPuma l){
        icono = BitmapFactory.decodeResource(l.getResources(), recurso);
        x = _x;
        y = _y;
        visible = true;
    }

    public  Imagen(int recurso, float _x, float _y, LienzoReebok l){
        icono = BitmapFactory.decodeResource(l.getResources(), recurso);
        x = _x;
        y = _y;
        visible = true;
    }

    public  Imagen(int recurso, float _x, float _y, Lienzosk l){
        icono = BitmapFactory.decodeResource(l.getResources(), recurso);
        x = _x;
        y = _y;
        visible = true;
    }

    public  Imagen(int recurso, float _x, float _y, Lienzovans l){
        icono = BitmapFactory.decodeResource(l.getResources(), recurso);
        x = _x;
        y = _y;
        visible = true;
    }

    public void pintar(Canvas c, Paint p){
        if (visible) {
            c.drawBitmap(icono, x, y, p);
        }
    }

    public void hacerVisible(boolean v){
        visible = v;
    }

    public boolean estaEnArea(float xp, float yp){
        float x2, y2;

        if (!visible){
            return false;
        }

        x2 = x+icono.getWidth();
        y2 = y+icono.getHeight();

        if(xp>=x && xp<=x2){
            if (yp >= y && yp <= y2){
                return true;
            }
        }
        return false;
    }

    public void moverX(float xp){
        x = xp - icono.getHeight()/2;
    }

    public void moverY(float yp){
        y = yp - icono.getHeight()/2;
    }

}

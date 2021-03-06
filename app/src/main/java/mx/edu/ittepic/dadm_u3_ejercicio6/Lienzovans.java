package mx.edu.ittepic.dadm_u3_ejercicio6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzovans extends View {

    Imagen principal, prod1_1, prod2_2, prod3_3, prod4_4, prod1, prod2, prod3, prod4, puntero, precio1, precio2, precio3, precio4;

    public Lienzovans(Context context) {
        super(context);
        puntero = null;
        principal = new Imagen(R.drawable.vans, 70, 220, this);

        prod1_1 = new Imagen(R.drawable.prod1_1vans, 100, 550, this);
        prod1 = new Imagen(R.drawable.prod1vans, 620, 10, this);
        precio1 = new Imagen(R.drawable.precio1vans, 630, 840, this);

        prod2_2 = new Imagen(R.drawable.prod2_2vans, 100, 950, this);
        prod2 = new Imagen(R.drawable.prod2vans, 620, 10, this);
        precio2 = new Imagen(R.drawable.precio2vans, 630, 840, this);

        prod3_3 = new Imagen(R.drawable.prod3_3vans, 100, 1350, this);
        prod3 = new Imagen(R.drawable.prod3vans, 620, 10, this);
        precio3 = new Imagen(R.drawable.precio3vans, 630, 840, this);

        prod4_4 = new Imagen(R.drawable.prod4_4vans, 100, 1750, this);
        prod4 = new Imagen(R.drawable.prod4vans, 620, 10, this);
        precio4 = new Imagen(R.drawable.precio4vans, 630, 840, this);

        prod1.hacerVisible(false);
        precio1.hacerVisible(false);
        prod2.hacerVisible(false);
        precio2.hacerVisible(false);
        prod3.hacerVisible(false);
        precio3.hacerVisible(false);
        prod4.hacerVisible(false);
        precio4.hacerVisible(false);
    }

    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        Paint p = new Paint();
        c.drawColor(Color.parseColor("#E7E7E0"));

        p.setColor(Color.parseColor("#4198EE"));
        c.drawRect(40, 0, 500, 3010, p);

        principal.pintar(c, p);
        prod1_1.pintar(c, p);
        prod1.pintar(c, p);
        precio1.pintar(c, p);
        prod2_2.pintar(c, p);
        prod2.pintar(c, p);
        precio2.pintar(c, p);
        prod3_3.pintar(c, p);
        prod3.pintar(c, p);
        precio3.pintar(c, p);
        prod4_4.pintar(c, p);
        prod4.pintar(c, p);
        precio4.pintar(c, p);
    }

    public boolean onTouchEvent(MotionEvent e){

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (prod1_1.estaEnArea(xp, yp)){
                    puntero = prod1_1;
                    prod1.hacerVisible(true);
                    precio1.hacerVisible(true);
                    prod2.hacerVisible(false);
                    precio2.hacerVisible(false);
                    prod3.hacerVisible(false);
                    precio3.hacerVisible(false);
                    prod4.hacerVisible(false);
                    precio4.hacerVisible(false);
                }
                if (prod2_2.estaEnArea(xp, yp)){
                    puntero = prod2_2;
                    prod2.hacerVisible(true);
                    precio2.hacerVisible(true);
                    prod1.hacerVisible(false);
                    precio1.hacerVisible(false);
                    prod3.hacerVisible(false);
                    precio3.hacerVisible(false);
                    prod4.hacerVisible(false);
                    precio4.hacerVisible(false);
                }
                if (prod3_3.estaEnArea(xp, yp)){
                    puntero = prod3_3;
                    prod3.hacerVisible(true);
                    precio3.hacerVisible(true);
                    prod1.hacerVisible(false);
                    precio1.hacerVisible(false);
                    prod2.hacerVisible(false);
                    precio2.hacerVisible(false);
                    prod4.hacerVisible(false);
                    precio4.hacerVisible(false);
                }
                if (prod4_4.estaEnArea(xp, yp)){
                    puntero = prod4_4;
                    prod4.hacerVisible(true);
                    precio4.hacerVisible(true);
                    prod1.hacerVisible(false);
                    precio1.hacerVisible(false);
                    prod2.hacerVisible(false);
                    precio2.hacerVisible(false);
                    prod3.hacerVisible(false);
                    precio3.hacerVisible(false);
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (puntero!=null) {
                    if (prod1_1.estaEnArea(xp, yp)) {
                        principal.moverY(yp - 290);
                        prod1_1.moverY(yp);
                        prod2_2.moverY(yp + 400);
                        prod3_3.moverY(yp + 800);
                        prod4_4.moverY(yp + 1200);
                    }

                    if (prod2_2.estaEnArea(xp, yp)) {
                        principal.moverY(yp - 690);
                        prod1_1.moverY(yp - 400);
                        prod2_2.moverY(yp);
                        prod3_3.moverY(yp + 400);
                        prod4_4.moverY(yp + 800);
                    }

                    if (prod3_3.estaEnArea(xp, yp)) {
                        principal.moverY(yp - 1090);
                        prod1_1.moverY(yp - 800);
                        prod2_2.moverY(yp - 400);
                        prod3_3.moverY(yp);
                        prod4_4.moverY(yp + 400);
                    }

                    if (prod4_4.estaEnArea(xp, yp)) {
                        principal.moverY(yp - 1490);
                        prod1_1.moverY(yp - 1200);
                        prod2_2.moverY(yp - 800);
                        prod3_3.moverY(yp - 400);
                        prod4_4.moverY(yp);
                    }
                }

                break;

            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }

}

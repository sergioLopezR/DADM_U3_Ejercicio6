package mx.edu.ittepic.dadm_u3_ejercicio6;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {

    String titulo, des1, des1_1, des1_2, des2, des2_1, des2_2, des3, des3_1, des3_2, des4, des4_1, des4_2, des5, des5_1, des5_2;
    Imagen dp, marco,  ks, puma, reebok, sk, vans, puntero, catalogo;
    MainActivity cont;
    private boolean k, p, r, s, v;

    public Lienzo(Context context) {
        super(context);
        dp = new Imagen(R.drawable.dp, 250, 60, this);
        marco = new Imagen(R.drawable.marco, 30, 920, this);
        ks = new Imagen(R.drawable.kswiss, 100, 540, this);
        puma = new Imagen(R.drawable.puma, 430, 570, this);
        reebok = new Imagen(R.drawable.reebok, 800, 540, this);
        sk = new Imagen(R.drawable.skechers, 1300, 490, this);
        vans = new Imagen(R.drawable.vans, 1800, 460, this);
        catalogo = new Imagen(R.drawable.vercatalogo, 600, 1350, this);
        titulo = "DEPORTENIS";
        des1 = "";
        des1_1 = "";
        des1_2 = "";
        des2 = "";
        des2_1 = "";
        des2_2 = "";
        des3 = "";
        des3_1 = "";
        des3_2 = "";
        des4 = "";
        des4_1 = "";
        des4_2 = "";
        des5 = "";
        des5_1 = "";
        des5_2 = "";
        puntero = null;
        cont = (MainActivity) context;
        catalogo.hacerVisible(false);
        marco.hacerVisible(false);
        k = false;
        p = false;
        r = false;
        s = false;
        v = false;
    }

    @Override
    protected void onDraw(Canvas c){
        super.onDraw(c);
        Paint p = new Paint();

        c.drawColor(Color.parseColor("#4198EE"));

        p.setTextSize(90);
        p.setColor(Color.BLACK);
        c.drawText(titulo, 700, 270, p);

        p.setColor(Color.parseColor("#FFFFFF"));
        c.drawRect(0, 500, 1700, 850, p);


        //Texto de Kiwiss
        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des1, 50, 1050, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des1_1, 110, 1150, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des1_2, 120, 1250, p);

        //Texto de Puma
        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des2, 150, 1050, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des2_1, 40, 1150, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des2_2, 300, 1250, p);

        //Texto de Reebok
        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des3, 150, 1050, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des3_1, 150, 1150, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des3_2, 150, 1250, p);

        //Texto de Sk
        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des4, 80, 1050, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des4_1, 140, 1150, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des4_2, 150, 1250, p);

        //Texto de Vans
        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des5, 60, 1050, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des5_1, 150, 1150, p);

        p.setTextSize(60);
        p.setColor(Color.BLACK);
        c.drawText(des5_2, 130, 1250, p);

        dp.pintar(c, p);
        marco.pintar(c, p);
        ks.pintar(c, p);
        puma.pintar(c, p);
        reebok.pintar(c, p);
        sk.pintar(c, p);
        vans.pintar(c, p);
        catalogo.pintar(c, p);


    }

    public boolean onTouchEvent(MotionEvent e){

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (ks.estaEnArea(xp, yp)){
                    puntero = ks;
                    agregarTextoKiwis();
                    borrarTextoPumas();
                    borrarTextoReebok();
                    borrarTextoSk();
                    borrarTextoVans();
                    k = true;
                    p = false;
                    r = false;
                    s = false;
                    v = false;
                }
                if (puma.estaEnArea(xp, yp)){
                    puntero = puma;
                    borrarTextoKiwis();
                    agregarTextoPumas();
                    borrarTextoReebok();
                    borrarTextoSk();
                    borrarTextoVans();
                    k = false;
                    p = true;
                    r = false;
                    s = false;
                    v = false;
                }
                if (reebok.estaEnArea(xp, yp)){
                    puntero = reebok;
                    borrarTextoKiwis();
                    borrarTextoPumas();
                    agregarTextoReebok();
                    borrarTextoSk();
                    borrarTextoVans();
                    k = false;
                    p = false;
                    r = true;
                    s = false;
                    v = false;
                }
                if (sk.estaEnArea(xp, yp)){
                    puntero = sk;
                    borrarTextoKiwis();
                    borrarTextoPumas();
                    borrarTextoReebok();
                    agregarTextoSk();
                    borrarTextoVans();
                    k = false;
                    p = false;
                    r = false;
                    s = true;
                    v = false;
                }
                if (vans.estaEnArea(xp, yp)){
                    puntero = vans;
                    borrarTextoKiwis();
                    borrarTextoPumas();
                    borrarTextoReebok();
                    borrarTextoSk();
                    agregarTextoVans();
                    k = false;
                    p = false;
                    r = false;
                    s = false;
                    v = true;
                }

                if (catalogo.estaEnArea(xp, yp) && k == true){
                    Intent pantalla = new Intent(cont, Main2Activity.class);
                    cont.startActivity(pantalla);
                }

                if (catalogo.estaEnArea(xp, yp) && p == true){
                    Intent pantalla2 = new Intent(cont, Main3Activity.class);
                    cont.startActivity(pantalla2);
                }

                if (catalogo.estaEnArea(xp, yp) && r == true){
                    Intent pantalla3 = new Intent(cont, Main4Activity.class);
                    cont.startActivity(pantalla3);
                }

                if (catalogo.estaEnArea(xp, yp) && s == true){
                    Intent pantalla4 = new Intent(cont, Main5Activity.class);
                    cont.startActivity(pantalla4);
                }

                if (catalogo.estaEnArea(xp, yp) && v == true){
                    Intent pantalla5 = new Intent(cont, Main6Activity.class);
                    cont.startActivity(pantalla5);
                }

                break;

            case MotionEvent.ACTION_MOVE:
                if (puntero!=null){
                    if (ks.estaEnArea(xp, yp)){
                        ks.moverX(xp+60);
                        puma.moverX(xp+310);
                        reebok.moverX(xp+730);
                        sk.moverX(xp+1230);
                        vans.moverX(xp+1730);
                    }

                    if (puma.estaEnArea(xp, yp)){
                        ks.moverX(xp-270);
                        puma.moverX(xp);
                        reebok.moverX(xp+420);
                        sk.moverX(xp+920);
                        vans.moverX(xp+1420);
                    }

                    if (reebok.estaEnArea(xp, yp)){
                        ks.moverX(xp-700);
                        puma.moverX(xp-420);
                        reebok.moverX(xp);
                        sk.moverX(xp+510);
                        vans.moverX(xp+1000);
                    }

                    if (sk.estaEnArea(xp, yp)){
                        ks.moverX(xp-1200);
                        puma.moverX(xp-930);
                        reebok.moverX(xp-500);
                        sk.moverX(xp);
                        vans.moverX(xp+510);
                    }
                    if (vans.estaEnArea(xp, yp)){
                        ks.moverX(xp-1660);
                        puma.moverX(xp-1370);
                        reebok.moverX(xp-1000);
                        sk.moverX(xp-500);
                        vans.moverX(xp);
                    }
                }

                break;

            case MotionEvent.ACTION_UP:
                puntero = null;
                break;
        }
        invalidate();
        return true;
    }


    private void agregarTextoKiwis() {
        des1 = "K-Swiss, Inc. es una marca estadounidense de calzado";
        des1_1 = "deportivo con sede en Westlake Village, California";
        des1_2 = "y actualmente propiedad E-Land World Limited";
    }

    private void agregarTextoPumas() {
        des2 = "Puma SE es una empresa alemana fabricante de";
        des2_1 = "accesorios, ropa y calzado deportivo, cuya sede central";
        des2_2 = "está en Herzogenaurach, Alemania.";
    }


    private void agregarTextoReebok() {
        des3 = "Reebok International Limited es una productora";
        des3_1 = "estadounidense de zapatillas deportivas, ropa, y";
        des3_2 = "accesorios, subsidiaria del grupo alemán Adidas.";
    }

    private void agregarTextoSk() {
        des4 = "Skechers es una empresa estadounidense dedicada";
        des4_1 = "a la fabricación de calzado, cuyas instalaciones";
        des4_2 = "principales se encuentran en Manhattan Beach";
    }

    private void agregarTextoVans() {
        des5 = "Vans es una compañía textil, dedicada principalmente";
        des5_1 = "a la producción de calzados, ropa, sudaderas,";
        des5_2 = "camisetas, fundada por Paul Van Doren en 1966.";
    }


    private void borrarTextoKiwis() {
        des1 = "";
        des1_1 = "";
        des1_2 = "";
        catalogo.hacerVisible(true);
        marco.hacerVisible(true);
    }

    private void borrarTextoReebok() {
        des3 = "";
        des3_1 = "";
        des3_2 = "";
        catalogo.hacerVisible(true);
        marco.hacerVisible(true);
    }

    private void borrarTextoPumas() {
        des2 = "";
        des2_1 = "";
        des2_2 = "";
        catalogo.hacerVisible(true);
        marco.hacerVisible(true);
    }

    private void borrarTextoSk() {
        des4 = "";
        des4_1 = "";
        des4_2 = "";
        catalogo.hacerVisible(true);
        marco.hacerVisible(true);
    }

    private void borrarTextoVans() {
        des5 = "";
        des5_1 = "";
        des5_2 = "";
        catalogo.hacerVisible(true);
        marco.hacerVisible(true);
    }



}

package com.mygdx.game.proyectil;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import asteroides.Asteroide;
import asteroides.AsteroideJefe;
import com.mygdx.game.Nave;

public class ProyectilEspecial2 extends Proyectil {                   //no se para que usar esta
    private float xSpeed;
    private float ySpeed;
    private boolean destroyed = false;
    //private int velPr;                     //cambiar xspeed y yspeed por esto?
    final private int dmg;
    private int rotacion;
    private Sprite spr;

    public ProyectilEspecial2(float x, float y, int velPr, int rr, int dmg){
        super(x,y,velPr,rr,dmg*2);
        Texture tx = new Texture(Gdx.files.internal("Rocket3.png"));
        spr = new Sprite(tx);
        this.rotacion = rr;
        this.dmg = dmg;
        //this.velPr = velPr;
        spr.setRotation(rotacion);

        this.rotacion += 90;

        this.xSpeed = velPr * (float)(Math.cos(Math.toRadians(rotacion)));
        this.ySpeed = velPr * (float)(Math.sin(Math.toRadians(rotacion)));

        spr.setPosition(x+xSpeed, y+ySpeed);
    }
    public void update() {
        spr.setPosition(spr.getX()+xSpeed, spr.getY()+ySpeed);
        if (spr.getX() < 0 || spr.getX()+spr.getWidth() > Gdx.graphics.getWidth()) {
            destroyed = true;
        }
        if (spr.getY() < 0 || spr.getY()+spr.getHeight() > Gdx.graphics.getHeight()) {
            destroyed = true;
        }
    }
    public void colisionado(Asteroide asteroide) {
        this.destroyed = true;
    }
    public void colisionado(AsteroideJefe asteroide) {
        colisionado((Asteroide)asteroide);
    }
    public void colisionado(Nave nave) {
        // nada
    }
    public void colisionado(Proyectil proyectil) {
        // nada
    }
    public boolean isDestroyed() {return destroyed;}
    public int getDamage() {
        return this.dmg;
    }
}
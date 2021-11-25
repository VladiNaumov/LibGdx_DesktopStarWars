package com.naumdeveloper.screen.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;


public class MenuScreen extends BaseScreen {

    private static final float V_LEN = 1.5f;

    private Texture img;
    private Vector2 touch;
    private Vector2 pos;
    private Vector2 v;

    //
    @Override
    public void show() {
        super.show();
        img = new Texture("ball.png");
        touch = new Vector2();
        pos = new Vector2();
        v = new Vector2();
    }

    //
    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        if(pos.dst(touch) <= v.len()){
            pos.set(touch);
        } else {
            pos.add(v);
        }
    }

    //
    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        //
        v.set(touch.cpy().sub(pos)).setLength2(V_LEN);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
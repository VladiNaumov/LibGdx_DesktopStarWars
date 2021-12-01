package com.naumdeveloper.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import com.naumdeveloper.math.Rect;
import com.naumdeveloper.util.Regions;


//БАЗОВЫЙ КЛАСС ДЛЯ СПРАЙТОВ. КОГДА ТЫ СОЗДАЕШЬ СВОЙ СПРАЙТ ТО НУЖНО УНАСЛЕДОВАТЬСЯ ОТ ЭТОГО КЛАССА
public abstract class BaseSprite extends Rect {

    //
    protected float angle;
    //
    protected float scale = 1f;
    //
    protected TextureRegion[] regions;

    //указывает на текущий кадр, по умолчанию он равен 0
    protected int frame;

    //
    private boolean destroyed;

    public BaseSprite() {

    }

    public BaseSprite(TextureRegion region) {
        regions = new TextureRegion[1];
        regions[0] = region;
    }

    /**
     * Разбивает TextureRegion на фреймы
     * @param region регион
     * @param rows количество строк
     * @param cols количество столбцов
     * @param frames количество фреймов
     * @return массив регионов
     */
    public BaseSprite(TextureRegion region, int rows, int cols, int frames) {
        regions = Regions.split(region, rows, cols, frames);
    }


    public void resize(Rect worldBounds) {

    }

    public void update(float delta) {

    }

    public void draw(SpriteBatch batch) {
        batch.draw(
                regions[frame],
                getLeft(), getBottom(),
                halfWidth, halfHeight,
                getWidth(), getHeight(),
                scale, scale,
                angle
        );
    }

    public void setHeightProportion(float height) {
        setHeight(height);
        float aspect = regions[frame].getRegionWidth() / (float) regions[frame].getRegionHeight();
        setWidth(height * aspect);
    }

    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(Vector2 touch, int pointer) {
        return false;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void destroy() {
        this.destroyed = true;
    }

    public void flushDestroy() {
        this.destroyed = false;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
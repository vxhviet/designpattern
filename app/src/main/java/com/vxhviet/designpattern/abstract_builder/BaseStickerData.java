package com.vxhviet.designpattern.abstract_builder;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Viet on 06/06/2017.
 */

public class BaseStickerData {
    @StringDef({
            Type.IMAGE,
            Type.TEXT
    })@Retention(RetentionPolicy.SOURCE)
    protected @interface Type{
        String IMAGE = "Image";
        String TEXT = "Text";
    }

    private @BaseStickerData.Type String mType;
    private float mPosX;
    private float mPosY;
    private float mWidth;
    private float mHeight;
    private float mAngle;

    /**
     * Dont use this to init the object use {@link AbstractBuilder} instead.
     * @param b
     */
    protected BaseStickerData(AbstractBuilder b) {
        mType = b.mType;
        mPosX = b.mPosX;
        mPosY = b.mPosY;
        mWidth = b.mWidth;
        mHeight = b.mHeight;
        mAngle = b.mAngle;
    }

    public String getType() {
        return mType;
    }

    public float getPosX() {
        return mPosX;
    }

    public float getPosY() {
        return mPosY;
    }

    public float getWidth() {
        return mWidth;
    }

    public float getHeight() {
        return mHeight;
    }

    public float getAngle() {
        return mAngle;
    }


    public static abstract class AbstractBuilder<T extends AbstractBuilder<T>> {
        private @BaseStickerData.Type String mType;
        private float mPosX;
        private float mPosY;
        private float mWidth;
        private float mHeight;
        private float mAngle;

        public T setType(@Type String type){
            mType = type;
            return getThis();
        }

        public T setPosX(float posX){
            mPosX = posX;
            return getThis();
        }

        public T setPosY(float posY){
            mPosY = posY;
            return getThis();
        }

        public T setWidth(float width){
            mWidth = width;
            return getThis();
        }

        public T setHeight(float height){
            mHeight = height;
            return getThis();
        }

        public T setAngle(float angle){
            mAngle = angle;
            return getThis();
        }

        protected abstract T getThis();
    }
}

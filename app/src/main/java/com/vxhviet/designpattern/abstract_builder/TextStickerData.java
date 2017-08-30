package com.vxhviet.designpattern.abstract_builder;

import android.support.annotation.DrawableRes;

/**
 * Created by Viet on 06/06/2017.
 */

public class TextStickerData extends BaseStickerData {

    private String mText;
    private String mFont;
    private int mColor;
    private @DrawableRes int mDrawableRes;

    private TextStickerData(Builder b) {
        super(b);
        mText = b.mText;
        mFont = b.mFont;
        mColor = b.mColor;
        mDrawableRes = b.mDrawableRes;
    }

    public String getText() {
        return mText;
    }

    public String getFont() {
        return mFont;
    }

    public int getColor() {
        return mColor;
    }

    public int getDrawableRes() {
        return mDrawableRes;
    }

    //in case we need to subsclass this child, see page 139 of Java Generics and Collections
    public static final class Builder extends AbstractBuilder<Builder> {
        private String mText;
        private String mFont;
        private int mColor;
        private @DrawableRes int mDrawableRes;

        public Builder setText(String text){
            mText = text;
            return this;
        }

        public Builder setFont(String font){
            mFont = font;
            return this;
        }

        public Builder setColor(int color){
            mColor = color;
            return this;
        }

        public Builder serDrawableRes(@DrawableRes int drawableRes){
            mDrawableRes = drawableRes;
            return this;
        }

        public TextStickerData build(){
            return new TextStickerData(this);
        }

        @Override
        protected Builder getThis() {
            return this;
        }
    }
}
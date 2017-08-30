package com.vxhviet.designpattern.abstract_builder;

import android.support.annotation.DrawableRes;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by Viet on 06/06/2017.
 */

public class ImageStickerData extends BaseStickerData {
    @DrawableRes
    private int mDrawableRes;

    private ImageStickerData(Builder b) {
        super(b);
        mDrawableRes = b.mDrawableRes;
    }

    public int getDrawableRes() {
        return mDrawableRes;
    }

    //in case we need to subsclass this child, see page 139 of Java Generics and Collections
    public static final class Builder extends AbstractBuilder<Builder> {
        @DrawableRes
        private int mDrawableRes;

        public Builder setDrawableRes(@DrawableRes int drawableRes) {
            mDrawableRes = drawableRes;
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        public ImageStickerData build() {
            return new ImageStickerData(this);
        }
    }
}

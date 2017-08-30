package com.vxhviet.designpattern.abstract_builder;

import com.vxhviet.designpattern.R;

/**
 * Created by Viet on 30/08/2017.
 *
 * For a summary see this: https://gist.github.com/vxhviet/cbbfb45b3fe4f47246ee2a390551d536
 *
 * References:
 * https://stackoverflow.com/questions/5818504/can-i-have-an-abstract-builder-class-in-java-with-method-chaining-without-doing/5818701#5818701
 * http://www.angelikalanger.com/GenericsFAQ/FAQSections/ProgrammingIdioms.html#FAQ206
 * https://books.google.com.vn/books?id=VUSbAgAAQBAJ&pg=PA141&lpg=PA141&dq=java+getthis+trick&source=bl&ots=BVuFi1sSmP&sig=w4WQwXLIySK7z9xphM5oVqJZZx0&hl=en&sa=X&ved=0ahUKEwi26OfaxKjUAhXGpZQKHfXNB9AQ6AEISzAF#v=onepage&q=java%20getthis%20trick&f=false
 */

public class AbstractBuilderDemo {

    public void demoUsage(){
        ImageStickerData t = new ImageStickerData.Builder()
                .setType(BaseStickerData.Type.IMAGE)
                .setPosX(0.5f)
                .setPosY(0.5f)
                .setWidth(0.1f)
                .setHeight(1f)
                .setAngle(90f)
                //.setDrawableRes(R.drawable.your_drawbale)
                .build();
    }
}

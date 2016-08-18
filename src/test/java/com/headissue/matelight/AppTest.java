package com.headissue.matelight;


import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.headissue.matelight.App.*;
import static org.junit.Assert.assertArrayEquals;

public class AppTest {


    @Test
    public void testWhiteByteArray() {
        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{(byte) 255, (byte) 255, (byte) 255};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 3, (byte) 255, (byte) 255, (byte) 255};
        assertArrayEquals(outColourByteArray, App.setPixel(lenghtLowByte, colourByteArray));
    }

    @Test
    public void testBlackByteArray() {
        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{0, 0, 0};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 3, 0, 0, 0};
        assertArrayEquals(outColourByteArray, App.setPixel(lenghtLowByte, colourByteArray));
    }

    @Test
    public void testRedByteArray() {

        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{(byte) 255, 0, 0};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 3, (byte) 255, 0, 0};

        assertArrayEquals(outColourByteArray, App.setPixel(lenghtLowByte, colourByteArray));
    }

    @Test
    public void testOneGreenPixel() {

        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{0, (byte) 255, 0};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 3, 0, (byte) 255, 0};

        assertArrayEquals(outColourByteArray, App.setPixel(lenghtLowByte, colourByteArray));
    }

    @Test
    public void testOneBluePixel() {

        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{0, 0, (byte) 255};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 3, 0, 0, (byte) 255};

        assertArrayEquals(outColourByteArray, App.setPixel(lenghtLowByte, colourByteArray));
    }

    @Test
    public void testSendWhiteByteArray() {

        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{(byte) 255, (byte) 255, (byte) 255};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 3, (byte) 255, (byte) 255, (byte) 255};
        assertArrayEquals(outColourByteArray, App.sendPixel(App.setPixel(lenghtLowByte, colourByteArray)));
    }

    @Test
    public void testSendBlackByteArray() {

        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{0, 0, 0};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 3, 0, 0, 0};
        assertArrayEquals(outColourByteArray, App.sendPixel(App.setPixel(lenghtLowByte, colourByteArray)));
    }

    @Test
    public void testSendRedByteArray() {

        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{(byte) 255, 0, 0};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 3, (byte) 255, 0, 0};
        assertArrayEquals(outColourByteArray, App.sendPixel(App.setPixel(lenghtLowByte, colourByteArray)));
    }

    @Test
    public void testSendGreenByteArray() {

        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{0, (byte) 255, 0};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 3, 0, (byte) 255, 0};
        assertArrayEquals(outColourByteArray, App.sendPixel(App.setPixel(lenghtLowByte, colourByteArray)));
    }

    @Test
    public void testSendBlueByteArray() {

        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{0, 0, (byte) 255};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 3, 0, 0, (byte) 255};
        assertArrayEquals(outColourByteArray, App.sendPixel(App.setPixel(lenghtLowByte, colourByteArray)));
    }

    @Test
    public void testSendWhiteByteArrayTenLeds() {

        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{(byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255};
        byte outPixel[] = new byte[]{0, 0, 0, 30, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255, (byte) 255};
        assertArrayEquals(outPixel, App.sendPixel(App.setPixel(lenghtLowByte, colourByteArray)));
    }

    @Test
    public void testSendBlackByteArrayTenLeds() {
        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(outColourByteArray, App.sendPixel(App.setPixel(lenghtLowByte, colourByteArray)));
    }

    @Test
    public void testSendRedByteArrayTenLeds() {
        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{(byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 30, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0};
        assertArrayEquals(outColourByteArray, App.sendPixel(App.setPixel(lenghtLowByte, colourByteArray)));
    }

    @Test
    public void testSendGreenByteArrayTenLeds() {
        byte lenghtLowByte = 0;
        byte ledColor[] = new byte[]{0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 30, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0};
        assertArrayEquals(outColourByteArray, App.sendPixel(App.setPixel(lenghtLowByte, ledColor)));
    }

    @Test
    public void testSendTenBluePixels() {
        byte lenghtLowByte = 0;
        byte colourByteArray[] = new byte[]{0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255};
        byte outColourByteArray[] = new byte[]{0, 0, 0, 30, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255, 0, 0, (byte) 255};
        assertArrayEquals(outColourByteArray, App.sendPixel(App.setPixel(lenghtLowByte, colourByteArray)));
    }

    @Test
    public void testSendHeaderOne() {

        byte pixel[] = new byte[]{0, (byte) 255, 0};
        byte headerArray[] = new byte[]{0, 0, 0, 3};

        assertArrayEquals(headerArray, App.constructHeader(pixel));
    }

    @Test
    public void testSendHeaderBiggerArray() {

        byte pixel[] = new byte[514];
        byte headerArray[] = new byte[]{0, 0, 2, 2};

        assertArrayEquals(headerArray, App.constructHeader(pixel));
    }

    @Test
    public void testSendRandomNumberOfBytes() {

        sendRandomByteArray();
    }

    @Test
    public void testSendColorLineToMateLight() {

        sendMultiColorLine();
    }

    @Test
    public void cleanMateLight() {

        cleanMate();
    }

    @Test
    public void testSendSnakeToMateLight() {

        sendSnake();
    }

    @Test
    public void testReadImage() throws IOException {

        sendImage();

    }


    @Test
    public void testReadGif() throws IOException {

        sendGif();

    }

}
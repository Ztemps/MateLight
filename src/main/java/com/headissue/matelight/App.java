package com.headissue.matelight;


import java.net.*;
import java.io.*;
import java.util.StringTokenizer;

public class App {

    static int maxLenght = 363;


    private static OutputStream getSocketConnection() throws IOException {
        Socket socket = new Socket("192.168.178.42", 7890);
        return socket.getOutputStream();

    }

    public static byte[] sendPixel(byte[] ledColor) {
        try {
            OutputStream out = getSocketConnection();
            out.write(ledColor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ledColor;
    }

    public static byte[] setPixel(byte channel, byte[] ledColor) {
        int maxlenght = 0;
        byte[] combined = null;
        for (int i = 0; i < ledColor.length; i++) {
            maxlenght++;
        }

        byte[] channelenght = new byte[]{channel, 0, 0, (byte) Math.abs(maxlenght)};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            outputStream.write(channelenght);
            outputStream.write(ledColor);
        } catch (IOException e) {
            e.printStackTrace();
        }

        combined = outputStream.toByteArray();

        return combined;

    }


    public static void sendRandomByteArray() {

        OutputStream out = null;
        try {
            out = getSocketConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int rndm1 = (int) (Math.random() * 255 + 1);
        int rndm2 = (int) (Math.random() * 255 + 1);
        int rndm3 = (int) (Math.random() * 255 + 1);
        byte rnmdByteArray[] = new byte[]{(byte) rndm1, (byte) rndm2, (byte) rndm3};

        for (; ; ) {
            rndm1 = (int) (Math.random() * 255 + 1);
            rndm2 = (int) (Math.random() * 255 + 1);
            rndm3 = (int) (Math.random() * 255 + 1);
            byte rndmByteArray2[] = new byte[]{(byte) rndm1, (byte) rndm2, (byte) rndm3};
            try {
                out.write(constructHeader(rnmdByteArray));
                out.write(rnmdByteArray);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                outputStream.write(rnmdByteArray);
                outputStream.write(rndmByteArray2);
                rnmdByteArray = outputStream.toByteArray();

                if (rnmdByteArray.length >= maxLenght) {
                    rnmdByteArray = rndmByteArray2;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void cleanMate() {

        byte blackColour[] = new byte[360];
        try {
            OutputStream out = getSocketConnection();
            out.write(constructHeader(blackColour));
            out.write(blackColour);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static byte[] constructHeader(byte[] pixels) {

        byte headerArray[] = new byte[]{0, 0, (byte) (pixels.length >> 8), (byte) pixels.length};
        return headerArray;
    }


    public static void sendMultiColorLine() {


        Socket socket = null;
        OutputStream out = null;

        int randomNumber = (int) (Math.random() * 255 + 1);
        int randomNumber2 = (int) (Math.random() * 255 + 1);
        int randomNumber3 = (int) (Math.random() * 255 + 1);
        byte rainbowLed[] = new byte[]{(byte) randomNumber, (byte) randomNumber2, (byte) randomNumber3};

        try {
            socket = new Socket("192.168.178.61", 7890);
            out = socket.getOutputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }

        while (socket != null) {

            for (int i = 0; i >= 0; i++) {

                byte outGrenLedNoChannel[] = new byte[]{(byte) randomNumber, (byte) randomNumber2, (byte) randomNumber3};

                try {
                    out.write(constructHeader(rainbowLed));
                    out.write(rainbowLed);
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    outputStream.write(rainbowLed);
                    outputStream.write(outGrenLedNoChannel);
                    rainbowLed = outputStream.toByteArray();

                    int lenghtOutPixel = 0;
                    for (int j = 0; j < rainbowLed.length; j++) {
                        lenghtOutPixel++;
                    }

                    if (lenghtOutPixel >= maxLenght || lenghtOutPixel <= 0) {
                        randomNumber = (int) (Math.random() * 254 + 1);
                        randomNumber2 = (int) (Math.random() * 254 + 1);
                        randomNumber3 = (int) (Math.random() * 254 + 1);
                        rainbowLed = new byte[]{(byte) randomNumber, (byte) randomNumber2, (byte) randomNumber3};
                    }

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }

    public static void sendSnake() {

        OutputStream out = null;

        try {
            out = getSocketConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte blackByteArray[] = new byte[]{0, 0, 0};
        byte greenByteArray[] = new byte[]{0, (byte) 255, 0};
        byte emptyByteArray[] = new byte[360];

        for (; ; ) {


            try {

                out.write(constructHeader(blackByteArray));
                out.write(blackByteArray);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                outputStream.write(blackByteArray);
                outputStream.write(greenByteArray);
                blackByteArray = outputStream.toByteArray();

                int lenghtByteArray = 0;
                for (int j = 0; j < blackByteArray.length; j++) {
                    lenghtByteArray++;
                }

                if (lenghtByteArray >= 24) {

                    blackByteArray[lenghtByteArray - 24] = blackByteArray[0];
                    blackByteArray[lenghtByteArray - 23] = blackByteArray[0];
                    blackByteArray[lenghtByteArray - 22] = blackByteArray[0];
                }

                if (lenghtByteArray - 24 >= maxLenght) {
                    out.write(constructHeader(emptyByteArray));
                    out.write(emptyByteArray);

                    blackByteArray = greenByteArray;

                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendImage() throws IOException {

        FileInputStream insFile = new FileInputStream("/home/javi/Desktop/head.ppm");

        if (insFile.read() != 'P') {
            throw new IOException("Invalid file");
        }
        if (insFile.read() != '6') {
            throw new IOException("Invalid file");
        }
        if (insFile.read() != '\n') {
            throw new IOException("Must be a new Line");
        }

        int fourthByte = insFile.read();

        if (fourthByte == '#') {
            while (insFile.read() != '#' && insFile.read() != '\n') {
                //Skip comments
            }
        }

        //Height
        StringBuilder heightString = new StringBuilder();
        int heightVar = 0;
        while (true) {
            heightVar = insFile.read();
            if (heightVar != 0x20) {
                heightString.append((char) heightVar);
            } else {
                break;
            }
        }

        //Length
        StringBuilder lengthString = new StringBuilder();
        int lenghtVar = 0;
        while (true) {
             lenghtVar = insFile.read();
            if (lenghtVar != 0x0a) {
                lengthString.append((char) lenghtVar);
            } else {
                break;
            }
        }

        //Max Value
        StringBuilder MaxValueString = new StringBuilder();
        int maxVar = 0;
        while (true) {
            maxVar = insFile.read();
            if (maxVar != 0x0a) {
                MaxValueString.append((char) maxVar);
            } else {
                break;
            }
        }

        //Colours ByteArray
        int byteArrayLength = Integer.parseInt(String.valueOf(heightString)) * Integer.parseInt(String.valueOf(lengthString));

        byte[][] colourByteArray = new byte[byteArrayLength][3];

        int count = 0;
        while (count < byteArrayLength) {

            byte byteRed = (byte) insFile.read();
            byte byteGreen = (byte) insFile.read();
            byte byteBlue = (byte) insFile.read();

            colourByteArray[count] = new byte[]{byteRed, byteGreen, byteBlue};

            count++;

        }


        String line;
        BufferedReader br = new BufferedReader(new FileReader("/home/javi/Desktop/MatelighPattern.csv"));
        int countCSV = 0;
        int[] arrayCSV = new int[byteArrayLength];

        //FIXMEE!
        while ((line = br.readLine()) != null) {

            StringTokenizer str = new StringTokenizer(line, ",");
            while (str.hasMoreTokens()) {
                int ledVar = Integer.parseInt(str.nextToken());

                arrayCSV[ledVar] = countCSV;

                countCSV++;
            }
        }

        byte headerArray[] = new byte[]{0, 0, (byte) (byteArrayLength * 3 >> 8), (byte) (byteArrayLength * 3)};

        byte[] colores = new byte[byteArrayLength * 3];

        int countImage = 0;
        for (int i = 0; i < byteArrayLength; i++) {

            int posImage = arrayCSV[i];

            colores[countImage] = colourByteArray[posImage][0];
            colores[countImage + 1] = colourByteArray[posImage][1];
            colores[countImage + 2] = colourByteArray[posImage][2];

            countImage = countImage + 3;

        }

        try {
            OutputStream out = getSocketConnection();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write(headerArray);
            outputStream.write(colores);
            headerArray = outputStream.toByteArray();
            out.write(headerArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }







    public static void   sendGif() {



    }























}

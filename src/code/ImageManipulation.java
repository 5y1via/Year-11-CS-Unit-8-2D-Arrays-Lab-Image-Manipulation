package code;

import image.APImage;
import image.Pixel;

public class ImageManipulation {

    /** CHALLENGE 0: Display Image
     *  Write a statement that will display the image in a window
     */
    public static void main(String[] args) {
        APImage image = new APImage("cyberpunk2077.jpg");
        // image.draw();
        // grayScale("cyberpunk2077.jpg");
        // blackAndWhite("cyberpunk2077.jpg");
        edgeDetection("cyberpunk2077.jpg", 20);
    }

    /** CHALLENGE ONE: Grayscale
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a grayscale copy of the image
     *
     * To convert a colour image to grayscale, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * Set the red, green, and blue components to this average value. */
    public static void grayScale(String pathOfFile) {
        APImage image = new APImage(pathOfFile);
        int width = image.getWidth();
        int height = image.getHeight();
        for (int i = 0; i<width; i++){
            for (int l = 0; l<height; l++){
                Pixel pixel = image.getPixel(i,l);
                int average = (pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3;
                pixel.setBlue(average);
                pixel.setRed(average);
                pixel.setGreen(average);
                image.setPixel(i, l, pixel);
            }
        }
        image.draw();
    }

    /** A helper method that can be used to assist you in each challenge.
     * This method simply calculates the average of the RGB values of a single pixel.
     * @param pixel
     * @return the average RGB value
     */
    private static int getAverageColour(Pixel pixel) {
        return 0;
    }

    /** CHALLENGE TWO: Black and White
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: a black and white copy of the image
     *
     * To convert a colour image to black and white, we need to visit every pixel in the image ...
     * Calculate the average of the red, green, and blue components of the pixel.
     * If the average is less than 128, set the pixel to black
     * If the average is equal to or greater than 128, set the pixel to white */
    public static void blackAndWhite(String pathOfFile) {
        APImage image = new APImage(pathOfFile);
        int width = image.getWidth();
        int height = image.getHeight();
        for (int i = 0; i<width; i++){
            for (int l = 0; l<height; l++){
                Pixel pixel = image.getPixel(i,l);
                int average = (pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3;
                if (average<128){
                    pixel.setBlue(0);
                    pixel.setGreen(0);
                    pixel.setRed(0);
                }
                else {
                    pixel.setBlue(255);
                    pixel.setGreen(255);
                    pixel.setRed(255);
                }
                image.setPixel(i, l, pixel);
            }
        }
        image.draw();
    }

    /** CHALLENGE Three: Edge Detection
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: an outline of the image. The amount of information will correspond to the threshold.
     *
     * Edge detection is an image processing technique for finding the boundaries of objects within images.
     * It works by detecting discontinuities in brightness. Edge detection is used for image segmentation
     * and data extraction in areas such as image processing, computer vision, and machine vision.
     *
     * There are many different edge detection algorithms. We will use a basic edge detection technique
     * For each pixel, we will calculate ...
     * 1. The average colour value of the current pixel
     * 2. The average colour value of the pixel to the left of the current pixel
     * 3. The average colour value of the pixel below the current pixel
     * If the difference between 1. and 2. OR if the difference between 1. and 3. is greater than some threshold value,
     * we will set the current pixel to black. This is because an absolute difference that is greater than our threshold
     * value should indicate an edge and thus, we colour the pixel black.
     * Otherwise, we will set the current pixel to white
     * NOTE: We want to be able to apply edge detection using various thresholds
     * For example, we could apply edge detection to an image using a threshold of 20 OR we could apply
     * edge detection to an image using a threshold of 35
     *  */
    public static void edgeDetection(String pathToFile, int threshold) {
        APImage image = new APImage(pathToFile);
        APImage imageCopy = image.clone();
        int width = image.getWidth();
        int height = image.getHeight();
        // you start at i = 1, l = 1
        for (int i = 1; i<width; i++){
            for (int l = 1; l<height; l++){
                Pixel pixelCurrent = imageCopy.getPixel(i,l);
                Pixel pixelLeft = imageCopy.getPixel(i-1,l);
                Pixel pixelBelow = imageCopy.getPixel(i,l-1);
                Pixel realPixelCurrent = image.getPixel(i, l);
                int current = (pixelCurrent.getRed() + pixelCurrent.getBlue() + pixelCurrent.getGreen()) / 3;
                int left = (pixelLeft.getRed() + pixelLeft.getBlue() + pixelLeft.getGreen()) / 3;
                int below = (pixelBelow.getRed() + pixelBelow.getBlue() + pixelBelow.getGreen()) / 3;
                if (current-left>threshold || left-current>threshold || current-below>threshold || below-left>threshold){
                    realPixelCurrent.setBlue(0);
                    realPixelCurrent.setRed(0);
                    realPixelCurrent.setGreen(0);
                }
                else {
                    realPixelCurrent.setBlue(255);
                    realPixelCurrent.setRed(255);
                    realPixelCurrent.setGreen(255);
                }
                image.setPixel(i, l, realPixelCurrent);
            }
        }
        image.draw();
    }

    /** CHALLENGE Four: Reflect Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image reflected about the y-axis
     *
     */
    public static void reflectImage(String pathToFile) {

    }

    /** CHALLENGE Five: Rotate Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image rotated 90 degrees CLOCKWISE
     *
     *  */
    public static void rotateImage(String pathToFile) {

    }

}

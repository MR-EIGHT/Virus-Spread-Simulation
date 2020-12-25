import javax.imageio.*;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Arrays;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//some of these imports were essential because Oracle has deleted javafx in the newer versions of jdk.


//app's runtime is 3.5 minutes.
//I have used "javafx.geometry.virusSpread.Point3D" to keep people's coordinates and sick/health status.
//x and y are coordinates and z is health status.
//because I kept people instead of points, showing density of people in a specific point would make apps runtime much longer.

//this project generates the gif file for the first test.
// also it gives the user the median of tests


public class virusSpread {


    //builds a gif using pictures in the directory.
    public static void gifbuilder(int n) throws IOException {

        BufferedImage first = ImageIO.read(new File("image1.jpg"));
        ImageOutputStream output = new FileImageOutputStream(new File("output" + n + ".gif"));

        GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), 250, true);
        writer.writeToSequence(first);


        File[] images = new File[]{

                new File("image1.jpg"),
                new File("image2.jpg"),
                new File("image3.jpg"),
                new File("image4.jpg"),
                new File("image5.jpg"),
                new File("image6.jpg"),
                new File("image7.jpg"),
                new File("image8.jpg"),
                new File("image9.jpg"),
                new File("image10.jpg"),
                new File("image11.jpg"),
                new File("image12.jpg"),
                new File("image13.jpg"),
                new File("image14.jpg"),
                new File("image15.jpg"),
                new File("image16.jpg"),
                new File("image17.jpg"),
                new File("image18.jpg"),
                new File("image19.jpg"),
                new File("image20.jpg"),
                new File("image21.jpg"),
                new File("image22.jpg"),
                new File("image23.jpg"),
                new File("image24.jpg"),
                new File("image25.jpg"),
                new File("image26.jpg"),
                new File("image27.jpg"),
                new File("image28.jpg"),
                new File("image29.jpg"),
                new File("image30.jpg"),
                new File("image31.jpg"),
                new File("image32.jpg"),
                new File("image33.jpg"),
                new File("image34.jpg"),
                new File("image35.jpg"),
                new File("image36.jpg"),
                new File("image37.jpg"),
                new File("image38.jpg"),
                new File("image39.jpg"),
                new File("image40.jpg"),
                new File("image41.jpg"),
                new File("image42.jpg"),
                new File("image43.jpg"),
                new File("image44.jpg"),
                new File("image45.jpg"),
                new File("image46.jpg"),
                new File("image47.jpg"),
                new File("image48.jpg"),
                new File("image49.jpg"),
                new File("image50.jpg"),
                new File("image51.jpg"),
                new File("image52.jpg"),
                new File("image53.jpg"),
                new File("image54.jpg"),
                new File("image55.jpg"),
                new File("image56.jpg"),
                new File("image57.jpg"),
                new File("image58.jpg"),
                new File("image59.jpg"),
                new File("image60.jpg"),
                new File("image61.jpg"),
                new File("image62.jpg"),
                new File("image63.jpg"),
                new File("image64.jpg"),
                new File("image65.jpg"),
                new File("image66.jpg"),
                new File("image67.jpg"),
                new File("image68.jpg"),
                new File("image69.jpg"),
                new File("image70.jpg"),
                new File("image71.jpg"),
                new File("image72.jpg"),
                new File("image73.jpg"),
                new File("image74.jpg"),
                new File("image75.jpg"),
                new File("image76.jpg"),
                new File("image77.jpg"),
                new File("image78.jpg"),
                new File("image79.jpg"),
                new File("image80.jpg"),
                new File("image81.jpg"),
                new File("image82.jpg"),
                new File("image83.jpg"),
                new File("image84.jpg"),
                new File("image85.jpg"),
                new File("image86.jpg"),
                new File("image87.jpg"),
                new File("image88.jpg"),
                new File("image89.jpg"),
                new File("image90.jpg"),
                new File("image91.jpg"),
                new File("image92.jpg"),
                new File("image93.jpg"),
                new File("image94.jpg"),
                new File("image95.jpg"),
                new File("image96.jpg"),
                new File("image97.jpg"),
                new File("image98.jpg"),
                new File("image99.jpg"),
                new File("image100.jpg"),

        };

        for (File image : images) {
            BufferedImage next = ImageIO.read(image);
            writer.writeToSequence(next);
        }

        writer.close();
        output.close();

    }


// making the pictures.

    public static void picmaker(Point3D people[], int day, int population, boolean quarantined) throws IOException {

        BufferedImage buff = new BufferedImage(800, 400, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = buff.createGraphics();
        g2d.setColor(new Color(255, 255, 255));
        g2d.fillRect(0, 0, 800, 400);
        g2d.setColor(new Color(0, 0, 0));
        g2d.drawRect(0, 0, 799, 399);


        g2d.setColor(new Color(100, 100, 120));

        for (int u = 0; u < 80; u++) {
            for (int o = 0; o < 25; o++) {
                g2d.drawRect(u * 10, o * 10, 10, 10);
            }
        }

        g2d.setFont(new Font("TimesRoman", Font.BOLD, 12));
        g2d.setColor(new Color(43, 17, 255));
        g2d.drawString("MEHRDAD HESHMAT", 680, 395);

        for (int t = 0; t < population; t++) {
            if (people[t].getZ() == 0) {
                g2d.setColor(new Color(47, 255, 37));
                g2d.fillRect((int) people[t].getX() * 10, (int) people[t].getY() * 10, 10, 10);

            }
            if (people[t].getZ() == -1) {
                g2d.setColor(new Color(255, 0, 22));
                g2d.fillRect((int) people[t].getX() * 10, (int) people[t].getY() * 10, 10, 10);
            }

        }

        g2d.setFont(new Font("TimesRoman", Font.BOLD, 25));
        g2d.setColor(new Color(0, 0, 0));
        g2d.drawString("Heat map Stats:", 310, 275);


        g2d.setColor(new Color(47, 255, 37));
        g2d.fillRect(2, 350, 15, 15);

        g2d.setColor(new Color(255, 0, 22));
        g2d.fillRect(2, 320, 15, 15);

        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        g2d.setColor(new Color(0, 0, 0));
        g2d.drawString("Sick:  " + howmanysick(people, population), 25, 330);
        g2d.drawString("Healthy:  " + (population - howmanysick(people, population)), 25, 360);
        g2d.drawString("Population:  " + population, 25, 280);
        g2d.drawString("Quarantined:  " + quarantined, 25, 295);
        day = day + 1;
        g2d.drawString("Day:  " + (day), 25, 310);


        g2d.dispose();
        File file = new File("image" + day + ".jpg");
        ImageIO.write(buff, "png", file);
    }

    //generates a random number.
    public static int random(int min, int max) {
        int rnd = min + (int) (Math.random() * ((max - min) + 1));
        return rnd;
    }

    // moves the people randomly. everybody is moving.
    public static void movement(Point3D points[], Point3D people[], int numofp) {
        int i, j, k = 0, p = 0;
        int x, y, x1, y1;
        for (j = 0; j < numofp; j++) {
            if (people[j].getZ() == -1) {
                points[k++] = new Point3D(people[j].getX(), people[j].getY(), people[j].getZ());

            }
        }
        for (j = 0; j < numofp; j++) {

            x = random(-1, 1);
            y = random(-1, 1);


            if (people[j].getX() == 0) x = random(0, 1);
            if (people[j].getY() == 0) y = random(0, 1);
            if (people[j].getX() == 79) x = random(-1, 0);
            if (people[j].getY() == 24) y = random(-1, 0);
            if (people[j].getX() == 79 && people[j].getY() == 24) {
                x = random(-1, 0);
                y = random(-1, 0);
            }
            if (people[j].getX() == 0 && people[j].getY() == 0) {
                x = random(0, 1);
                y = random(0, 1);
            }


            people[j] = people[j].add(x, y, 0);

        }


        for (j = 0; j < numofp; j++) {
            if (people[j].getZ() == -1)
                points[k++] = new Point3D(people[j].getX(), people[j].getY(), people[j].getZ());
        }


        sickpos(people, points, k, numofp);
    }


    // moves the people randomly. this one is for quarantined where 0.25 of people are not moving.

    public static void qurantinedmovement(Point3D points[], Point3D people[], int numofp) {
        int i, j, k = 0, p = 0;
        int x, y, x1, y1;
        for (j = 0; j < numofp; j++) {
            if (people[j].getZ() == -1) {
                points[k++] = new Point3D(people[j].getX(), people[j].getY(), people[j].getZ());

            }
        }

        for (j = 0; j < numofp - (numofp / 4); j++) {

            x = random(-1, 1);
            y = random(-1, 1);

            if (people[j].getX() == 0) x = random(0, 1);
            if (people[j].getY() == 0) y = random(0, 1);
            if (people[j].getX() == 79) x = random(-1, 0);
            if (people[j].getY() == 24) y = random(-1, 0);
            if (people[j].getX() == 79 && people[j].getY() == 24) {
                x = random(-1, 0);
                y = random(-1, 0);
            }
            if (people[j].getX() == 0 && people[j].getY() == 0) {
                x = random(0, 1);
                y = random(0, 1);
            }


            people[j] = people[j].add(x, y, 0);

        }


        for (j = 0; j < numofp; j++) {
            if (people[j].getZ() == -1)
                points[k++] = new Point3D(people[j].getX(), people[j].getY(), people[j].getZ());
        }


        sickpos(people, points, k, numofp);
    }


    //keeps and finds sick people's position.
    public static void sickpos(Point3D people[], Point3D points[], int index, int numofp) {


        for (int i = 0; i < numofp; i++) {
            for (int j = 0; j < index; j++) {
                if (people[i].getX() == points[j].getX() && people[i].getY() == points[j].getY() && people[i].getZ() == 0)
                    if (random(0, 1) == 0)
                        people[i] = people[i].add(0, 0, -1);
            }
        }

        for (int j = 0; j < index; j++)
            points[j] = null;
    }

    // fills the array with random coordinates
    // 0 in Z s means the person is healthy.
    // -1 in Z s means the person is sick.

    public static void fillingwithrandoms(Point3D people[], int numofp) {
        int k = 0, i;
        int x, y;


        people[0] = new Point3D(random(0, 79), random(0, 24), -1);
        k = 1;
        for (i = 1; i < numofp; i++) {
            y = random(0, 24);
            x = random(0, 79);
            people[k++] = new Point3D(x, y, 0);
        }
    }

    //returns the number of sick people.
    public static int howmanysick(Point3D people[], int numofp) {
        int sicks = 0;
        for (int i = 0; i < numofp; i++) {
            if (people[i].getZ() == -1) sicks++;
        }

        return sicks;
    }


    public static void main(String[] args) throws IOException {
        int i, j, k = 0;
        int[] sicks = new int[1000];
        int[] sicks2 = new int[1000];
        int[] sicks3 = new int[1000];
        int[] sicks4 = new int[1000];
        Point3D[] points = new Point3D[2000];
        Point3D[] people = new Point3D[100];
        Point3D[] people2 = new Point3D[1000];

        //filling the array of people with random coordinates.

        fillingwithrandoms(people, 100);
        fillingwithrandoms(people2, 1000);


        //doing the tests and saving the number of sick people in an array.

        for (j = 0; j < 1000; j++) {
            for (int l = 0; l < 100; l++) {
                movement(points, people, 100);
                if (j == 0) picmaker(people, l, 100, false);
            }
            sicks[j] = howmanysick(people, 100);
            fillingwithrandoms(people, 100);
        }
        gifbuilder(1);

        for (j = 0; j < 1000; j++) {
            for (int l = 0; l < 100; l++) {
                movement(points, people2, 1000);
                if (j == 0) picmaker(people2, l, 1000, false);
            }
            sicks2[j] = howmanysick(people2, 1000);
            fillingwithrandoms(people2, 1000);
        }
        gifbuilder(2);


        //quarantined

        for (j = 0; j < 1000; j++) {
            for (int l = 0; l < 100; l++) {
                qurantinedmovement(points, people, 100);
                if (j == 0) picmaker(people, l, 100, true);
            }
            sicks3[j] = howmanysick(people, 100);
            fillingwithrandoms(people, 100);
        }

        gifbuilder(3);

        for (j = 0; j < 1000; j++) {
            for (int l = 0; l < 100; l++) {
                qurantinedmovement(points, people2, 1000);
                if (j == 0) picmaker(people2, l, 1000, true);
            }
            sicks4[j] = howmanysick(people2, 1000);
            fillingwithrandoms(people2, 1000);
        }

        gifbuilder(4);

        //sorting array of sick people.

        Arrays.sort(sicks);
        Arrays.sort(sicks2);
        Arrays.sort(sicks3);
        Arrays.sort(sicks4);


        //printing medians of tests.

        System.out.println("The Median of 100 people in 2000 blocks:  " + (sicks[499] + sicks[500]) / 2);
        System.out.println("The Median of 1000 people in 2000 blocks:  " + (sicks2[499] + sicks2[500]) / 2);
        System.out.println("The Median of 100 people in 2000 blocks (Quarantined):  " + (sicks3[499] + sicks3[500]) / 2);
        System.out.println("The Median of 1000 people in 2000 blocks(Quarantined):  " + (sicks4[499] + sicks4[500]) / 2);


        //deleting generated pictures.
        File file;
        for (i = 0; i <= 100; i++) {
            file = new File("image" + i + ".jpg");
            file.delete();
        }
    }


    //gif builder class

    /**
     * Annotation that provides information about argument's name.
     *
     * @since JavaFX 8.0
     */
    @Retention(RUNTIME)
    @Target(PARAMETER)
    public static @interface NamedArg {
        /**
         * The name of the annotated argument.
         *
         * @return the name of the annotated argument
         */
        public String value();

        /**
         * The default value of the annotated argument.
         *
         * @return the default value of the annotated argument
         */
        public String defaultValue() default "";
    }


    //THE REST OF THE CODE IS THE SOURCE CODES OF JAVAFX CLASS AND IT'S REQUIREMENTS LIKE NamedArg.java.

    public static class GifSequenceWriter {

        protected ImageWriter writer;
        protected ImageWriteParam params;
        protected IIOMetadata metadata;

        public GifSequenceWriter(ImageOutputStream out, int imageType, int delay, boolean loop) throws IOException {
            writer = ImageIO.getImageWritersBySuffix("gif").next();
            params = writer.getDefaultWriteParam();

            ImageTypeSpecifier imageTypeSpecifier = ImageTypeSpecifier.createFromBufferedImageType(imageType);
            metadata = writer.getDefaultImageMetadata(imageTypeSpecifier, params);

            configureRootMetadata(delay, loop);

            writer.setOutput(out);
            writer.prepareWriteSequence(null);
        }

        private static IIOMetadataNode getNode(IIOMetadataNode rootNode, String nodeName) {
            int nNodes = rootNode.getLength();
            for (int i = 0; i < nNodes; i++) {
                if (rootNode.item(i).getNodeName().equalsIgnoreCase(nodeName)) {
                    return (IIOMetadataNode) rootNode.item(i);
                }
            }
            IIOMetadataNode node = new IIOMetadataNode(nodeName);
            rootNode.appendChild(node);
            return (node);
        }

        private void configureRootMetadata(int delay, boolean loop) throws IIOInvalidTreeException {
            String metaFormatName = metadata.getNativeMetadataFormatName();
            IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree(metaFormatName);

            IIOMetadataNode graphicsControlExtensionNode = getNode(root, "GraphicControlExtension");
            graphicsControlExtensionNode.setAttribute("disposalMethod", "none");
            graphicsControlExtensionNode.setAttribute("userInputFlag", "FALSE");
            graphicsControlExtensionNode.setAttribute("transparentColorFlag", "FALSE");
            graphicsControlExtensionNode.setAttribute("delayTime", Integer.toString(delay / 10));
            graphicsControlExtensionNode.setAttribute("transparentColorIndex", "0");

            IIOMetadataNode commentsNode = getNode(root, "CommentExtensions");
            commentsNode.setAttribute("CommentExtension", "Created by: https://memorynotfound.com");

            IIOMetadataNode appExtensionsNode = getNode(root, "ApplicationExtensions");
            IIOMetadataNode child = new IIOMetadataNode("ApplicationExtension");
            child.setAttribute("applicationID", "NETSCAPE");
            child.setAttribute("authenticationCode", "2.0");

            int loopContinuously = loop ? 0 : 1;
            child.setUserObject(new byte[]{0x1, (byte) (loopContinuously & 0xFF), (byte) ((loopContinuously >> 8) & 0xFF)});
            appExtensionsNode.appendChild(child);
            metadata.setFromTree(metaFormatName, root);
        }

        public void writeToSequence(RenderedImage img) throws IOException {
            writer.writeToSequence(new IIOImage(img, null, metadata), params);
        }

        public void close() throws IOException {
            writer.endWriteSequence();
        }

    }

    /**
     * A 3D geometric point that usually represents the x, y, z coordinates.
     * It can also represent a relative magnitude vector's x, y, z magnitudes.
     *
     * @since JavaFX 2.0
     */
    public static class Point3D {

        /**
         * Point or vector with all three coordinates set to 0.
         */
        public static final Point3D ZERO = new Point3D(0.0, 0.0, 0.0);

        /**
         * The x coordinate.
         *
         * @defaultValue 0.0
         */
        private double x;
        /**
         * The y coordinate.
         *
         * @defaultValue 0.0
         */
        private double y;
        /**
         * The z coordinate.
         *
         * @defaultValue 0.0
         */
        private double z;
        /**
         * Cache the hash code to make computing hashes faster.
         */
        private int hash = 0;

        /**
         * Creates a new instance of {@code virusspread.Point3D}.
         *
         * @param x The X coordinate of the {@code virusspread.Point3D}
         * @param y The Y coordinate of the {@code virusspread.Point3D}
         * @param z The Z coordinate of the {@code virusspread.Point3D}
         */
        public Point3D(@NamedArg("x") double x, @NamedArg("y") double y, @NamedArg("z") double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        /**
         * The x coordinate.
         *
         * @return the x coordinate
         */
        public final double getX() {
            return x;
        }

        /**
         * The y coordinate.
         *
         * @return the y coordinate
         */
        public final double getY() {
            return y;
        }

        /**
         * The z coordinate.
         *
         * @return the z coordinate
         */
        public final double getZ() {
            return z;
        }

        /**
         * Computes the distance between this point and point {@code (x1, y1, z1)}.
         *
         * @param x1 the x coordinate of other point
         * @param y1 the y coordinate of other point
         * @param z1 the z coordinate of other point
         * @return the distance between this point and point {@code (x1, y1, z1)}.
         */
        public double distance(double x1, double y1, double z1) {
            double a = getX() - x1;
            double b = getY() - y1;
            double c = getZ() - z1;
            return Math.sqrt(a * a + b * b + c * c);
        }

        /**
         * Computes the distance between this point and the specified {@code point}.
         *
         * @param point the other point
         * @return the distance between this point and the specified {@code point}.
         * @throws NullPointerException if the specified {@code point} is null
         */
        public double distance(Point3D point) {
            return distance(point.getX(), point.getY(), point.getZ());
        }

        /**
         * Returns a point with the specified coordinates added to the coordinates
         * of this point.
         *
         * @param x the X coordinate addition
         * @param y the Y coordinate addition
         * @param z the Z coordinate addition
         * @return the point with added coordinates
         * @since JavaFX 8.0
         */
        public Point3D add(double x, double y, double z) {
            return new Point3D(
                    getX() + x,
                    getY() + y,
                    getZ() + z);
        }

        /**
         * Returns a point with the coordinates of the specified point added to the
         * coordinates of this point.
         *
         * @param point the point whose coordinates are to be added
         * @return the point with added coordinates
         * @throws NullPointerException if the specified {@code point} is null
         * @since JavaFX 8.0
         */
        public Point3D add(Point3D point) {
            return add(point.getX(), point.getY(), point.getZ());
        }

        /**
         * Returns a point with the specified coordinates subtracted from
         * the coordinates of this point.
         *
         * @param x the X coordinate subtraction
         * @param y the Y coordinate subtraction
         * @param z the Z coordinate subtraction
         * @return the point with subtracted coordinates
         * @since JavaFX 8.0
         */
        public Point3D subtract(double x, double y, double z) {
            return new Point3D(
                    getX() - x,
                    getY() - y,
                    getZ() - z);
        }

        /**
         * Returns a point with the coordinates of the specified point subtracted
         * from the coordinates of this point.
         *
         * @param point the point whose coordinates are to be subtracted
         * @return the point with subtracted coordinates
         * @throws NullPointerException if the specified {@code point} is null
         * @since JavaFX 8.0
         */
        public Point3D subtract(Point3D point) {
            return subtract(point.getX(), point.getY(), point.getZ());
        }

        /**
         * Returns a point with the coordinates of this point multiplied
         * by the specified factor
         *
         * @param factor the factor multiplying the coordinates
         * @return the point with multiplied coordinates
         * @since JavaFX 8.0
         */
        public Point3D multiply(double factor) {
            return new Point3D(getX() * factor, getY() * factor, getZ() * factor);
        }

        /**
         * Normalizes the relative magnitude vector represented by this instance.
         * Returns a vector with the same direction and magnitude equal to 1.
         * If this is a zero vector, a zero vector is returned.
         *
         * @return the normalized vector represented by a {@code virusspread.Point3D} instance
         * @since JavaFX 8.0
         */
        public Point3D normalize() {
            final double mag = magnitude();

            if (mag == 0.0) {
                return new Point3D(0.0, 0.0, 0.0);
            }

            return new Point3D(
                    getX() / mag,
                    getY() / mag,
                    getZ() / mag);
        }

        /**
         * Returns a point which lies in the middle between this point and the
         * specified coordinates.
         *
         * @param x the X coordinate of the second endpoint
         * @param y the Y coordinate of the second endpoint
         * @param z the Z coordinate of the second endpoint
         * @return the point in the middle
         * @since JavaFX 8.0
         */
        public Point3D midpoint(double x, double y, double z) {
            return new Point3D(
                    x + (getX() - x) / 2.0,
                    y + (getY() - y) / 2.0,
                    z + (getZ() - z) / 2.0);
        }

        /**
         * Returns a point which lies in the middle between this point and the
         * specified point.
         *
         * @param point the other endpoint
         * @return the point in the middle
         * @throws NullPointerException if the specified {@code point} is null
         * @since JavaFX 8.0
         */
        public Point3D midpoint(Point3D point) {
            return midpoint(point.getX(), point.getY(), point.getZ());
        }

        /**
         * Computes the angle (in degrees) between the vector represented
         * by this point and the specified vector.
         *
         * @param x the X magnitude of the other vector
         * @param y the Y magnitude of the other vector
         * @param z the Z magnitude of the other vector
         * @return the angle between the two vectors measured in degrees
         * @since JavaFX 8.0
         */
        public double angle(double x, double y, double z) {
            final double ax = getX();
            final double ay = getY();
            final double az = getZ();

            final double delta = (ax * x + ay * y + az * z) / Math.sqrt(
                    (ax * ax + ay * ay + az * az) * (x * x + y * y + z * z));

            if (delta > 1.0) {
                return 0.0;
            }
            if (delta < -1.0) {
                return 180.0;
            }

            return Math.toDegrees(Math.acos(delta));
        }

        /**
         * Computes the angle (in degrees) between the vector represented
         * by this point and the vector represented by the specified point.
         *
         * @param point the other vector
         * @return the angle between the two vectors measured in degrees,
         * {@code NaN} if any of the two vectors is a zero vector
         * @throws NullPointerException if the specified {@code point} is null
         * @since JavaFX 8.0
         */
        public double angle(Point3D point) {
            return angle(point.getX(), point.getY(), point.getZ());
        }

        /**
         * Computes the angle (in degrees) between the three points with this point
         * as a vertex.
         *
         * @param p1 one point
         * @param p2 other point
         * @return angle between the vectors (this, p1) and (this, p2) measured
         * in degrees, {@code NaN} if the three points are not different
         * from one another
         * @throws NullPointerException if the {@code p1} or {@code p2} is null
         * @since JavaFX 8.0
         */
        public double angle(Point3D p1, Point3D p2) {
            final double x = getX();
            final double y = getY();
            final double z = getZ();

            final double ax = p1.getX() - x;
            final double ay = p1.getY() - y;
            final double az = p1.getZ() - z;
            final double bx = p2.getX() - x;
            final double by = p2.getY() - y;
            final double bz = p2.getZ() - z;

            final double delta = (ax * bx + ay * by + az * bz) / Math.sqrt(
                    (ax * ax + ay * ay + az * az) * (bx * bx + by * by + bz * bz));

            if (delta > 1.0) {
                return 0.0;
            }
            if (delta < -1.0) {
                return 180.0;
            }

            return Math.toDegrees(Math.acos(delta));
        }

        /**
         * Computes magnitude (length) of the relative magnitude vector represented
         * by this instance.
         *
         * @return magnitude of the vector
         * @since JavaFX 8.0
         */
        public double magnitude() {
            final double x = getX();
            final double y = getY();
            final double z = getZ();

            return Math.sqrt(x * x + y * y + z * z);
        }

        /**
         * Computes dot (scalar) product of the vector represented by this instance
         * and the specified vector.
         *
         * @param x the X magnitude of the other vector
         * @param y the Y magnitude of the other vector
         * @param z the Z magnitude of the other vector
         * @return the dot product of the two vectors
         * @since JavaFX 8.0
         */
        public double dotProduct(double x, double y, double z) {
            return getX() * x + getY() * y + getZ() * z;
        }

        /**
         * Computes dot (scalar) product of the vector represented by this instance
         * and the specified vector.
         *
         * @param vector the other vector
         * @return the dot product of the two vectors
         * @throws NullPointerException if the specified {@code vector} is null
         * @since JavaFX 8.0
         */
        public double dotProduct(Point3D vector) {
            return dotProduct(vector.getX(), vector.getY(), vector.getZ());
        }

        /**
         * Computes cross product of the vector represented by this instance
         * and the specified vector.
         *
         * @param x the X magnitude of the other vector
         * @param y the Y magnitude of the other vector
         * @param z the Z magnitude of the other vector
         * @return the cross product of the two vectors
         * @since JavaFX 8.0
         */
        public Point3D crossProduct(double x, double y, double z) {
            final double ax = getX();
            final double ay = getY();
            final double az = getZ();

            return new Point3D(
                    ay * z - az * y,
                    az * x - ax * z,
                    ax * y - ay * x);
        }

        /**
         * Computes cross product of the vector represented by this instance
         * and the specified vector.
         *
         * @param vector the other vector
         * @return the cross product of the two vectors
         * @throws NullPointerException if the specified {@code vector} is null
         * @since JavaFX 8.0
         */
        public Point3D crossProduct(Point3D vector) {
            return crossProduct(vector.getX(), vector.getY(), vector.getZ());
        }

        /**
         * Returns a hash code value for the point.
         *
         * @return a hash code value for the point.
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj instanceof Point3D) {
                Point3D other = (Point3D) obj;
                return getX() == other.getX() && getY() == other.getY() && getZ() == other.getZ();
            } else return false;
        }

        /**
         * Returns a hash code for this {@code virusspread.Point3D} object.
         *
         * @return a hash code for this {@code virusspread.Point3D} object.
         */
        @Override
        public int hashCode() {
            if (hash == 0) {
                long bits = 7L;
                bits = 31L * bits + Double.doubleToLongBits(getX());
                bits = 31L * bits + Double.doubleToLongBits(getY());
                bits = 31L * bits + Double.doubleToLongBits(getZ());
                hash = (int) (bits ^ (bits >> 32));
            }
            return hash;
        }

        /**
         * Returns a string representation of this {@code virusspread.Point3D}.
         * This method is intended to be used only for informational purposes.
         * The content and format of the returned string might vary between
         * implementations.
         * The returned string might be empty but cannot be {@code null}.
         */
        @Override
        public String toString() {
            return "virusspread.Point3D [x = " + getX() + ", y = " + getY() + ", z = " + getZ() + "]";
        }
    }
}





